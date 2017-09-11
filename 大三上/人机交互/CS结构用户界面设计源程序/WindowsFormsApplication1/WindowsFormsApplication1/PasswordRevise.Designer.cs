namespace WindowsFormsApplication1
{
    partial class PasswordRevise
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
            this.确认修改 = new System.Windows.Forms.Button();
            this.旧密码 = new System.Windows.Forms.Label();
            this.新密码 = new System.Windows.Forms.Label();
            this.确认新密码 = new System.Windows.Forms.Label();
            this.旧密码输入框 = new System.Windows.Forms.TextBox();
            this.新密码输入框 = new System.Windows.Forms.TextBox();
            this.确认新密码输入框 = new System.Windows.Forms.TextBox();
            this.密码不一致 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // 确认修改
            // 
            this.确认修改.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.确认修改.Location = new System.Drawing.Point(269, 190);
            this.确认修改.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.确认修改.Name = "确认修改";
            this.确认修改.Size = new System.Drawing.Size(70, 25);
            this.确认修改.TabIndex = 0;
            this.确认修改.Text = "确认修改";
            this.确认修改.UseVisualStyleBackColor = false;
            this.确认修改.Click += new System.EventHandler(this.确认修改_Click);
            // 
            // 旧密码
            // 
            this.旧密码.Font = new System.Drawing.Font("Microsoft YaHei UI", 10F);
            this.旧密码.Location = new System.Drawing.Point(30, 35);
            this.旧密码.Name = "旧密码";
            this.旧密码.Size = new System.Drawing.Size(100, 30);
            this.旧密码.TabIndex = 1;
            this.旧密码.Text = "旧密码：";
            this.旧密码.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 新密码
            // 
            this.新密码.Font = new System.Drawing.Font("Microsoft YaHei UI", 10F);
            this.新密码.Location = new System.Drawing.Point(30, 85);
            this.新密码.Name = "新密码";
            this.新密码.Size = new System.Drawing.Size(100, 30);
            this.新密码.TabIndex = 2;
            this.新密码.Text = "新密码：";
            this.新密码.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 确认新密码
            // 
            this.确认新密码.Font = new System.Drawing.Font("Microsoft YaHei UI", 10F);
            this.确认新密码.Location = new System.Drawing.Point(30, 139);
            this.确认新密码.Name = "确认新密码";
            this.确认新密码.Size = new System.Drawing.Size(100, 30);
            this.确认新密码.TabIndex = 3;
            this.确认新密码.Text = "确认新密码：";
            // 
            // 旧密码输入框
            // 
            this.旧密码输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.旧密码输入框.Location = new System.Drawing.Point(120, 39);
            this.旧密码输入框.Name = "旧密码输入框";
            this.旧密码输入框.PasswordChar = '*';
            this.旧密码输入框.Size = new System.Drawing.Size(120, 23);
            this.旧密码输入框.TabIndex = 4;
            // 
            // 新密码输入框
            // 
            this.新密码输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.新密码输入框.Location = new System.Drawing.Point(120, 89);
            this.新密码输入框.Name = "新密码输入框";
            this.新密码输入框.PasswordChar = '*';
            this.新密码输入框.Size = new System.Drawing.Size(120, 23);
            this.新密码输入框.TabIndex = 5;
            // 
            // 确认新密码输入框
            // 
            this.确认新密码输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.确认新密码输入框.Location = new System.Drawing.Point(120, 139);
            this.确认新密码输入框.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.确认新密码输入框.Name = "确认新密码输入框";
            this.确认新密码输入框.PasswordChar = '*';
            this.确认新密码输入框.Size = new System.Drawing.Size(120, 23);
            this.确认新密码输入框.TabIndex = 6;
            this.确认新密码输入框.Enter += new System.EventHandler(this.确认新密码输入框_Enter);
            this.确认新密码输入框.KeyDown += new System.Windows.Forms.KeyEventHandler(this.确认新密码输入框_KeyDown);
            this.确认新密码输入框.Leave += new System.EventHandler(this.确认新密码输入框_Leave);
            // 
            // 密码不一致
            // 
            this.密码不一致.ForeColor = System.Drawing.Color.Red;
            this.密码不一致.Location = new System.Drawing.Point(250, 139);
            this.密码不一致.Name = "密码不一致";
            this.密码不一致.Size = new System.Drawing.Size(70, 23);
            this.密码不一致.TabIndex = 7;
            this.密码不一致.Text = "密码不一致";
            this.密码不一致.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.密码不一致.Visible = false;
            // 
            // PasswordRevise
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(339, 215);
            this.Controls.Add(this.密码不一致);
            this.Controls.Add(this.确认新密码输入框);
            this.Controls.Add(this.新密码输入框);
            this.Controls.Add(this.旧密码输入框);
            this.Controls.Add(this.确认新密码);
            this.Controls.Add(this.新密码);
            this.Controls.Add(this.旧密码);
            this.Controls.Add(this.确认修改);
            this.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MaximizeBox = false;
            this.Name = "PasswordRevise";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "修改密码";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.PasswordRevise_FormClosing);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button 确认修改;
        private System.Windows.Forms.Label 旧密码;
        private System.Windows.Forms.Label 新密码;
        private System.Windows.Forms.Label 确认新密码;
        private System.Windows.Forms.TextBox 旧密码输入框;
        private System.Windows.Forms.TextBox 新密码输入框;
        private System.Windows.Forms.TextBox 确认新密码输入框;
        private System.Windows.Forms.Label 密码不一致;
    }
}