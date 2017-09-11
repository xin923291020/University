using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using CCWin;

namespace 末日余生
{
    public partial class Guide : CCSkinMain
    {
        private int Page = 1;
        public Guide()
        {
            InitializeComponent();
            InitializeMyComponent();
        }

        private void InitializeMyComponent()
        {
            if (Page == 1)
            {
                Prev.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/不能上一页.png");
            }
            else if(Page == 2)
            {
                Prev.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/上一页.png");
                Next.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/下一页.png");
            }
            else if(Page == 3)
            {
                Prev.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/上一页.png");
                Next.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/下一页.png");
            }
            else if (Page == 4)
            {
                现在开始.Visible = false;
                退出引导.Visible = true;
                Prev.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/上一页.png");
                Next.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/下一页.png");
            }
            else if (Page == 5)
            {
                现在开始.Visible = true;
                退出引导.Visible = false;
                Next.BackgroundImage = Image.FromFile("C:/Users/asus1/Desktop/C#程序/末日余生/images/不能下一页.png");
            }
        }

        private void 退出引导_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void GuidePanelOne_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics,GuidePanelOne.ClientRectangle,Color.White, 1, ButtonBorderStyle.Solid,
                Color.White, 1, ButtonBorderStyle.Solid, Color.DimGray, 1, ButtonBorderStyle.Solid, Color.DimGray, 1, ButtonBorderStyle.Solid);
        }

        private void GuidePanelTwo_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, GuidePanelTwo.ClientRectangle, Color.White, 1, ButtonBorderStyle.Solid,
                Color.White, 1, ButtonBorderStyle.Solid, Color.DimGray, 1, ButtonBorderStyle.Solid, Color.DimGray, 1, ButtonBorderStyle.Solid);
        }


        private void GuidePanelThree_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, GuidePanelThree.ClientRectangle, Color.White, 1, ButtonBorderStyle.Solid,
                Color.White, 1, ButtonBorderStyle.Solid, Color.DimGray, 1, ButtonBorderStyle.Solid, Color.DimGray, 1, ButtonBorderStyle.Solid);
        }

        private void GuidePanelFour_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, GuidePanelFour.ClientRectangle, Color.White, 1, ButtonBorderStyle.Solid,
                Color.White, 1, ButtonBorderStyle.Solid, Color.DimGray, 1, ButtonBorderStyle.Solid, Color.DimGray, 1, ButtonBorderStyle.Solid);
        }

        private void GuidePanelFive_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, GuidePanelFive.ClientRectangle, Color.White, 1, ButtonBorderStyle.Solid,
                Color.White, 1, ButtonBorderStyle.Solid, Color.DimGray, 1, ButtonBorderStyle.Solid, Color.DimGray, 1, ButtonBorderStyle.Solid);
        }
        private void Prev_Click(object sender, EventArgs e)
        {
            if (Page > 1)
            {
                PrevTimer.Start();
            }
        }

        private void Next_Click(object sender, EventArgs e)
        {
            if (Page < 6)
            {
                NextTimer.Start();
            }
        }

        private void NextTimer_Tick(object sender, EventArgs e)
        {
            if (Page == 1)
            {
                if (GuidePanelOne.Right > 0)
                {
                    GuidePanelOne.Left -= 23;
                    GuidePanelTwo.Left -= 23;
                }
                else
                {
                    NextTimer.Stop();
                    Page++;
                    InitializeMyComponent();
                }
            }
            else if (Page == 2)
            {
                if (GuidePanelTwo.Right > 0)
                {
                    GuidePanelTwo.Left -= 23;
                    GuidePanelThree.Left -= 23;
                }
                else
                {
                    NextTimer.Stop();
                    Page++;
                    InitializeMyComponent();
                }
            }
            else if (Page == 3)
            {
                if (GuidePanelThree.Right > 0)
                {
                    GuidePanelThree.Left -= 23;
                    GuidePanelFour.Left -= 23;
                }
                else
                {
                    NextTimer.Stop();
                    Page++;
                    InitializeMyComponent();
                }
            }
            else if (Page == 4)
            {
                if (GuidePanelFour.Right > 0)
                {
                    GuidePanelFour.Left -= 23;
                    GuidePanelFive.Left -= 23;
                }
                else
                {
                    NextTimer.Stop();
                    Page++;
                    InitializeMyComponent();
                }
            }
            else
            {
                NextTimer.Stop();
            }
        }

        private void PrevTimer_Tick(object sender, EventArgs e)
        {
            if (Page == 2)
            {
                if (GuidePanelTwo.Left < Width)
                {
                    GuidePanelOne.Left += 23;
                    GuidePanelTwo.Left += 23;
                }
                else
                {
                    PrevTimer.Stop();
                    Page--;
                    InitializeMyComponent();
                }
            }
            else if (Page == 3)
            {
                if (GuidePanelThree.Left < Width)
                {
                    GuidePanelTwo.Left += 23;
                    GuidePanelThree.Left += 23;
                }
                else
                {
                    PrevTimer.Stop();
                    Page--;
                    InitializeMyComponent();
                }
            }
            else if (Page == 4)
            {
                if (GuidePanelFour.Left < Width)
                {
                    GuidePanelThree.Left += 23;
                    GuidePanelFour.Left += 23;
                }
                else
                {
                    PrevTimer.Stop();
                    Page--;
                    InitializeMyComponent();
                }
            }
            else if (Page == 5)
            {
                if (GuidePanelFive.Left < Width)
                {
                    GuidePanelFour.Left += 23;
                    GuidePanelFive.Left += 23;
                }
                else
                {
                    PrevTimer.Stop();
                    Page--;
                    InitializeMyComponent();
                }
            }
        }

        private void 现在开始_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void 绿格子_Click(object sender, EventArgs e)
        {

        }
    }
}
