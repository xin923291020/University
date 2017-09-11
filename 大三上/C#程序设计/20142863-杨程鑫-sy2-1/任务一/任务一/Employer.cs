using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 任务一
{
    class Employer:People
    {
        private string workunit;
        public Employer(string name,int age,string workunit)
        {
            this.name = name;
            this.age = age;
            this.workunit = workunit;
        }
        public new void Work()
        {
            Console.WriteLine("我叫" + name + "，今年" + age + "岁，在" + workunit + "上班。");
        }
    }
}
