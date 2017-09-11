using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using CCWin;

namespace WindowsFormsApplication1
{
    public partial class CompanyAdd : CCSkinMain
    {
        public CompanyAdd()
        {
            InitializeComponent();
        }

        private void 新增_Click(object sender, EventArgs e)
        {
            if (this.单位名称输入框.Text == "")
            {
                MessageBox.Show("商品名不能为空。");
                this.单位名称输入框.Focus();
                return;
            }
            if (this.地址输入框.Text == "")
            {
                MessageBox.Show("地址不能为空。");
                this.地址输入框.Focus();
                return;
            }
            if (this.代表人输入框.Text == "")
            {
                MessageBox.Show("代表人不能为空。");
                this.代表人输入框.Focus();
                return;
            }
            if (this.联系电话输入框.Text == "")
            {
                MessageBox.Show("联系电话不能为空。");
                this.联系电话输入框.Focus();
                return;
            }
        }

        private void CompanyAdd_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Hide();
            e.Cancel = true;
        }
    }
}
