namespace 末日余生
{
    partial class TheLastofUs
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(TheLastofUs));
            this.角色输入面板 = new System.Windows.Forms.TextBox();
            this.提交按钮 = new System.Windows.Forms.Button();
            this.系统提示面板 = new System.Windows.Forms.Label();
            this.上 = new System.Windows.Forms.Button();
            this.左 = new System.Windows.Forms.Button();
            this.下 = new System.Windows.Forms.Button();
            this.右 = new System.Windows.Forms.Button();
            this.角色 = new System.Windows.Forms.PictureBox();
            this.地图 = new System.Windows.Forms.TableLayoutPanel();
            this.体力 = new System.Windows.Forms.Label();
            this.体力值 = new System.Windows.Forms.Label();
            this.时间 = new System.Windows.Forms.Label();
            this.定时器 = new System.Windows.Forms.Timer(this.components);
            this.丧尸生成器 = new System.Windows.Forms.Timer(this.components);
            this.显示背包 = new System.Windows.Forms.Button();
            this.显示或打开地图 = new System.Windows.Forms.Button();
            this.显示属性 = new System.Windows.Forms.Button();
            this.事件提醒 = new System.Windows.Forms.Timer(this.components);
            this.事件 = new System.Windows.Forms.Label();
            this.丧尸头像 = new System.Windows.Forms.PictureBox();
            this.死丧尸头像 = new System.Windows.Forms.PictureBox();
            this.丧尸头像闪烁 = new System.Windows.Forms.Timer(this.components);
            this.面板 = new System.Windows.Forms.Panel();
            this.火腿肠头像 = new System.Windows.Forms.PictureBox();
            this.BGPPlayer = new AxWMPLib.AxWindowsMediaPlayer();
            this.背景音乐 = new System.Windows.Forms.Button();
            this.无背景音乐 = new System.Windows.Forms.Button();
            this.体力上限 = new System.Windows.Forms.Label();
            this.TextPlayer = new AxWMPLib.AxWindowsMediaPlayer();
            this.提示文本 = new System.Windows.Forms.ToolTip(this.components);
            this.我的能力 = new System.Windows.Forms.Button();
            this.中毒 = new System.Windows.Forms.PictureBox();
            this.虚弱 = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.角色)).BeginInit();
            this.地图.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.丧尸头像)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.死丧尸头像)).BeginInit();
            this.面板.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.火腿肠头像)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.BGPPlayer)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.TextPlayer)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.中毒)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.虚弱)).BeginInit();
            this.SuspendLayout();
            // 
            // 角色输入面板
            // 
            this.角色输入面板.Font = new System.Drawing.Font("Microsoft YaHei UI", 12F);
            this.角色输入面板.Location = new System.Drawing.Point(10, 293);
            this.角色输入面板.Margin = new System.Windows.Forms.Padding(4);
            this.角色输入面板.Multiline = true;
            this.角色输入面板.Name = "角色输入面板";
            this.角色输入面板.Size = new System.Drawing.Size(426, 65);
            this.角色输入面板.TabIndex = 0;
            this.角色输入面板.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.角色输入面板_KeyPress);
            this.角色输入面板.KeyUp += new System.Windows.Forms.KeyEventHandler(this.角色输入面板_KeyUp);
            // 
            // 提交按钮
            // 
            this.提交按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("提交按钮.BackgroundImage")));
            this.提交按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.提交按钮.Cursor = System.Windows.Forms.Cursors.Hand;
            this.提交按钮.FlatAppearance.BorderSize = 0;
            this.提交按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.提交按钮.Location = new System.Drawing.Point(409, 364);
            this.提交按钮.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.提交按钮.Name = "提交按钮";
            this.提交按钮.Size = new System.Drawing.Size(23, 23);
            this.提交按钮.TabIndex = 1;
            this.提交按钮.UseVisualStyleBackColor = true;
            this.提交按钮.Click += new System.EventHandler(this.提交按钮_Click);
            // 
            // 系统提示面板
            // 
            this.系统提示面板.Location = new System.Drawing.Point(0, 0);
            this.系统提示面板.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.系统提示面板.Name = "系统提示面板";
            this.系统提示面板.Size = new System.Drawing.Size(420, 158);
            this.系统提示面板.TabIndex = 2;
            // 
            // 上
            // 
            this.上.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("上.BackgroundImage")));
            this.上.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.上.Cursor = System.Windows.Forms.Cursors.Hand;
            this.上.FlatAppearance.BorderSize = 0;
            this.上.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.上.Location = new System.Drawing.Point(528, 303);
            this.上.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.上.Name = "上";
            this.上.Size = new System.Drawing.Size(30, 30);
            this.上.TabIndex = 5;
            this.上.UseVisualStyleBackColor = true;
            this.上.Click += new System.EventHandler(this.上_Click);
            // 
            // 左
            // 
            this.左.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("左.BackgroundImage")));
            this.左.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.左.Cursor = System.Windows.Forms.Cursors.Hand;
            this.左.FlatAppearance.BorderSize = 0;
            this.左.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.左.Location = new System.Drawing.Point(480, 349);
            this.左.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.左.Name = "左";
            this.左.Size = new System.Drawing.Size(30, 30);
            this.左.TabIndex = 6;
            this.左.UseVisualStyleBackColor = true;
            this.左.Click += new System.EventHandler(this.左_Click);
            // 
            // 下
            // 
            this.下.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("下.BackgroundImage")));
            this.下.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.下.Cursor = System.Windows.Forms.Cursors.Hand;
            this.下.FlatAppearance.BorderSize = 0;
            this.下.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.下.Location = new System.Drawing.Point(528, 349);
            this.下.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.下.Name = "下";
            this.下.Size = new System.Drawing.Size(30, 30);
            this.下.TabIndex = 7;
            this.下.UseVisualStyleBackColor = true;
            this.下.Click += new System.EventHandler(this.下_Click);
            // 
            // 右
            // 
            this.右.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("右.BackgroundImage")));
            this.右.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.右.Cursor = System.Windows.Forms.Cursors.Hand;
            this.右.FlatAppearance.BorderSize = 0;
            this.右.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.右.Location = new System.Drawing.Point(575, 349);
            this.右.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.右.Name = "右";
            this.右.Size = new System.Drawing.Size(30, 30);
            this.右.TabIndex = 8;
            this.右.UseVisualStyleBackColor = true;
            this.右.Click += new System.EventHandler(this.右_Click);
            // 
            // 角色
            // 
            this.角色.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("角色.BackgroundImage")));
            this.角色.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.角色.Dock = System.Windows.Forms.DockStyle.Fill;
            this.角色.Location = new System.Drawing.Point(121, 1);
            this.角色.Margin = new System.Windows.Forms.Padding(0);
            this.角色.Name = "角色";
            this.角色.Size = new System.Drawing.Size(38, 39);
            this.角色.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage;
            this.角色.TabIndex = 10;
            this.角色.TabStop = false;
            // 
            // 地图
            // 
            this.地图.CellBorderStyle = System.Windows.Forms.TableLayoutPanelCellBorderStyle.Single;
            this.地图.ColumnCount = 4;
            this.地图.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 25.5F));
            this.地图.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 25.5F));
            this.地图.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 25.5F));
            this.地图.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 23.5F));
            this.地图.Controls.Add(this.角色, 3, 0);
            this.地图.Location = new System.Drawing.Point(462, 132);
            this.地图.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.地图.Name = "地图";
            this.地图.RowCount = 4;
            this.地图.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 25.5F));
            this.地图.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 25.5F));
            this.地图.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 25.5F));
            this.地图.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 23.5F));
            this.地图.Size = new System.Drawing.Size(160, 160);
            this.地图.TabIndex = 9;
            this.地图.CellPaint += new System.Windows.Forms.TableLayoutCellPaintEventHandler(this.地图_CellPaint);
            // 
            // 体力
            // 
            this.体力.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.体力.Location = new System.Drawing.Point(445, 47);
            this.体力.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.体力.Name = "体力";
            this.体力.Size = new System.Drawing.Size(58, 24);
            this.体力.TabIndex = 10;
            this.体力.Text = "体力：";
            this.体力.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 体力值
            // 
            this.体力值.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.体力值.Location = new System.Drawing.Point(487, 47);
            this.体力值.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.体力值.Name = "体力值";
            this.体力值.Size = new System.Drawing.Size(58, 24);
            this.体力值.TabIndex = 11;
            this.体力值.Text = "100";
            this.体力值.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 时间
            // 
            this.时间.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.时间.Location = new System.Drawing.Point(556, 47);
            this.时间.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.时间.Name = "时间";
            this.时间.Size = new System.Drawing.Size(58, 24);
            this.时间.TabIndex = 12;
            this.时间.Text = "9:00";
            this.时间.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 定时器
            // 
            this.定时器.Interval = 50;
            this.定时器.Tick += new System.EventHandler(this.定时器_Tick);
            // 
            // 丧尸生成器
            // 
            this.丧尸生成器.Enabled = true;
            this.丧尸生成器.Interval = 30000;
            this.丧尸生成器.Tick += new System.EventHandler(this.丧尸生成器_Tick);
            // 
            // 显示背包
            // 
            this.显示背包.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("显示背包.BackgroundImage")));
            this.显示背包.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.显示背包.Cursor = System.Windows.Forms.Cursors.Hand;
            this.显示背包.FlatAppearance.BorderSize = 0;
            this.显示背包.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.显示背包.Location = new System.Drawing.Point(500, 84);
            this.显示背包.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.显示背包.Name = "显示背包";
            this.显示背包.Size = new System.Drawing.Size(30, 30);
            this.显示背包.TabIndex = 13;
            this.显示背包.UseVisualStyleBackColor = true;
            this.显示背包.Click += new System.EventHandler(this.显示背包_Click);
            // 
            // 显示或打开地图
            // 
            this.显示或打开地图.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("显示或打开地图.BackgroundImage")));
            this.显示或打开地图.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.显示或打开地图.Cursor = System.Windows.Forms.Cursors.Hand;
            this.显示或打开地图.FlatAppearance.BorderSize = 0;
            this.显示或打开地图.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.显示或打开地图.Location = new System.Drawing.Point(450, 84);
            this.显示或打开地图.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.显示或打开地图.Name = "显示或打开地图";
            this.显示或打开地图.Size = new System.Drawing.Size(30, 30);
            this.显示或打开地图.TabIndex = 14;
            this.显示或打开地图.UseVisualStyleBackColor = true;
            this.显示或打开地图.Click += new System.EventHandler(this.显示或打开地图_Click);
            // 
            // 显示属性
            // 
            this.显示属性.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("显示属性.BackgroundImage")));
            this.显示属性.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.显示属性.Cursor = System.Windows.Forms.Cursors.Hand;
            this.显示属性.FlatAppearance.BorderSize = 0;
            this.显示属性.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.显示属性.Location = new System.Drawing.Point(600, 84);
            this.显示属性.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.显示属性.Name = "显示属性";
            this.显示属性.Size = new System.Drawing.Size(30, 30);
            this.显示属性.TabIndex = 15;
            this.显示属性.UseVisualStyleBackColor = true;
            this.显示属性.Click += new System.EventHandler(this.显示属性_Click);
            // 
            // 事件提醒
            // 
            this.事件提醒.Interval = 50;
            this.事件提醒.Tick += new System.EventHandler(this.事件提醒_Tick);
            // 
            // 事件
            // 
            this.事件.Location = new System.Drawing.Point(10, 364);
            this.事件.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.事件.Name = "事件";
            this.事件.Size = new System.Drawing.Size(314, 24);
            this.事件.TabIndex = 16;
            this.事件.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // 丧尸头像
            // 
            this.丧尸头像.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("丧尸头像.BackgroundImage")));
            this.丧尸头像.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.丧尸头像.Location = new System.Drawing.Point(360, 155);
            this.丧尸头像.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.丧尸头像.Name = "丧尸头像";
            this.丧尸头像.Size = new System.Drawing.Size(60, 70);
            this.丧尸头像.TabIndex = 17;
            this.丧尸头像.TabStop = false;
            this.丧尸头像.Visible = false;
            // 
            // 死丧尸头像
            // 
            this.死丧尸头像.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("死丧尸头像.BackgroundImage")));
            this.死丧尸头像.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.死丧尸头像.Location = new System.Drawing.Point(360, 155);
            this.死丧尸头像.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.死丧尸头像.Name = "死丧尸头像";
            this.死丧尸头像.Size = new System.Drawing.Size(60, 70);
            this.死丧尸头像.TabIndex = 18;
            this.死丧尸头像.TabStop = false;
            this.死丧尸头像.Visible = false;
            // 
            // 丧尸头像闪烁
            // 
            this.丧尸头像闪烁.Interval = 200;
            this.丧尸头像闪烁.Tick += new System.EventHandler(this.丧尸头像闪烁_Tick);
            // 
            // 面板
            // 
            this.面板.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.面板.Controls.Add(this.火腿肠头像);
            this.面板.Controls.Add(this.系统提示面板);
            this.面板.Controls.Add(this.丧尸头像);
            this.面板.Controls.Add(this.死丧尸头像);
            this.面板.Location = new System.Drawing.Point(10, 53);
            this.面板.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.面板.Name = "面板";
            this.面板.Size = new System.Drawing.Size(426, 234);
            this.面板.TabIndex = 19;
            // 
            // 火腿肠头像
            // 
            this.火腿肠头像.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("火腿肠头像.BackgroundImage")));
            this.火腿肠头像.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.火腿肠头像.Location = new System.Drawing.Point(360, 155);
            this.火腿肠头像.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.火腿肠头像.Name = "火腿肠头像";
            this.火腿肠头像.Size = new System.Drawing.Size(60, 70);
            this.火腿肠头像.TabIndex = 19;
            this.火腿肠头像.TabStop = false;
            this.火腿肠头像.Visible = false;
            // 
            // BGPPlayer
            // 
            this.BGPPlayer.Enabled = true;
            this.BGPPlayer.Location = new System.Drawing.Point(650, 36);
            this.BGPPlayer.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.BGPPlayer.Name = "BGPPlayer";
            this.BGPPlayer.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("BGPPlayer.OcxState")));
            this.BGPPlayer.Size = new System.Drawing.Size(38, 36);
            this.BGPPlayer.TabIndex = 20;
            this.BGPPlayer.StatusChange += new System.EventHandler(this.BGPPlayer_StatusChange);
            // 
            // 背景音乐
            // 
            this.背景音乐.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("背景音乐.BackgroundImage")));
            this.背景音乐.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.背景音乐.Cursor = System.Windows.Forms.Cursors.Hand;
            this.背景音乐.FlatAppearance.BorderSize = 0;
            this.背景音乐.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.背景音乐.Location = new System.Drawing.Point(409, 27);
            this.背景音乐.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.背景音乐.Name = "背景音乐";
            this.背景音乐.Size = new System.Drawing.Size(23, 23);
            this.背景音乐.TabIndex = 21;
            this.背景音乐.UseVisualStyleBackColor = true;
            this.背景音乐.Click += new System.EventHandler(this.背景音乐_Click);
            // 
            // 无背景音乐
            // 
            this.无背景音乐.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("无背景音乐.BackgroundImage")));
            this.无背景音乐.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.无背景音乐.Cursor = System.Windows.Forms.Cursors.Hand;
            this.无背景音乐.FlatAppearance.BorderSize = 0;
            this.无背景音乐.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.无背景音乐.Location = new System.Drawing.Point(409, 27);
            this.无背景音乐.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.无背景音乐.Name = "无背景音乐";
            this.无背景音乐.Size = new System.Drawing.Size(23, 23);
            this.无背景音乐.TabIndex = 22;
            this.无背景音乐.UseVisualStyleBackColor = true;
            this.无背景音乐.Visible = false;
            this.无背景音乐.Click += new System.EventHandler(this.无背景音乐_Click);
            // 
            // 体力上限
            // 
            this.体力上限.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.体力上限.Location = new System.Drawing.Point(511, 47);
            this.体力上限.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.体力上限.Name = "体力上限";
            this.体力上限.Size = new System.Drawing.Size(58, 24);
            this.体力上限.TabIndex = 23;
            this.体力上限.Text = "/100";
            this.体力上限.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // TextPlayer
            // 
            this.TextPlayer.Enabled = true;
            this.TextPlayer.Location = new System.Drawing.Point(650, 78);
            this.TextPlayer.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.TextPlayer.Name = "TextPlayer";
            this.TextPlayer.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("TextPlayer.OcxState")));
            this.TextPlayer.Size = new System.Drawing.Size(38, 36);
            this.TextPlayer.TabIndex = 24;
            // 
            // 我的能力
            // 
            this.我的能力.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("我的能力.BackgroundImage")));
            this.我的能力.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.我的能力.Cursor = System.Windows.Forms.Cursors.Hand;
            this.我的能力.FlatAppearance.BorderSize = 0;
            this.我的能力.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.我的能力.Location = new System.Drawing.Point(550, 84);
            this.我的能力.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.我的能力.Name = "我的能力";
            this.我的能力.Size = new System.Drawing.Size(30, 30);
            this.我的能力.TabIndex = 25;
            this.我的能力.UseVisualStyleBackColor = true;
            this.我的能力.MouseClick += new System.Windows.Forms.MouseEventHandler(this.我的能力_MouseClick);
            // 
            // 中毒
            // 
            this.中毒.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("中毒.BackgroundImage")));
            this.中毒.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.中毒.Cursor = System.Windows.Forms.Cursors.Hand;
            this.中毒.Location = new System.Drawing.Point(55, 28);
            this.中毒.Name = "中毒";
            this.中毒.Size = new System.Drawing.Size(23, 23);
            this.中毒.TabIndex = 26;
            this.中毒.TabStop = false;
            this.中毒.Visible = false;
            // 
            // 虚弱
            // 
            this.虚弱.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("虚弱.BackgroundImage")));
            this.虚弱.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.虚弱.Cursor = System.Windows.Forms.Cursors.Hand;
            this.虚弱.Location = new System.Drawing.Point(10, 27);
            this.虚弱.Name = "虚弱";
            this.虚弱.Size = new System.Drawing.Size(39, 23);
            this.虚弱.TabIndex = 27;
            this.虚弱.TabStop = false;
            this.虚弱.Visible = false;
            // 
            // TheLastofUs
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(10F, 21F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(125)))));
            this.ClientSize = new System.Drawing.Size(645, 395);
            this.Controls.Add(this.虚弱);
            this.Controls.Add(this.中毒);
            this.Controls.Add(this.我的能力);
            this.Controls.Add(this.TextPlayer);
            this.Controls.Add(this.体力上限);
            this.Controls.Add(this.无背景音乐);
            this.Controls.Add(this.背景音乐);
            this.Controls.Add(this.BGPPlayer);
            this.Controls.Add(this.面板);
            this.Controls.Add(this.事件);
            this.Controls.Add(this.显示属性);
            this.Controls.Add(this.显示或打开地图);
            this.Controls.Add(this.显示背包);
            this.Controls.Add(this.时间);
            this.Controls.Add(this.体力值);
            this.Controls.Add(this.体力);
            this.Controls.Add(this.地图);
            this.Controls.Add(this.右);
            this.Controls.Add(this.下);
            this.Controls.Add(this.左);
            this.Controls.Add(this.上);
            this.Controls.Add(this.提交按钮);
            this.Controls.Add(this.角色输入面板);
            this.Font = new System.Drawing.Font("Microsoft YaHei UI", 12F);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "TheLastofUs";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "末日余生";
            this.Load += new System.EventHandler(this.TheLastofUs_Load);
            this.DoubleClick += new System.EventHandler(this.TheLastofUs_DoubleClick);
            this.Move += new System.EventHandler(this.TheLastofUs_Move);
            ((System.ComponentModel.ISupportInitialize)(this.角色)).EndInit();
            this.地图.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.丧尸头像)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.死丧尸头像)).EndInit();
            this.面板.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.火腿肠头像)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.BGPPlayer)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.TextPlayer)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.中毒)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.虚弱)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox 角色输入面板;
        private System.Windows.Forms.Button 提交按钮;
        private System.Windows.Forms.Label 系统提示面板;
        private System.Windows.Forms.Button 上;
        private System.Windows.Forms.Button 左;
        private System.Windows.Forms.Button 下;
        private System.Windows.Forms.Button 右;
        private System.Windows.Forms.PictureBox 角色;
        private System.Windows.Forms.TableLayoutPanel 地图;
        private System.Windows.Forms.Label 体力;
        private System.Windows.Forms.Label 体力值;
        private System.Windows.Forms.Label 时间;
        private System.Windows.Forms.Timer 定时器;
        private System.Windows.Forms.Timer 丧尸生成器;
        private System.Windows.Forms.Button 显示背包;
        private System.Windows.Forms.Button 显示或打开地图;
        private System.Windows.Forms.Button 显示属性;
        private System.Windows.Forms.Timer 事件提醒;
        private System.Windows.Forms.Label 事件;
        private System.Windows.Forms.PictureBox 丧尸头像;
        private System.Windows.Forms.PictureBox 死丧尸头像;
        private System.Windows.Forms.Timer 丧尸头像闪烁;
        private System.Windows.Forms.Panel 面板;
        private System.Windows.Forms.PictureBox 火腿肠头像;
        private AxWMPLib.AxWindowsMediaPlayer BGPPlayer;
        private System.Windows.Forms.Button 背景音乐;
        private System.Windows.Forms.Button 无背景音乐;
        private System.Windows.Forms.Label 体力上限;
        private AxWMPLib.AxWindowsMediaPlayer TextPlayer;
        private System.Windows.Forms.ToolTip 提示文本;
        private System.Windows.Forms.Button 我的能力;
        private System.Windows.Forms.PictureBox 中毒;
        private System.Windows.Forms.PictureBox 虚弱;
    }
}

