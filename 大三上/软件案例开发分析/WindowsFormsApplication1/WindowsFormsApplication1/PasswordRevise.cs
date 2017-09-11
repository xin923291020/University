using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using WindowsFormsApplication1.Models;
using CCWin;

namespace WindowsFormsApplication1
{
    public partial class PasswordRevise : CCSkinMain
    {
        private string user = "";
        public PasswordRevise(string user)
        {
            this.user = user;
            InitializeComponent();
        }

        private void 确认新密码输入框_Leave(object sender, EventArgs e)
        {
            if(新密码输入框.Text != 确认新密码输入框.Text)
            {
                密码不一致.Visible = true;
            }
        }

        private void 确认新密码输入框_Enter(object sender, EventArgs e)
        {
            密码不一致.Visible = false;
        }

        private void PasswordRevise_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Dispose();
        }

        private void 确认修改_Click(object sender, EventArgs e)
        {
            ConfirmRevisePassword();
        }

        private void 确认新密码输入框_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                ConfirmRevisePassword();
            }
        }

        private void ConfirmRevisePassword()
        {
            if (旧密码输入框.Text == "")
            {
                MyMessageBox.Show("旧密码不能为空");
                旧密码输入框.Focus();
                return;
            }
            if (新密码输入框.Text == "")
            {
                MyMessageBox.Show("新密码不能为空");
                新密码输入框.Focus();
                return;
            }
            if (确认新密码输入框.Text == "")
            {
                MyMessageBox.Show("确认新密码不能为空");
                确认新密码输入框.Focus();
                return;
            }
            if (新密码输入框.Text != 确认新密码输入框.Text)
            {
                MyMessageBox.Show("新密码不一致");
                确认新密码输入框.Focus();
                return;
            }
            ShopContext sp = new ShopContext();
            var result = (from u in sp.userLogins where u.UserNumber == user select u);
            foreach (var item in result)
            {
                if (item.UserPassWord != 旧密码输入框.Text)
                {
                    MyMessageBox.Show("旧密码错误");
                    旧密码输入框.Focus();
                    return;
                }
                break;
            }
            var data = sp.userLogins.Find(user);
            data.UserPassWord = 确认新密码输入框.Text;
            sp.SaveChanges();
            MyMessageBox.Show("修改成功");
            this.Dispose();
        }
    }
}
