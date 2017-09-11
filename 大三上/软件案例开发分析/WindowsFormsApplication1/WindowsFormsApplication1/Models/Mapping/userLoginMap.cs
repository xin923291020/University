using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace WindowsFormsApplication1.Models.Mapping
{
    public class userLoginMap : EntityTypeConfiguration<userLogin>
    {
        public userLoginMap()
        {
            // Primary Key
            this.HasKey(t => t.UserNumber);

            // Properties
            this.Property(t => t.UserNumber)
                .IsRequired()
                .HasMaxLength(3);

            this.Property(t => t.UserPassWord)
                .IsRequired()
                .HasMaxLength(15);

            this.Property(t => t.UserName)
                .IsRequired()
                .HasMaxLength(5);

            this.Property(t => t.Phone)
                .IsRequired()
                .IsFixedLength()
                .HasMaxLength(11);

            this.Property(t => t.Authortityx)
                .IsRequired()
                .IsFixedLength()
                .HasMaxLength(1);

            // Table & Column Mappings
            this.ToTable("userLogin");
            this.Property(t => t.UserNumber).HasColumnName("UserNumber");
            this.Property(t => t.UserPassWord).HasColumnName("UserPassWord");
            this.Property(t => t.UserName).HasColumnName("UserName");
            this.Property(t => t.Phone).HasColumnName("Phone");
            this.Property(t => t.Authortityx).HasColumnName("Authortityx");
        }
    }
}
