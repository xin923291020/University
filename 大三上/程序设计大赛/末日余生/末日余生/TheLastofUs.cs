using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using 末日余生.Models;
using System.Threading;
using System.Media;
using CCWin;
using WMPLib;

namespace 末日余生
{
    public partial class TheLastofUs : CCSkinMain
    {
        static TheLastofUs theLastofUs = null;//本窗口单例模式变量。
        TheLastofUsContext TLU = new TheLastofUsContext();//数据库对象。
        RoleAttribute RA = new RoleAttribute();//角色属性面板。
        Rucksack RS = new Rucksack();//角色背包面板。
        SkillsTab ST = new SkillsTab();//技能栏面板。
        RoleAction roleAction = new RoleAction();//角色普通行为反馈类。
        RoleAttcak roleAttack = new RoleAttcak();//角色攻击行为反馈类。
        Level1ActionFeedBack L1AFB = new Level1ActionFeedBack();//第一章场景探索反馈类。
        SoundPlayer sp = new SoundPlayer();//单对象声音播放器。
        Random ran = new Random();//随机数对象。
        SolidBrush BrushRed = new SolidBrush(Color.FromArgb(255, 0, 33));//地图红色刷子。
        SolidBrush BrushGreen = new SolidBrush(Color.FromArgb(28, 134, 10));//地图绿色刷子。
        private int X = 3, Y = 0;//标记当前角色所在格子。
        char[] content; int i = 0;//系统面板内容。
        char[] ItemContent; int j = 0;//时间提醒面板内容。
        private string PresentEvent = "";//当前格子触发的随机事件。
        private string PresentScene = "";//当前格子的场景事件。
        private int FlashTimes = 0;//标记丧尸死亡头像闪烁的次数。
        private int IsNightFlag = 1;//标记是不是晚上。
        private int IsPoisoning = 1;//标记角色是否中毒。
        public static bool HavePistol = false;//存储角色是否有手枪。
        public static int SkillOne = 0;//标记角色第一个技能是否获得。
        public static bool SkillTwo = false;//标记角色第二个技能是否获得。
        public bool AttackFlag = false;//标记角色是否遇到了丧尸。
        private int ZombieLevel = 1;//标记当前丧尸的等级。
        public int ZombieForce = 4;//标记当前丧尸的攻击力。

        public TheLastofUs()
        {
            InitializeComponent();
            SetToolTip();
        }
        public static TheLastofUs getTheLastofUs()
        {
            if (theLastofUs == null)
            {
                theLastofUs = new TheLastofUs();
                System.Windows.Forms.Control.CheckForIllegalCrossThreadCalls = false;
            }
            else
            {
                return theLastofUs;
            }
            return theLastofUs;
        }

        #region 窗口生成
        private void TheLastofUs_Load(object sender, EventArgs e)
        {
            this.地图.Controls.Add(this.角色, X, Y);
            var data = TLU.Level1.Find(X, Y);
            PresentScene = data.SceneDescribe.ToString();
            PhysicalValueRefresh();
            TimeRefresh();
            IsPoisoningRefresh();
            var IsHavePistol = TLU.Rucksacks.Find("小鑫");
            if (IsHavePistol.HavePistol == 1)
            {
                HavePistol = true;
            }
            SkillRefresh();
            TextPlayer.Ctlcontrols.stop();
            this.系统提示面板.Text = data.SceneDescribe.ToString();
        }
        private void SetToolTip()
        {
            提示文本.SetToolTip(上, "向上走一格。");
            提示文本.SetToolTip(下, "向下走一格。");
            提示文本.SetToolTip(左, "向左走一格。");
            提示文本.SetToolTip(右, "向右走一格。");
            提示文本.SetToolTip(背景音乐, "关闭背景音乐");
            提示文本.SetToolTip(无背景音乐, "打开背景音乐");
            提示文本.SetToolTip(提交按钮, "提交输入");
            提示文本.SetToolTip(显示或打开地图, "显示/隐藏地图");
            提示文本.SetToolTip(显示背包, "显示/隐藏背包");
            提示文本.SetToolTip(显示属性, "显示/隐藏属性");
            提示文本.SetToolTip(我的能力, "显示/隐藏我的能力");
            提示文本.SetToolTip(虚弱, "体力低于20，小心丧尸");
            提示文本.SetToolTip(中毒, "中毒，体力消耗加倍");
        }
        private void 地图_CellPaint(object sender, TableLayoutCellPaintEventArgs e)
        {
            var data = TLU.Level1.Find(e.Column, e.Row);
            if (data.EventFlag == 0)
            {
                e.Graphics.FillRectangle(BrushRed, e.CellBounds);
            }
            else if (data.EventFlag == 1)
            {
                e.Graphics.FillRectangle(BrushGreen, e.CellBounds);
            }
            else
            {
                e.Graphics.FillRectangle(Brushes.Yellow, e.CellBounds);
            }
        }
        private void TheLastofUs_Move(object sender, EventArgs e)
        {
            if (RA.Visible)
            {
                RA.X = this.Left - RA.Width;
                RA.Y = this.Top;
                RA.FormRefresh();
            }
            if (RS.Visible)
            {
                RS.X = this.Left + this.Width;
                RS.Y = this.Top;
                RS.FormRefresh();
            }
            if (ST.Visible)
            {
                ST.X = this.Left + this.Width;
                ST.Y = this.Bottom - 175;
                ST.FormRefresh();
            }
        }
        #endregion

        #region 单击事件
        private void 上_Click(object sender, EventArgs e)
        {
            if (!AttackFlag)
            {
                if (Y == 1 || Y == 2 || Y == 3)
                {
                    TimeUpAndPhysicalValueDown();
                    Y--;
                    this.地图.Controls.Add(this.角色, X, Y);
                    GetPresentScene();
                    EventBring();
                }
            }
        }
        private void 下_Click(object sender, EventArgs e)
        {
            if (!AttackFlag)
            {
                if (Y == 0 || Y == 1 || Y == 2)
                {
                    TimeUpAndPhysicalValueDown();
                    Y++;
                    this.地图.Controls.Add(this.角色, X, Y);
                    GetPresentScene();
                    EventBring();
                }
            }
        }
        private void 左_Click(object sender, EventArgs e)
        {
            if (!AttackFlag)
            {
                if (X == 1 || X == 2 || X == 3)
                {
                    TimeUpAndPhysicalValueDown();
                    X--;
                    this.地图.Controls.Add(this.角色, X, Y);
                    GetPresentScene();
                    EventBring();
                }
            }
        }
        private void 右_Click(object sender, EventArgs e)
        {
            if (!AttackFlag)
            {
                if (X == 0 || X == 1 || X == 2)
                {
                    TimeUpAndPhysicalValueDown();
                    X++;
                    this.地图.Controls.Add(this.角色, X, Y);
                    GetPresentScene();
                    EventBring();
                }
            }
        }
        private void 提交按钮_Click(object sender, EventArgs e)
        {
            if (!AttackFlag)
            {
                if (this.角色输入面板.Text == "")
                {
                    系统提示面板Refresh(PresentScene);
                    return;
                }
                else if (this.角色输入面板.Text != "")
                {
                    火腿肠头像.Visible = false;
                    TimeUpAndPhysicalValueDown();
                    string ActionFeedBack = "";
                    if (roleAction.getActionFeedBack(this.角色输入面板.Text, out ActionFeedBack))
                    {
                        系统提示面板Refresh(ActionFeedBack);
                        this.角色输入面板.Text = "";
                        return;
                    }
                    if (L1AFB.getActionFeedBack(this.角色输入面板.Text, X, Y, out ActionFeedBack))
                    {
                        系统提示面板Refresh(ActionFeedBack);
                        if (ActionFeedBack.Contains("枪里还有最后一颗子弹"))
                        {
                            HavePistol = true;
                            var IsHavePistol = TLU.Rucksacks.Find("小鑫");
                            IsHavePistol.HavePistol = 1;
                            TLU.SaveChanges();
                            RS.FormRefresh();
                        }
                        else if (ActionFeedBack.Contains("Level1达成"))
                        {
                            MyMessageBox.Show("章节一通关。", "恭喜");
                            this.Close();
                        }
                        this.角色输入面板.Text = "";
                        return;
                    }
                    SceneNullActionFeedBack();
                }
            }
            else if (AttackFlag)
            {
                if (this.角色输入面板.Text != "")
                {
                    TimeUpAndPhysicalValueDown();
                    string ActionFeedBack = "";
                    if (roleAction.getActionFeedBack(this.角色输入面板.Text, out ActionFeedBack))
                    {
                        系统提示面板Refresh(ActionFeedBack);
                        this.角色输入面板.Text = "";
                        return;
                    }
                    string Mark = "";
                    if (roleAttack.getMark(this.角色输入面板.Text, out Mark))
                    {
                        if (!CountResult(Mark))
                        {
                            系统提示面板Refresh("你在和丧尸交战的时候中毒了，体力减20\n" + PresentEvent);
                            GetSkillTwo();
                        }
                        else
                        {
                            ZombieKilled();
                        }
                        return;
                    }
                    AttackNullActionFeedBack();
                }
                else
                {
                    系统提示面板Refresh(PresentEvent.ToString());
                }
            }
        }
        private void 角色输入面板_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Up && this.角色输入面板.Text == "")
            {
                this.上.PerformClick();
            }
            else if (e.KeyCode == Keys.Down && this.角色输入面板.Text == "")
            {
                this.下.PerformClick();
            }
            else if (e.KeyCode == Keys.Left && this.角色输入面板.Text == "")
            {
                this.左.PerformClick();
            }
            else if (e.KeyCode == Keys.Right && this.角色输入面板.Text == "")
            {
                this.右.PerformClick();
            }
        }
        private void 角色输入面板_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == 13)
            {
                e.Handled = true;
                this.提交按钮.PerformClick();
            }
            else
            {
                return;
            }
        }
        private void 显示或打开地图_Click(object sender, EventArgs e)
        {
            if (this.地图.Visible)
            {
                this.地图.Visible = false;
            }
            else if (!this.地图.Visible)
            {
                this.地图.Visible = true;
            }
        }
        private void 显示属性_Click(object sender, EventArgs e)
        {
            RA.Focus();
            if (RA.Visible == false)
            {
                RA.X = this.Left - RA.Width;
                RA.Y = this.Top;
                RA.FormRefresh();
                RA.Show();
            }
            else
            {
                RA.Visible = false;
            }
        }
        private void 显示背包_Click(object sender, EventArgs e)
        {
            RS.Focus();
            if (RS.Visible == false)
            {
                RS.X = this.Left + this.Width;
                RS.Y = this.Top;
                RS.FormRefresh();
                RS.Show();
            }
            else
            {
                RS.Visible = false;
            }
        }
        private void 我的能力_MouseClick(object sender, MouseEventArgs e)
        {
            ST.Focus();
            if (ST.Visible == false)
            {
                ST.X = this.Left + this.Width;
                ST.Y = this.Bottom - 175;
                ST.FormRefresh();
                ST.Show();
            }
            else
            {
                ST.Visible = false;
            }
        }
        private void TheLastofUs_DoubleClick(object sender, EventArgs e)
        {
            if (RA.Visible)
            {
                RA.Hide();
                RA.Show();
            }
            if (RS.Visible)
            {
                RS.Hide();
                RS.Show();
            }
            if (ST.Visible)
            {
                ST.Hide();
                ST.Show();
            }
            this.Focus();
        }
        #endregion

        #region 定时器事件
        private void 系统提示面板Refresh(string Words)
        {
            this.系统提示面板.Text = "";
            content = Words.ToCharArray();
            i = -1;
            TextPlayer.Ctlcontrols.play();
            this.定时器.Start();
        }
        private void 定时器_Tick(object sender, EventArgs e)
        {
            if (i != content.Length - 1)
            {
                i++;
                this.系统提示面板.Text += content[i];
            }
            else
            {
                this.定时器.Stop();
                this.角色输入面板.Text = "";
            }
        }
        private void 丧尸生成器_Tick(object sender, EventArgs e)
        {
            int i = 0;
            var EventFlag = from Flag in TLU.Level1 where Flag.EventFlag == 1 select Flag;
            foreach (var item in EventFlag)
            {
                i++;
            }
            int number = ran.Next(0, i);
            i = -1;
            foreach (var item in EventFlag)
            {
                i++;
                if (number == i)
                {
                    var data = TLU.Level1.Find(item.X, item.Y);
                    data.EventFlag = 0;
                }
            }
            TLU.SaveChanges();
            this.地图.Refresh();
        }
        private void 事件提醒_Tick(object sender, EventArgs e)
        {
            if (j != ItemContent.Length - 1)
            {
                j++;
                事件.Text += ItemContent[j];
            }
            else
            {
                事件提醒.Stop();
                Thread.Sleep(800);
                事件.Text = "";
            }
        }
        private void 丧尸头像闪烁_Tick(object sender, EventArgs e)
        {
            if (FlashTimes % 2 == 0)
            {
                丧尸头像.Visible = false;
                死丧尸头像.Visible = true;
            }
            else if (FlashTimes % 2 == 1)
            {
                丧尸头像.Visible = true;
                死丧尸头像.Visible = false;
            }
            if (FlashTimes == 4)
            {
                丧尸头像闪烁.Stop();
                死丧尸头像.Visible = false;
                FlashTimes = 0;
            }
            FlashTimes++;
        }
        private void Prase(string Words)
        {
            事件.Text = "";
            ItemContent = Words.ToCharArray();
            j = -1;
        }
        #endregion

        #region 声效
        private void BGPPlayer_StatusChange(object sender, EventArgs e)
        {
            if ((int)BGPPlayer.playState == 1)
            {
                BGPPlayer.Ctlcontrols.play();
            }
        }
        private void 背景音乐_Click(object sender, EventArgs e)
        {
            if ((int)BGPPlayer.playState == 3)
            {
                背景音乐.Visible = false;
                无背景音乐.Visible = true;
                BGPPlayer.Ctlcontrols.pause();
            }
        }
        private void 无背景音乐_Click(object sender, EventArgs e)
        {
            if ((int)BGPPlayer.playState == 2)
            {
                背景音乐.Visible = true;
                无背景音乐.Visible = false;
                BGPPlayer.Ctlcontrols.play();
            }
        }
        #endregion

        #region 丧尸击杀
        public void ZombieKilled()
        {
            sp.SoundLocation = @"C:/Users/asus1/Desktop/C#程序/末日余生/video/丧尸死亡.wav";
            sp.Play();
            AttackFlag = false;
            this.角色输入面板.Text = "";
            系统提示面板Refresh("你在和丧尸交战的时候胜利了，获得经验+" + ((RA.GetLevel()/3) + 1) + "\n" + PresentScene.ToString());
            丧尸头像闪烁.Start();
            GainExperience();
            GetSkillOne();
        }
        private void GainExperience()
        {
            var roleAttribute = TLU.RoleAttributes.Find("小鑫");
            roleAttribute.Experience = (Convert.ToInt32(roleAttribute.Experience) + (this.ZombieLevel / 3) + 1).ToString();
            var ex = from experience in TLU.RoleLevels orderby experience.LevelExperience descending select experience;
            foreach (var item in ex)
            {
                if (Convert.ToInt32(roleAttribute.Experience) >= item.LevelExperience)
                {
                    roleAttribute.RoleLevel = item.RoleLevel1.ToString();
                    roleAttribute.ForceValue = item.LevelForceValue.ToString();
                    break;
                }
            }
            TLU.SaveChanges();
            RA.FormRefresh();
            var MaxPhysicalValue = TLU.RoleLevels.Find(RA.GetLevel());
            int PhysicalValue = (int)MaxPhysicalValue.MAXPhysicalValue;
            var MAXPhysicalValue = TLU.Rucksacks.Find("小鑫");
            MAXPhysicalValue.MAXPhysicalValue = PhysicalValue.ToString();
            TLU.SaveChanges();
            PhysicalValueRefresh();
        }
        private bool CountResult(string Mark)
        {
            if (Mark == "Fist")
            {
                int RoleNumber = ran.Next(0, RA.ForceValue * 8);
                int ZombieNumber = ran.Next(0, ZombieForce);
                if (RoleNumber + SkillOne >= ZombieNumber)
                {
                    GainExperience();
                    return true;
                }
                else
                {
                    this.体力值.Text = (Convert.ToInt32(this.体力值.Text.ToString()) - 20).ToString();
                    Poisoning();
                    return false;
                }
            }
            else if (Mark == "Weapon")
            {
                int RoleNumber = ran.Next(0, RA.GeneralValue * 5);
                int ZombieNumber = ran.Next(0, ZombieForce);
                if (RoleNumber + SkillOne <= ZombieNumber)
                {
                    GainExperience();
                    return true;
                }
                else
                {
                    this.体力值.Text = (Convert.ToInt32(this.体力值.Text.ToString()) - 20).ToString();
                    Poisoning();
                    return false;
                }
            }
            return false;
        }
        #endregion

        #region 道具获得
        private void SausageAdd()
        {
            var Sausage = TLU.Rucksacks.Find("小鑫");
            Sausage.Sausage += 1;
            TLU.SaveChanges();
            RS.FormRefresh();
        }
        private void TentAdd()
        {
            var Sausage = TLU.Rucksacks.Find("小鑫");
            Sausage.Tent += 1;
            TLU.SaveChanges();
            RS.FormRefresh();
        }
        private void BulletsAdd()
        {
            var Sausage = TLU.Rucksacks.Find("小鑫");
            Sausage.Bullets += 1;
            TLU.SaveChanges();
            RS.FormRefresh();
        }
        #endregion

        #region 文字交互
        private void EventBring()
        {
            火腿肠头像.Visible = false;
            var data = TLU.Level1.Find(X, Y);
            if (data.EventFlag == 0)
            {
                int number = ran.Next(0,99);
                if (number >= 0 && number < 36)
                {
                    var Event = TLU.EventTables.Find("0", "0");
                    PresentEvent = Event.EventDescribe.ToString();
                    系统提示面板Refresh(Event.EventDescribe.ToString() + "\n" + PresentScene.ToString());
                    data.EventFlag = 1;
                }
                else if(number >= 36 && number < 71)
                {
                    AttackFlag = true;
                    var Event = TLU.EventTables.Find("1", "0");
                    var ZombieForce = TLU.ZombieAttributes.Find(RA.GetLevel());
                    this.ZombieLevel = RA.GetLevel();
                    this.ZombieForce = Convert.ToInt32(ZombieForce.ForceValue);
                    PresentEvent = Event.EventDescribe.ToString() + ZombieLevel + "级丧尸，攻击力" + ZombieForce.ForceValue;
                    系统提示面板Refresh(PresentEvent);
                    丧尸头像.Visible = true;
                    sp.SoundLocation = @"C:/Users/asus1/Desktop/C#程序/末日余生/video/丧尸出现.wav";
                    sp.Play();
                    data.EventFlag = 1;
                }
                else if(number >= 71 && number < 86)
                {
                    var Event = TLU.EventTables.Find("2", "0");
                    火腿肠头像.Visible = true;
                    PresentEvent = Event.EventDescribe.ToString();
                    系统提示面板Refresh(Event.EventDescribe.ToString() + "\n" + PresentScene.ToString());
                    data.EventFlag = 1;
                    SausageAdd();
                }
                else if (number >= 86 && number < 95)
                {
                    var Event = TLU.EventTables.Find("2", "1");
                    PresentEvent = Event.EventDescribe.ToString();
                    系统提示面板Refresh(Event.EventDescribe.ToString() + "\n" + PresentScene.ToString());
                    data.EventFlag = 1;
                    TentAdd();
                }
                else if (number >= 95 && number < 99)
                {
                    if (HavePistol)
                    {
                        var Event = TLU.EventTables.Find("2", "2");
                        PresentEvent = Event.EventDescribe.ToString();
                        系统提示面板Refresh(Event.EventDescribe.ToString() + "\n" + PresentScene.ToString());
                        data.EventFlag = 1;
                        BulletsAdd();
                    }
                    else
                    {
                        var Event = TLU.EventTables.Find("0", "0");
                        PresentEvent = Event.EventDescribe.ToString();
                        系统提示面板Refresh(Event.EventDescribe.ToString() + "\n" + PresentScene.ToString());
                        data.EventFlag = 1;
                    }
                }
                else if (number == 99)
                {
                    var Event = TLU.EventTables.Find("3", "1");
                    PresentEvent = Event.EventDescribe.ToString();
                    系统提示面板Refresh(Event.EventDescribe.ToString());
                    data.EventFlag = 1;
                }
                TLU.SaveChanges();
            }
            else
            {
                PresentScene = data.SceneDescribe.ToString();
                系统提示面板Refresh(data.SceneDescribe.ToString());
            }
        }      
        private void SceneNullActionFeedBack()
        {
            系统提示面板Refresh("做一些相关的举动吧\n" + PresentScene.ToString());
            this.角色输入面板.Text = "";
        }
        private void AttackNullActionFeedBack()
        {
            系统提示面板Refresh("做一些相关的举动吧\n" + PresentEvent.ToString());
            this.角色输入面板.Text = "";
        }
        private void GetPresentScene()
        {
            var data = TLU.Level1.Find(X, Y);
            PresentScene = data.SceneDescribe.ToString();
        }
        #endregion

        #region 属性变更
        private void PhysicalValueRefresh()
        {
            var PhysicalValue = TLU.Rucksacks.Find("小鑫");
            体力值.Text = PhysicalValue.PhysicalValue;
            体力上限.Text = "/" + PhysicalValue.MAXPhysicalValue;
            PhysicalValueProving();
        }
        public void PhysicalValueAdd()
        {
            var PhysicalValue = TLU.Rucksacks.Find("小鑫");
            PhysicalValue.PhysicalValue = Convert.ToString(Convert.ToInt32(PhysicalValue.PhysicalValue) + 20);
            TLU.SaveChanges();
            PhysicalValueRefresh();
        }
        private void PhysicalValueProving()
        {
            var PhysicalValue = TLU.Rucksacks.Find("小鑫");
            if (Convert.ToInt32(体力值.Text) > Convert.ToInt32(PhysicalValue.MAXPhysicalValue))
            {
                PhysicalValue.PhysicalValue = PhysicalValue.MAXPhysicalValue;
                TLU.SaveChanges();
                PhysicalValueRefresh();
            }
            else if (Convert.ToInt32(体力值.Text) > 20 && Convert.ToInt32(体力值.Text) <= 100)
            {
                体力.ForeColor = Color.Black;
                体力值.ForeColor = Color.Black;
                体力上限.ForeColor = Color.Black;
                虚弱.Visible = false;
            }
            else if (Convert.ToInt32(体力值.Text) > 0 && Convert.ToInt32(体力值.Text) <= 20)
            {
                体力.ForeColor = Color.Red;
                体力值.ForeColor = Color.Red;
                体力上限.ForeColor = Color.Red;
                虚弱.Visible = true;
            }
            else if (Convert.ToInt32(体力值.Text) <= 0)
            {
                MyMessageBox.Show("游戏失败。");
                this.Close();
            }
        }
        private void TimeUpAndPhysicalValueDown()
        {
            var PhysicalValue = TLU.Rucksacks.Find("小鑫");
            PhysicalValue.PhysicalValue = Convert.ToString(Convert.ToInt32(PhysicalValue.PhysicalValue) - 1 * IsNightFlag * IsPoisoning);
            PhysicalValueRefresh();
            PhysicalValueProving();

            PhysicalValue.Time = Convert.ToDateTime(PhysicalValue.Time).AddMinutes(20).ToShortTimeString().ToString();
            TLU.SaveChanges();
            TimeRefresh();
        }
        private void TimeRefresh()
        {
            var Time = TLU.Rucksacks.Find("小鑫");
            this.时间.Text = Time.Time;
            IsNight(this.时间.Text);
        }
        private void IsNight(string Time)
        {
            if (String.Compare(Convert.ToDateTime(Time).ToString("HH:mm"), "21:40") > 0 || String.Compare(Convert.ToDateTime(Time).ToString("HH:mm"), "06:00") < 0)
            {
                if (IsNightFlag == 1)
                {
                    Prase("夜深了，体力会加速衰减。");
                    事件提醒.Start();
                }
                IsNightFlag = 2;
            }
        }
        public void SetTime()
        {
            var Time = TLU.Rucksacks.Find("小鑫");
            Time.Time = "6:00";
            TimeRefresh();
            IsNightFlag = 1;
            Prase("你使用了帐篷，安全度过了一个晚上。");
            事件提醒.Start();
        }
        private void Poisoning()
        {
            if (!SkillTwo)
            {
                var Poisoning = TLU.Rucksacks.Find("小鑫");
                Poisoning.IsPoisoning = 2;
                TLU.SaveChanges();
                IsPoisoningRefresh();
            }
            else
            {
                int number = ran.Next(0, 2);
                if (number == 0)
                {
                    var Poisoning = TLU.Rucksacks.Find("小鑫");
                    Poisoning.IsPoisoning = 2;
                    TLU.SaveChanges();
                    IsPoisoningRefresh();
                }
                else
                {
                    Prase("你免疫了一次中毒。");
                    事件提醒.Start();
                }
            }
        }
        private void IsPoisoningRefresh()
        {
            var Poisoning = TLU.Rucksacks.Find("小鑫");
            this.IsPoisoning = (int)Poisoning.IsPoisoning;
            if (IsPoisoning == 1)
            {
                中毒.Visible = false;
            }
            else
            {
                中毒.Visible = true;
            }
        }
        public void Detoxify()
        {
            this.IsPoisoning = 1;
            中毒.Visible = false;
        }
        private void SkillRefresh()
        {
            var IsSkill = TLU.Skills.Find("小鑫");
            if (IsSkill.TheTerminatorOfZombie == 1)
            {
                SkillOne = 2;
            }
            if (IsSkill.Resistance == 1)
            {
                SkillTwo = true;
            }
            ST.FormRefresh();
        }
        #endregion

        #region 技能获得
        private void GetSkillOne()
        {
            int number = ran.Next(0, 99);
            if (number == 49)
            {
                if (SkillOne != 2)
                {
                    var data = TLU.Skills.Find("小鑫");
                    data.TheTerminatorOfZombie = 1;
                    TLU.SaveChanges();
                    Prase("你获得了技能丧尸终结者。");
                    事件提醒.Start();
                }
                SkillRefresh();
            }
        }
        private void GetSkillTwo()
        {
            int number = ran.Next(0, 99);
            if (number == 49)
            {
                if (SkillTwo == false)
                {
                    var data = TLU.Skills.Find("小鑫");
                    data.Resistance = 1;
                    TLU.SaveChanges();
                    Prase("你获得了毒素抗性");
                    事件提醒.Start();
                }
                SkillRefresh();
            }
        }
        #endregion
    }
}
