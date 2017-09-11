using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using CCWin;

namespace Calculate
{
    public partial class 计算器 : CCSkinMain
    {
        double a = 0;
        double b = 0;
        bool c = false;
        string d;
        public 计算器()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (c == true)
            {
                textBox1.Text = "";
                c = false;
            }
            textBox1.Text += "1";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (c == true)
            {
                textBox1.Text = "";
                c = false;
            }
            textBox1.Text += "2";
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (c == true)
            {
                textBox1.Text = "";
                c = false;
            }
            textBox1.Text += "3";
        }

        private void button5_Click(object sender, EventArgs e)
        {
            if (c == true)
            {
                textBox1.Text = "";
                c = false;
            }
            textBox1.Text += "4";
        }

        private void button6_Click(object sender, EventArgs e)
        {
            if (c == true)
            {
                textBox1.Text = "";
                c = false;
            }
            textBox1.Text += "5";
        }

        private void button7_Click(object sender, EventArgs e)
        {
            if (c == true)
            {
                textBox1.Text = "";
                c = false;
            }
            textBox1.Text += "6";
        }

        private void button10_Click(object sender, EventArgs e)
        {
            if (c == true)
            {
                textBox1.Text = "";
                c = false;
            }
            textBox1.Text += "7";
        }

        private void button9_Click(object sender, EventArgs e)
        {
            if (c == true)
            {
                textBox1.Text = "";
                c = false;
            }
            textBox1.Text += "8";
        }

        private void button15_Click(object sender, EventArgs e)
        {
            if (c == true)
            {
                textBox1.Text = "";
                c = false;
            }
            textBox1.Text += "9";
        }

        private void button13_Click(object sender, EventArgs e)
        {
            if (c == true)
            {
                textBox1.Text = "";
                c = false;
            }
            textBox1.Text += "0";
            if (d == "/")
            {
                textBox1.Clear();
                MessageBox.Show("除数不能为零", "错误提示", MessageBoxButtons.OK,MessageBoxIcon.Warning);
            }
        }

        private void button11_Click(object sender, EventArgs e)
        {
            c = true;
            b = double.Parse(textBox1.Text);
            d = "+";
        }

        private void button16_Click(object sender, EventArgs e)
        {
            c = true;
            b = double.Parse(textBox1.Text);
            d = "-";
        }

        private void button8_Click(object sender, EventArgs e)
        {
            c = true;
            b = double.Parse(textBox1.Text);
            d = "*";
        }

        private void button4_Click(object sender, EventArgs e)
        {
            c = true;
            b = double.Parse(textBox1.Text);
            d = "/";
        }

        private void button14_Click(object sender, EventArgs e)
        {
            switch (d)
            {
                case "+": a = b + double.Parse(textBox1.Text); break;
                case "-": a = b - double.Parse(textBox1.Text); break;
                case "*": a = b * double.Parse(textBox1.Text); break;
                case "/": a = b / double.Parse(textBox1.Text); break;
                case "log": a = Math.Log(Convert.ToDouble(textBox1.Text),b); break;
            }
            textBox1.Text = a + "";
            c = true;
        }

        private void button12_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
        }

        private void button17_Click(object sender, EventArgs e)
        {
            textBox1.Text = (Convert.ToInt32(textBox1.Text) * Convert.ToInt32(textBox1.Text)).ToString();
        }

        private void button18_Click(object sender, EventArgs e)
        {
            textBox1.Text = (Math.Sqrt(Convert.ToInt32(textBox1.Text))).ToString();
        }

        private void button19_Click(object sender, EventArgs e)
        {
            c = true;
            b = double.Parse(textBox1.Text);
            d = "log";
        }

        private void button20_Click(object sender, EventArgs e)
        {
            textBox1.Text = (Math.Log(Convert.ToInt32(textBox1.Text))).ToString();
        }
    }
}
