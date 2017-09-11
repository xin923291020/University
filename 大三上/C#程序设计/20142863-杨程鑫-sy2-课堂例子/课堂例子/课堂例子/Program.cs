using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 课堂例子
{
    class Program
    {
        static void Main(string[] args)
        {
            Person person = new Person("杨程鑫","男",1995);
            person.Print();
            Teacher teacher = new Teacher("杨程鑫","男",1995,"20142863",2014);
            teacher.Print();
        }
    }
}
