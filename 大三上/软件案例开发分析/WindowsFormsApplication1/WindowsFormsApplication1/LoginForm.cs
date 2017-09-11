using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using WindowsFormsApplication1.Models;
using System.Threading;
using CCWin;

namespace WindowsFormsApplication1
{
    public partial class LoginForm : CCSkinMain
    {
        public bool flag = false;
        public LoginForm()
        {
            InitializeComponent();
        }

        private void loginButton_MouseClick(object sender, MouseEventArgs e)
        {
            Login();
        }

        private void cancelButton_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void LoginForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void userTextBox_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                this.passwordTextBox.Focus();
            }
        }

        private void passwordTextBox_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                Login();
            }
        }

        private void Login()
        {
            int i = 0;
            string user = userTextBox.Text;
            string password = passwordTextBox.Text;
            using (ShopContext sp = new ShopContext())
            {
                var result = (from u in sp.userLogins where u.UserNumber == user select u);
                foreach (var item in result)
                {
                    i++;
                    if (item.UserPassWord == password)
                    {
                        this.Close();
                        new Thread(() => Application.Run(new MainForm(user, password))).Start();
                        return;
                    }
                    else
                    {
                        MyMessageBox.Show("密码错误", "温馨提示");
                        passwordTextBox.Focus();
                        return;
                    }
                }
                if (i == 0)
                {
                    MyMessageBox.Show("账号不存在", "温馨提示");
                    userTextBox.Focus();
                }
            }
        }
    }
}
