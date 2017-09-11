using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace 末日余生.Models.Mapping
{
    public class EventTableMap : EntityTypeConfiguration<EventTable>
    {
        public EventTableMap()
        {
            // Primary Key
            this.HasKey(t => new { t.Kind, t.ID });

            // Properties
            this.Property(t => t.Kind)
                .IsRequired()
                .HasMaxLength(50);

            this.Property(t => t.ID)
                .IsRequired()
                .HasMaxLength(50);

            this.Property(t => t.EventDescribe)
                .IsRequired()
                .HasMaxLength(200);

            // Table & Column Mappings
            this.ToTable("EventTable");
            this.Property(t => t.Kind).HasColumnName("Kind");
            this.Property(t => t.ID).HasColumnName("ID");
            this.Property(t => t.EventDescribe).HasColumnName("EventDescribe");
        }
    }
}
