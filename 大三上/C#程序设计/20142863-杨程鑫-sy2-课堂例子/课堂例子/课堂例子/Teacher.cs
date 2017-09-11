using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 课堂例子
{
    class Teacher:Person
    {
        private string MyTID;
        private int MyTStartYear;
        private readonly int tAge;
        public Teacher(string name,string gender,int yearofbirth,string ID,int tstartyear)
        {
            this.MyName = name;
            this.MyGender = gender;
            this.MyYearOfBirth = yearofbirth;
            this.MyTID = ID;
            this.MyTStartYear = tstartyear;
            this.tAge = 2016 - tstartyear;
        }
        public void Print()
        {
            Console.Write("教师工号：" + MyTID);
            Console.WriteLine("教龄：" + tAge);
        }
    }
}
