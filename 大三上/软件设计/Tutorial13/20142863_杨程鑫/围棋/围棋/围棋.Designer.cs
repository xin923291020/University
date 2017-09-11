namespace 围棋
{
    partial class 围棋
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.棋盘 = new System.Windows.Forms.Panel();
            this.SuspendLayout();
            // 
            // 棋盘
            // 
            this.棋盘.BackColor = System.Drawing.Color.Transparent;
            this.棋盘.Location = new System.Drawing.Point(30, 40);
            this.棋盘.Name = "棋盘";
            this.棋盘.Size = new System.Drawing.Size(575, 575);
            this.棋盘.TabIndex = 0;
            this.棋盘.Paint += new System.Windows.Forms.PaintEventHandler(this.棋盘_Paint);
            this.棋盘.MouseClick += new System.Windows.Forms.MouseEventHandler(this.棋盘_MouseClick);
            this.棋盘.MouseMove += new System.Windows.Forms.MouseEventHandler(this.棋盘_MouseMove);
            // 
            // 围棋
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(192)))));
            this.ClientSize = new System.Drawing.Size(634, 651);
            this.Controls.Add(this.棋盘);
            this.Name = "围棋";
            this.Text = "围棋";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel 棋盘;
    }
}

