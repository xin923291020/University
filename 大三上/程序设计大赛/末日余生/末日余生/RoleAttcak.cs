using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using 末日余生.Models;

namespace 末日余生
{
    class RoleAttcak
    {
        TheLastofUsContext TLU = new TheLastofUsContext();
        public bool getMark(string Sentence, out string Mark)
        {
            var whole = from u in TLU.RoleAttacks select u;
            foreach (var item in whole)
            {
                if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                {
                    Mark = item.Mark.ToString();
                    return true;
                }
            }
            foreach (var item in whole)
            {
                if (Sentence.Contains(item.KeyWordsB))
                {
                    Mark = item.Mark.ToString();
                    return true;
                }
            }
            Mark = "";
            return false;
        }
    }
}
