using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace WindowsFormsApplication1.Models.Mapping
{
    public class commodityMap : EntityTypeConfiguration<commodity>
    {
        public commodityMap()
        {
            // Primary Key
            this.HasKey(t => t.CommodityName);

            // Properties
            this.Property(t => t.CommodityName)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.Price)
                .IsRequired()
                .HasMaxLength(4);

            this.Property(t => t.Unit)
                .IsRequired()
                .IsFixedLength()
                .HasMaxLength(2);

            // Table & Column Mappings
            this.ToTable("commodity");
            this.Property(t => t.CommodityName).HasColumnName("CommodityName");
            this.Property(t => t.Price).HasColumnName("Price");
            this.Property(t => t.Unit).HasColumnName("Unit");
        }
    }
}
