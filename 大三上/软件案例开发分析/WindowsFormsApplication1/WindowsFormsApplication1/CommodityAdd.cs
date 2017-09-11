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
    public partial class CommodityAdd : CCSkinMain
    {
        ShopContext sp = new ShopContext();
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
            try
            {
                var data = sp.commodities.Find(this.商品名输入框.Text);
                if (data.CommodityName == this.商品名输入框.Text)
                {
                    MessageBox.Show("不能重复录入商品。");
                    this.商品名输入框.Focus();
                    return;
                }
            }
            catch
            {
                commodity cd = new commodity();
                cd.CommodityName = this.商品名输入框.Text;
                cd.Price = this.单价输入框.Text;
                cd.Unit = this.单位选择.Text;
                sp.commodities.Add(cd);
                sp.SaveChanges();
                MessageBox.Show("新增商品成功");
                this.Hide();
                this.商品名输入框.Text = "";
                this.单价输入框.Text = "";
                this.单位选择.SelectedIndex = -1;
            }
        }

        private void CommodityAdd_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Hide();
            e.Cancel = true;
        }
    }
}
