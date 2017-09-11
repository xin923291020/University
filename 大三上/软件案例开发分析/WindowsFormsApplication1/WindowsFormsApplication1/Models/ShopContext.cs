using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using WindowsFormsApplication1.Models.Mapping;

namespace WindowsFormsApplication1.Models
{
    public partial class ShopContext : DbContext
    {
        static ShopContext()
        {
            Database.SetInitializer<ShopContext>(null);
        }

        public ShopContext()
            : base("Name=ShopContext")
        {
        }

        public DbSet<bankroll> bankrolls { get; set; }
        public DbSet<commodity> commodities { get; set; }
        public DbSet<company> companies { get; set; }
        public DbSet<PurchasedMaterialList> PurchasedMaterialLists { get; set; }
        public DbSet<SaledMaterialList> SaledMaterialLists { get; set; }
        public DbSet<userLogin> userLogins { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new bankrollMap());
            modelBuilder.Configurations.Add(new commodityMap());
            modelBuilder.Configurations.Add(new companyMap());
            modelBuilder.Configurations.Add(new PurchasedMaterialListMap());
            modelBuilder.Configurations.Add(new SaledMaterialListMap());
            modelBuilder.Configurations.Add(new userLoginMap());
        }
    }
}
