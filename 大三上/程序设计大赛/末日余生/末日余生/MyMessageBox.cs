using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using CCWin;

namespace 末日余生
{
    public partial class MyMessageBox : CCSkinMain
    {
        static MyMessageBox myMessageBox = null;
        public MyMessageBox()
        {
            InitializeComponent();
        }
        public static MyMessageBox getMyMessageBox(string content, String title)
        {
            if (myMessageBox == null)
            {
                myMessageBox = new MyMessageBox();
                myMessageBox.Content.Text = content;
                myMessageBox.Text = title;
            }
            else
            {
                myMessageBox.Content.Text = content;
                myMessageBox.Text = title;
                return myMessageBox;
            }
            return myMessageBox;
        }

        public static void Show(string content)
        {
            myMessageBox = getMyMessageBox(content, "");
            myMessageBox.ShowDialog();
        }

        public static void Show(string content, String title)
        {
            myMessageBox = getMyMessageBox(content, title);
            myMessageBox.ShowDialog();
        }

        public static void Show(string content, String title, bool flag)
        {
            if (flag)
            {
                myMessageBox = getMyMessageBox(content, title);
                myMessageBox.ShowDialog();
            }
            else
            {
                myMessageBox = getMyMessageBox(content, title);
                myMessageBox.Show();
            }
        }

        private void Confirm_Click(object sender, EventArgs e)
        {
            myMessageBox.Hide();
        }

        private void MyMessageBox_FormClosing(object sender, FormClosingEventArgs e)
        {
            myMessageBox.Hide();
            e.Cancel = true;
        }
    }
}
