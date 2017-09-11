using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace 末日余生.Models.Mapping
{
    public class RucksackMap : EntityTypeConfiguration<Rucksack>
    {
        public RucksackMap()
        {
            // Primary Key
            this.HasKey(t => t.Name);

            // Properties
            this.Property(t => t.Name)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.Weapon)
                .IsRequired()
                .HasMaxLength(20);

            this.Property(t => t.PhysicalValue)
                .HasMaxLength(4);

            this.Property(t => t.MAXPhysicalValue)
                .HasMaxLength(4);

            this.Property(t => t.Time)
                .HasMaxLength(5);

            // Table & Column Mappings
            this.ToTable("Rucksack");
            this.Property(t => t.Name).HasColumnName("Name");
            this.Property(t => t.Weapon).HasColumnName("Weapon");
            this.Property(t => t.Bullets).HasColumnName("Bullets");
            this.Property(t => t.Sausage).HasColumnName("Sausage");
            this.Property(t => t.Tent).HasColumnName("Tent");
            this.Property(t => t.HavePistol).HasColumnName("HavePistol");
            this.Property(t => t.PhysicalValue).HasColumnName("PhysicalValue");
            this.Property(t => t.MAXPhysicalValue).HasColumnName("MAXPhysicalValue");
            this.Property(t => t.Time).HasColumnName("Time");
            this.Property(t => t.IsPoisoning).HasColumnName("IsPoisoning");
            this.Property(t => t.Antidote).HasColumnName("Antidote");
        }
    }
}
