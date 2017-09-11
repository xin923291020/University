package software;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MainInterface extends JFrame
{
	private JFrame frame; 
	private String SQLstr = "select * from student"; //初始化查询语句  
	
	private JPanel contentPane;    //容器面板。
	private JTabbedPane tabbedPane;    //标签面板，放置子面板。
	private JPanel criteriaQueriesPanel;    //条件查询面板。
	private JPanel gradePanel;

	private JLabel criteriaQueriesLabel;    //条件查询标签。
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JTextField textField;    //面板中的一个输入框。
	private JButton selectButton_1;
	
	private JLabel allDataLabel_1;    //查询结果显示标签。
	private StudentModel sm = null;
	private JTable criteriaQueriesTable = null;    //用于放置表格Model的表格。
	private JScrollPane criteriaQueriesJSPane;	   //用于放置表格的滚动面板。
	private JPanel resultPanel;    //查询结果显示面板。
	
	private JButton addButton;
	private JButton upadateButton;
	private JButton deleteButton;
	private JButton importButton;
	
	private JButton increaseWork;
	private JButton deleteWork;
	private JButton selectButton_2;
	
	private JLabel allDataLabel_2;
	private DefaultTableModel defaultModel = null;
	private JTable table = null;
	private JScrollPane scrollPane;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainInterface()
	{
		this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent paramAnonymousWindowEvent)
            {
            	Browser.release();
            }
        });
		ImageIcon img = new ImageIcon("F:\\eclipse\\Java eclipse\\software\\src\\software\\icon1.png");
		setIconImage(img.getImage());
		setBounds(100,100,910,605);    //设置窗口的大小和位置。
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置窗口关闭按钮。
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);    //设置容器为绝对布局。
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);    //设置标签面板，用于切换面板。
		tabbedPane.setBounds(10,10,874,545);    //设置标签的大小和位置。
		contentPane.add(tabbedPane);    //将标签放到Frame下的容器中。
		
		criteriaQueriesPanel = new JPanel();    //初始化criteriaQueriesPanel面板。
		tabbedPane.addTab("学生信息",null,criteriaQueriesPanel,null);    //将criteriaQueriesPanel面板放入tabbedPane中。
		criteriaQueriesPanel.setLayout(null);    //为criteriaQueriesPanel设置绝对布局。
		gradePanel = new JPanel();
		tabbedPane.addTab("学生成绩", null, gradePanel, null);
		gradePanel.setLayout(null);
		
		criteriaQueriesLabel = new JLabel("按条件查询");    //初始化criteriaQueriesLabel标签。
		criteriaQueriesLabel.setBounds(10,10,100,35);    //设置criteriaQueriesLabel标签的大小和位置。
		criteriaQueriesPanel.add(criteriaQueriesLabel);    //将criteriaQueriesLabel标签放到criteriaQueriesPanel面板中。
		comboBox = new JComboBox();    //初始化comboBox复选框。
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"全部学生","学号","班级","姓名"}));    //为复选框添加选项。
		comboBox.setBounds(115,50,140,35);    //设置复选框的大小和位置。
		criteriaQueriesPanel.add(comboBox);    //将comboBox放到criteriaQueriesPanel面板中。	
		textField = new JTextField();    //初始化textField输入框。
		textField.setBounds(320,50,210,35);    //设置输入框的大小和位置。
		textField.setColumns(10);    //设置textField文本字段的列数。
		criteriaQueriesPanel.add(textField);    //将textField放到criteriaQueriesPanel面板中。
		selectButton_1 = new JButton("查询结果");    //初始化button按钮。
		selectButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));    //为button设置鼠标手型。
		selectButton_1.setBounds(600,50,150,30);    //设置按钮的大小和位置。
		criteriaQueriesPanel.add(selectButton_1);    //将button按钮放到criteriaQueriesPanel面板中。
		
		allDataLabel_1 = new JLabel("查询结果显示");    //初始化allDataLabel标签。
		allDataLabel_1.setBounds(10,90,130,45);    //设置allDataLabel标签的大小和位置。
		criteriaQueriesPanel.add(allDataLabel_1);    //将allDataLabel放到criteriaQueriesPanel面板中。
		resultPanel = new JPanel();    //初始化resultPanel面板。
		resultPanel.setBounds(10,150,850,315);    //设置resultPanel的大小和位置。
		resultPanel.setLayout(null);    //设置resultPanel为绝对布局。
		criteriaQueriesPanel.add(resultPanel);    //将resultPanel放到criteriaQueriesPanel中。
		
		addButton = new JButton("新增");
		addButton.setBounds(31, 481, 90, 25);
		criteriaQueriesPanel.add(addButton);				
		upadateButton = new JButton("修改");
		upadateButton.setBounds(149, 481, 90, 25);
		criteriaQueriesPanel.add(upadateButton);
		importButton = new JButton("导入");
		importButton.setBounds(406, 481, 90, 25);
		criteriaQueriesPanel.add(importButton);
		deleteButton = new JButton("删除");
		deleteButton.setBounds(275, 481, 90, 25);
		criteriaQueriesPanel.add(deleteButton);
		
		increaseWork = new JButton("新建作业");
		increaseWork.setBounds(131, 10, 127, 30);
		gradePanel.add(increaseWork);
		deleteWork = new JButton("删除作业");
		deleteWork.setBounds(368, 10, 127, 30);
		gradePanel.add(deleteWork);
		selectButton_2 = new JButton("查询");
		selectButton_2.setBounds(590, 10, 133, 30);
		gradePanel.add(selectButton_2);
		
		allDataLabel_2 = new JLabel("查询结果显示");
		allDataLabel_2.setFont(new Font("楷体", Font.PLAIN, 14));
		allDataLabel_2.setBounds(10, 62, 105, 30);
		gradePanel.add(allDataLabel_2);
		
		GradeDatabaseConnection con = new GradeDatabaseConnection();
		/*
		 * 面板一监听事件。
		 */
		textField.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(!(textField.getText().equals("")))
				{
					getTable();
				}
			}
		});
		selectButton_1.addMouseListener(new MouseAdapter()    //为button设置鼠标监听事件。
		{
			public void mouseClicked(MouseEvent e)    //其中的鼠标单击事件。
			{
				getTable();
			}
		});
		addButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				while(true)
				{
					new AddStudent(frame,"添加新学生",true);
					int i = JOptionPane.showConfirmDialog(frame,"是否继续添加学生?","",JOptionPane.YES_NO_OPTION); 
					if(i == JOptionPane.NO_OPTION)
					{
						break;
					}	
				}
			}
		});
		upadateButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(criteriaQueriesTable.getSelectedRow() == -1 || criteriaQueriesTable == null)
				{
					JOptionPane.showMessageDialog(frame, "请先选择一行数据");
					return;
				}
				else
				{
					int id = criteriaQueriesTable.getSelectedRow();
					Object num = criteriaQueriesTable.getValueAt(id,0);
					sm = new StudentModel();
					String sql = "select * from student Where Sno = " + num;
					sm.queryStudent(sql,null);
					new UpdateStudent(frame,"修改学生信息",true,sm);
				}
			}
		});
		deleteButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(criteriaQueriesTable.getSelectedRow() == -1 || criteriaQueriesTable == null)
				{
					JOptionPane.showMessageDialog(frame, "请先选择一行数据");
					return;
				}
				else
				{
					int selectID = criteriaQueriesTable.getSelectedRow();
					String stuID[] = {criteriaQueriesTable.getValueAt(selectID,0).toString()};
					String sql = "delete from student where Sno = ?";
					String sql1 = "delete from studentgrade where Sno = '" + criteriaQueriesTable.getValueAt(selectID,0).toString() + "'";
					GradeDatabaseConnection sh1 = new GradeDatabaseConnection();
					sh1.executeUpdate(sql1);
					sm = new StudentModel();
					sm.deleteStudent(sql, stuID);
					criteriaQueriesTable.removeRowSelectionInterval(selectID, selectID);
					//更新数据模型
				}
			}
		});
		importButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				JFileChooser fd = new JFileChooser();
				fd.showOpenDialog(null);
				String filepath = fd.getSelectedFile().getAbsolutePath();
				try
				{
					ImportExcel.insertDB(filepath);
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		/*
		 * 面板二监听事件。
		 */
		increaseWork.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource() == increaseWork)
				{
					String gradeMember = JOptionPane.showInputDialog(null,"请输入");
					if(gradeMember == null || gradeMember.trim().equals(""))
					{	
					}
					if(defaultModel == null)
					{
						String alterSQL = "alter table studentgrade add " + gradeMember + " nchar(10)";
					    String insertSQL = "insert into grademembers values('" + gradeMember + "')";
					    con.executeUpdate(alterSQL);
					    con.executeUpdate(insertSQL);
					}
					else
					{
					    defaultModel.addColumn(gradeMember);
					    String alterSQL = "alter table studentgrade add " + gradeMember + " nchar(10)";
					    String insertSQL = "insert into grademembers values('" + gradeMember + "')";
					    con.executeUpdate(alterSQL);
					    con.executeUpdate(insertSQL);
					}
				}
			}
		});
		deleteWork.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource() == deleteWork)	
				{
					Delete de = new Delete();
					de.setVisible(true);
				}
			}
		});
		selectButton_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource() == selectButton_2)
				{
					if(table != null)
					{
						scrollPane.removeAll();
					}
					String sql = "select * from studentgrade";
					ResultSet rs = con.executeQuery(sql);
					Vector<String> head = new Vector<String>();
					Vector<Vector<String>> body = new Vector<Vector<String>>();
					try
					{
						ResultSetMetaData metaData = rs.getMetaData();
						for(int i = 1;i <= metaData.getColumnCount();i++)
						{
							head.add(metaData.getColumnName(i));
						}
						while(rs.next())
						{
							Vector<String> line = new Vector<String>();
							for(int i = 1;i <= metaData.getColumnCount();i++)
							{
							    line.add(rs.getString(i));
							    //System.out.println(rs.getString(i));
							}
						    body.add(line);
						}
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
					defaultModel = new DefaultTableModel(body,head);
					table = new JTable(defaultModel);
					table.setBounds(20, 102, 823, 391);
					table.setCellSelectionEnabled(true);
					scrollPane = new JScrollPane();
					scrollPane.setBounds(20, 102, 823, 391);
					scrollPane.setViewportView(table);
					gradePanel.add(scrollPane);
				}
			}
		});
	}
	private void getTable()
	{
		if(comboBox.getSelectedItem().equals("全部学生"))
		{
			SQLstr = "select * from student";
		}
		else
		{
		if(!(Match.isLegal(textField.getText())))    //检查用户输入是否为正确的学号，姓名，班级。
		{
			JOptionPane.showMessageDialog(null,"输入非法，请按格式输入学号，班级，姓名（如：20142863，信1405-1班，杨程鑫）。");
			return;
		}
		SQLstr += " Where ";    //根据用户所选所填构造数据库语句，下略。
		//检查用户在comboBox所选和在textField填写的内容是否匹配。
		if(comboBox.getSelectedItem().equals("学号") && (Match.isSno(textField.getText())))
		{
			SQLstr += "Sno ";
		}
		else if(comboBox.getSelectedItem().equals("班级") && (Match.isClass(textField.getText())))
		{
			SQLstr += "Class ";
		}
		else if(comboBox.getSelectedItem().equals("姓名") && (Match.isName(textField.getText())))
		{
			SQLstr += "Name ";
		}
		else    //若不匹配，初始化SQL语句，监测事件结束。
		{
			JOptionPane.showMessageDialog(null,"所选与输入不匹配，请检查");
			SQLstr = "select * from student";
			return;
		}
		SQLstr += "= '" + textField.getText() + "'";
		}
		//TModel = new Display(SQLstr);    //根据SQL语句创建AbstractTableModel。
		if(sm !=  null)
		{
			resultPanel.removeAll();
		}
		sm = new StudentModel();
		sm.queryStudent(SQLstr,null);
		criteriaQueriesTable = new JTable(sm);    //根据TModel初始化JTable。
		refushJtable renderer = new refushJtable();
		criteriaQueriesTable.setDefaultRenderer(Object.class, renderer);
		criteriaQueriesTable.addMouseListener(renderer);
		criteriaQueriesTable.addMouseMotionListener(renderer);
        
		sm.TableColumn = criteriaQueriesTable.getColumnModel().getColumn(3);    //标记TableColumn为JTable中的第三列。
		sm.TableColumn.setPreferredWidth(250);    //设置列宽。
		criteriaQueriesTable.setSelectionBackground(Color.WHITE);    //设置criteriaQueriesTable的选取背景为白色。
		criteriaQueriesTable.setColumnSelectionAllowed(false);    //设置criteriaQueriesTable不可整列选取。
		criteriaQueriesTable.setRowSelectionAllowed(false);    //设置criteriaQueriesTable不可整行选取。
		criteriaQueriesTable.getTableHeader().setReorderingAllowed(false);    //设置criteriaQueriesTable不可整列移动 。
		int cell = criteriaQueriesTable.getModel().getColumnCount();    //cell储存 criteriaQueriesTable的列数。
		
		criteriaQueriesTable.addMouseListener(new MouseAdapter()    //为criteriaQueriesTable添加鼠标监听事件。
		{
			public void mouseClicked(MouseEvent e2)    //鼠标单击事件。
			{
				int row = ((JTable)e2.getSource()).rowAtPoint(e2.getPoint());    //row储存单击单元格所在的列数。
				int col = ((JTable)e2.getSource()).columnAtPoint(e2.getPoint());    //col储存单击单元格所在的行数。
				if(col + 1 == cell)    //满足等式，则表示用户单击了博客地址所在列。
				{
					Object test = criteriaQueriesTable.getValueAt(row,col);    //得到用户单击单元格的内容。
					
						String url = test.toString();
						String str = (String) criteriaQueriesTable.getValueAt(row,col-1);
						Browser.init(url,str);
				}
			}
		});
		criteriaQueriesJSPane = new JScrollPane(criteriaQueriesTable);    //将criteriaQueriesTable放入criteriaQueriesJSPane带有滚动条容器中。
		criteriaQueriesJSPane.setBounds(50, 10, 750, 300);    //设置criteriaQueriesJSPane滚动条容器大小和位置。
		criteriaQueriesJSPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);   //使滚动条在criteriaQueriesJSPane中出现。
		criteriaQueriesJSPane.setEnabled(true);    //设置criteriaQueriesJSPane不可对输入做出相应。
		criteriaQueriesJSPane.setViewportBorder(null);    //设置视觉边界为空。
		resultPanel.add(criteriaQueriesJSPane);    //将criteriaQueriesJSPane放到resultPanel中。
		SQLstr = "select * from student";    //执行完毕后，初始化SQL语句。
	}
	class refushJtable extends DefaultTableCellRenderer implements MouseInputListener
	{	  
		private static final long serialVersionUID = 1L;
	    private int row = -1;    //鼠标事件所在的行
	    private int col = -1;    //鼠标事件所在的列
	    @Override
	    public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column)
	    {
	    	criteriaQueriesTable = table;
	        super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
	        this.setForeground(Color.BLACK);    //设置表格中主题为黑色。
	        table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));    //去除表格光标。
	        this.setText(value.toString());
	       
	        if(row == this.row && column == this.col)    //如果当前需要渲染器的单元格就是鼠标事件所在的单元格
	        {
	            
	            if (column == 3)    //如果是第四列(第四列是显示超链接的列)
	            {
	                this.setForeground(Color.blue);    //改变前景色(文字颜色)
	                table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));    //改变鼠标形状
	                this.setText("<html><u>" + value.toString() + "</u></html>");//显示超链接样式
	            }
	            setBackground(table.getSelectionBackground());
	        }
	        else if(isSelected)
	        {
	            setForeground(table.getSelectionForeground());    //如果单元格被选中,则改变前景色和背景色
	            setBackground(table.getSelectionBackground());
	        }
	        else
	        {
	            setBackground(Color.white);//其他情况下恢复默认背景色
	        }
	        return this;
	    } 
	    public void mouseExited(MouseEvent e)
	    {
	        if(criteriaQueriesTable != null)
	        {
	            int oldRow = row;
	            int oldCol = col;
	            row = -1;    //鼠标移出目标表格后,恢复行列数据到默认值
	            col = -1;
	            
	            if(oldRow != -1 && oldCol != -1)    //当之前的行列数据有效时重画相关区域
	            {
	                Rectangle rect = criteriaQueriesTable.getCellRect(oldRow, oldCol, false);
	                criteriaQueriesTable.repaint(rect);
	            }
	        }
	    }
	    public void mouseMoved(MouseEvent e)
	    {
	        if (criteriaQueriesTable != null)
	        {
	            Point p = e.getPoint();
	            int oldRow = row;
	            int oldCol = col;
	            row = criteriaQueriesTable.rowAtPoint(p);
	            col = criteriaQueriesTable.columnAtPoint(p);
	            if (oldRow != -1 && oldCol != -1)    //重画原来的区域
	            {
	                Rectangle rect = criteriaQueriesTable.getCellRect(oldRow,oldCol,false);
	                criteriaQueriesTable.repaint(rect);
	            }
	            if (row != -1 && col != -1)    //重画新的区域
	            {
	                Rectangle rect = criteriaQueriesTable.getCellRect(row, col, false);
	                criteriaQueriesTable.repaint(rect);
	            }
	        }
	    }
		@Override public void mouseClicked(MouseEvent e) {}
		@Override public void mousePressed(MouseEvent e) {}
		@Override public void mouseReleased(MouseEvent e) {}
		@Override public void mouseEntered(MouseEvent e) {}
		@Override public void mouseDragged(MouseEvent e) {}
	}
}