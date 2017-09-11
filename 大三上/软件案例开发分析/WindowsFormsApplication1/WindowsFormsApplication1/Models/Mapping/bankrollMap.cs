using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace WindowsFormsApplication1.Models.Mapping
{
    public class bankrollMap : EntityTypeConfiguration<bankroll>
    {
        public bankrollMap()
        {
            // Primary Key
            this.HasKey(t => t.Time_Stamp);

            // Properties
            this.Property(t => t.Time_Stamp)
                .IsRequired()
                .HasMaxLength(15);

            this.Property(t => t.Supplier)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.AggregateAmount)
                .IsRequired()
                .HasMaxLength(4);

            this.Property(t => t.Pay)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.OddChange)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.INorEX)
                .IsRequired()
                .IsFixedLength()
                .HasMaxLength(1);

            // Table & Column Mappings
            this.ToTable("bankroll");
            this.Property(t => t.Time_Stamp).HasColumnName("Time_Stamp");
            this.Property(t => t.Supplier).HasColumnName("Supplier");
            this.Property(t => t.AggregateAmount).HasColumnName("AggregateAmount");
            this.Property(t => t.Pay).HasColumnName("Pay");
            this.Property(t => t.OddChange).HasColumnName("OddChange");
            this.Property(t => t.INorEX).HasColumnName("INorEX");
        }
    }
}
