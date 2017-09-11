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
    public partial class RoleAttribute : CCSkinMain
    {
        public int ForceValue = 0;
        public int GeneralValue = 0;
        public int X = 0;
        public int Y = 0;
        public RoleAttribute()
        {
            InitializeComponent();
            FormRefresh();
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
        private void RoleAttribute_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Hide();
            e.Cancel = true;
        }

        public void FormRefresh()
        {
            TheLastofUsContext TLU = new TheLastofUsContext();
            this.Left = X;
            this.Top = Y;
            var attribution = TLU.RoleAttributes.Find("小鑫");
            this.等级.Text = attribution.RoleLevel;
            this.经验.Text = attribution.Experience;
            this.ForceValue = Convert.ToInt32(attribution.ForceValue.ToString());
            this.GeneralValue = Convert.ToInt32(attribution.ForceValue.ToString()) + Convert.ToInt32(attribution.WeaponValue.ToString());
            this.武力值.Text = this.GeneralValue.ToString();
            var LevelUpExperience = from experience in TLU.RoleLevels orderby experience.LevelExperience ascending select experience;
            foreach (var item in LevelUpExperience)
            {
                if (Convert.ToInt32(this.经验.Text) < item.LevelExperience)
                {
                    this.经验.Text = this.经验.Text + "/" + item.LevelExperience.ToString();
                    break;
                }
            }
        }

        public int GetLevel()
        {
            return Convert.ToInt32(this.等级.Text);
        }
    }
}
