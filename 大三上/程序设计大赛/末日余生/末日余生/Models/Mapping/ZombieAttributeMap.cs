using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace 末日余生.Models.Mapping
{
    public class ZombieAttributeMap : EntityTypeConfiguration<ZombieAttribute>
    {
        public ZombieAttributeMap()
        {
            // Primary Key
            this.HasKey(t => t.ZombieLevel);

            // Properties
            this.Property(t => t.ZombieLevel)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.ForceValue)
                .IsRequired()
                .HasMaxLength(4);

            // Table & Column Mappings
            this.ToTable("ZombieAttribute");
            this.Property(t => t.ZombieLevel).HasColumnName("ZombieLevel");
            this.Property(t => t.ForceValue).HasColumnName("ForceValue");
        }
    }
}
