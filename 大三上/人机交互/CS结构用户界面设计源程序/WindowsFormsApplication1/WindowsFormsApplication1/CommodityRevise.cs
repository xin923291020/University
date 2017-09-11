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
    public partial class CommodityRevise : CCSkinMain
    {
        private bool F2Flag = false;
        public CommodityRevise()
        {
            InitializeComponent();
        }

        private void dataGridView1_CellMouseEnter(object sender, DataGridViewCellEventArgs e)
        {
            if (!this.修改面板.Visible)
            {
                if ((e.ColumnIndex == 0 || e.ColumnIndex == 1 || e.ColumnIndex == 2) && e.RowIndex != -1)
                {
                    F2Flag = true;
                    this.dataGridView1.Rows[e.RowIndex].Cells[0].ToolTipText = "Presh F2 To Revise";
                    this.dataGridView1.Rows[e.RowIndex].Cells[1].ToolTipText = "Presh F2 To Revise";
                    this.dataGridView1.Rows[e.RowIndex].Cells[2].ToolTipText = "Presh F2 To Revise";
                    this.商品名.Text = this.dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString();
                    this.单价.Text = this.dataGridView1.Rows[e.RowIndex].Cells[1].Value.ToString();
                    this.单位.Text = this.dataGridView1.Rows[e.RowIndex].Cells[2].Value.ToString();
                }
                else
                {
                    F2Flag = false;
                }
            }
        }

        private void dataGridView1_KeyDown(object sender, KeyEventArgs e)
        {
            if (F2Flag)
            {
                if (e.KeyCode == Keys.F2)
                {
                    for (int i = 0; i < this.dataGridView1.RowCount; i++)
                    {
                        this.dataGridView1.Rows[i].Cells[0].ToolTipText = "";
                    }
                    this.修改面板.Visible = true;
                }
            }
        }

        private void CommodityRevise_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Hide();
            e.Cancel = true;
        }

        private void dataGridView1_MouseClick(object sender, MouseEventArgs e)
        {
            this.修改面板.Visible = false;
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if ((e.ColumnIndex == 0 || e.ColumnIndex == 1 || e.ColumnIndex == 2) && e.RowIndex != -1)
            {
                this.商品名.Text = this.dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString();
                this.单价.Text = this.dataGridView1.Rows[e.RowIndex].Cells[1].Value.ToString();
                this.单位.Text = this.dataGridView1.Rows[e.RowIndex].Cells[2].Value.ToString();
            }
        }

        private void 保存修改_Click(object sender, EventArgs e)
        {
            MessageBox.Show("修改成功。");
            this.修改面板.Visible = false;
            return;
        }

        private void 隐藏面板_Click(object sender, EventArgs e)
        {
            this.修改面板.Visible = false;
            this.dataGridView1.Focus();
        }

        private void 修改ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (F2Flag)
            {
                for (int i = 0; i < this.dataGridView1.RowCount; i++)
                {
                    this.dataGridView1.Rows[i].Cells[0].ToolTipText = "";
                }
                this.修改面板.Visible = true;
            }
        }
    }
}
