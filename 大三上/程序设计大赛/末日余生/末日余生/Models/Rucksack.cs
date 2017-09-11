using System;
using System.Collections.Generic;

namespace 末日余生.Models
{
    public partial class Rucksack
    {
        public string Name { get; set; }
        public string Weapon { get; set; }
        public int Bullets { get; set; }
        public int Sausage { get; set; }
        public int Tent { get; set; }
        public Nullable<int> HavePistol { get; set; }
        public string PhysicalValue { get; set; }
        public string MAXPhysicalValue { get; set; }
        public string Time { get; set; }
        public Nullable<int> IsPoisoning { get; set; }
        public Nullable<int> Antidote { get; set; }
    }
}
