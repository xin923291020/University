﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 围棋
{
    class WhiteChess : System.Windows.Forms.PictureBox
    {
        public WhiteChess()
        {
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.Size = new System.Drawing.Size(30,30);
            this.BackgroundImage = System.Drawing.Image.FromFile("C:/Users/asus1/Desktop/C#程序/围棋/围棋/WhiteChess.png");
        }
    }
}
