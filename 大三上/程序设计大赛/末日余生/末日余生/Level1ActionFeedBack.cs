using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using 末日余生.Models;

namespace 末日余生
{
    class Level1ActionFeedBack
    {
        TheLastofUsContext TLU = new TheLastofUsContext();
        public bool getActionFeedBack(string Sentence,int X,int Y, out string ActionFeedBack)
        {
            if (X == 0 && Y == 0)
            {
                var whole = from u in TLU.Level1_0_0 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 0 && Y == 1)
            {
                var whole = from u in TLU.Level1_0_1 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 0 && Y == 2)
            {
                var whole = from u in TLU.Level1_0_2 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 0 && Y == 3)
            {
                var whole = from u in TLU.Level1_0_3 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 1 && Y == 0)
            {
                var whole = from u in TLU.Level1_1_0 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 1 && Y == 1)
            {
                var whole = from u in TLU.Level1_1_1 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 1 && Y == 2)
            {
                var whole = from u in TLU.Level1_1_2 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 1 && Y == 3)
            {
                var whole = from u in TLU.Level1_1_3 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 2 && Y == 0)
            {
                var whole = from u in TLU.Level1_2_0 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 2 && Y == 1)
            {
                var whole = from u in TLU.Level1_2_1 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 2 && Y == 2)
            {
                var whole = from u in TLU.Level1_2_2 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 2 && Y == 3)
            {
                var whole = from u in TLU.Level1_2_3 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 3 && Y == 0)
            {
                var whole = from u in TLU.Level1_3_0 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 3 && Y == 1)
            {
                var whole = from u in TLU.Level1_3_1 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 3 && Y == 2)
            {
                var whole = from u in TLU.Level1_3_2 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            else if (X == 3 && Y == 3)
            {
                var whole = from u in TLU.Level1_3_3 select u;
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsA) && Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
                foreach (var item in whole)
                {
                    if (Sentence.Contains(item.KeyWordsB))
                    {
                        ActionFeedBack = item.ActionFeedBack.ToString();
                        return true;
                    }
                }
            }
            ActionFeedBack = "";
            return false;
        }
    }
}
