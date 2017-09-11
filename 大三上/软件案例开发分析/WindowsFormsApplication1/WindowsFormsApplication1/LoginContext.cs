using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using WindowsFormsApplication1.Models.Mapping;

namespace WindowsFormsApplication1.Models
{
    public partial class LoginContext : DbContext
    {
        static LoginContext()
        {
            Database.SetInitializer<LoginContext>(null);
        }

        public LoginContext()
            : base("Name=LoginContext")
        {
        }

        public DbSet<register> registers { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new registerMap());
        }
    }
}
