using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using 末日余生.Models.Mapping;

namespace 末日余生.Models
{
    public partial class TheLastofUsContext : DbContext
    {
        static TheLastofUsContext()
        {
            Database.SetInitializer<TheLastofUsContext>(null);
        }

        public TheLastofUsContext()
            : base("Name=TheLastofUsContext")
        {
        }

        public DbSet<EventTable> EventTables { get; set; }
        public DbSet<Level1> Level1 { get; set; }
        public DbSet<Level1_0_0> Level1_0_0 { get; set; }
        public DbSet<Level1_0_1> Level1_0_1 { get; set; }
        public DbSet<Level1_0_2> Level1_0_2 { get; set; }
        public DbSet<Level1_0_3> Level1_0_3 { get; set; }
        public DbSet<Level1_1_0> Level1_1_0 { get; set; }
        public DbSet<Level1_1_1> Level1_1_1 { get; set; }
        public DbSet<Level1_1_2> Level1_1_2 { get; set; }
        public DbSet<Level1_1_3> Level1_1_3 { get; set; }
        public DbSet<Level1_2_0> Level1_2_0 { get; set; }
        public DbSet<Level1_2_1> Level1_2_1 { get; set; }
        public DbSet<Level1_2_2> Level1_2_2 { get; set; }
        public DbSet<Level1_2_3> Level1_2_3 { get; set; }
        public DbSet<Level1_3_0> Level1_3_0 { get; set; }
        public DbSet<Level1_3_1> Level1_3_1 { get; set; }
        public DbSet<Level1_3_2> Level1_3_2 { get; set; }
        public DbSet<Level1_3_3> Level1_3_3 { get; set; }
        public DbSet<RoleAction> RoleActions { get; set; }
        public DbSet<RoleAttack> RoleAttacks { get; set; }
        public DbSet<RoleAttribute> RoleAttributes { get; set; }
        public DbSet<RoleLevel> RoleLevels { get; set; }
        public DbSet<Rucksack> Rucksacks { get; set; }
        public DbSet<Skill> Skills { get; set; }
        public DbSet<ZombieAttribute> ZombieAttributes { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new EventTableMap());
            modelBuilder.Configurations.Add(new Level1Map());
            modelBuilder.Configurations.Add(new Level1_0_0Map());
            modelBuilder.Configurations.Add(new Level1_0_1Map());
            modelBuilder.Configurations.Add(new Level1_0_2Map());
            modelBuilder.Configurations.Add(new Level1_0_3Map());
            modelBuilder.Configurations.Add(new Level1_1_0Map());
            modelBuilder.Configurations.Add(new Level1_1_1Map());
            modelBuilder.Configurations.Add(new Level1_1_2Map());
            modelBuilder.Configurations.Add(new Level1_1_3Map());
            modelBuilder.Configurations.Add(new Level1_2_0Map());
            modelBuilder.Configurations.Add(new Level1_2_1Map());
            modelBuilder.Configurations.Add(new Level1_2_2Map());
            modelBuilder.Configurations.Add(new Level1_2_3Map());
            modelBuilder.Configurations.Add(new Level1_3_0Map());
            modelBuilder.Configurations.Add(new Level1_3_1Map());
            modelBuilder.Configurations.Add(new Level1_3_2Map());
            modelBuilder.Configurations.Add(new Level1_3_3Map());
            modelBuilder.Configurations.Add(new RoleActionMap());
            modelBuilder.Configurations.Add(new RoleAttackMap());
            modelBuilder.Configurations.Add(new RoleAttributeMap());
            modelBuilder.Configurations.Add(new RoleLevelMap());
            modelBuilder.Configurations.Add(new RucksackMap());
            modelBuilder.Configurations.Add(new SkillMap());
            modelBuilder.Configurations.Add(new ZombieAttributeMap());
        }
    }
}
