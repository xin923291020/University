using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using 末日余生.Models;

namespace 末日余生
{
    class RoleAction
    {
        TheLastofUsContext TLU = new TheLastofUsContext();
        public bool getActionFeedBack(string Sentence,out string ActionFeedBack)
        {
            var whole = from u in TLU.RoleActions select u;
            foreach (var item in whole)
            {
                if (Sentence.Contains(item.RoleAction1))
                {
                    ActionFeedBack = item.ActionFeedBack.ToString();
                    return true;
                }
            }
            ActionFeedBack = "";
            return false;
        }
    }
}
