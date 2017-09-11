using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace 末日余生.Models.Mapping
{
    public class Level1Map : EntityTypeConfiguration<Level1>
    {
        public Level1Map()
        {
            // Primary Key
            this.HasKey(t => new { t.X, t.Y });

            // Properties
            this.Property(t => t.X)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.Y)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.SceneDescribe)
                .IsRequired()
                .HasMaxLength(200);

            // Table & Column Mappings
            this.ToTable("Level1");
            this.Property(t => t.X).HasColumnName("X");
            this.Property(t => t.Y).HasColumnName("Y");
            this.Property(t => t.SceneDescribe).HasColumnName("SceneDescribe");
            this.Property(t => t.EventFlag).HasColumnName("EventFlag");
        }
    }
}
