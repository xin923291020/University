using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace 末日余生.Models.Mapping
{
    public class Level1_2_3Map : EntityTypeConfiguration<Level1_2_3>
    {
        public Level1_2_3Map()
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
                .HasMaxLength(10);

            this.Property(t => t.ActionFeedBack)
                .IsRequired()
                .HasMaxLength(300);

            // Table & Column Mappings
            this.ToTable("Level1_2_3");
            this.Property(t => t.Keys).HasColumnName("Keys");
            this.Property(t => t.KeyWordsA).HasColumnName("KeyWordsA");
            this.Property(t => t.KeyWordsB).HasColumnName("KeyWordsB");
            this.Property(t => t.ActionFeedBack).HasColumnName("ActionFeedBack");
        }
    }
}
