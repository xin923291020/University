using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using CCWin;

namespace 增加学生
{
    public partial class 学生信息 : CCSkinMain
    {
        private string sex = "";
        public 学生信息()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            listBox1.Items.Add(comboBox1.SelectedItem);
            listBox1.Items.Add("姓名：" + textBox1.Text);
            if(radioButton1.Checked)
            {
                sex = "男";
            }
            else
	        {
                sex = "女";
	        }
            listBox1.Items.Add("性别：" + sex);
            if (checkBox1.Checked)
            {
                listBox1.Items.Add("已签到");
            }
            else
            {
                listBox1.Items.Add("未签到");
            }
        }
    }
}
