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
    public partial class MainForm : CCSkinMain
    {
        private int checktimes = 0;
        public CommodityForm CF = new CommodityForm();
        public CommodityForm CF1 = new CommodityForm();
        public CommodityAdd CA = new CommodityAdd();
        public CompanyAdd CA1 = new CompanyAdd();
        public CommodityRevise CR = new CommodityRevise();
        public CompanyRevise CR1 = new CompanyRevise();
        public MainForm()
        {
            InitializeComponent();
        }

        #region 菜单
        /// <summary>
        /// 退出系统。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 退出_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void 联系我们_Click(object sender, EventArgs e)    //显示联系方式。
        {
            MyMessageBox.Show("编程人员：杨程鑫。\n联系方式：18932599331", "联系我们");
        }

        private void 新增商品_Click(object sender, EventArgs e)
        {
            CA.ShowDialog();
        }

        private void 新增供货商_Click(object sender, EventArgs e)
        {
            CA1.ShowDialog();
        }
        #endregion

        #region 进出货页面按钮单击监听事件
        /// <summary>
        /// 进货总按钮，用于显示和隐藏子面板。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 进货总按钮_Click(object sender, EventArgs e)
        {
            if(this.进货面板.Visible == false)    //若进货面板未显示，则另其显示。
            {
                if (this.出货面板.Visible == true)    //若出货面板在显示，隐藏出货面板。资金按钮上移。
                {
                    this.资金总按钮.Top -= this.出货面板.Height;
                    this.出货面板.Visible = false;
                }
                if (this.资金面板.Visible == true)    //若资金面板在显示，隐藏资金面板。
                {
                    this.资金面板.Visible = false;
                }
                //修改进货面板所在位置，另其显示。
                int top = this.进货总按钮.Top + this.进货总按钮.Height;
                int left = this.进货总按钮.Left;
                this.进货面板.Top = top;
                this.进货面板.Left = left;
                this.进货面板.Visible = true;
                //出货，资金按钮下移。
                this.出货总按钮.Top += this.进货面板.Height;
                this.资金总按钮.Top += this.进货面板.Height;
            }
            else    //若进货面板已显示，则隐藏。
            {
                this.进货面板.Visible = false;
                this.出货总按钮.Top -= this.进货面板.Height;
                this.资金总按钮.Top -= this.进货面板.Height;
            }
        }

        /// <summary>
        /// 出货总按钮，用于显示和隐藏子面板。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 出货总按钮_Click(object sender, EventArgs e)
        {
            if (this.出货面板.Visible == false)   //若出货面板未显示，则另其显示。
            {
                if (this.进货面板.Visible == true)    //若进货面板在显示，另其隐藏，上移出货，资金按钮。
                {
                    this.出货总按钮.Top -= this.进货面板.Height;
                    this.资金总按钮.Top -= this.进货面板.Height;
                    this.进货面板.Visible = false;
                }
                if (this.资金面板.Visible == true)    //若资金面板在显示，另其隐藏。
                {
                    this.资金面板.Visible = false;
                }
                //修改出货面板所在位置。
                int top = this.出货总按钮.Top + this.出货总按钮.Height;
                int left = this.出货总按钮.Left;
                this.出货面板.Top = top;
                this.出货面板.Left = left;
                this.出货面板.Visible = true;
                //资金按钮下移。
                this.资金总按钮.Top += this.出货面板.Height;
            }
            else    //若出货面板已显示，则隐藏。
            {
                this.出货面板.Visible = false;
                this.资金总按钮.Top -= this.出货面板.Height;
            }
        }

        /// <summary>
        /// 资金总按钮，用于显示和隐藏子面板。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 资金总按钮_Click(object sender, EventArgs e)
        {
            if (this.资金面板.Visible == false)   //若资金面板未显示，则另其显示。
            {
                if (this.出货面板.Visible == true)
                {
                    this.资金总按钮.Top -= this.出货面板.Height;
                    this.出货面板.Visible = false;
                }
                if (this.进货面板.Visible == true)
                {
                    this.出货总按钮.Top -= this.进货面板.Height;
                    this.资金总按钮.Top -= this.进货面板.Height;
                    this.进货面板.Visible = false;
                }
                int top = this.资金总按钮.Top + this.资金总按钮.Height;
                int left = this.资金总按钮.Left;
                this.资金面板.Top = top;
                this.资金面板.Left = left;
                this.资金面板.Visible = true;
            }
            else    //若资金面板已显示，则隐藏。
            {
                this.资金面板.Visible = false;
            }
        }

        /// <summary>
        ///  进货子按钮，添加进货页眉，初始化供应商的选项，根据数据库已有时间戳生成当前时间戳。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 进货子按钮_Click(object sender, EventArgs e)
        {
            WelcomePageClose();
            if (!this.页眉框.TabPages.Contains(进货)) //如果进货页面隐藏，则初始化页面中的供货商。
            {
            }
            else    //若当前页眉中无进货页眉，则添加。
            {
                this.页眉框.SelectedTab = this.进货;
            }
        }

        /// <summary>
        /// 用于显示进货管理页眉。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 进货管理子按钮_Click(object sender, EventArgs e)
        {
            WelcomePageClose();
            if (!this.页眉框.TabPages.Contains(进货管理))
            {
                this.页眉框.TabPages.Add(进货管理);
                this.页眉框.SelectedTab = this.进货管理;
                PurchasedListRefresh();
            }
            else
            {
                this.页眉框.SelectedTab = this.进货管理;
            }
            
        }

        /// <summary>
        /// 进货子按钮，添加进货页眉，初始化购货商的选项，根据数据库已有时间戳生成当前时间戳。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 出货子按钮_Click(object sender, EventArgs e)
        {
            WelcomePageClose();
            if (!this.页眉框.TabPages.Contains(出货))
            {
                this.页眉框.TabPages.Add(出货);
                this.页眉框.SelectedTab = this.出货;
            }
            else
            {
                this.页眉框.SelectedTab = this.出货;
            }
        }

        private void 出货管理子按钮_Click(object sender, EventArgs e)
        {
            WelcomePageClose();
            if (!this.页眉框.TabPages.Contains(出货管理))
            {
                this.页眉框.TabPages.Add(出货管理);
                this.页眉框.SelectedTab = this.出货管理;
            }
            else
            {
                this.页眉框.SelectedTab = this.出货管理;
            }
        }

        private void 查看资金子按钮_Click(object sender, EventArgs e)
        {
            WelcomePageClose();
            if (!this.页眉框.TabPages.Contains(资金))
            {
                GetIncomeExpendAndProfit();
                this.页眉框.TabPages.Add(资金);
                GetIncomeExpendAndProfit();
                this.页眉框.SelectedTab = this.资金;
            }
            else
            {
                GetIncomeExpendAndProfit();
                this.页眉框.SelectedTab = this.资金;
            }
        }

        /// <summary>
        ///  关闭按钮，提示功能，关闭后清空进货页眉项目。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 进货单关闭按钮_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("记录未保存，确定要关闭此页面吗？", "温馨提示", MessageBoxButtons.OKCancel);
            if (result == DialogResult.OK)
            {
                this.进货单现金输入框.Text = "";
                this.进货单总金额标签.Text = "";
                this.进货单找零金额标签.Text = "";
                this.页眉框.TabPages.Remove(进货);
                this.进货单供应商下拉列表框.SelectedIndex = -1;
                this.进货单供应商下拉列表框.Items.Clear();
                while (this.进货单表格.RowCount != 0)
                {
                    this.进货单表格.Rows.RemoveAt(0);
                }
            }
            else
            {
                return;
            }
        }

        /// <summary>
        /// 进货单商品列表显示按钮。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 添加_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < CF.ListLength; i++)
            {
                CF.SelectList[i] = "";
            }
            CF.ListLength = 0;
            CF.ShowDialog();
        }

        /// <summary>
        /// 出货单商品列表显示按钮。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 添加1_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < CF1.ListLength; i++)
            {
                CF1.SelectList[i] = "";
            }
            CF1.ListLength = 0;
            CF1.ShowDialog();
        }

        /// <summary>
        /// 进货单保存按钮
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 进货单保存按钮_Click(object sender, EventArgs e)
        {
            if (this.进货单供应商下拉列表框.Text != "")
            {
                if (this.进货单总金额标签.Text != "合计")
                {
                    if (this.进货单现金输入框.Text != "")
                    {
                        MyMessageBox.Show("保存成功");
                    }
                    else
                    {
                        MyMessageBox.Show("请输入支付金额");
                    }
                }
                else
                {
                    MyMessageBox.Show("请输入个数");
                }
            }
            else
            {
                MyMessageBox.Show("请选择供货商");
            }
        }

        /// <summary>
        /// 出货单保存按钮。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 出货单保存按钮_Click(object sender, EventArgs e)
        {
            if (this.出货单购货商.Text != "")
            {
                if (this.出货单总金额标签.Text != "合计")
                {
                    if (this.出货单现金输入框.Text != "")
                    {
                        MyMessageBox.Show("保存成功");
                    }
                    else
                    {
                        MyMessageBox.Show("请输入支付金额");
                    }
                }
                else
                {
                    MyMessageBox.Show("请输入个数。");
                }
            }
            else
            {
                MyMessageBox.Show("请选择出货商");
            }
        }
        #endregion

        #region 页眉监听事件
        /// <summary>
        /// 关闭当前双击的页眉。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 页眉框_DoubleClick(object sender, EventArgs e)
        {
            if (this.页眉框.SelectedTab.Text == "进货")
            {
                this.进货单供应商下拉列表框.Items.Clear();
            }
            this.页眉框.TabPages.Remove(this.页眉框.SelectedTab);
        }

        /// <summary>
        /// 刷新进货管理中的进货信息。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 页眉框_Click(object sender, EventArgs e)
        {
            if (this.页眉框.SelectedTab.Text == "进货管理")
            {
                PurchasedListRefresh();
            }
            if (this.页眉框.SelectedTab.Text == "资金")
            {
                GetIncomeExpendAndProfit();
            }
        }
        #endregion

        #region 焦点监听事件

        /// <summary>
        /// 进货单单元格编辑事件。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 进货单表格_CellEndEdit(object sender, DataGridViewCellEventArgs e)
        {
            if (this.进货单表格.Rows[e.RowIndex].Cells[3].Value != null)
            {
                int num;
                if (int.TryParse(this.进货单表格.Rows[e.RowIndex].Cells[3].Value.ToString(), out num))
                {
                    if (num > 0)
                    {
                        this.进货单表格.Rows[e.RowIndex].Cells[4].Value = Convert.ToString(Convert.ToInt32(this.进货单表格.Rows[e.RowIndex].Cells[3].Value) * Convert.ToInt32(this.进货单表格.Rows[e.RowIndex].Cells[2].Value));
                        this.进货单总金额标签.Text = "0";
                        for (int i = 0; i < this.进货单表格.RowCount; i++)
                        {
                            this.进货单总金额标签.Text = Convert.ToString(Convert.ToInt32((this.进货单总金额标签.Text)) + Convert.ToInt32(this.进货单表格.Rows[i].Cells[4].Value));
                        }
                    }
                    else
                    {
                        MyMessageBox.Show("请输入正数。");
                    }
                }
                else
                {
                    MyMessageBox.Show("请输入整数。");
                }
            }
        }

        /// <summary>
        /// 出货单单元格编辑事件。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 出货单表格_CellEndEdit(object sender, DataGridViewCellEventArgs e)
        {
            if (this.出货单表格.Rows[e.RowIndex].Cells[3].Value != null)
            {
                int num;
                if (int.TryParse(this.出货单表格.Rows[e.RowIndex].Cells[3].Value.ToString(), out num))
                {
                    if (num > 0)
                    {
                        this.出货单表格.Rows[e.RowIndex].Cells[4].Value = Convert.ToString(Convert.ToInt32(this.出货单表格.Rows[e.RowIndex].Cells[3].Value) * Convert.ToInt32(this.出货单表格.Rows[e.RowIndex].Cells[2].Value));
                        this.出货单总金额标签.Text = "0";
                        for (int i = 0; i < this.出货单表格.RowCount; i++)
                        {
                            this.出货单总金额标签.Text = Convert.ToString(Convert.ToInt32((this.出货单总金额标签.Text)) + Convert.ToInt32(this.出货单表格.Rows[i].Cells[4].Value));
                        }
                    }
                    else
                    {
                        MyMessageBox.Show("请输入正数。");
                    }
                }
                else
                {
                    MyMessageBox.Show("请输入整数。");
                }
            }
        }

        /// <summary>
        /// 进货单现金输入框焦点离开监听事件。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 进货单现金输入框_Leave(object sender, EventArgs e)
        {
            if (this.进货单现金输入框.Text != "")
            {
                int num;
                if (int.TryParse(this.进货单现金输入框.Text, out num))
                {
                    if (num >= Convert.ToInt32(this.进货单总金额标签.Text))
                    {
                        this.进货单找零金额标签.Text = Convert.ToString(num - Convert.ToInt32(this.进货单总金额标签.Text));
                    }
                    else
                    {
                        MyMessageBox.Show("支付现金应大于总金额。");
                        this.进货单现金输入框.Focus();
                    }
                }
                else
                {
                    MyMessageBox.Show("请输入整数。");
                    this.进货单现金输入框.Focus();
                }
            }
        }

        /// <summary>
        /// 出货单现金输入框焦点离开监听事件。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 出货单现金输入框_Leave(object sender, EventArgs e)
        {
            if (this.出货单现金输入框.Text != "")
            {
                int num;
                if (int.TryParse(this.出货单现金输入框.Text, out num))
                {
                    if (num >= Convert.ToInt32(this.出货单总金额标签.Text))
                    {
                        this.出货单找零金额标签.Text = Convert.ToString(num - Convert.ToInt32(this.出货单总金额标签.Text));
                    }
                    else
                    {
                        MyMessageBox.Show("支付现金应大于总金额。");
                        this.出货单现金输入框.Focus();
                    }
                }
                else
                {
                    MyMessageBox.Show("请输入整数。");
                    this.出货单现金输入框.Focus();
                }
            }
        }
        #endregion

        #region 主界面函数
        /// <summary>
        /// 主界面加载的时候执行的函数。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void MainForm_Load(object sender, EventArgs e)
        {
            PurchasedListRefresh();
            GetIncomeExpendAndProfit();
        }

        /// <summary>
        /// 主界面重拾焦点时触发的函数。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void MainForm_Activated(object sender, EventArgs e)
        {
            if (checktimes == 0)
            {
            }
            if (checktimes == 1)
            {
                Application.Exit();
                Application.Restart();
            }
            if (CF.flag)
            {
                CF.flag = false;
                for (int i = 0; i < CF.ListLength; i++)
                {
                }
            }
            if (CF1.flag)
            {
                CF1.flag = false;
                for (int i = 0; i < CF1.ListLength; i++)
                {
                }
            }
        }
        #endregion

        #region 进货管理函数
        /// <summary>
        /// 进货管理表格第五列点击事件监听函数。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 进货管理表格_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.ColumnIndex == 5)
            {
            }
        }
        #endregion

        #region 表格绘制事件
        private void PurchasedListRefresh()
        {
        }

        /// <summary>
        /// 获得收入，支出，盈利金额。
        /// </summary>
        private void GetIncomeExpendAndProfit()
        {
        }

        /// <summary>
        /// 资金表格行绘制颜色事件。
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void 资金表格_RowPostPaint(object sender, DataGridViewRowPostPaintEventArgs e)
        {
        }
        #endregion

        private void 修改供货商_Click(object sender, EventArgs e)
        {
            CR1.ShowDialog();
        }

        private void 修改商品_Click(object sender, EventArgs e)
        {
            CR.ShowDialog();
        }

        private void 页眉框_DrawItem(object sender, DrawItemEventArgs e)
        {
            SolidBrush BLACK = new SolidBrush(Color.Black);
            SolidBrush MyBlue = new SolidBrush(Color.FromArgb(128, 208, 255));
            Rectangle BigRec = 页眉框.ClientRectangle;
            e.Graphics.FillRectangle(MyBlue, BigRec);

            StringFormat SF = new StringFormat();
            SF.Alignment = StringAlignment.Center;
            Pen MyPen = new Pen(MyBlue, 3);
            for (int i = 0; i < 页眉框.TabPages.Count;i++ )
            {
                Rectangle rec = 页眉框.GetTabRect(i);
                e.Graphics.FillRectangle(MyBlue, rec);
                Point p1 = new Point(rec.X, rec.Y - 2);
                Point p2 = new Point(rec.X + rec.Width, rec.Y - 2);
                e.Graphics.DrawLine(MyPen,p1,p2);
                Point p3 = new Point(rec.X - 2,rec.Y - 2);
                Point p4 = new Point(rec.X - 2, rec.Y + rec.Height);
                e.Graphics.DrawLine(MyPen, p3, p4);
                e.Graphics.DrawString(页眉框.TabPages[i].Text, new Font("Microsoft YaHei UI", 9), BLACK, rec, SF);
            }
        }

        private void 修改密码_Click(object sender, EventArgs e)
        {
        }

        private void 链接标签1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (资金面板.Visible == false)
            {
                this.资金总按钮.PerformClick();
                Thread.Sleep(500);
                this.查看资金子按钮.PerformClick();
            }
            else
            {
                this.查看资金子按钮.PerformClick();
            }
        }

        private void WelcomePageClose()
        {
            if (关闭欢迎.Checked == true)
            {
                页眉框.TabPages.Remove(欢迎);
            }
        }

        private void 链接标签4_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (进货面板.Visible == false)
            {
                this.进货总按钮.PerformClick();
                Thread.Sleep(500);
                this.进货管理子按钮.PerformClick();
            }
            else
            {
                this.进货管理子按钮.PerformClick();
            }
        }

        private void 链接标签3_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            MyMessageBox.Show("敬请期待");
        }

        private void 链接标签5_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (进货面板.Visible == false)
            {
                this.进货总按钮.PerformClick();
                Thread.Sleep(500);
                this.进货子按钮.PerformClick();
            }
            else
            {
                this.进货子按钮.PerformClick();
            }
        }

        private void 链接标签2_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (出货面板.Visible == false)
            {
                this.出货总按钮.PerformClick();
                Thread.Sleep(500);
                this.出货管理子按钮.PerformClick();
            }
            else
            {
                this.出货管理子按钮.PerformClick();
            }
        }

        private void MainForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
    }
}
