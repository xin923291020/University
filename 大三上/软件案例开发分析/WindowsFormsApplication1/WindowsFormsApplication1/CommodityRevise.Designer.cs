namespace WindowsFormsApplication1
{
    partial class CommodityRevise
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle3 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle4 = new System.Windows.Forms.DataGridViewCellStyle();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.商品名列 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.单价列 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.单位列 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.修改ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.删除ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.commodityBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.shopDataSet = new WindowsFormsApplication1.ShopDataSet();
            this.commodityTableAdapter = new WindowsFormsApplication1.ShopDataSetTableAdapters.commodityTableAdapter();
            this.修改面板 = new System.Windows.Forms.Panel();
            this.隐藏面板 = new System.Windows.Forms.Button();
            this.保存修改 = new System.Windows.Forms.Button();
            this.单位 = new System.Windows.Forms.TextBox();
            this.单价 = new System.Windows.Forms.TextBox();
            this.商品名 = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.contextMenuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.commodityBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.shopDataSet)).BeginInit();
            this.修改面板.SuspendLayout();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.dataGridView1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle1.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle1.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle1.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle1.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridView1.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle1;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.商品名列,
            this.单价列,
            this.单位列});
            this.dataGridView1.ContextMenuStrip = this.contextMenuStrip1;
            this.dataGridView1.DataSource = this.commodityBindingSource;
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle2.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle2.ForeColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.dataGridView1.DefaultCellStyle = dataGridViewCellStyle2;
            this.dataGridView1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView1.EnableHeadersVisualStyles = false;
            this.dataGridView1.Location = new System.Drawing.Point(4, 28);
            this.dataGridView1.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.dataGridView1.Name = "dataGridView1";
            dataGridViewCellStyle3.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle3.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle3.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle3.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle3.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle3.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridView1.RowHeadersDefaultCellStyle = dataGridViewCellStyle3;
            this.dataGridView1.RowHeadersWidth = 40;
            dataGridViewCellStyle4.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            this.dataGridView1.RowsDefaultCellStyle = dataGridViewCellStyle4;
            this.dataGridView1.RowTemplate.Height = 23;
            this.dataGridView1.Size = new System.Drawing.Size(342, 282);
            this.dataGridView1.TabIndex = 0;
            this.dataGridView1.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellClick);
            this.dataGridView1.CellMouseEnter += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellMouseEnter);
            this.dataGridView1.KeyDown += new System.Windows.Forms.KeyEventHandler(this.dataGridView1_KeyDown);
            this.dataGridView1.MouseClick += new System.Windows.Forms.MouseEventHandler(this.dataGridView1_MouseClick);
            // 
            // 商品名列
            // 
            this.商品名列.DataPropertyName = "CommodityName";
            this.商品名列.HeaderText = "商品名";
            this.商品名列.Name = "商品名列";
            this.商品名列.ReadOnly = true;
            // 
            // 单价列
            // 
            this.单价列.DataPropertyName = "Price";
            this.单价列.HeaderText = "单价";
            this.单价列.Name = "单价列";
            this.单价列.ReadOnly = true;
            // 
            // 单位列
            // 
            this.单位列.DataPropertyName = "Unit";
            this.单位列.HeaderText = "单位";
            this.单位列.Name = "单位列";
            this.单位列.ReadOnly = true;
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.修改ToolStripMenuItem,
            this.删除ToolStripMenuItem});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(101, 48);
            // 
            // 修改ToolStripMenuItem
            // 
            this.修改ToolStripMenuItem.Name = "修改ToolStripMenuItem";
            this.修改ToolStripMenuItem.Size = new System.Drawing.Size(100, 22);
            this.修改ToolStripMenuItem.Text = "修改";
            this.修改ToolStripMenuItem.Click += new System.EventHandler(this.修改ToolStripMenuItem_Click);
            // 
            // 删除ToolStripMenuItem
            // 
            this.删除ToolStripMenuItem.Name = "删除ToolStripMenuItem";
            this.删除ToolStripMenuItem.Size = new System.Drawing.Size(100, 22);
            this.删除ToolStripMenuItem.Text = "删除";
            this.删除ToolStripMenuItem.Click += new System.EventHandler(this.删除ToolStripMenuItem_Click);
            // 
            // commodityBindingSource
            // 
            this.commodityBindingSource.DataMember = "commodity";
            this.commodityBindingSource.DataSource = this.shopDataSet;
            // 
            // shopDataSet
            // 
            this.shopDataSet.DataSetName = "ShopDataSet";
            this.shopDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // commodityTableAdapter
            // 
            this.commodityTableAdapter.ClearBeforeFill = true;
            // 
            // 修改面板
            // 
            this.修改面板.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.修改面板.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.修改面板.Controls.Add(this.隐藏面板);
            this.修改面板.Controls.Add(this.保存修改);
            this.修改面板.Controls.Add(this.单位);
            this.修改面板.Controls.Add(this.单价);
            this.修改面板.Controls.Add(this.商品名);
            this.修改面板.Location = new System.Drawing.Point(115, 100);
            this.修改面板.Name = "修改面板";
            this.修改面板.Size = new System.Drawing.Size(130, 170);
            this.修改面板.TabIndex = 1;
            this.修改面板.Visible = false;
            // 
            // 隐藏面板
            // 
            this.隐藏面板.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.隐藏面板.FlatAppearance.BorderSize = 0;
            this.隐藏面板.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.隐藏面板.Font = new System.Drawing.Font("宋体", 8F);
            this.隐藏面板.Location = new System.Drawing.Point(111, -1);
            this.隐藏面板.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.隐藏面板.Name = "隐藏面板";
            this.隐藏面板.Size = new System.Drawing.Size(18, 18);
            this.隐藏面板.TabIndex = 4;
            this.隐藏面板.Text = "×";
            this.隐藏面板.UseVisualStyleBackColor = false;
            this.隐藏面板.Click += new System.EventHandler(this.隐藏面板_Click);
            // 
            // 保存修改
            // 
            this.保存修改.FlatAppearance.BorderSize = 0;
            this.保存修改.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.保存修改.Font = new System.Drawing.Font("宋体", 8F);
            this.保存修改.Location = new System.Drawing.Point(111, 151);
            this.保存修改.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.保存修改.Name = "保存修改";
            this.保存修改.Size = new System.Drawing.Size(18, 18);
            this.保存修改.TabIndex = 3;
            this.保存修改.Text = "√";
            this.保存修改.UseVisualStyleBackColor = true;
            this.保存修改.Click += new System.EventHandler(this.保存修改_Click);
            // 
            // 单位
            // 
            this.单位.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.单位.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.单位.Location = new System.Drawing.Point(15, 116);
            this.单位.Name = "单位";
            this.单位.Size = new System.Drawing.Size(100, 23);
            this.单位.TabIndex = 2;
            // 
            // 单价
            // 
            this.单价.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.单价.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.单价.Location = new System.Drawing.Point(15, 73);
            this.单价.Name = "单价";
            this.单价.Size = new System.Drawing.Size(100, 23);
            this.单价.TabIndex = 1;
            // 
            // 商品名
            // 
            this.商品名.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.商品名.Enabled = false;
            this.商品名.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.商品名.Location = new System.Drawing.Point(15, 30);
            this.商品名.Name = "商品名";
            this.商品名.Size = new System.Drawing.Size(100, 23);
            this.商品名.TabIndex = 0;
            // 
            // CommodityRevise
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(350, 314);
            this.Controls.Add(this.修改面板);
            this.Controls.Add(this.dataGridView1);
            this.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MaximizeBox = false;
            this.Name = "CommodityRevise";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "修改商品";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.CommodityRevise_FormClosing);
            this.Load += new System.EventHandler(this.CommodityRevise_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.contextMenuStrip1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.commodityBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.shopDataSet)).EndInit();
            this.修改面板.ResumeLayout(false);
            this.修改面板.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private ShopDataSet shopDataSet;
        private System.Windows.Forms.BindingSource commodityBindingSource;
        private ShopDataSetTableAdapters.commodityTableAdapter commodityTableAdapter;
        private System.Windows.Forms.Panel 修改面板;
        private System.Windows.Forms.TextBox 单位;
        private System.Windows.Forms.TextBox 单价;
        private System.Windows.Forms.TextBox 商品名;
        private System.Windows.Forms.Button 保存修改;
        private System.Windows.Forms.DataGridViewTextBoxColumn 商品名列;
        private System.Windows.Forms.DataGridViewTextBoxColumn 单价列;
        private System.Windows.Forms.DataGridViewTextBoxColumn 单位列;
        private System.Windows.Forms.Button 隐藏面板;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem 修改ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 删除ToolStripMenuItem;
    }
}