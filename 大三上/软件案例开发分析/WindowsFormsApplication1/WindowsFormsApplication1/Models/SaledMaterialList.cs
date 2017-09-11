using System;
using System.Collections.Generic;

namespace WindowsFormsApplication1.Models
{
    public partial class SaledMaterialList
    {
        public string Time_Stamp { get; set; }
        public string CommodityName { get; set; }
        public string Number { get; set; }
        public string Income { get; set; }
        public virtual bankroll bankroll { get; set; }
        public virtual commodity commodity { get; set; }
    }
}
