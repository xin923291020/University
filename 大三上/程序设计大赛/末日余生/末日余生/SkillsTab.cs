using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using 末日余生.Models;
using CCWin;

namespace 末日余生
{
    public partial class SkillsTab : CCSkinMain
    {
        public int X = 0;
        public int Y = 0;
        public SkillsTab()
        {
            InitializeComponent();
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
        private void SetToolTip()
        {
            提示文本.SetToolTip(丧尸终结者, "丧尸终结者：击杀丧尸的概率增加。");
            提示文本.SetToolTip(毒素抗性, "毒素抗性：与丧尸战斗失败后有一定几率免疫中毒。");
        }
        public void FormRefresh()
        {
            this.Left = X;
            this.Top = Y;
            SkillRefresh();
        }
        private void SkillsTab_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Hide();
            e.Cancel = true;
        }

        private void SkillsTab_Load(object sender, EventArgs e)
        {
            SetToolTip();
            SkillRefresh();
        }
        private void SkillRefresh()
        {
            if (TheLastofUs.SkillOne == 2)
            {
                丧尸终结者.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/丧尸终结者.png");
            }
            if (TheLastofUs.SkillTwo == true)
            {
                毒素抗性.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/毒素抗性.jpg");
            }
        }
    }
}
