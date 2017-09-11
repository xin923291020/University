namespace 末日余生
{
    partial class SkillsTab
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(SkillsTab));
            this.丧尸终结者 = new System.Windows.Forms.PictureBox();
            this.毒素抗性 = new System.Windows.Forms.PictureBox();
            this.被动标签 = new System.Windows.Forms.Label();
            this.提示文本 = new System.Windows.Forms.ToolTip(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.丧尸终结者)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.毒素抗性)).BeginInit();
            this.SuspendLayout();
            // 
            // 丧尸终结者
            // 
            this.丧尸终结者.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("丧尸终结者.BackgroundImage")));
            this.丧尸终结者.Cursor = System.Windows.Forms.Cursors.Hand;
            this.丧尸终结者.Location = new System.Drawing.Point(30, 55);
            this.丧尸终结者.Margin = new System.Windows.Forms.Padding(0);
            this.丧尸终结者.Name = "丧尸终结者";
            this.丧尸终结者.Size = new System.Drawing.Size(30, 30);
            this.丧尸终结者.TabIndex = 15;
            this.丧尸终结者.TabStop = false;
            // 
            // 毒素抗性
            // 
            this.毒素抗性.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("毒素抗性.BackgroundImage")));
            this.毒素抗性.Cursor = System.Windows.Forms.Cursors.Hand;
            this.毒素抗性.Location = new System.Drawing.Point(65, 55);
            this.毒素抗性.Margin = new System.Windows.Forms.Padding(0);
            this.毒素抗性.Name = "毒素抗性";
            this.毒素抗性.Size = new System.Drawing.Size(30, 30);
            this.毒素抗性.TabIndex = 16;
            this.毒素抗性.TabStop = false;
            // 
            // 被动标签
            // 
            this.被动标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.被动标签.Location = new System.Drawing.Point(16, 28);
            this.被动标签.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.被动标签.Name = "被动标签";
            this.被动标签.Size = new System.Drawing.Size(58, 24);
            this.被动标签.TabIndex = 24;
            this.被动标签.Text = "被动：";
            this.被动标签.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // SkillsTab
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(125)))));
            this.ClientSize = new System.Drawing.Size(220, 100);
            this.Controls.Add(this.被动标签);
            this.Controls.Add(this.毒素抗性);
            this.Controls.Add(this.丧尸终结者);
            this.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "SkillsTab";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.Manual;
            this.Text = "技能栏";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.SkillsTab_FormClosing);
            this.Load += new System.EventHandler(this.SkillsTab_Load);
            ((System.ComponentModel.ISupportInitialize)(this.丧尸终结者)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.毒素抗性)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox 丧尸终结者;
        private System.Windows.Forms.PictureBox 毒素抗性;
        private System.Windows.Forms.Label 被动标签;
        private System.Windows.Forms.ToolTip 提示文本;
    }
}