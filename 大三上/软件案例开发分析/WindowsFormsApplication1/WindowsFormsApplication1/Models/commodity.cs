using System;
using System.Collections.Generic;

namespace WindowsFormsApplication1.Models
{
    public partial class commodity
    {
        public commodity()
        {
            this.PurchasedMaterialLists = new List<PurchasedMaterialList>();
            this.SaledMaterialLists = new List<SaledMaterialList>();
        }

        public string CommodityName { get; set; }
        public string Price { get; set; }
        public string Unit { get; set; }
        public virtual ICollection<PurchasedMaterialList> PurchasedMaterialLists { get; set; }
        public virtual ICollection<SaledMaterialList> SaledMaterialLists { get; set; }
    }
}
