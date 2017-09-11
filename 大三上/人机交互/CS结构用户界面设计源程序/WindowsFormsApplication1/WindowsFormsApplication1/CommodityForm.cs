﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using CCWin;

namespace WindowsFormsApplication1
{
    public partial class CommodityForm : CCSkinMain
    {
        public string[] SelectList = new string[10];
        public bool flag = false;
        public int ListLength = 0;
        public CommodityForm()
        {
            InitializeComponent();
        }
        private void button1_Click(object sender, EventArgs e)
        {
            this.flag = true;
            for (int i = 0; i < checkedListBox1.CheckedItems.Count; i++)
            {
                this.SelectList[i] = this.checkedListBox1.CheckedItems[i].ToString();
                this.ListLength++;
            }
            foreach (int i in this.checkedListBox1.CheckedIndices)
            {
                this.checkedListBox1.SetItemChecked(i, false);
            }
            this.Hide();
        }

        private void commodityForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Hide();
            foreach (int i in this.checkedListBox1.CheckedIndices)
            {
                this.checkedListBox1.SetItemChecked(i, false);
            }
            e.Cancel = true;
        }
    }
}
