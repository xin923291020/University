using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 任务一
{
    class Student:People
    {
        private string school;
        public Student(string name,int age,string school)
        {
            this.name = name;
            this.age = age;
            this.school = school;
        }
        public new void Work()
        {
            Console.WriteLine("我叫" + name + "，今年" + age + "岁，在" + school + "就读。");
        }
    }
}
