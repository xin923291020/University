using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Media;
using 末日余生.Models;
using System.Threading;
using CCWin;

namespace 末日余生
{
    public partial class Rucksack : CCSkinMain
    {
        public int X = 0;
        public int Y = 0;
        char[] RemindContent; int i = 0;
        SoundPlayer sp = new SoundPlayer();

        public Rucksack()
        {
            InitializeComponent();
            this.BulletSoundPlayer.Ctlcontrols.stop();
            FormRefresh();
            SetToolTip();
        }
        protected override CreateParams CreateParams
        {
            get
            {
                const int WS_EX_TOOLWINDOW = 0x80;
                CreateParams cp = base.CreateParams;
                cp.ExStyle |= WS_EX_TOOLWINDOW;      // 不显示在Alt-Tab
                return cp;
            }
        }

        private void Rucksack_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Hide();
            e.Cancel = true;
        }
        private void SetToolTip()
        {
            提示文本.SetToolTip(武器格, "当前装备的武器");
            提示文本.SetToolTip(子弹格, "对低于自己等级的丧尸必杀");
            提示文本.SetToolTip(香肠格, "回复20点体力的香肠");
            提示文本.SetToolTip(帐篷格, "用来过夜的帐篷");
        }
        public void FormRefresh()
        {
            TheLastofUsContext TLU = new TheLastofUsContext();
            this.Left = X;
            this.Top = Y;
            var rucksack = TLU.Rucksacks.Find("小鑫");
            this.子弹数量.Text = rucksack.Bullets.ToString();
            this.香肠数量.Text = rucksack.Sausage.ToString();
            this.帐篷数量.Text = rucksack.Tent.ToString();
            this.解药数量.Text = rucksack.Antidote.ToString();
            if (TheLastofUs.HavePistol)
            {
                子弹格.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/子弹.png");
            }
        }

        private void 香肠格_Click(object sender, EventArgs e)
        {
            TheLastofUs theLastofUs = TheLastofUs.getTheLastofUs();
            if (Convert.ToInt32(this.香肠数量.Text) > 0 && IsEat())
            {
                sp.SoundLocation = @"C:/Users/asus1/Desktop/C#程序/末日余生/video/打开帐篷.wav";
                sp.Play();
                theLastofUs.PhysicalValueAdd();
                TheLastofUsContext TLU = new TheLastofUsContext();
                var rucksack = TLU.Rucksacks.Find("小鑫");
                rucksack.Sausage -= 1;
                TLU.SaveChanges();
                FormRefresh();
            }
            else if (!IsEat())
            {
                Prase("体力已满，不能食用香肠。");
                提醒定时器.Start();
            }
        }
        private void 帐篷格_Click(object sender, EventArgs e)
        {
            TheLastofUsContext TLU = new TheLastofUsContext();
            var rucksack = TLU.Rucksacks.Find("小鑫");
            TheLastofUs theLastofUs = TheLastofUs.getTheLastofUs();
            if (IsNight(rucksack.Time) && rucksack.Tent > 0)
            {
                sp.SoundLocation = @"C:/Users/asus1/Desktop/C#程序/末日余生/video/打开帐篷.wav";
                sp.Play();
                theLastofUs.SetTime();
                rucksack.Tent -= 1;
                TLU.SaveChanges();
                FormRefresh();
            }
            else
            {
                Prase("现在是白天，不能使用帐篷。");
                提醒定时器.Start();
            }
        }
        private void 子弹格_Click(object sender, EventArgs e)
        {
            TheLastofUs theLastofUs = TheLastofUs.getTheLastofUs();
            if (TheLastofUs.HavePistol)
            {
                TheLastofUsContext TLU = new TheLastofUsContext();
                var rucksack = TLU.Rucksacks.Find("小鑫");
                if (rucksack.Bullets > 0)
                {
                    if (theLastofUs.AttackFlag)
                    {
                        BulletSoundPlayer.Ctlcontrols.play();
                        theLastofUs.ZombieKilled();
                        rucksack.Bullets -= 1;
                        TLU.SaveChanges();
                        FormRefresh();
                    }
                    else
                    {
                        Prase("你没有遇到丧尸，不能使用子弹。");
                        提醒定时器.Start();
                    }
                }
            }
        }

        private void 提醒定时器_Tick(object sender, EventArgs e)
        {
            if (i != RemindContent.Length - 1)
            {
                i++;
                提醒.Text += RemindContent[i];
            }
            else
            {
                提醒定时器.Stop();
                Empty();
            }
        }
        public void Empty()
        {
            Thread.Sleep(1000);
            提醒.Text = "";
        }
        private void Prase(string Words)
        {
            提醒.Text = "";
            RemindContent = Words.ToCharArray();
            i = -1;
        }
        private bool IsEat()
        {
            TheLastofUsContext TLU = new TheLastofUsContext();
            var PhysicalValue = TLU.Rucksacks.Find("小鑫");
            if (Convert.ToInt32(PhysicalValue.PhysicalValue) >= Convert.ToInt32(PhysicalValue.MAXPhysicalValue))
            {
                return false;
            }
            return true;
        }
        private bool IsNight(string Time)
        {
            if (String.Compare(Convert.ToDateTime(Time).ToString("HH:mm"), "21:40") > 0 || String.Compare(Convert.ToDateTime(Time).ToString("HH:mm"), "06:00") < 0)
            {
                return true;
            }
            return false;
        }

        private void 解药格_Click(object sender, EventArgs e)
        {
            TheLastofUs theLastofUs = TheLastofUs.getTheLastofUs();
            TheLastofUsContext TLU = new TheLastofUsContext();
            var Antidote = TLU.Rucksacks.Find("小鑫");
            if (Convert.ToInt32(this.解药数量.Text) > 0 && Antidote.IsPoisoning == 2)
            {
                Antidote.Antidote -= 1;
                Antidote.IsPoisoning = 1;
                TLU.SaveChanges();
                theLastofUs.Detoxify();
                FormRefresh();
                Prase("服用了解药，毒解掉了。");
                提醒定时器.Start();
            }
        }
    }
}
