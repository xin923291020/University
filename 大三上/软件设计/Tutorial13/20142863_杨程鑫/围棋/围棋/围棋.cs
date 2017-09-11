using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace 围棋
{
    public partial class 围棋 : Form
    {
        ChessFactory CF = ChessFactory.getChessFactory();
        Pen BlackPen = new Pen(Color.Black);

        private int AX = 15, AY = 15;
        private int BX = 555, BY = 15;
        private int thisPointX = 0,thisPointY = 0;

        private bool HandFlag = false;
        private int ChessCount = 0;
        public 围棋()
        {
            InitializeComponent();
        }

        private void 棋盘_Paint(object sender, PaintEventArgs e)
        {
            for (int i = 0; i < 19; i++)
            {
                e.Graphics.DrawLine(BlackPen,new Point(AX,AY),new Point(BX,BY));
                AY += 30;
                BY += 30;
            }
            AX = 15; AY = 15; BX = 15; BY = 555;
            for (int i = 0; i < 19; i++)
            {
                e.Graphics.DrawLine(BlackPen, new Point(AX, AY), new Point(BX, BY));
                AX += 30;
                BX += 30;
            }
        }

        private void 棋盘_MouseMove(object sender, MouseEventArgs e)
        {
            if (IsCrossoverPoint(e.X, e.Y))
            {
                this.棋盘.Cursor = System.Windows.Forms.Cursors.Hand;
                HandFlag = true;
            }
            else
            {
                this.棋盘.Cursor = System.Windows.Forms.Cursors.Default;
                HandFlag = false;
            }
        }
        private bool IsCrossoverPoint(int X,int Y)
        {
            int PointX = 15, PointY = 15;
            for (int i = 0; i < 19; i++)
            {
                for (int j = 0; j < 19; j++)
                {
                    if (Math.Abs(X - PointX) <= 8 && Math.Abs(Y - PointY) <= 8)
                    {
                        thisPointX = PointX;
                        thisPointY = PointY;
                        return true;
                    }
                    PointX += 30;
                }
                PointX = 15;
                PointY += 30;
            }
            return false;
        }

        private void 棋盘_MouseClick(object sender, MouseEventArgs e)
        {
            if (HandFlag)
            {
                PictureBox Chess = CF.GetChess(ChessCount);
                Chess.Location = new System.Drawing.Point(thisPointX - 15, thisPointY - 15); ;
                Chess.Parent = this.棋盘;
                ChessCount++;
            }
        }
    }
}
