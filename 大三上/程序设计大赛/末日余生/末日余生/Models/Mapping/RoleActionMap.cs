using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace 末日余生.Models.Mapping
{
    public class RoleActionMap : EntityTypeConfiguration<RoleAction>
    {
        public RoleActionMap()
        {
            // Primary Key
            this.HasKey(t => t.RoleAction1);

            // Properties
            this.Property(t => t.RoleAction1)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.ActionFeedBack)
                .IsRequired()
                .HasMaxLength(200);

            // Table & Column Mappings
            this.ToTable("RoleAction");
            this.Property(t => t.RoleAction1).HasColumnName("RoleAction");
            this.Property(t => t.ActionFeedBack).HasColumnName("ActionFeedBack");
        }
    }
}
