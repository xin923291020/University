using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CountSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int oddNumberSum = 0;
            int evenNumberSum = 0;
            Console.WriteLine("请输入数组的长度。");
            int length = Int32.Parse(Console.ReadLine());
            int[] array = new int[length];
            Console.WriteLine("请依次输入数组。");
            for (int i = 0; i < length; i++)
            {
                array[i] = Int32.Parse(Console.ReadLine());
                if (array[i] % 2 == 1 || array[i] % 2 == -1)
                {
                    oddNumberSum += array[i];
                }
                if (array[i] % 2 == 0)
                {
                    evenNumberSum += array[i];
                }
            }
            Console.WriteLine("奇数和为：" + oddNumberSum + "；偶数和为：" + evenNumberSum);
        }
    }
}
