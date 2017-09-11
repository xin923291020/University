using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
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
            this.Hide();
            MainForm MF = new MainForm();
            MF.Show();
        }
    }
}
