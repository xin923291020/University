namespace 末日余生
{
    partial class Rucksack
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Rucksack));
            this.武器格 = new System.Windows.Forms.PictureBox();
            this.香肠格 = new System.Windows.Forms.PictureBox();
            this.帐篷格 = new System.Windows.Forms.PictureBox();
            this.子弹格 = new System.Windows.Forms.PictureBox();
            this.乘号1 = new System.Windows.Forms.Label();
            this.乘号3 = new System.Windows.Forms.Label();
            this.乘号2 = new System.Windows.Forms.Label();
            this.乘号4 = new System.Windows.Forms.Label();
            this.武器数量 = new System.Windows.Forms.Label();
            this.子弹数量 = new System.Windows.Forms.Label();
            this.香肠数量 = new System.Windows.Forms.Label();
            this.帐篷数量 = new System.Windows.Forms.Label();
            this.提醒 = new System.Windows.Forms.Label();
            this.提醒定时器 = new System.Windows.Forms.Timer(this.components);
            this.提示文本 = new System.Windows.Forms.ToolTip(this.components);
            this.解药格 = new System.Windows.Forms.PictureBox();
            this.乘号5 = new System.Windows.Forms.Label();
            this.解药数量 = new System.Windows.Forms.Label();
            this.BulletSoundPlayer = new AxWMPLib.AxWindowsMediaPlayer();
            ((System.ComponentModel.ISupportInitialize)(this.武器格)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.香肠格)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.帐篷格)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.子弹格)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.解药格)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.BulletSoundPlayer)).BeginInit();
            this.SuspendLayout();
            // 
            // 武器格
            // 
            this.武器格.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("武器格.BackgroundImage")));
            this.武器格.Cursor = System.Windows.Forms.Cursors.Hand;
            this.武器格.Location = new System.Drawing.Point(20, 35);
            this.武器格.Margin = new System.Windows.Forms.Padding(0);
            this.武器格.Name = "武器格";
            this.武器格.Size = new System.Drawing.Size(30, 30);
            this.武器格.TabIndex = 0;
            this.武器格.TabStop = false;
            // 
            // 香肠格
            // 
            this.香肠格.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("香肠格.BackgroundImage")));
            this.香肠格.Cursor = System.Windows.Forms.Cursors.Hand;
            this.香肠格.Location = new System.Drawing.Point(20, 90);
            this.香肠格.Margin = new System.Windows.Forms.Padding(0);
            this.香肠格.Name = "香肠格";
            this.香肠格.Size = new System.Drawing.Size(30, 30);
            this.香肠格.TabIndex = 1;
            this.香肠格.TabStop = false;
            this.香肠格.Click += new System.EventHandler(this.香肠格_Click);
            // 
            // 帐篷格
            // 
            this.帐篷格.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("帐篷格.BackgroundImage")));
            this.帐篷格.Cursor = System.Windows.Forms.Cursors.Hand;
            this.帐篷格.Location = new System.Drawing.Point(110, 90);
            this.帐篷格.Margin = new System.Windows.Forms.Padding(0);
            this.帐篷格.Name = "帐篷格";
            this.帐篷格.Size = new System.Drawing.Size(30, 30);
            this.帐篷格.TabIndex = 2;
            this.帐篷格.TabStop = false;
            this.帐篷格.Click += new System.EventHandler(this.帐篷格_Click);
            // 
            // 子弹格
            // 
            this.子弹格.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("子弹格.BackgroundImage")));
            this.子弹格.Cursor = System.Windows.Forms.Cursors.Hand;
            this.子弹格.Location = new System.Drawing.Point(110, 35);
            this.子弹格.Margin = new System.Windows.Forms.Padding(0);
            this.子弹格.Name = "子弹格";
            this.子弹格.Size = new System.Drawing.Size(30, 30);
            this.子弹格.TabIndex = 3;
            this.子弹格.TabStop = false;
            this.子弹格.Click += new System.EventHandler(this.子弹格_Click);
            // 
            // 乘号1
            // 
            this.乘号1.Location = new System.Drawing.Point(60, 41);
            this.乘号1.Name = "乘号1";
            this.乘号1.Size = new System.Drawing.Size(15, 15);
            this.乘号1.TabIndex = 4;
            this.乘号1.Text = "×";
            this.乘号1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 乘号3
            // 
            this.乘号3.AutoSize = true;
            this.乘号3.Location = new System.Drawing.Point(60, 96);
            this.乘号3.Name = "乘号3";
            this.乘号3.Size = new System.Drawing.Size(17, 17);
            this.乘号3.TabIndex = 5;
            this.乘号3.Text = "×";
            // 
            // 乘号2
            // 
            this.乘号2.AutoSize = true;
            this.乘号2.Location = new System.Drawing.Point(150, 41);
            this.乘号2.Name = "乘号2";
            this.乘号2.Size = new System.Drawing.Size(17, 17);
            this.乘号2.TabIndex = 6;
            this.乘号2.Text = "×";
            // 
            // 乘号4
            // 
            this.乘号4.AutoSize = true;
            this.乘号4.Location = new System.Drawing.Point(150, 96);
            this.乘号4.Name = "乘号4";
            this.乘号4.Size = new System.Drawing.Size(17, 17);
            this.乘号4.TabIndex = 7;
            this.乘号4.Text = "×";
            // 
            // 武器数量
            // 
            this.武器数量.Location = new System.Drawing.Point(75, 38);
            this.武器数量.Name = "武器数量";
            this.武器数量.Size = new System.Drawing.Size(22, 22);
            this.武器数量.TabIndex = 8;
            this.武器数量.Text = "？";
            this.武器数量.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 子弹数量
            // 
            this.子弹数量.Location = new System.Drawing.Point(165, 38);
            this.子弹数量.Name = "子弹数量";
            this.子弹数量.Size = new System.Drawing.Size(22, 22);
            this.子弹数量.TabIndex = 9;
            this.子弹数量.Text = "0";
            this.子弹数量.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 香肠数量
            // 
            this.香肠数量.Location = new System.Drawing.Point(75, 93);
            this.香肠数量.Name = "香肠数量";
            this.香肠数量.Size = new System.Drawing.Size(22, 22);
            this.香肠数量.TabIndex = 10;
            this.香肠数量.Text = "0";
            this.香肠数量.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 帐篷数量
            // 
            this.帐篷数量.Location = new System.Drawing.Point(165, 93);
            this.帐篷数量.Name = "帐篷数量";
            this.帐篷数量.Size = new System.Drawing.Size(22, 22);
            this.帐篷数量.TabIndex = 11;
            this.帐篷数量.Text = "0";
            this.帐篷数量.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 提醒
            // 
            this.提醒.Location = new System.Drawing.Point(17, 190);
            this.提醒.Name = "提醒";
            this.提醒.Size = new System.Drawing.Size(190, 20);
            this.提醒.TabIndex = 12;
            this.提醒.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 提醒定时器
            // 
            this.提醒定时器.Interval = 50;
            this.提醒定时器.Tick += new System.EventHandler(this.提醒定时器_Tick);
            // 
            // 解药格
            // 
            this.解药格.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("解药格.BackgroundImage")));
            this.解药格.Cursor = System.Windows.Forms.Cursors.Hand;
            this.解药格.Location = new System.Drawing.Point(20, 145);
            this.解药格.Margin = new System.Windows.Forms.Padding(0);
            this.解药格.Name = "解药格";
            this.解药格.Size = new System.Drawing.Size(30, 30);
            this.解药格.TabIndex = 14;
            this.解药格.TabStop = false;
            this.解药格.Click += new System.EventHandler(this.解药格_Click);
            // 
            // 乘号5
            // 
            this.乘号5.AutoSize = true;
            this.乘号5.Location = new System.Drawing.Point(60, 151);
            this.乘号5.Name = "乘号5";
            this.乘号5.Size = new System.Drawing.Size(17, 17);
            this.乘号5.TabIndex = 15;
            this.乘号5.Text = "×";
            // 
            // 解药数量
            // 
            this.解药数量.Location = new System.Drawing.Point(75, 148);
            this.解药数量.Name = "解药数量";
            this.解药数量.Size = new System.Drawing.Size(22, 22);
            this.解药数量.TabIndex = 16;
            this.解药数量.Text = "0";
            this.解药数量.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // BulletSoundPlayer
            // 
            this.BulletSoundPlayer.Enabled = true;
            this.BulletSoundPlayer.Location = new System.Drawing.Point(222, 35);
            this.BulletSoundPlayer.Name = "BulletSoundPlayer";
            this.BulletSoundPlayer.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("BulletSoundPlayer.OcxState")));
            this.BulletSoundPlayer.Size = new System.Drawing.Size(35, 35);
            this.BulletSoundPlayer.TabIndex = 13;
            // 
            // Rucksack
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(125)))));
            this.ClientSize = new System.Drawing.Size(220, 220);
            this.ControlBoxActive = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(100)))), ((int)(((byte)(0)))));
            this.ControlBoxDeactive = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(100)))), ((int)(((byte)(0)))));
            this.Controls.Add(this.解药数量);
            this.Controls.Add(this.乘号5);
            this.Controls.Add(this.解药格);
            this.Controls.Add(this.BulletSoundPlayer);
            this.Controls.Add(this.提醒);
            this.Controls.Add(this.帐篷数量);
            this.Controls.Add(this.香肠数量);
            this.Controls.Add(this.子弹数量);
            this.Controls.Add(this.武器数量);
            this.Controls.Add(this.乘号4);
            this.Controls.Add(this.乘号2);
            this.Controls.Add(this.乘号3);
            this.Controls.Add(this.乘号1);
            this.Controls.Add(this.子弹格);
            this.Controls.Add(this.帐篷格);
            this.Controls.Add(this.香肠格);
            this.Controls.Add(this.武器格);
            this.DoubleBuffered = false;
            this.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Rucksack";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.Manual;
            this.Text = "背包";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Rucksack_FormClosing);
            ((System.ComponentModel.ISupportInitialize)(this.武器格)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.香肠格)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.帐篷格)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.子弹格)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.解药格)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.BulletSoundPlayer)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox 武器格;
        private System.Windows.Forms.PictureBox 香肠格;
        private System.Windows.Forms.PictureBox 子弹格;
        private System.Windows.Forms.Label 乘号1;
        private System.Windows.Forms.Label 乘号3;
        private System.Windows.Forms.Label 乘号2;
        private System.Windows.Forms.Label 乘号4;
        private System.Windows.Forms.PictureBox 帐篷格;
        private System.Windows.Forms.Label 武器数量;
        private System.Windows.Forms.Label 子弹数量;
        private System.Windows.Forms.Label 香肠数量;
        private System.Windows.Forms.Label 帐篷数量;
        private System.Windows.Forms.Label 提醒;
        private System.Windows.Forms.Timer 提醒定时器;
        private System.Windows.Forms.ToolTip 提示文本;
        private AxWMPLib.AxWindowsMediaPlayer BulletSoundPlayer;
        private System.Windows.Forms.PictureBox 解药格;
        private System.Windows.Forms.Label 乘号5;
        private System.Windows.Forms.Label 解药数量;
    }
}