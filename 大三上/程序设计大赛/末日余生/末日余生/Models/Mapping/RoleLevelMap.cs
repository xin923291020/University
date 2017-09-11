using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace 末日余生.Models.Mapping
{
    public class RoleLevelMap : EntityTypeConfiguration<RoleLevel>
    {
        public RoleLevelMap()
        {
            // Primary Key
            this.HasKey(t => t.RoleLevel1);

            // Properties
            this.Property(t => t.RoleLevel1)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            // Table & Column Mappings
            this.ToTable("RoleLevel");
            this.Property(t => t.RoleLevel1).HasColumnName("RoleLevel");
            this.Property(t => t.LevelExperience).HasColumnName("LevelExperience");
            this.Property(t => t.LevelForceValue).HasColumnName("LevelForceValue");
            this.Property(t => t.MAXPhysicalValue).HasColumnName("MAXPhysicalValue");
        }
    }
}
