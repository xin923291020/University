using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ComputeGirth
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = -1;
            while (number != 0)
            {
                Console.WriteLine("0：退出；1：三角形；2：长方形。");
                number = Int32.Parse(Console.ReadLine());
                if (number == 1)
                {
                    Console.WriteLine("请输入三角形三边变长");
                    double sideA = double.Parse(Console.ReadLine());
                    double sideB = double.Parse(Console.ReadLine());
                    double sideC = double.Parse(Console.ReadLine());
                    if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA)
                    {
                        double girth = sideA + sideB + sideC;
                        double p = (girth / 2);
                        double area = Math.Sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
                        Console.WriteLine("三角形周长为：" + girth + "；面积为：" + area);
                        Console.WriteLine("按任意键继续。");
                        Console.ReadKey();
                    }
                    else
                    {
                        Console.WriteLine("输入三边不能构成三角形。");
                        Console.WriteLine("按任意键继续。");
                        Console.ReadKey();
                    }
                }
                if (number == 2)
                {
                    Console.WriteLine("请输入长方形的长和宽。");
                    double length = Double.Parse(Console.ReadLine());
                    double width = Double.Parse(Console.ReadLine());
                    double girth = 2 * (length + width);
                    double area = length * width;
                    Console.WriteLine("长方形周长为：" + girth + "；面积为：" + area);
                    Console.WriteLine("按任意键继续。");
                    Console.ReadKey();
                }
                Console.Clear();
            }
        }
    }
}
