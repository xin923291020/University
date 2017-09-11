using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 任务二
{
    class Circle: Ishape, IDisplayresult
    {
        private double radius;
        public void initialize(double radius)
        {
            this.radius = radius;
        }
        public decimal getPerimeter(double radius)
        {
            return (decimal)(6.28 * radius);
        }
        public decimal getArea(double radius)
        {
            return (decimal)(3.14 * radius * radius);
        }
        public void displayResult()
        {
            Console.WriteLine("圆的周长为：" + getPerimeter(radius) + "面积为：" + getArea(radius));
        }
    }
}
