using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 任务二
{
    interface Ishape
    {
        void initialize(double side);
        decimal getPerimeter(double side);
        decimal getArea(double side);
    }
}
