namespace WindowsFormsApplication1
{
    partial class CompanyRevise
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.单位名称 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.代表人 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.地址 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.电话 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.修改ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.删除ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.companyBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.shopDataSet = new WindowsFormsApplication1.ShopDataSet();
            this.companyTableAdapter = new WindowsFormsApplication1.ShopDataSetTableAdapters.companyTableAdapter();
            this.修改面板 = new System.Windows.Forms.Panel();
            this.button2 = new System.Windows.Forms.Button();
            this.保存修改 = new System.Windows.Forms.Button();
            this.电话输入框 = new System.Windows.Forms.TextBox();
            this.地址输入框 = new System.Windows.Forms.TextBox();
            this.代表人输入框 = new System.Windows.Forms.TextBox();
            this.单位名称输入框 = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.contextMenuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.companyBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.shopDataSet)).BeginInit();
            this.修改面板.SuspendLayout();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
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
            this.单位名称,
            this.代表人,
            this.地址,
            this.电话});
            this.dataGridView1.ContextMenuStrip = this.contextMenuStrip1;
            this.dataGridView1.DataSource = this.companyBindingSource;
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
            dataGridViewCellStyle3.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle3.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle3.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle3.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle3.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle3.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridView1.RowHeadersDefaultCellStyle = dataGridViewCellStyle3;
            this.dataGridView1.RowTemplate.Height = 23;
            this.dataGridView1.Size = new System.Drawing.Size(443, 318);
            this.dataGridView1.TabIndex = 0;
            this.dataGridView1.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellClick);
            this.dataGridView1.CellMouseEnter += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellMouseEnter);
            this.dataGridView1.KeyDown += new System.Windows.Forms.KeyEventHandler(this.dataGridView1_KeyDown);
            this.dataGridView1.MouseClick += new System.Windows.Forms.MouseEventHandler(this.dataGridView1_MouseClick);
            // 
            // 单位名称
            // 
            this.单位名称.DataPropertyName = "CompanyName";
            this.单位名称.HeaderText = "单位名称";
            this.单位名称.Name = "单位名称";
            this.单位名称.ReadOnly = true;
            this.单位名称.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            // 
            // 代表人
            // 
            this.代表人.DataPropertyName = "Represent";
            this.代表人.HeaderText = "代表人";
            this.代表人.Name = "代表人";
            this.代表人.ReadOnly = true;
            // 
            // 地址
            // 
            this.地址.DataPropertyName = "Address";
            this.地址.HeaderText = "地址";
            this.地址.Name = "地址";
            this.地址.ReadOnly = true;
            // 
            // 电话
            // 
            this.电话.DataPropertyName = "Phone";
            this.电话.HeaderText = "电话";
            this.电话.Name = "电话";
            this.电话.ReadOnly = true;
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
            // companyBindingSource
            // 
            this.companyBindingSource.DataMember = "company";
            this.companyBindingSource.DataSource = this.shopDataSet;
            // 
            // shopDataSet
            // 
            this.shopDataSet.DataSetName = "ShopDataSet";
            this.shopDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // companyTableAdapter
            // 
            this.companyTableAdapter.ClearBeforeFill = true;
            // 
            // 修改面板
            // 
            this.修改面板.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.修改面板.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.修改面板.Controls.Add(this.button2);
            this.修改面板.Controls.Add(this.保存修改);
            this.修改面板.Controls.Add(this.电话输入框);
            this.修改面板.Controls.Add(this.地址输入框);
            this.修改面板.Controls.Add(this.代表人输入框);
            this.修改面板.Controls.Add(this.单位名称输入框);
            this.修改面板.Location = new System.Drawing.Point(110, 80);
            this.修改面板.Name = "修改面板";
            this.修改面板.Size = new System.Drawing.Size(230, 220);
            this.修改面板.TabIndex = 1;
            this.修改面板.Visible = false;
            // 
            // button2
            // 
            this.button2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.button2.FlatAppearance.BorderSize = 0;
            this.button2.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button2.Font = new System.Drawing.Font("宋体", 8F);
            this.button2.Location = new System.Drawing.Point(210, -1);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(18, 18);
            this.button2.TabIndex = 9;
            this.button2.Text = "×";
            this.button2.UseVisualStyleBackColor = false;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // 保存修改
            // 
            this.保存修改.FlatAppearance.BorderSize = 0;
            this.保存修改.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.保存修改.Font = new System.Drawing.Font("宋体", 8F);
            this.保存修改.Location = new System.Drawing.Point(210, 200);
            this.保存修改.Name = "保存修改";
            this.保存修改.Size = new System.Drawing.Size(18, 18);
            this.保存修改.TabIndex = 8;
            this.保存修改.Text = "√";
            this.保存修改.UseVisualStyleBackColor = true;
            this.保存修改.Click += new System.EventHandler(this.保存修改_Click);
            // 
            // 电话输入框
            // 
            this.电话输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.电话输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.电话输入框.Location = new System.Drawing.Point(15, 159);
            this.电话输入框.Name = "电话输入框";
            this.电话输入框.Size = new System.Drawing.Size(200, 23);
            this.电话输入框.TabIndex = 7;
            // 
            // 地址输入框
            // 
            this.地址输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.地址输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.地址输入框.Location = new System.Drawing.Point(15, 116);
            this.地址输入框.Name = "地址输入框";
            this.地址输入框.Size = new System.Drawing.Size(200, 23);
            this.地址输入框.TabIndex = 6;
            // 
            // 代表人输入框
            // 
            this.代表人输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.代表人输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.代表人输入框.Location = new System.Drawing.Point(15, 73);
            this.代表人输入框.Name = "代表人输入框";
            this.代表人输入框.Size = new System.Drawing.Size(200, 23);
            this.代表人输入框.TabIndex = 5;
            // 
            // 单位名称输入框
            // 
            this.单位名称输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.单位名称输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.单位名称输入框.Location = new System.Drawing.Point(15, 30);
            this.单位名称输入框.Name = "单位名称输入框";
            this.单位名称输入框.Size = new System.Drawing.Size(200, 23);
            this.单位名称输入框.TabIndex = 4;
            // 
            // CompanyRevise
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(451, 350);
            this.Controls.Add(this.修改面板);
            this.Controls.Add(this.dataGridView1);
            this.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MaximizeBox = false;
            this.Name = "CompanyRevise";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "修改供应商";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.CompanyRevise_FormClosing);
            this.Load += new System.EventHandler(this.CompanyRevise_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.contextMenuStrip1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.companyBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.shopDataSet)).EndInit();
            this.修改面板.ResumeLayout(false);
            this.修改面板.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private ShopDataSet shopDataSet;
        private System.Windows.Forms.BindingSource companyBindingSource;
        private ShopDataSetTableAdapters.companyTableAdapter companyTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn 单位名称;
        private System.Windows.Forms.DataGridViewTextBoxColumn 代表人;
        private System.Windows.Forms.DataGridViewTextBoxColumn 地址;
        private System.Windows.Forms.DataGridViewTextBoxColumn 电话;
        private System.Windows.Forms.Panel 修改面板;
        private System.Windows.Forms.TextBox 电话输入框;
        private System.Windows.Forms.TextBox 地址输入框;
        private System.Windows.Forms.TextBox 代表人输入框;
        private System.Windows.Forms.TextBox 单位名称输入框;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button 保存修改;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem 修改ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 删除ToolStripMenuItem;
    }
}