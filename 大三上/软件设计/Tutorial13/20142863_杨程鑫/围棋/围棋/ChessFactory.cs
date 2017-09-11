using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace 围棋
{
    class ChessFactory
    {
        private static ChessFactory chessFactory = null;
        public static ChessFactory getChessFactory()
        {
            if (chessFactory == null)
            {
                chessFactory = new ChessFactory();
                return chessFactory;
            }
            else
            {
                return chessFactory;
            }
        }
        public System.Windows.Forms.PictureBox GetChess(int ChessCount)
        {
            if (ChessCount % 2 == 0)
            {
                return new BlackChess();
            }
            return new WhiteChess();
        }
    }
}
