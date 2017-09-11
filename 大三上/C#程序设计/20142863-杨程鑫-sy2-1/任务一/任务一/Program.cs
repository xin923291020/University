using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 任务一
{
    class Program
    {
        static void Main(string[] args)
        {
            Student student = new Student("杨程鑫",21,"石家庄铁道大学");
            student.Work();
            Employer employer = new Employer("杨程鑫",21,"石家庄铁道大学");
            employer.Work();
        }
    }
}
