using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace 末日余生.Models.Mapping
{
    public class RoleAttributeMap : EntityTypeConfiguration<RoleAttribute>
    {
        public RoleAttributeMap()
        {
            // Primary Key
            this.HasKey(t => t.Name);

            // Properties
            this.Property(t => t.Name)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.Age)
                .IsRequired()
                .HasMaxLength(3);

            this.Property(t => t.Weapon)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.WeaponValue)
                .IsRequired()
                .HasMaxLength(4);

            this.Property(t => t.ForceValue)
                .IsRequired()
                .HasMaxLength(4);

            this.Property(t => t.Experience)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.RoleLevel)
                .IsRequired()
                .HasMaxLength(2);

            // Table & Column Mappings
            this.ToTable("RoleAttribute");
            this.Property(t => t.Name).HasColumnName("Name");
            this.Property(t => t.Sex).HasColumnName("Sex");
            this.Property(t => t.Age).HasColumnName("Age");
            this.Property(t => t.Weapon).HasColumnName("Weapon");
            this.Property(t => t.WeaponValue).HasColumnName("WeaponValue");
            this.Property(t => t.ForceValue).HasColumnName("ForceValue");
            this.Property(t => t.Experience).HasColumnName("Experience");
            this.Property(t => t.RoleLevel).HasColumnName("RoleLevel");
        }
    }
}
