namespace WindowsFormsApplication1
{
    partial class CompanyAdd
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
            this.单位名称 = new System.Windows.Forms.Label();
            this.代表人 = new System.Windows.Forms.Label();
            this.地址 = new System.Windows.Forms.Label();
            this.联系电话 = new System.Windows.Forms.Label();
            this.单位名称输入框 = new System.Windows.Forms.TextBox();
            this.地址输入框 = new System.Windows.Forms.TextBox();
            this.代表人输入框 = new System.Windows.Forms.TextBox();
            this.联系电话输入框 = new System.Windows.Forms.TextBox();
            this.新增 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // 单位名称
            // 
            this.单位名称.Font = new System.Drawing.Font("Microsoft YaHei UI", 10F);
            this.单位名称.Location = new System.Drawing.Point(30, 35);
            this.单位名称.Name = "单位名称";
            this.单位名称.Size = new System.Drawing.Size(100, 30);
            this.单位名称.TabIndex = 0;
            this.单位名称.Text = "单位名称：";
            this.单位名称.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 代表人
            // 
            this.代表人.Font = new System.Drawing.Font("Microsoft YaHei UI", 10F);
            this.代表人.Location = new System.Drawing.Point(30, 135);
            this.代表人.Name = "代表人";
            this.代表人.Size = new System.Drawing.Size(100, 30);
            this.代表人.TabIndex = 1;
            this.代表人.Text = "代表人：";
            this.代表人.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 地址
            // 
            this.地址.Font = new System.Drawing.Font("Microsoft YaHei UI", 10F);
            this.地址.Location = new System.Drawing.Point(30, 85);
            this.地址.Name = "地址";
            this.地址.Size = new System.Drawing.Size(100, 30);
            this.地址.TabIndex = 2;
            this.地址.Text = "地址：";
            this.地址.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 联系电话
            // 
            this.联系电话.Font = new System.Drawing.Font("Microsoft YaHei UI", 10F);
            this.联系电话.Location = new System.Drawing.Point(30, 185);
            this.联系电话.Name = "联系电话";
            this.联系电话.Size = new System.Drawing.Size(100, 30);
            this.联系电话.TabIndex = 3;
            this.联系电话.Text = "联系电话：";
            this.联系电话.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 单位名称输入框
            // 
            this.单位名称输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.单位名称输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.单位名称输入框.Location = new System.Drawing.Point(125, 39);
            this.单位名称输入框.Name = "单位名称输入框";
            this.单位名称输入框.Size = new System.Drawing.Size(200, 23);
            this.单位名称输入框.TabIndex = 4;
            // 
            // 地址输入框
            // 
            this.地址输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.地址输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.地址输入框.Location = new System.Drawing.Point(125, 89);
            this.地址输入框.Name = "地址输入框";
            this.地址输入框.Size = new System.Drawing.Size(200, 23);
            this.地址输入框.TabIndex = 5;
            // 
            // 代表人输入框
            // 
            this.代表人输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.代表人输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.代表人输入框.Location = new System.Drawing.Point(125, 139);
            this.代表人输入框.Name = "代表人输入框";
            this.代表人输入框.Size = new System.Drawing.Size(200, 23);
            this.代表人输入框.TabIndex = 6;
            // 
            // 联系电话输入框
            // 
            this.联系电话输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.联系电话输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.联系电话输入框.Location = new System.Drawing.Point(125, 189);
            this.联系电话输入框.Name = "联系电话输入框";
            this.联系电话输入框.Size = new System.Drawing.Size(200, 23);
            this.联系电话输入框.TabIndex = 7;
            // 
            // 新增
            // 
            this.新增.Location = new System.Drawing.Point(355, 225);
            this.新增.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.新增.Name = "新增";
            this.新增.Size = new System.Drawing.Size(50, 25);
            this.新增.TabIndex = 8;
            this.新增.Text = "新增";
            this.新增.UseVisualStyleBackColor = true;
            this.新增.Click += new System.EventHandler(this.新增_Click);
            // 
            // CompanyAdd
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(405, 250);
            this.Controls.Add(this.新增);
            this.Controls.Add(this.联系电话输入框);
            this.Controls.Add(this.代表人输入框);
            this.Controls.Add(this.地址输入框);
            this.Controls.Add(this.单位名称输入框);
            this.Controls.Add(this.联系电话);
            this.Controls.Add(this.地址);
            this.Controls.Add(this.代表人);
            this.Controls.Add(this.单位名称);
            this.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MaximizeBox = false;
            this.Name = "CompanyAdd";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "新增供货商";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.CompanyAdd_FormClosing);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label 单位名称;
        private System.Windows.Forms.Label 代表人;
        private System.Windows.Forms.Label 地址;
        private System.Windows.Forms.Label 联系电话;
        private System.Windows.Forms.TextBox 单位名称输入框;
        private System.Windows.Forms.TextBox 地址输入框;
        private System.Windows.Forms.TextBox 代表人输入框;
        private System.Windows.Forms.TextBox 联系电话输入框;
        private System.Windows.Forms.Button 新增;
    }
}