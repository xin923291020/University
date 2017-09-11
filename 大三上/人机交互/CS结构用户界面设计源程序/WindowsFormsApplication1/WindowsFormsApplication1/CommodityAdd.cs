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
    public partial class CommodityAdd : CCSkinMain
    {
        public CommodityAdd()
        {
            InitializeComponent();
        }

        private void 新增_Click(object sender, EventArgs e)
        {
            if (this.商品名输入框.Text == "")
            {
                MessageBox.Show("商品名不能为空。");
                this.商品名输入框.Focus();
                return;
            }
            if (this.单价输入框.Text == "")
            {
                MessageBox.Show("商品单价不能为空。");
                this.单价输入框.Focus();
                return;
            }
            if (this.单位选择.Text == "")
            {
                MessageBox.Show("请选择单位。");
                this.单位选择.Focus();
                return;
            }
        }

        private void CommodityAdd_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Hide();
            e.Cancel = true;
        }
    }
}
