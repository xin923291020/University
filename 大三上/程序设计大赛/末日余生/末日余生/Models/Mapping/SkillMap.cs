using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace 末日余生.Models.Mapping
{
    public class SkillMap : EntityTypeConfiguration<Skill>
    {
        public SkillMap()
        {
            // Primary Key
            this.HasKey(t => t.Name);

            // Properties
            this.Property(t => t.Name)
                .IsRequired()
                .HasMaxLength(10);

            // Table & Column Mappings
            this.ToTable("Skill");
            this.Property(t => t.Name).HasColumnName("Name");
            this.Property(t => t.TheTerminatorOfZombie).HasColumnName("TheTerminatorOfZombie");
            this.Property(t => t.Resistance).HasColumnName("Resistance");
        }
    }
}
