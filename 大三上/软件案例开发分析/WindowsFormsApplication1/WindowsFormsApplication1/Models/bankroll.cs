using System;
using System.Collections.Generic;

namespace WindowsFormsApplication1.Models
{
    public partial class bankroll
    {
        public bankroll()
        {
            this.PurchasedMaterialLists = new List<PurchasedMaterialList>();
            this.SaledMaterialLists = new List<SaledMaterialList>();
        }

        public string Time_Stamp { get; set; }
        public string Supplier { get; set; }
        public string AggregateAmount { get; set; }
        public string Pay { get; set; }
        public string OddChange { get; set; }
        public string INorEX { get; set; }
        public virtual ICollection<PurchasedMaterialList> PurchasedMaterialLists { get; set; }
        public virtual ICollection<SaledMaterialList> SaledMaterialLists { get; set; }
    }
}
