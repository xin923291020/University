using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SeekSaddlePoint
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("请输入二维数组的行数和列数，空格隔开。");
            string[] stringnums = Console.ReadLine().Split(new String[]{" "},StringSplitOptions.None);
            int[] nums = new int[stringnums.Length];
            for (int i = 0; i < stringnums.Length; i++)
            {
                nums[i] = Int32.Parse(stringnums[i]);
            }
            int[,] array = new int[nums[0],nums[1]];
            Console.WriteLine("请输入二维数组中每行的数，空格隔开，回车换行。");
            for (int i = 0; i < nums[0]; i++)
            {
                stringnums = Console.ReadLine().Split(new String[] { " " }, StringSplitOptions.None);
                for (int j = 0; j < stringnums.Length; j++)
                {
                    array[i,j] = Int32.Parse(stringnums[j]);
                }
            }
            Console.WriteLine();
            Console.WriteLine("----------------------");
            for (int i = 0; i < nums[0]; i++)
            {
                for (int j = 0; j < nums[1]; j++)
                {
                    if(IsRowMAX((array[i,j]),GetRow(array,i)) && IsColMIN(array[i,j],GetCol(array,j)))
                    {
                        Console.WriteLine((i + 1) + "行" + (j + 1) + "列  " + array[i,j] + "是鞍点。");
                    }
                }
            }
        }
        public static int[] GetRow(int[,] array, int row)
        {
            int[] nums = new int[array.GetLength(1)];
            for (int i = 0; i < nums.Length; i++)
            {
                nums[i] = array[row,i];
            }
            return nums;
        }
        public static int[] GetCol(int[,] array, int col)
        {
            int[] nums = new int[array.GetLength(0)];
            for (int i = 0; i < nums.Length; i++)
            {
                nums[i] = array[i,col];
            }
            return nums;
        }
        public static bool IsRowMAX(int number, int[] array)
        {
            int MAX = array[0];
            for (int i = 1; i < array.Length; i++)
            {
                if (MAX < array[i])
                {
                    MAX = array[i];
                }
            }
            if (number == MAX)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public static bool IsColMIN(int number, int[] array)
        {
            int MIN = array[0];
            for (int i = 1; i < array.Length; i++)
            {
                if (MIN > array[i])
                {
                    MIN = array[i];
                }
            }
            if (number == MIN)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
