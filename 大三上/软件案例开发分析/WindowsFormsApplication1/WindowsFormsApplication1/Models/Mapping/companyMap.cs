using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace WindowsFormsApplication1.Models.Mapping
{
    public class companyMap : EntityTypeConfiguration<company>
    {
        public companyMap()
        {
            // Primary Key
            this.HasKey(t => t.CompanyName);

            // Properties
            this.Property(t => t.CompanyName)
                .IsRequired()
                .HasMaxLength(30);

            this.Property(t => t.Represent)
                .IsRequired()
                .HasMaxLength(5);

            this.Property(t => t.Address)
                .IsRequired()
                .HasMaxLength(30);

            this.Property(t => t.Phone)
                .IsRequired()
                .HasMaxLength(12);

            // Table & Column Mappings
            this.ToTable("company");
            this.Property(t => t.CompanyName).HasColumnName("CompanyName");
            this.Property(t => t.Represent).HasColumnName("Represent");
            this.Property(t => t.Address).HasColumnName("Address");
            this.Property(t => t.Phone).HasColumnName("Phone");
        }
    }
}
