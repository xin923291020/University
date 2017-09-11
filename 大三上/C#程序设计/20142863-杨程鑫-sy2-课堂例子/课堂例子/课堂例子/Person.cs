using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 课堂例子
{
    class Person
    {
        protected string MyName;
        protected string MyGender;
        protected int MyYearOfBirth;
        protected readonly int Age;
        public Person()
        {
        }
        public Person(string name, string gender, int yearofbirth)
        {
            this.MyName = name;
            this.MyGender = gender;
            this.MyYearOfBirth = yearofbirth;
            this.Age = 2016 - yearofbirth;
        }
        public void Print()
        {
            Console.Write(MyName);
            if (MyGender == "男")
            {
                Console.Write("先生");
            }
            else
            {
                Console.Write("女士");
            }
            Console.WriteLine(Age + "岁了。");
        }
    }
}
