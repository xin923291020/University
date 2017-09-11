namespace 末日余生
{
    partial class RoleAttribute
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(RoleAttribute));
            this.角色 = new System.Windows.Forms.PictureBox();
            this.姓名 = new System.Windows.Forms.Label();
            this.性别 = new System.Windows.Forms.Label();
            this.年龄 = new System.Windows.Forms.Label();
            this.等级标签 = new System.Windows.Forms.Label();
            this.武力值标签 = new System.Windows.Forms.Label();
            this.等级 = new System.Windows.Forms.Label();
            this.武力值 = new System.Windows.Forms.Label();
            this.经验标签 = new System.Windows.Forms.Label();
            this.经验 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.角色)).BeginInit();
            this.SuspendLayout();
            // 
            // 角色
            // 
            this.角色.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("角色.BackgroundImage")));
            this.角色.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.角色.Location = new System.Drawing.Point(18, 46);
            this.角色.Name = "角色";
            this.角色.Size = new System.Drawing.Size(70, 70);
            this.角色.TabIndex = 0;
            this.角色.TabStop = false;
            // 
            // 姓名
            // 
            this.姓名.Location = new System.Drawing.Point(100, 40);
            this.姓名.Name = "姓名";
            this.姓名.Size = new System.Drawing.Size(80, 20);
            this.姓名.TabIndex = 1;
            this.姓名.Text = "姓名：小鑫";
            this.姓名.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 性别
            // 
            this.性别.Location = new System.Drawing.Point(100, 70);
            this.性别.Name = "性别";
            this.性别.Size = new System.Drawing.Size(80, 20);
            this.性别.TabIndex = 2;
            this.性别.Text = "性别：男";
            this.性别.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 年龄
            // 
            this.年龄.Location = new System.Drawing.Point(100, 100);
            this.年龄.Name = "年龄";
            this.年龄.Size = new System.Drawing.Size(80, 20);
            this.年龄.TabIndex = 3;
            this.年龄.Text = "年龄：21";
            this.年龄.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 等级标签
            // 
            this.等级标签.Location = new System.Drawing.Point(20, 145);
            this.等级标签.Name = "等级标签";
            this.等级标签.Size = new System.Drawing.Size(60, 20);
            this.等级标签.TabIndex = 4;
            this.等级标签.Text = "等级：";
            this.等级标签.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 武力值标签
            // 
            this.武力值标签.Location = new System.Drawing.Point(20, 205);
            this.武力值标签.Name = "武力值标签";
            this.武力值标签.Size = new System.Drawing.Size(60, 20);
            this.武力值标签.TabIndex = 5;
            this.武力值标签.Text = "武力值：";
            this.武力值标签.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 等级
            // 
            this.等级.Location = new System.Drawing.Point(80, 145);
            this.等级.Name = "等级";
            this.等级.Size = new System.Drawing.Size(60, 20);
            this.等级.TabIndex = 6;
            this.等级.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 武力值
            // 
            this.武力值.Location = new System.Drawing.Point(80, 205);
            this.武力值.Name = "武力值";
            this.武力值.Size = new System.Drawing.Size(60, 20);
            this.武力值.TabIndex = 7;
            this.武力值.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 经验标签
            // 
            this.经验标签.Location = new System.Drawing.Point(20, 175);
            this.经验标签.Name = "经验标签";
            this.经验标签.Size = new System.Drawing.Size(60, 20);
            this.经验标签.TabIndex = 8;
            this.经验标签.Text = "经验：";
            this.经验标签.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 经验
            // 
            this.经验.Location = new System.Drawing.Point(80, 175);
            this.经验.Name = "经验";
            this.经验.Size = new System.Drawing.Size(60, 20);
            this.经验.TabIndex = 9;
            this.经验.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // RoleAttribute
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(125)))));
            this.ClientSize = new System.Drawing.Size(190, 245);
            this.Controls.Add(this.经验);
            this.Controls.Add(this.经验标签);
            this.Controls.Add(this.武力值);
            this.Controls.Add(this.等级);
            this.Controls.Add(this.武力值标签);
            this.Controls.Add(this.等级标签);
            this.Controls.Add(this.年龄);
            this.Controls.Add(this.性别);
            this.Controls.Add(this.姓名);
            this.Controls.Add(this.角色);
            this.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "RoleAttribute";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.Manual;
            this.Text = "属性";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.RoleAttribute_FormClosing);
            ((System.ComponentModel.ISupportInitialize)(this.角色)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox 角色;
        private System.Windows.Forms.Label 姓名;
        private System.Windows.Forms.Label 性别;
        private System.Windows.Forms.Label 年龄;
        private System.Windows.Forms.Label 等级标签;
        private System.Windows.Forms.Label 武力值标签;
        private System.Windows.Forms.Label 等级;
        private System.Windows.Forms.Label 武力值;
        private System.Windows.Forms.Label 经验标签;
        private System.Windows.Forms.Label 经验;
    }
}