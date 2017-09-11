using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 任务二
{
    class Square : Ishape, IDisplayresult
    {
        private double side;
        public void initialize(double side)
        {
            this.side = side;
        }
        public decimal getPerimeter(double side)
        {
            return (decimal)(4 * side);
        }
        public decimal getArea(double side)
        {
            return (decimal)(side * side);
        }
        public void displayResult()
        {
            Console.WriteLine("正方形的周长为：" + getPerimeter(side) + "面积为：" + getArea(side));
        }
    }
}
