using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace 末日余生.Models.Mapping
{
    public class RoleAttackMap : EntityTypeConfiguration<RoleAttack>
    {
        public RoleAttackMap()
        {
            // Primary Key
            this.HasKey(t => t.Keys);

            // Properties
            this.Property(t => t.Keys)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.KeyWordsA)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.KeyWordsB)
                .IsRequired()
                .HasMaxLength(10);

            this.Property(t => t.Mark)
                .IsRequired()
                .HasMaxLength(10);

            // Table & Column Mappings
            this.ToTable("RoleAttack");
            this.Property(t => t.Keys).HasColumnName("Keys");
            this.Property(t => t.KeyWordsA).HasColumnName("KeyWordsA");
            this.Property(t => t.KeyWordsB).HasColumnName("KeyWordsB");
            this.Property(t => t.Mark).HasColumnName("Mark");
        }
    }
}
