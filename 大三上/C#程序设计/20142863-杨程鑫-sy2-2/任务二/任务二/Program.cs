using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 任务二
{
    class Program
    {
        static void Main(string[] args)
        {
            Square square = new Square();
            square.initialize(2);
            square.displayResult();
            Circle circle = new Circle();
            circle.initialize(2);
            circle.displayResult();
        }
    }
}
