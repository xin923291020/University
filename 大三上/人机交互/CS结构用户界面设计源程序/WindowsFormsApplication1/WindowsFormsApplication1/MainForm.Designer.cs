using System.Windows.Forms;
namespace WindowsFormsApplication1
{
    partial class MainForm
    {
        #region
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;
        #endregion

        #region
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
        #endregion

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainForm));
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle9 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle10 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle11 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle12 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle13 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle14 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle15 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle16 = new System.Windows.Forms.DataGridViewCellStyle();
            this.进货面板 = new System.Windows.Forms.Panel();
            this.进货管理子按钮 = new System.Windows.Forms.Button();
            this.进货子按钮 = new System.Windows.Forms.Button();
            this.出货面板 = new System.Windows.Forms.Panel();
            this.出货管理子按钮 = new System.Windows.Forms.Button();
            this.出货子按钮 = new System.Windows.Forms.Button();
            this.资金面板 = new System.Windows.Forms.Panel();
            this.查看资金子按钮 = new System.Windows.Forms.Button();
            this.进货总按钮 = new System.Windows.Forms.Button();
            this.出货总按钮 = new System.Windows.Forms.Button();
            this.资金总按钮 = new System.Windows.Forms.Button();
            this.进货单保存按钮 = new System.Windows.Forms.Button();
            this.进货单关闭按钮 = new System.Windows.Forms.Button();
            this.菜单 = new System.Windows.Forms.MenuStrip();
            this.新增 = new System.Windows.Forms.ToolStripMenuItem();
            this.新增供货商 = new System.Windows.Forms.ToolStripMenuItem();
            this.新增商品 = new System.Windows.Forms.ToolStripMenuItem();
            this.修改 = new System.Windows.Forms.ToolStripMenuItem();
            this.修改供货商 = new System.Windows.Forms.ToolStripMenuItem();
            this.修改商品 = new System.Windows.Forms.ToolStripMenuItem();
            this.修改密码 = new System.Windows.Forms.ToolStripMenuItem();
            this.联系我们 = new System.Windows.Forms.ToolStripMenuItem();
            this.退出 = new System.Windows.Forms.ToolStripMenuItem();
            this.进货单时间戳 = new System.Windows.Forms.Label();
            this.进货单现金标签 = new System.Windows.Forms.Label();
            this.进货单合计标签 = new System.Windows.Forms.Label();
            this.进货单总金额标签 = new System.Windows.Forms.Label();
            this.进货单找零标签 = new System.Windows.Forms.Label();
            this.进货单找零金额标签 = new System.Windows.Forms.Label();
            this.进货单现金输入框 = new System.Windows.Forms.TextBox();
            this.进货单供应商下拉列表框 = new System.Windows.Forms.ComboBox();
            this.进货单时间 = new System.Windows.Forms.DateTimePicker();
            this.页眉框 = new System.Windows.Forms.TabControl();
            this.出货管理 = new System.Windows.Forms.TabPage();
            this.进货管理 = new System.Windows.Forms.TabPage();
            this.资金 = new System.Windows.Forms.TabPage();
            this.进货管理面板 = new System.Windows.Forms.Panel();
            this.进货 = new System.Windows.Forms.TabPage();
            this.进货单面板 = new System.Windows.Forms.Panel();
            this.添加 = new System.Windows.Forms.Button();
            this.进货单表格 = new System.Windows.Forms.DataGridView();
            this.商品名1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.单位1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.单价1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.个数1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.总价1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.出货 = new System.Windows.Forms.TabPage();
            this.出货单关闭按钮 = new System.Windows.Forms.Button();
            this.出货单保存按钮 = new System.Windows.Forms.Button();
            this.出货单现金输入框 = new System.Windows.Forms.TextBox();
            this.出货单找零金额标签 = new System.Windows.Forms.Label();
            this.出货单找零标签 = new System.Windows.Forms.Label();
            this.出货单总金额标签 = new System.Windows.Forms.Label();
            this.出货单合计标签 = new System.Windows.Forms.Label();
            this.出货单现金标签 = new System.Windows.Forms.Label();
            this.出货单面板 = new System.Windows.Forms.Panel();
            this.添加1 = new System.Windows.Forms.Button();
            this.出货单表格 = new System.Windows.Forms.DataGridView();
            this.商品名3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.单位3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.单价3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.个数3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.总金额3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.出货单时间戳 = new System.Windows.Forms.Label();
            this.出货单时间 = new System.Windows.Forms.DateTimePicker();
            this.出货单购货商 = new System.Windows.Forms.TextBox();
            this.欢迎 = new System.Windows.Forms.TabPage();
            this.链接标签2 = new System.Windows.Forms.LinkLabel();
            this.链接标签5 = new System.Windows.Forms.LinkLabel();
            this.链接标签3 = new System.Windows.Forms.LinkLabel();
            this.链接标签4 = new System.Windows.Forms.LinkLabel();
            this.关闭欢迎 = new System.Windows.Forms.CheckBox();
            this.链接标签1 = new System.Windows.Forms.LinkLabel();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.用户 = new System.Windows.Forms.Label();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridView2 = new System.Windows.Forms.DataGridView();
            this.Column5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column8 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column9 = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.dataGridView3 = new System.Windows.Forms.DataGridView();
            this.Column10 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column11 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column12 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column13 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column14 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.进货面板.SuspendLayout();
            this.出货面板.SuspendLayout();
            this.资金面板.SuspendLayout();
            this.菜单.SuspendLayout();
            this.页眉框.SuspendLayout();
            this.出货管理.SuspendLayout();
            this.进货管理.SuspendLayout();
            this.资金.SuspendLayout();
            this.进货管理面板.SuspendLayout();
            this.进货.SuspendLayout();
            this.进货单面板.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.进货单表格)).BeginInit();
            this.出货.SuspendLayout();
            this.出货单面板.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.出货单表格)).BeginInit();
            this.欢迎.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView3)).BeginInit();
            this.SuspendLayout();
            // 
            // 进货面板
            // 
            this.进货面板.Controls.Add(this.进货管理子按钮);
            this.进货面板.Controls.Add(this.进货子按钮);
            this.进货面板.Location = new System.Drawing.Point(800, 190);
            this.进货面板.Name = "进货面板";
            this.进货面板.Size = new System.Drawing.Size(70, 140);
            this.进货面板.TabIndex = 3;
            this.进货面板.Visible = false;
            // 
            // 进货管理子按钮
            // 
            this.进货管理子按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("进货管理子按钮.BackgroundImage")));
            this.进货管理子按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.进货管理子按钮.FlatAppearance.BorderSize = 0;
            this.进货管理子按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.进货管理子按钮.Location = new System.Drawing.Point(0, 55);
            this.进货管理子按钮.Name = "进货管理子按钮";
            this.进货管理子按钮.Size = new System.Drawing.Size(70, 55);
            this.进货管理子按钮.TabIndex = 1;
            this.进货管理子按钮.UseVisualStyleBackColor = true;
            this.进货管理子按钮.Click += new System.EventHandler(this.进货管理子按钮_Click);
            // 
            // 进货子按钮
            // 
            this.进货子按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("进货子按钮.BackgroundImage")));
            this.进货子按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.进货子按钮.FlatAppearance.BorderSize = 0;
            this.进货子按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.进货子按钮.Location = new System.Drawing.Point(0, 0);
            this.进货子按钮.Name = "进货子按钮";
            this.进货子按钮.Size = new System.Drawing.Size(70, 55);
            this.进货子按钮.TabIndex = 0;
            this.进货子按钮.UseVisualStyleBackColor = true;
            this.进货子按钮.Click += new System.EventHandler(this.进货子按钮_Click);
            // 
            // 出货面板
            // 
            this.出货面板.Controls.Add(this.出货管理子按钮);
            this.出货面板.Controls.Add(this.出货子按钮);
            this.出货面板.Location = new System.Drawing.Point(875, 50);
            this.出货面板.Name = "出货面板";
            this.出货面板.Size = new System.Drawing.Size(70, 140);
            this.出货面板.TabIndex = 4;
            this.出货面板.Visible = false;
            // 
            // 出货管理子按钮
            // 
            this.出货管理子按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("出货管理子按钮.BackgroundImage")));
            this.出货管理子按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.出货管理子按钮.FlatAppearance.BorderSize = 0;
            this.出货管理子按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.出货管理子按钮.Location = new System.Drawing.Point(0, 55);
            this.出货管理子按钮.Name = "出货管理子按钮";
            this.出货管理子按钮.Size = new System.Drawing.Size(70, 55);
            this.出货管理子按钮.TabIndex = 1;
            this.出货管理子按钮.UseVisualStyleBackColor = true;
            this.出货管理子按钮.Click += new System.EventHandler(this.出货管理子按钮_Click);
            // 
            // 出货子按钮
            // 
            this.出货子按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("出货子按钮.BackgroundImage")));
            this.出货子按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.出货子按钮.FlatAppearance.BorderSize = 0;
            this.出货子按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.出货子按钮.Location = new System.Drawing.Point(0, 0);
            this.出货子按钮.Name = "出货子按钮";
            this.出货子按钮.Size = new System.Drawing.Size(70, 55);
            this.出货子按钮.TabIndex = 0;
            this.出货子按钮.UseVisualStyleBackColor = true;
            this.出货子按钮.Click += new System.EventHandler(this.出货子按钮_Click);
            // 
            // 资金面板
            // 
            this.资金面板.Controls.Add(this.查看资金子按钮);
            this.资金面板.Location = new System.Drawing.Point(800, 50);
            this.资金面板.Name = "资金面板";
            this.资金面板.Size = new System.Drawing.Size(70, 140);
            this.资金面板.TabIndex = 5;
            this.资金面板.Visible = false;
            // 
            // 查看资金子按钮
            // 
            this.查看资金子按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("查看资金子按钮.BackgroundImage")));
            this.查看资金子按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.查看资金子按钮.FlatAppearance.BorderSize = 0;
            this.查看资金子按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.查看资金子按钮.Location = new System.Drawing.Point(0, 0);
            this.查看资金子按钮.Name = "查看资金子按钮";
            this.查看资金子按钮.Size = new System.Drawing.Size(70, 55);
            this.查看资金子按钮.TabIndex = 0;
            this.查看资金子按钮.UseVisualStyleBackColor = true;
            this.查看资金子按钮.Click += new System.EventHandler(this.查看资金子按钮_Click);
            // 
            // 进货总按钮
            // 
            this.进货总按钮.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(208)))), ((int)(((byte)(255)))));
            this.进货总按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("进货总按钮.BackgroundImage")));
            this.进货总按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.进货总按钮.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(208)))), ((int)(((byte)(255)))));
            this.进货总按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.进货总按钮.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.进货总按钮.Location = new System.Drawing.Point(3, 53);
            this.进货总按钮.Name = "进货总按钮";
            this.进货总按钮.Size = new System.Drawing.Size(70, 70);
            this.进货总按钮.TabIndex = 0;
            this.进货总按钮.UseVisualStyleBackColor = false;
            this.进货总按钮.Click += new System.EventHandler(this.进货总按钮_Click);
            // 
            // 出货总按钮
            // 
            this.出货总按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("出货总按钮.BackgroundImage")));
            this.出货总按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.出货总按钮.FlatAppearance.BorderSize = 0;
            this.出货总按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.出货总按钮.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.出货总按钮.Location = new System.Drawing.Point(3, 123);
            this.出货总按钮.Name = "出货总按钮";
            this.出货总按钮.Size = new System.Drawing.Size(70, 70);
            this.出货总按钮.TabIndex = 1;
            this.出货总按钮.UseVisualStyleBackColor = true;
            this.出货总按钮.Click += new System.EventHandler(this.出货总按钮_Click);
            // 
            // 资金总按钮
            // 
            this.资金总按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("资金总按钮.BackgroundImage")));
            this.资金总按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.资金总按钮.FlatAppearance.BorderSize = 0;
            this.资金总按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.资金总按钮.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.资金总按钮.Location = new System.Drawing.Point(3, 193);
            this.资金总按钮.Name = "资金总按钮";
            this.资金总按钮.Size = new System.Drawing.Size(70, 70);
            this.资金总按钮.TabIndex = 2;
            this.资金总按钮.UseVisualStyleBackColor = true;
            this.资金总按钮.Click += new System.EventHandler(this.资金总按钮_Click);
            // 
            // 进货单保存按钮
            // 
            this.进货单保存按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("进货单保存按钮.BackgroundImage")));
            this.进货单保存按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.进货单保存按钮.FlatAppearance.BorderSize = 0;
            this.进货单保存按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.进货单保存按钮.Location = new System.Drawing.Point(20, 15);
            this.进货单保存按钮.Name = "进货单保存按钮";
            this.进货单保存按钮.Size = new System.Drawing.Size(35, 35);
            this.进货单保存按钮.TabIndex = 4;
            this.进货单保存按钮.UseVisualStyleBackColor = true;
            this.进货单保存按钮.Click += new System.EventHandler(this.进货单保存按钮_Click);
            // 
            // 进货单关闭按钮
            // 
            this.进货单关闭按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("进货单关闭按钮.BackgroundImage")));
            this.进货单关闭按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.进货单关闭按钮.FlatAppearance.BorderSize = 0;
            this.进货单关闭按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.进货单关闭按钮.Location = new System.Drawing.Point(85, 15);
            this.进货单关闭按钮.Name = "进货单关闭按钮";
            this.进货单关闭按钮.Size = new System.Drawing.Size(35, 35);
            this.进货单关闭按钮.TabIndex = 5;
            this.进货单关闭按钮.UseVisualStyleBackColor = true;
            this.进货单关闭按钮.Click += new System.EventHandler(this.进货单关闭按钮_Click);
            // 
            // 菜单
            // 
            this.菜单.AutoSize = false;
            this.菜单.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(208)))), ((int)(((byte)(255)))));
            this.菜单.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.新增,
            this.修改,
            this.联系我们,
            this.退出});
            this.菜单.Location = new System.Drawing.Point(4, 28);
            this.菜单.Name = "菜单";
            this.菜单.Size = new System.Drawing.Size(752, 25);
            this.菜单.TabIndex = 6;
            this.菜单.Text = "菜单";
            // 
            // 新增
            // 
            this.新增.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.新增供货商,
            this.新增商品});
            this.新增.Name = "新增";
            this.新增.Size = new System.Drawing.Size(44, 21);
            this.新增.Text = "新增";
            // 
            // 新增供货商
            // 
            this.新增供货商.Name = "新增供货商";
            this.新增供货商.Size = new System.Drawing.Size(136, 22);
            this.新增供货商.Text = "新增供货商";
            this.新增供货商.Click += new System.EventHandler(this.新增供货商_Click);
            // 
            // 新增商品
            // 
            this.新增商品.Name = "新增商品";
            this.新增商品.Size = new System.Drawing.Size(136, 22);
            this.新增商品.Text = "新增商品";
            this.新增商品.Click += new System.EventHandler(this.新增商品_Click);
            // 
            // 修改
            // 
            this.修改.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.修改供货商,
            this.修改商品,
            this.修改密码});
            this.修改.Name = "修改";
            this.修改.Size = new System.Drawing.Size(44, 21);
            this.修改.Text = "修改";
            // 
            // 修改供货商
            // 
            this.修改供货商.Name = "修改供货商";
            this.修改供货商.Size = new System.Drawing.Size(136, 22);
            this.修改供货商.Text = "修改供货商";
            this.修改供货商.Click += new System.EventHandler(this.修改供货商_Click);
            // 
            // 修改商品
            // 
            this.修改商品.Name = "修改商品";
            this.修改商品.Size = new System.Drawing.Size(136, 22);
            this.修改商品.Text = "修改商品";
            this.修改商品.Click += new System.EventHandler(this.修改商品_Click);
            // 
            // 修改密码
            // 
            this.修改密码.Name = "修改密码";
            this.修改密码.Size = new System.Drawing.Size(136, 22);
            this.修改密码.Text = "修改密码";
            this.修改密码.Click += new System.EventHandler(this.修改密码_Click);
            // 
            // 联系我们
            // 
            this.联系我们.Name = "联系我们";
            this.联系我们.Size = new System.Drawing.Size(68, 21);
            this.联系我们.Text = "联系我们";
            this.联系我们.Click += new System.EventHandler(this.联系我们_Click);
            // 
            // 退出
            // 
            this.退出.Name = "退出";
            this.退出.Size = new System.Drawing.Size(44, 21);
            this.退出.Text = "退出";
            this.退出.Click += new System.EventHandler(this.退出_Click);
            // 
            // 进货单时间戳
            // 
            this.进货单时间戳.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.进货单时间戳.Font = new System.Drawing.Font("宋体", 12F);
            this.进货单时间戳.Location = new System.Drawing.Point(520, 60);
            this.进货单时间戳.Name = "进货单时间戳";
            this.进货单时间戳.Size = new System.Drawing.Size(110, 20);
            this.进货单时间戳.TabIndex = 3;
            this.进货单时间戳.Text = "         ";
            // 
            // 进货单现金标签
            // 
            this.进货单现金标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9.5F);
            this.进货单现金标签.Location = new System.Drawing.Point(200, 350);
            this.进货单现金标签.Name = "进货单现金标签";
            this.进货单现金标签.Size = new System.Drawing.Size(50, 25);
            this.进货单现金标签.TabIndex = 7;
            this.进货单现金标签.Text = "现金：";
            this.进货单现金标签.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 进货单合计标签
            // 
            this.进货单合计标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9.5F);
            this.进货单合计标签.Location = new System.Drawing.Point(350, 350);
            this.进货单合计标签.Name = "进货单合计标签";
            this.进货单合计标签.Size = new System.Drawing.Size(50, 25);
            this.进货单合计标签.TabIndex = 8;
            this.进货单合计标签.Text = "合计：";
            this.进货单合计标签.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 进货单总金额标签
            // 
            this.进货单总金额标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9.5F);
            this.进货单总金额标签.Location = new System.Drawing.Point(400, 350);
            this.进货单总金额标签.Name = "进货单总金额标签";
            this.进货单总金额标签.Size = new System.Drawing.Size(50, 25);
            this.进货单总金额标签.TabIndex = 9;
            this.进货单总金额标签.Text = "合计";
            this.进货单总金额标签.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 进货单找零标签
            // 
            this.进货单找零标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9.5F);
            this.进货单找零标签.Location = new System.Drawing.Point(500, 350);
            this.进货单找零标签.Name = "进货单找零标签";
            this.进货单找零标签.Size = new System.Drawing.Size(50, 25);
            this.进货单找零标签.TabIndex = 10;
            this.进货单找零标签.Text = "找零：";
            this.进货单找零标签.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 进货单找零金额标签
            // 
            this.进货单找零金额标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9.5F);
            this.进货单找零金额标签.Location = new System.Drawing.Point(550, 350);
            this.进货单找零金额标签.Name = "进货单找零金额标签";
            this.进货单找零金额标签.Size = new System.Drawing.Size(50, 25);
            this.进货单找零金额标签.TabIndex = 12;
            this.进货单找零金额标签.Text = "找零";
            this.进货单找零金额标签.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 进货单现金输入框
            // 
            this.进货单现金输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.进货单现金输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.进货单现金输入框.Location = new System.Drawing.Point(250, 350);
            this.进货单现金输入框.Name = "进货单现金输入框";
            this.进货单现金输入框.Size = new System.Drawing.Size(50, 23);
            this.进货单现金输入框.TabIndex = 11;
            this.进货单现金输入框.Leave += new System.EventHandler(this.进货单现金输入框_Leave);
            // 
            // 进货单供应商下拉列表框
            // 
            this.进货单供应商下拉列表框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.进货单供应商下拉列表框.FormattingEnabled = true;
            this.进货单供应商下拉列表框.Location = new System.Drawing.Point(20, 60);
            this.进货单供应商下拉列表框.Name = "进货单供应商下拉列表框";
            this.进货单供应商下拉列表框.Size = new System.Drawing.Size(100, 25);
            this.进货单供应商下拉列表框.TabIndex = 0;
            // 
            // 进货单时间
            // 
            this.进货单时间.Location = new System.Drawing.Point(170, 60);
            this.进货单时间.Name = "进货单时间";
            this.进货单时间.Size = new System.Drawing.Size(100, 23);
            this.进货单时间.TabIndex = 1;
            // 
            // 页眉框
            // 
            this.页眉框.Controls.Add(this.出货管理);
            this.页眉框.Controls.Add(this.进货管理);
            this.页眉框.Controls.Add(this.资金);
            this.页眉框.Controls.Add(this.进货);
            this.页眉框.Controls.Add(this.出货);
            this.页眉框.Controls.Add(this.欢迎);
            this.页眉框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.页眉框.Location = new System.Drawing.Point(76, 56);
            this.页眉框.Name = "页眉框";
            this.页眉框.SelectedIndex = 0;
            this.页眉框.Size = new System.Drawing.Size(680, 418);
            this.页眉框.TabIndex = 7;
            this.页眉框.DrawItem += new System.Windows.Forms.DrawItemEventHandler(this.页眉框_DrawItem);
            this.页眉框.Click += new System.EventHandler(this.页眉框_Click);
            this.页眉框.DoubleClick += new System.EventHandler(this.页眉框_DoubleClick);
            // 
            // 出货管理
            // 
            this.出货管理.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.出货管理.Controls.Add(this.dataGridView1);
            this.出货管理.Location = new System.Drawing.Point(4, 26);
            this.出货管理.Name = "出货管理";
            this.出货管理.Size = new System.Drawing.Size(672, 388);
            this.出货管理.TabIndex = 3;
            this.出货管理.Text = "出货单";
            this.出货管理.UseVisualStyleBackColor = true;
            // 
            // 进货管理
            // 
            this.进货管理.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.进货管理.Controls.Add(this.dataGridView2);
            this.进货管理.Location = new System.Drawing.Point(4, 26);
            this.进货管理.Name = "进货管理";
            this.进货管理.Size = new System.Drawing.Size(672, 388);
            this.进货管理.TabIndex = 4;
            this.进货管理.Text = "进货管理";
            this.进货管理.UseVisualStyleBackColor = true;
            // 
            // 资金
            // 
            this.资金.Controls.Add(this.进货管理面板);
            this.资金.Location = new System.Drawing.Point(4, 26);
            this.资金.Name = "资金";
            this.资金.Size = new System.Drawing.Size(672, 388);
            this.资金.TabIndex = 1;
            this.资金.Text = "资金";
            this.资金.UseVisualStyleBackColor = true;
            // 
            // 进货管理面板
            // 
            this.进货管理面板.AutoScroll = true;
            this.进货管理面板.Controls.Add(this.dataGridView3);
            this.进货管理面板.Dock = System.Windows.Forms.DockStyle.Fill;
            this.进货管理面板.Location = new System.Drawing.Point(0, 0);
            this.进货管理面板.Name = "进货管理面板";
            this.进货管理面板.Size = new System.Drawing.Size(672, 388);
            this.进货管理面板.TabIndex = 2;
            // 
            // 进货
            // 
            this.进货.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.进货.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.进货.Controls.Add(this.进货单面板);
            this.进货.Controls.Add(this.进货单找零金额标签);
            this.进货.Controls.Add(this.进货单现金输入框);
            this.进货.Controls.Add(this.进货单找零标签);
            this.进货.Controls.Add(this.进货单总金额标签);
            this.进货.Controls.Add(this.进货单合计标签);
            this.进货.Controls.Add(this.进货单现金标签);
            this.进货.Controls.Add(this.进货单关闭按钮);
            this.进货.Controls.Add(this.进货单保存按钮);
            this.进货.Controls.Add(this.进货单时间戳);
            this.进货.Controls.Add(this.进货单时间);
            this.进货.Controls.Add(this.进货单供应商下拉列表框);
            this.进货.Location = new System.Drawing.Point(4, 26);
            this.进货.Name = "进货";
            this.进货.Size = new System.Drawing.Size(672, 388);
            this.进货.TabIndex = 2;
            this.进货.Text = "进货";
            // 
            // 进货单面板
            // 
            this.进货单面板.Controls.Add(this.添加);
            this.进货单面板.Controls.Add(this.进货单表格);
            this.进货单面板.Location = new System.Drawing.Point(20, 100);
            this.进货单面板.Name = "进货单面板";
            this.进货单面板.Size = new System.Drawing.Size(630, 230);
            this.进货单面板.TabIndex = 13;
            // 
            // 添加
            // 
            this.添加.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.添加.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("添加.BackgroundImage")));
            this.添加.Cursor = System.Windows.Forms.Cursors.Hand;
            this.添加.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.添加.FlatAppearance.BorderSize = 0;
            this.添加.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.添加.Location = new System.Drawing.Point(604, 204);
            this.添加.Name = "添加";
            this.添加.Size = new System.Drawing.Size(25, 25);
            this.添加.TabIndex = 1;
            this.添加.UseVisualStyleBackColor = false;
            this.添加.Click += new System.EventHandler(this.添加_Click);
            // 
            // 进货单表格
            // 
            this.进货单表格.AllowUserToAddRows = false;
            this.进货单表格.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.进货单表格.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.进货单表格.BorderStyle = System.Windows.Forms.BorderStyle.None;
            dataGridViewCellStyle9.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle9.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle9.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle9.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle9.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle9.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle9.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.进货单表格.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle9;
            this.进货单表格.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.进货单表格.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.商品名1,
            this.单位1,
            this.单价1,
            this.个数1,
            this.总价1});
            dataGridViewCellStyle10.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle10.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle10.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle10.ForeColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle10.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle10.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle10.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.进货单表格.DefaultCellStyle = dataGridViewCellStyle10;
            this.进货单表格.EnableHeadersVisualStyles = false;
            this.进货单表格.Location = new System.Drawing.Point(0, 0);
            this.进货单表格.Name = "进货单表格";
            dataGridViewCellStyle11.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle11.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle11.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle11.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle11.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle11.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle11.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.进货单表格.RowHeadersDefaultCellStyle = dataGridViewCellStyle11;
            this.进货单表格.RowHeadersWidth = 40;
            dataGridViewCellStyle12.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            this.进货单表格.RowsDefaultCellStyle = dataGridViewCellStyle12;
            this.进货单表格.RowTemplate.Height = 23;
            this.进货单表格.Size = new System.Drawing.Size(630, 230);
            this.进货单表格.TabIndex = 0;
            this.进货单表格.CellEndEdit += new System.Windows.Forms.DataGridViewCellEventHandler(this.进货单表格_CellEndEdit);
            // 
            // 商品名1
            // 
            this.商品名1.HeaderText = "商品名";
            this.商品名1.Name = "商品名1";
            this.商品名1.ReadOnly = true;
            // 
            // 单位1
            // 
            this.单位1.HeaderText = "单位";
            this.单位1.Name = "单位1";
            this.单位1.ReadOnly = true;
            // 
            // 单价1
            // 
            this.单价1.HeaderText = "单价";
            this.单价1.Name = "单价1";
            this.单价1.ReadOnly = true;
            // 
            // 个数1
            // 
            this.个数1.HeaderText = "个数";
            this.个数1.Name = "个数1";
            // 
            // 总价1
            // 
            this.总价1.HeaderText = "总价";
            this.总价1.Name = "总价1";
            this.总价1.ReadOnly = true;
            // 
            // 出货
            // 
            this.出货.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.出货.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.出货.Controls.Add(this.出货单关闭按钮);
            this.出货.Controls.Add(this.出货单保存按钮);
            this.出货.Controls.Add(this.出货单现金输入框);
            this.出货.Controls.Add(this.出货单找零金额标签);
            this.出货.Controls.Add(this.出货单找零标签);
            this.出货.Controls.Add(this.出货单总金额标签);
            this.出货.Controls.Add(this.出货单合计标签);
            this.出货.Controls.Add(this.出货单现金标签);
            this.出货.Controls.Add(this.出货单面板);
            this.出货.Controls.Add(this.出货单时间戳);
            this.出货.Controls.Add(this.出货单时间);
            this.出货.Controls.Add(this.出货单购货商);
            this.出货.Location = new System.Drawing.Point(4, 26);
            this.出货.Name = "出货";
            this.出货.Size = new System.Drawing.Size(672, 388);
            this.出货.TabIndex = 2;
            this.出货.Text = "出货";
            // 
            // 出货单关闭按钮
            // 
            this.出货单关闭按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("出货单关闭按钮.BackgroundImage")));
            this.出货单关闭按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.出货单关闭按钮.FlatAppearance.BorderSize = 0;
            this.出货单关闭按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.出货单关闭按钮.Location = new System.Drawing.Point(85, 15);
            this.出货单关闭按钮.Name = "出货单关闭按钮";
            this.出货单关闭按钮.Size = new System.Drawing.Size(35, 35);
            this.出货单关闭按钮.TabIndex = 13;
            this.出货单关闭按钮.UseVisualStyleBackColor = true;
            // 
            // 出货单保存按钮
            // 
            this.出货单保存按钮.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("出货单保存按钮.BackgroundImage")));
            this.出货单保存按钮.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.出货单保存按钮.FlatAppearance.BorderSize = 0;
            this.出货单保存按钮.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.出货单保存按钮.Location = new System.Drawing.Point(20, 15);
            this.出货单保存按钮.Name = "出货单保存按钮";
            this.出货单保存按钮.Size = new System.Drawing.Size(35, 35);
            this.出货单保存按钮.TabIndex = 12;
            this.出货单保存按钮.UseVisualStyleBackColor = true;
            this.出货单保存按钮.Click += new System.EventHandler(this.出货单保存按钮_Click);
            // 
            // 出货单现金输入框
            // 
            this.出货单现金输入框.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.出货单现金输入框.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.出货单现金输入框.Location = new System.Drawing.Point(250, 350);
            this.出货单现金输入框.Name = "出货单现金输入框";
            this.出货单现金输入框.Size = new System.Drawing.Size(50, 23);
            this.出货单现金输入框.TabIndex = 11;
            this.出货单现金输入框.Leave += new System.EventHandler(this.出货单现金输入框_Leave);
            // 
            // 出货单找零金额标签
            // 
            this.出货单找零金额标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9.5F);
            this.出货单找零金额标签.Location = new System.Drawing.Point(550, 350);
            this.出货单找零金额标签.Name = "出货单找零金额标签";
            this.出货单找零金额标签.Size = new System.Drawing.Size(50, 25);
            this.出货单找零金额标签.TabIndex = 10;
            this.出货单找零金额标签.Text = "找零";
            this.出货单找零金额标签.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 出货单找零标签
            // 
            this.出货单找零标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9.5F);
            this.出货单找零标签.Location = new System.Drawing.Point(500, 350);
            this.出货单找零标签.Name = "出货单找零标签";
            this.出货单找零标签.Size = new System.Drawing.Size(50, 25);
            this.出货单找零标签.TabIndex = 9;
            this.出货单找零标签.Text = "找零：";
            this.出货单找零标签.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 出货单总金额标签
            // 
            this.出货单总金额标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9.5F);
            this.出货单总金额标签.Location = new System.Drawing.Point(400, 350);
            this.出货单总金额标签.Name = "出货单总金额标签";
            this.出货单总金额标签.Size = new System.Drawing.Size(50, 25);
            this.出货单总金额标签.TabIndex = 8;
            this.出货单总金额标签.Text = "合计";
            this.出货单总金额标签.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 出货单合计标签
            // 
            this.出货单合计标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9.5F);
            this.出货单合计标签.Location = new System.Drawing.Point(350, 350);
            this.出货单合计标签.Name = "出货单合计标签";
            this.出货单合计标签.Size = new System.Drawing.Size(50, 25);
            this.出货单合计标签.TabIndex = 7;
            this.出货单合计标签.Text = "合计：";
            this.出货单合计标签.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 出货单现金标签
            // 
            this.出货单现金标签.Font = new System.Drawing.Font("Microsoft YaHei UI", 9.5F);
            this.出货单现金标签.Location = new System.Drawing.Point(200, 350);
            this.出货单现金标签.Name = "出货单现金标签";
            this.出货单现金标签.Size = new System.Drawing.Size(50, 25);
            this.出货单现金标签.TabIndex = 6;
            this.出货单现金标签.Text = "现金：";
            this.出货单现金标签.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 出货单面板
            // 
            this.出货单面板.Controls.Add(this.添加1);
            this.出货单面板.Controls.Add(this.出货单表格);
            this.出货单面板.Location = new System.Drawing.Point(20, 100);
            this.出货单面板.Name = "出货单面板";
            this.出货单面板.Size = new System.Drawing.Size(630, 230);
            this.出货单面板.TabIndex = 5;
            // 
            // 添加1
            // 
            this.添加1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.添加1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("添加1.BackgroundImage")));
            this.添加1.FlatAppearance.BorderSize = 0;
            this.添加1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.添加1.Location = new System.Drawing.Point(604, 204);
            this.添加1.Name = "添加1";
            this.添加1.Size = new System.Drawing.Size(25, 25);
            this.添加1.TabIndex = 1;
            this.添加1.UseVisualStyleBackColor = false;
            this.添加1.Click += new System.EventHandler(this.添加1_Click);
            // 
            // 出货单表格
            // 
            this.出货单表格.AllowUserToAddRows = false;
            this.出货单表格.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle13.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle13.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle13.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle13.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle13.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle13.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle13.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.出货单表格.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle13;
            this.出货单表格.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.出货单表格.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.商品名3,
            this.单位3,
            this.单价3,
            this.个数3,
            this.总金额3});
            dataGridViewCellStyle14.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle14.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle14.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle14.ForeColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle14.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle14.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle14.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.出货单表格.DefaultCellStyle = dataGridViewCellStyle14;
            this.出货单表格.Dock = System.Windows.Forms.DockStyle.Fill;
            this.出货单表格.EnableHeadersVisualStyles = false;
            this.出货单表格.Location = new System.Drawing.Point(0, 0);
            this.出货单表格.Name = "出货单表格";
            dataGridViewCellStyle15.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle15.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle15.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle15.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle15.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle15.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle15.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.出货单表格.RowHeadersDefaultCellStyle = dataGridViewCellStyle15;
            this.出货单表格.RowHeadersWidth = 40;
            dataGridViewCellStyle16.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            this.出货单表格.RowsDefaultCellStyle = dataGridViewCellStyle16;
            this.出货单表格.RowTemplate.Height = 23;
            this.出货单表格.Size = new System.Drawing.Size(630, 230);
            this.出货单表格.TabIndex = 0;
            this.出货单表格.CellEndEdit += new System.Windows.Forms.DataGridViewCellEventHandler(this.出货单表格_CellEndEdit);
            // 
            // 商品名3
            // 
            this.商品名3.FillWeight = 110.0746F;
            this.商品名3.HeaderText = "商品名";
            this.商品名3.Name = "商品名3";
            this.商品名3.ReadOnly = true;
            this.商品名3.Width = 118;
            // 
            // 单位3
            // 
            this.单位3.FillWeight = 103.0515F;
            this.单位3.HeaderText = "单位";
            this.单位3.Name = "单位3";
            this.单位3.ReadOnly = true;
            this.单位3.Width = 117;
            // 
            // 单价3
            // 
            this.单价3.FillWeight = 99.33611F;
            this.单价3.HeaderText = "单价";
            this.单价3.Name = "单价3";
            this.单价3.ReadOnly = true;
            this.单价3.Width = 118;
            // 
            // 个数3
            // 
            this.个数3.FillWeight = 94.74806F;
            this.个数3.HeaderText = "个数";
            this.个数3.Name = "个数3";
            this.个数3.Width = 117;
            // 
            // 总金额3
            // 
            this.总金额3.FillWeight = 92.78968F;
            this.总金额3.HeaderText = "总金额";
            this.总金额3.Name = "总金额3";
            this.总金额3.ReadOnly = true;
            this.总金额3.Width = 118;
            // 
            // 出货单时间戳
            // 
            this.出货单时间戳.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.出货单时间戳.Font = new System.Drawing.Font("宋体", 12F);
            this.出货单时间戳.Location = new System.Drawing.Point(520, 60);
            this.出货单时间戳.Name = "出货单时间戳";
            this.出货单时间戳.Size = new System.Drawing.Size(110, 20);
            this.出货单时间戳.TabIndex = 4;
            this.出货单时间戳.Text = "     ";
            this.出货单时间戳.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // 出货单时间
            // 
            this.出货单时间.Location = new System.Drawing.Point(170, 60);
            this.出货单时间.Name = "出货单时间";
            this.出货单时间.Size = new System.Drawing.Size(100, 23);
            this.出货单时间.TabIndex = 3;
            // 
            // 出货单购货商
            // 
            this.出货单购货商.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.出货单购货商.Location = new System.Drawing.Point(20, 60);
            this.出货单购货商.Name = "出货单购货商";
            this.出货单购货商.Size = new System.Drawing.Size(100, 23);
            this.出货单购货商.TabIndex = 2;
            this.出货单购货商.Text = "散户";
            // 
            // 欢迎
            // 
            this.欢迎.BackColor = System.Drawing.Color.White;
            this.欢迎.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("欢迎.BackgroundImage")));
            this.欢迎.Controls.Add(this.链接标签2);
            this.欢迎.Controls.Add(this.链接标签5);
            this.欢迎.Controls.Add(this.链接标签3);
            this.欢迎.Controls.Add(this.链接标签4);
            this.欢迎.Controls.Add(this.关闭欢迎);
            this.欢迎.Controls.Add(this.链接标签1);
            this.欢迎.Controls.Add(this.pictureBox2);
            this.欢迎.Controls.Add(this.pictureBox1);
            this.欢迎.Font = new System.Drawing.Font("黑体", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.欢迎.Location = new System.Drawing.Point(4, 26);
            this.欢迎.Name = "欢迎";
            this.欢迎.Padding = new System.Windows.Forms.Padding(3);
            this.欢迎.Size = new System.Drawing.Size(672, 388);
            this.欢迎.TabIndex = 0;
            this.欢迎.Text = "欢迎";
            // 
            // 链接标签2
            // 
            this.链接标签2.BackColor = System.Drawing.Color.Transparent;
            this.链接标签2.Font = new System.Drawing.Font("黑体", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.链接标签2.Location = new System.Drawing.Point(185, 85);
            this.链接标签2.Name = "链接标签2";
            this.链接标签2.Size = new System.Drawing.Size(140, 40);
            this.链接标签2.TabIndex = 7;
            this.链接标签2.TabStop = true;
            this.链接标签2.Text = "· 销量怎么样？";
            this.链接标签2.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.链接标签2.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.链接标签2_LinkClicked);
            // 
            // 链接标签5
            // 
            this.链接标签5.BackColor = System.Drawing.Color.Transparent;
            this.链接标签5.Font = new System.Drawing.Font("黑体", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.链接标签5.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.链接标签5.Location = new System.Drawing.Point(185, 260);
            this.链接标签5.Name = "链接标签5";
            this.链接标签5.Size = new System.Drawing.Size(200, 40);
            this.链接标签5.TabIndex = 6;
            this.链接标签5.TabStop = true;
            this.链接标签5.Text = "· 有人买东西！";
            this.链接标签5.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.链接标签5.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.链接标签5_LinkClicked);
            // 
            // 链接标签3
            // 
            this.链接标签3.BackColor = System.Drawing.Color.Transparent;
            this.链接标签3.Font = new System.Drawing.Font("黑体", 12F, System.Drawing.FontStyle.Italic);
            this.链接标签3.Location = new System.Drawing.Point(185, 140);
            this.链接标签3.Name = "链接标签3";
            this.链接标签3.Size = new System.Drawing.Size(200, 40);
            this.链接标签3.TabIndex = 5;
            this.链接标签3.TabStop = true;
            this.链接标签3.Text = "· 我该进些什么？";
            this.链接标签3.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.链接标签3.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.链接标签3_LinkClicked);
            // 
            // 链接标签4
            // 
            this.链接标签4.BackColor = System.Drawing.Color.Transparent;
            this.链接标签4.Font = new System.Drawing.Font("黑体", 12F, System.Drawing.FontStyle.Italic);
            this.链接标签4.Location = new System.Drawing.Point(185, 200);
            this.链接标签4.Name = "链接标签4";
            this.链接标签4.Size = new System.Drawing.Size(200, 40);
            this.链接标签4.TabIndex = 4;
            this.链接标签4.TabStop = true;
            this.链接标签4.Text = "· 我的货到啦！";
            this.链接标签4.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.链接标签4.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.链接标签4_LinkClicked);
            // 
            // 关闭欢迎
            // 
            this.关闭欢迎.AutoSize = true;
            this.关闭欢迎.BackColor = System.Drawing.Color.Transparent;
            this.关闭欢迎.Checked = true;
            this.关闭欢迎.CheckState = System.Windows.Forms.CheckState.Checked;
            this.关闭欢迎.Location = new System.Drawing.Point(498, 322);
            this.关闭欢迎.Name = "关闭欢迎";
            this.关闭欢迎.Size = new System.Drawing.Size(156, 16);
            this.关闭欢迎.TabIndex = 3;
            this.关闭欢迎.Text = "打开其他页面后关闭此页";
            this.关闭欢迎.UseVisualStyleBackColor = false;
            // 
            // 链接标签1
            // 
            this.链接标签1.BackColor = System.Drawing.Color.Transparent;
            this.链接标签1.Font = new System.Drawing.Font("黑体", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.链接标签1.Location = new System.Drawing.Point(185, 30);
            this.链接标签1.Name = "链接标签1";
            this.链接标签1.Size = new System.Drawing.Size(200, 40);
            this.链接标签1.TabIndex = 2;
            this.链接标签1.TabStop = true;
            this.链接标签1.Text = "· 我挣了多少钱？";
            this.链接标签1.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.链接标签1.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.链接标签1_LinkClicked);
            // 
            // pictureBox2
            // 
            this.pictureBox2.BackColor = System.Drawing.Color.Transparent;
            this.pictureBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox2.BackgroundImage")));
            this.pictureBox2.Location = new System.Drawing.Point(10, 197);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(120, 176);
            this.pictureBox2.TabIndex = 1;
            this.pictureBox2.TabStop = false;
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.Color.Transparent;
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(429, 15);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(228, 171);
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // 用户
            // 
            this.用户.Font = new System.Drawing.Font("Microsoft YaHei UI", 9F);
            this.用户.Location = new System.Drawing.Point(555, 2);
            this.用户.Name = "用户";
            this.用户.Size = new System.Drawing.Size(100, 23);
            this.用户.TabIndex = 8;
            // 
            // dataGridView1
            // 
            this.dataGridView1.BackgroundColor = System.Drawing.Color.White;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.Column2,
            this.Column3,
            this.Column4});
            this.dataGridView1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView1.Location = new System.Drawing.Point(0, 0);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowTemplate.Height = 23;
            this.dataGridView1.Size = new System.Drawing.Size(670, 386);
            this.dataGridView1.TabIndex = 0;
            // 
            // Column1
            // 
            this.Column1.HeaderText = "出货单号";
            this.Column1.Name = "Column1";
            this.Column1.Width = 157;
            // 
            // Column2
            // 
            this.Column2.HeaderText = "商品名";
            this.Column2.Name = "Column2";
            this.Column2.Width = 157;
            // 
            // Column3
            // 
            this.Column3.HeaderText = "数量";
            this.Column3.Name = "Column3";
            this.Column3.Width = 157;
            // 
            // Column4
            // 
            this.Column4.HeaderText = "收入";
            this.Column4.Name = "Column4";
            this.Column4.Width = 157;
            // 
            // dataGridView2
            // 
            this.dataGridView2.BackgroundColor = System.Drawing.Color.White;
            this.dataGridView2.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView2.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column5,
            this.Column6,
            this.Column7,
            this.Column8,
            this.Column9});
            this.dataGridView2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView2.Location = new System.Drawing.Point(0, 0);
            this.dataGridView2.Name = "dataGridView2";
            this.dataGridView2.RowTemplate.Height = 23;
            this.dataGridView2.Size = new System.Drawing.Size(670, 386);
            this.dataGridView2.TabIndex = 0;
            // 
            // Column5
            // 
            this.Column5.HeaderText = "出货单号";
            this.Column5.Name = "Column5";
            this.Column5.Width = 125;
            // 
            // Column6
            // 
            this.Column6.HeaderText = "商品名";
            this.Column6.Name = "Column6";
            this.Column6.Width = 125;
            // 
            // Column7
            // 
            this.Column7.HeaderText = "个数";
            this.Column7.Name = "Column7";
            this.Column7.Width = 125;
            // 
            // Column8
            // 
            this.Column8.HeaderText = "花销";
            this.Column8.Name = "Column8";
            this.Column8.Width = 125;
            // 
            // Column9
            // 
            this.Column9.HeaderText = "是否到货";
            this.Column9.Name = "Column9";
            this.Column9.Width = 125;
            // 
            // dataGridView3
            // 
            this.dataGridView3.BackgroundColor = System.Drawing.Color.White;
            this.dataGridView3.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView3.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column10,
            this.Column11,
            this.Column12,
            this.Column13,
            this.Column14});
            this.dataGridView3.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView3.Location = new System.Drawing.Point(0, 0);
            this.dataGridView3.Name = "dataGridView3";
            this.dataGridView3.RowTemplate.Height = 23;
            this.dataGridView3.Size = new System.Drawing.Size(672, 388);
            this.dataGridView3.TabIndex = 0;
            // 
            // Column10
            // 
            this.Column10.HeaderText = "单号";
            this.Column10.Name = "Column10";
            this.Column10.Width = 125;
            // 
            // Column11
            // 
            this.Column11.HeaderText = "交易对象";
            this.Column11.Name = "Column11";
            this.Column11.Width = 125;
            // 
            // Column12
            // 
            this.Column12.HeaderText = "支付现金";
            this.Column12.Name = "Column12";
            this.Column12.Width = 125;
            // 
            // Column13
            // 
            this.Column13.HeaderText = "找零";
            this.Column13.Name = "Column13";
            this.Column13.Width = 125;
            // 
            // Column14
            // 
            this.Column14.HeaderText = "总金额";
            this.Column14.Name = "Column14";
            this.Column14.Width = 125;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(760, 478);
            this.Controls.Add(this.用户);
            this.Controls.Add(this.页眉框);
            this.Controls.Add(this.进货面板);
            this.Controls.Add(this.出货面板);
            this.Controls.Add(this.资金面板);
            this.Controls.Add(this.进货总按钮);
            this.Controls.Add(this.出货总按钮);
            this.Controls.Add(this.资金总按钮);
            this.Controls.Add(this.菜单);
            this.HelpButton = true;
            this.MainMenuStrip = this.菜单;
            this.Name = "MainForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "超市进销存";
            this.Activated += new System.EventHandler(this.MainForm_Activated);
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.MainForm_FormClosing);
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.进货面板.ResumeLayout(false);
            this.出货面板.ResumeLayout(false);
            this.资金面板.ResumeLayout(false);
            this.菜单.ResumeLayout(false);
            this.菜单.PerformLayout();
            this.页眉框.ResumeLayout(false);
            this.出货管理.ResumeLayout(false);
            this.进货管理.ResumeLayout(false);
            this.资金.ResumeLayout(false);
            this.进货管理面板.ResumeLayout(false);
            this.进货.ResumeLayout(false);
            this.进货.PerformLayout();
            this.进货单面板.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.进货单表格)).EndInit();
            this.出货.ResumeLayout(false);
            this.出货.PerformLayout();
            this.出货单面板.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.出货单表格)).EndInit();
            this.欢迎.ResumeLayout(false);
            this.欢迎.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView3)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private Panel 进货面板;
        private Panel 出货面板;
        private Panel 资金面板;

        private Button 进货总按钮;
        private Button 出货总按钮;
        private Button 资金总按钮;

        private MenuStrip 菜单;
        private ToolStripMenuItem 退出;
        private ToolStripMenuItem 联系我们;

        private TabControl 页眉框;
        private TabPage 资金;
        private TabPage 出货;
        private TabPage 进货管理;

        private Button 进货子按钮;
        private Button 进货管理子按钮;
        private Button 出货子按钮;
        private Button 出货管理子按钮;
        private Button 查看资金子按钮;
        private Button 进货单保存按钮;
        private Button 进货单关闭按钮;

        private ComboBox 进货单供应商下拉列表框;
        private DateTimePicker 进货单时间;

        private Label 进货单时间戳;
        private Label 进货单现金标签;
        private Label 进货单合计标签;
        private Label 进货单总金额标签;
        private Label 进货单找零标签;
        private Label 进货单找零金额标签;
        private TextBox 进货单现金输入框;
        private TabPage 进货;
        private DataGridView 进货单表格;

        private Panel 进货单面板;
        private Button 添加;
        private Panel 出货单面板;
        private Label 出货单时间戳;
        private DateTimePicker 出货单时间;
        private DataGridView 出货单表格;
        private TextBox 出货单购货商;
        private Button 添加1;
        private Label 出货单现金标签;
        private TextBox 出货单现金输入框;
        private Label 出货单找零金额标签;
        private Label 出货单找零标签;
        private Label 出货单总金额标签;
        private Label 出货单合计标签;
        private DataGridViewTextBoxColumn 商品名1;
        private DataGridViewTextBoxColumn 单位1;
        private DataGridViewTextBoxColumn 单价1;
        private DataGridViewTextBoxColumn 个数1;
        private DataGridViewTextBoxColumn 总价1;
        private DataGridViewTextBoxColumn 商品名3;
        private DataGridViewTextBoxColumn 单位3;
        private DataGridViewTextBoxColumn 单价3;
        private DataGridViewTextBoxColumn 个数3;
        private DataGridViewTextBoxColumn 总金额3;
        private ToolStripMenuItem 新增;
        private ToolStripMenuItem 新增供货商;
        private ToolStripMenuItem 新增商品;
        private ToolStripMenuItem 修改;
        private ToolStripMenuItem 修改供货商;
        private ToolStripMenuItem 修改商品;
        private TabPage 欢迎;
        private Button 出货单保存按钮;
        private Button 出货单关闭按钮;
        private ToolStripMenuItem 修改密码;
        private Label 用户;
        private PictureBox pictureBox1;
        private PictureBox pictureBox2;
        private LinkLabel 链接标签1;
        private CheckBox 关闭欢迎;
        private LinkLabel 链接标签4;
        private LinkLabel 链接标签3;
        private LinkLabel 链接标签5;
        private LinkLabel 链接标签2;
        private TabPage 出货管理;
        private Panel 进货管理面板;
        private DataGridView dataGridView1;
        private DataGridViewTextBoxColumn Column1;
        private DataGridViewTextBoxColumn Column2;
        private DataGridViewTextBoxColumn Column3;
        private DataGridViewTextBoxColumn Column4;
        private DataGridView dataGridView2;
        private DataGridViewTextBoxColumn Column5;
        private DataGridViewTextBoxColumn Column6;
        private DataGridViewTextBoxColumn Column7;
        private DataGridViewTextBoxColumn Column8;
        private DataGridViewCheckBoxColumn Column9;
        private DataGridView dataGridView3;
        private DataGridViewTextBoxColumn Column10;
        private DataGridViewTextBoxColumn Column11;
        private DataGridViewTextBoxColumn Column12;
        private DataGridViewTextBoxColumn Column13;
        private DataGridViewTextBoxColumn Column14;
    }
}

