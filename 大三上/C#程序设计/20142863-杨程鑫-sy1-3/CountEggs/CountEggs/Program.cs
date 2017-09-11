using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CountEggs
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 5;
            while (true)
            {
                if (i % 2 == 1 && i % 3 == 1 && i % 4 == 1)
                {
                    Console.WriteLine("鸡蛋至少有" + i + "个");
                    break;
                }
                i += 2;
            }
        }
    }
}
