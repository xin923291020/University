using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace JudgeSeason
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("请输入需要判断的月份,如果想判断一月，则输入1。");
            int number = Int32.Parse(Console.ReadLine());
            switch (number)
            {
                case 1: Console.WriteLine("一月在冬季。"); break;
                case 2: Console.WriteLine("二月在春季。"); break;
                case 3: Console.WriteLine("三月在春季。"); break;
                case 4: Console.WriteLine("四月在春季。"); break;
                case 5: Console.WriteLine("五月在夏季。"); break;
                case 6: Console.WriteLine("六月在夏季。"); break;
                case 7: Console.WriteLine("七月在夏季。"); break;
                case 8: Console.WriteLine("八月在秋季。"); break;
                case 9: Console.WriteLine("九月在秋季。"); break;
                case 10: Console.WriteLine("十月在秋季。"); break;
                case 11: Console.WriteLine("十一月在冬季。"); break;
                case 12: Console.WriteLine("十二月在冬季。"); break;
                default: Console.WriteLine(number + "不是月份。"); break;
            }
        }
    }
}
