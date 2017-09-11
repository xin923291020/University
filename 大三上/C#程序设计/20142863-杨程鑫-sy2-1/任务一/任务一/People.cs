using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 任务一
{
    abstract class People
    {
        protected string name;
        protected int age;
        public People()
        {
        }
        public People(string name, int age)
        {
            this.name = name;
            this.age = age;
        }
        public void Work()
        {
            Console.WriteLine("我叫" + name + "，今年" + age + "岁。");
        }
    }
}
