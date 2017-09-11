namespace WindowsFormsApplication1
{
    partial class MyMessageBox
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
            this.MessagePanel = new System.Windows.Forms.Panel();
            this.Content = new System.Windows.Forms.Label();
            this.ButtonPanel = new System.Windows.Forms.Panel();
            this.Confirm = new System.Windows.Forms.Button();
            this.MessagePanel.SuspendLayout();
            this.ButtonPanel.SuspendLayout();
            this.SuspendLayout();
            // 
            // MessagePanel
            // 
            this.MessagePanel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.MessagePanel.Controls.Add(this.Content);
            this.MessagePanel.Location = new System.Drawing.Point(4, 28);
            this.MessagePanel.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MessagePanel.Name = "MessagePanel";
            this.MessagePanel.Size = new System.Drawing.Size(226, 80);
            this.MessagePanel.TabIndex = 0;
            // 
            // Content
            // 
            this.Content.Location = new System.Drawing.Point(10, 15);
            this.Content.Name = "Content";
            this.Content.Size = new System.Drawing.Size(170, 50);
            this.Content.TabIndex = 0;
            // 
            // ButtonPanel
            // 
            this.ButtonPanel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.ButtonPanel.Controls.Add(this.Confirm);
            this.ButtonPanel.Location = new System.Drawing.Point(4, 106);
            this.ButtonPanel.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.ButtonPanel.Name = "ButtonPanel";
            this.ButtonPanel.Size = new System.Drawing.Size(226, 55);
            this.ButtonPanel.TabIndex = 1;
            // 
            // Confirm
            // 
            this.Confirm.Location = new System.Drawing.Point(132, 18);
            this.Confirm.Name = "Confirm";
            this.Confirm.Size = new System.Drawing.Size(85, 28);
            this.Confirm.TabIndex = 0;
            this.Confirm.Text = "确认";
            this.Confirm.UseVisualStyleBackColor = true;
            this.Confirm.Click += new System.EventHandler(this.Confirm_Click);
            // 
            // MyMessageBox
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(235, 165);
            this.Controls.Add(this.ButtonPanel);
            this.Controls.Add(this.MessagePanel);
            this.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "MyMessageBox";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "MyMessageBox";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.MyMessageBox_FormClosing);
            this.MessagePanel.ResumeLayout(false);
            this.ButtonPanel.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel MessagePanel;
        private System.Windows.Forms.Panel ButtonPanel;
        private System.Windows.Forms.Button Confirm;
        private System.Windows.Forms.Label Content;
    }
}