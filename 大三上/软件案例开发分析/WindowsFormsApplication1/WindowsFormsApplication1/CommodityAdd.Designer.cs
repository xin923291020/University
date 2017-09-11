namespace WindowsFormsApplication1
{
    partial class CommodityAdd
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
            this.商品名 = new System.Windows.Forms.Label();
            this.单价 = new System.Windows.Forms.Label();
            this.单位 = new System.Windows.Forms.Label();
            this.商品名输入框 = new System.Windows.Forms.TextBox();
            this.单价输入框 = new System.Windows.Forms.TextBox();
            this.单位选择 = new System.Windows.Forms.ComboBox();
            this.新增 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // 商品名
            // 
            this.商品名.Font = new System.Drawing.Font("Microsoft YaHei UI", 10F);
            this.商品名.Location = new System.Drawing.Point(30, 35);
            this.商品名.Name = "商品名";
            this.商品名.Size = new System.Drawing.Size(100, 30);
            this.商品名.TabIndex = 0;
            this.商品名.Text = "商品名：";
            this.商品名.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 单价
            // 
            this.单价.Font = new System.Drawing.Font("Microsoft YaHei UI", 10F);
            this.单价.Location = new System.Drawing.Point(30, 85);
            this.单价.Name = "单价";
            this.单价.Size = new System.Drawing.Size(100, 30);
            this.单价.TabIndex = 1;
            this.单价.Text = "单价：";
            this.单价.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 单位
            // 
            this.单位.Font = new System.Drawing.Font("Microsoft YaHei UI", 10F);
            this.单位.Location = new System.Drawing.Point(30, 135);
            this.单位.Name = "单位";
            this.单位.Size = new System.Drawing.Size(100, 30);
            this.单位.TabIndex = 2;
            this.单位.Text = "单位：";
            this.单位.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 商品名输入框
            // 
            this.商品名输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.商品名输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.商品名输入框.Location = new System.Drawing.Point(120, 39);
            this.商品名输入框.Name = "商品名输入框";
            this.商品名输入框.Size = new System.Drawing.Size(120, 23);
            this.商品名输入框.TabIndex = 3;
            // 
            // 单价输入框
            // 
            this.单价输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.单价输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.单价输入框.Location = new System.Drawing.Point(120, 89);
            this.单价输入框.Name = "单价输入框";
            this.单价输入框.Size = new System.Drawing.Size(120, 23);
            this.单价输入框.TabIndex = 4;
            // 
            // 单位选择
            // 
            this.单位选择.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.单位选择.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.单位选择.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.单位选择.FormattingEnabled = true;
            this.单位选择.Items.AddRange(new object[] {
            "个",
            "瓶"});
            this.单位选择.Location = new System.Drawing.Point(120, 137);
            this.单位选择.Name = "单位选择";
            this.单位选择.Size = new System.Drawing.Size(120, 25);
            this.单位选择.TabIndex = 5;
            // 
            // 新增
            // 
            this.新增.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.新增.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.新增.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.新增.Location = new System.Drawing.Point(254, 169);
            this.新增.Name = "新增";
            this.新增.Size = new System.Drawing.Size(50, 25);
            this.新增.TabIndex = 6;
            this.新增.Text = "新增";
            this.新增.UseVisualStyleBackColor = false;
            this.新增.Click += new System.EventHandler(this.新增_Click);
            // 
            // CommodityAdd
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(305, 195);
            this.Controls.Add(this.新增);
            this.Controls.Add(this.单位选择);
            this.Controls.Add(this.单价输入框);
            this.Controls.Add(this.商品名输入框);
            this.Controls.Add(this.单位);
            this.Controls.Add(this.单价);
            this.Controls.Add(this.商品名);
            this.Font = new System.Drawing.Font("Microsoft YaHei UI", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MaximizeBox = false;
            this.Name = "CommodityAdd";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "新增商品";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.CommodityAdd_FormClosing);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label 商品名;
        private System.Windows.Forms.Label 单价;
        private System.Windows.Forms.Label 单位;
        private System.Windows.Forms.TextBox 商品名输入框;
        private System.Windows.Forms.TextBox 单价输入框;
        private System.Windows.Forms.ComboBox 单位选择;
        private System.Windows.Forms.Button 新增;
    }
}