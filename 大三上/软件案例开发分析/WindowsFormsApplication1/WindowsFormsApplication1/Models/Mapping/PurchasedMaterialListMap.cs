using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace WindowsFormsApplication1.Models.Mapping
{
    public class PurchasedMaterialListMap : EntityTypeConfiguration<PurchasedMaterialList>
    {
        public PurchasedMaterialListMap()
        {
            // Primary Key
            this.HasKey(t => new { t.Time_Stamp, t.CommodityName });

            // Properties
            this.Property(t => t.Time_Stamp)
                .IsRequired()
                .HasMaxLength(15);

            this.Property(t => t.CommodityName)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.Number)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.Cost)
                .IsRequired()
                .IsFixedLength()
                .HasMaxLength(5);

            this.Property(t => t.Arrive)
                .IsRequired()
                .IsFixedLength()
                .HasMaxLength(1);

            // Table & Column Mappings
            this.ToTable("PurchasedMaterialList");
            this.Property(t => t.Time_Stamp).HasColumnName("Time_Stamp");
            this.Property(t => t.CommodityName).HasColumnName("CommodityName");
            this.Property(t => t.Number).HasColumnName("Number");
            this.Property(t => t.Cost).HasColumnName("Cost");
            this.Property(t => t.Arrive).HasColumnName("Arrive");

            // Relationships
            this.HasRequired(t => t.bankroll)
                .WithMany(t => t.PurchasedMaterialLists)
                .HasForeignKey(d => d.Time_Stamp);
            this.HasRequired(t => t.commodity)
                .WithMany(t => t.PurchasedMaterialLists)
                .HasForeignKey(d => d.CommodityName);

        }
    }
}
