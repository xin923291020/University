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
	private String SQLstr = "select * from student"; //��ʼ����ѯ���  
	
	private JPanel contentPane;    //������塣
	private JTabbedPane tabbedPane;    //��ǩ��壬��������塣
	private JPanel criteriaQueriesPanel;    //������ѯ��塣
	private JPanel gradePanel;

	private JLabel criteriaQueriesLabel;    //������ѯ��ǩ��
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JTextField textField;    //����е�һ�������
	private JButton selectButton_1;
	
	private JLabel allDataLabel_1;    //��ѯ�����ʾ��ǩ��
	private StudentModel sm = null;
	private JTable criteriaQueriesTable = null;    //���ڷ��ñ��Model�ı��
	private JScrollPane criteriaQueriesJSPane;	   //���ڷ��ñ��Ĺ�����塣
	private JPanel resultPanel;    //��ѯ�����ʾ��塣
	
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
		setBounds(100,100,910,605);    //���ô��ڵĴ�С��λ�á�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //���ô��ڹرհ�ť��
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);    //��������Ϊ���Բ��֡�
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);    //���ñ�ǩ��壬�����л���塣
		tabbedPane.setBounds(10,10,874,545);    //���ñ�ǩ�Ĵ�С��λ�á�
		contentPane.add(tabbedPane);    //����ǩ�ŵ�Frame�µ������С�
		
		criteriaQueriesPanel = new JPanel();    //��ʼ��criteriaQueriesPanel��塣
		tabbedPane.addTab("ѧ����Ϣ",null,criteriaQueriesPanel,null);    //��criteriaQueriesPanel������tabbedPane�С�
		criteriaQueriesPanel.setLayout(null);    //ΪcriteriaQueriesPanel���þ��Բ��֡�
		gradePanel = new JPanel();
		tabbedPane.addTab("ѧ���ɼ�", null, gradePanel, null);
		gradePanel.setLayout(null);
		
		criteriaQueriesLabel = new JLabel("��������ѯ");    //��ʼ��criteriaQueriesLabel��ǩ��
		criteriaQueriesLabel.setBounds(10,10,100,35);    //����criteriaQueriesLabel��ǩ�Ĵ�С��λ�á�
		criteriaQueriesPanel.add(criteriaQueriesLabel);    //��criteriaQueriesLabel��ǩ�ŵ�criteriaQueriesPanel����С�
		comboBox = new JComboBox();    //��ʼ��comboBox��ѡ��
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ȫ��ѧ��","ѧ��","�༶","����"}));    //Ϊ��ѡ�����ѡ�
		comboBox.setBounds(115,50,140,35);    //���ø�ѡ��Ĵ�С��λ�á�
		criteriaQueriesPanel.add(comboBox);    //��comboBox�ŵ�criteriaQueriesPanel����С�	
		textField = new JTextField();    //��ʼ��textField�����
		textField.setBounds(320,50,210,35);    //���������Ĵ�С��λ�á�
		textField.setColumns(10);    //����textField�ı��ֶε�������
		criteriaQueriesPanel.add(textField);    //��textField�ŵ�criteriaQueriesPanel����С�
		selectButton_1 = new JButton("��ѯ���");    //��ʼ��button��ť��
		selectButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));    //Ϊbutton����������͡�
		selectButton_1.setBounds(600,50,150,30);    //���ð�ť�Ĵ�С��λ�á�
		criteriaQueriesPanel.add(selectButton_1);    //��button��ť�ŵ�criteriaQueriesPanel����С�
		
		allDataLabel_1 = new JLabel("��ѯ�����ʾ");    //��ʼ��allDataLabel��ǩ��
		allDataLabel_1.setBounds(10,90,130,45);    //����allDataLabel��ǩ�Ĵ�С��λ�á�
		criteriaQueriesPanel.add(allDataLabel_1);    //��allDataLabel�ŵ�criteriaQueriesPanel����С�
		resultPanel = new JPanel();    //��ʼ��resultPanel��塣
		resultPanel.setBounds(10,150,850,315);    //����resultPanel�Ĵ�С��λ�á�
		resultPanel.setLayout(null);    //����resultPanelΪ���Բ��֡�
		criteriaQueriesPanel.add(resultPanel);    //��resultPanel�ŵ�criteriaQueriesPanel�С�
		
		addButton = new JButton("����");
		addButton.setBounds(31, 481, 90, 25);
		criteriaQueriesPanel.add(addButton);				
		upadateButton = new JButton("�޸�");
		upadateButton.setBounds(149, 481, 90, 25);
		criteriaQueriesPanel.add(upadateButton);
		importButton = new JButton("����");
		importButton.setBounds(406, 481, 90, 25);
		criteriaQueriesPanel.add(importButton);
		deleteButton = new JButton("ɾ��");
		deleteButton.setBounds(275, 481, 90, 25);
		criteriaQueriesPanel.add(deleteButton);
		
		increaseWork = new JButton("�½���ҵ");
		increaseWork.setBounds(131, 10, 127, 30);
		gradePanel.add(increaseWork);
		deleteWork = new JButton("ɾ����ҵ");
		deleteWork.setBounds(368, 10, 127, 30);
		gradePanel.add(deleteWork);
		selectButton_2 = new JButton("��ѯ");
		selectButton_2.setBounds(590, 10, 133, 30);
		gradePanel.add(selectButton_2);
		
		allDataLabel_2 = new JLabel("��ѯ�����ʾ");
		allDataLabel_2.setFont(new Font("����", Font.PLAIN, 14));
		allDataLabel_2.setBounds(10, 62, 105, 30);
		gradePanel.add(allDataLabel_2);
		
		GradeDatabaseConnection con = new GradeDatabaseConnection();
		/*
		 * ���һ�����¼���
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
		selectButton_1.addMouseListener(new MouseAdapter()    //Ϊbutton�����������¼���
		{
			public void mouseClicked(MouseEvent e)    //���е���굥���¼���
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
					new AddStudent(frame,"�����ѧ��",true);
					int i = JOptionPane.showConfirmDialog(frame,"�Ƿ�������ѧ��?","",JOptionPane.YES_NO_OPTION); 
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
					JOptionPane.showMessageDialog(frame, "����ѡ��һ������");
					return;
				}
				else
				{
					int id = criteriaQueriesTable.getSelectedRow();
					Object num = criteriaQueriesTable.getValueAt(id,0);
					sm = new StudentModel();
					String sql = "select * from student Where Sno = " + num;
					sm.queryStudent(sql,null);
					new UpdateStudent(frame,"�޸�ѧ����Ϣ",true,sm);
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
					JOptionPane.showMessageDialog(frame, "����ѡ��һ������");
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
					//��������ģ��
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
		 * ���������¼���
		 */
		increaseWork.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource() == increaseWork)
				{
					String gradeMember = JOptionPane.showInputDialog(null,"������");
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
		if(comboBox.getSelectedItem().equals("ȫ��ѧ��"))
		{
			SQLstr = "select * from student";
		}
		else
		{
		if(!(Match.isLegal(textField.getText())))    //����û������Ƿ�Ϊ��ȷ��ѧ�ţ��������༶��
		{
			JOptionPane.showMessageDialog(null,"����Ƿ����밴��ʽ����ѧ�ţ��༶���������磺20142863����1405-1�࣬����Σ���");
			return;
		}
		SQLstr += " Where ";    //�����û���ѡ��������ݿ���䣬���ԡ�
		//����û���comboBox��ѡ����textField��д�������Ƿ�ƥ�䡣
		if(comboBox.getSelectedItem().equals("ѧ��") && (Match.isSno(textField.getText())))
		{
			SQLstr += "Sno ";
		}
		else if(comboBox.getSelectedItem().equals("�༶") && (Match.isClass(textField.getText())))
		{
			SQLstr += "Class ";
		}
		else if(comboBox.getSelectedItem().equals("����") && (Match.isName(textField.getText())))
		{
			SQLstr += "Name ";
		}
		else    //����ƥ�䣬��ʼ��SQL��䣬����¼�������
		{
			JOptionPane.showMessageDialog(null,"��ѡ�����벻ƥ�䣬����");
			SQLstr = "select * from student";
			return;
		}
		SQLstr += "= '" + textField.getText() + "'";
		}
		//TModel = new Display(SQLstr);    //����SQL��䴴��AbstractTableModel��
		if(sm !=  null)
		{
			resultPanel.removeAll();
		}
		sm = new StudentModel();
		sm.queryStudent(SQLstr,null);
		criteriaQueriesTable = new JTable(sm);    //����TModel��ʼ��JTable��
		refushJtable renderer = new refushJtable();
		criteriaQueriesTable.setDefaultRenderer(Object.class, renderer);
		criteriaQueriesTable.addMouseListener(renderer);
		criteriaQueriesTable.addMouseMotionListener(renderer);
        
		sm.TableColumn = criteriaQueriesTable.getColumnModel().getColumn(3);    //���TableColumnΪJTable�еĵ����С�
		sm.TableColumn.setPreferredWidth(250);    //�����п�
		criteriaQueriesTable.setSelectionBackground(Color.WHITE);    //����criteriaQueriesTable��ѡȡ����Ϊ��ɫ��
		criteriaQueriesTable.setColumnSelectionAllowed(false);    //����criteriaQueriesTable��������ѡȡ��
		criteriaQueriesTable.setRowSelectionAllowed(false);    //����criteriaQueriesTable��������ѡȡ��
		criteriaQueriesTable.getTableHeader().setReorderingAllowed(false);    //����criteriaQueriesTable���������ƶ� ��
		int cell = criteriaQueriesTable.getModel().getColumnCount();    //cell���� criteriaQueriesTable��������
		
		criteriaQueriesTable.addMouseListener(new MouseAdapter()    //ΪcriteriaQueriesTable����������¼���
		{
			public void mouseClicked(MouseEvent e2)    //��굥���¼���
			{
				int row = ((JTable)e2.getSource()).rowAtPoint(e2.getPoint());    //row���浥����Ԫ�����ڵ�������
				int col = ((JTable)e2.getSource()).columnAtPoint(e2.getPoint());    //col���浥����Ԫ�����ڵ�������
				if(col + 1 == cell)    //�����ʽ�����ʾ�û������˲��͵�ַ�����С�
				{
					Object test = criteriaQueriesTable.getValueAt(row,col);    //�õ��û�������Ԫ������ݡ�
					
						String url = test.toString();
						String str = (String) criteriaQueriesTable.getValueAt(row,col-1);
						Browser.init(url,str);
				}
			}
		});
		criteriaQueriesJSPane = new JScrollPane(criteriaQueriesTable);    //��criteriaQueriesTable����criteriaQueriesJSPane���й����������С�
		criteriaQueriesJSPane.setBounds(50, 10, 750, 300);    //����criteriaQueriesJSPane������������С��λ�á�
		criteriaQueriesJSPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);   //ʹ��������criteriaQueriesJSPane�г��֡�
		criteriaQueriesJSPane.setEnabled(true);    //����criteriaQueriesJSPane���ɶ�����������Ӧ��
		criteriaQueriesJSPane.setViewportBorder(null);    //�����Ӿ��߽�Ϊ�ա�
		resultPanel.add(criteriaQueriesJSPane);    //��criteriaQueriesJSPane�ŵ�resultPanel�С�
		SQLstr = "select * from student";    //ִ����Ϻ󣬳�ʼ��SQL��䡣
	}
	class refushJtable extends DefaultTableCellRenderer implements MouseInputListener
	{	  
		private static final long serialVersionUID = 1L;
	    private int row = -1;    //����¼����ڵ���
	    private int col = -1;    //����¼����ڵ���
	    @Override
	    public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column)
	    {
	    	criteriaQueriesTable = table;
	        super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
	        this.setForeground(Color.BLACK);    //���ñ��������Ϊ��ɫ��
	        table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));    //ȥ������ꡣ
	        this.setText(value.toString());
	       
	        if(row == this.row && column == this.col)    //�����ǰ��Ҫ��Ⱦ���ĵ�Ԫ���������¼����ڵĵ�Ԫ��
	        {
	            
	            if (column == 3)    //����ǵ�����(����������ʾ�����ӵ���)
	            {
	                this.setForeground(Color.blue);    //�ı�ǰ��ɫ(������ɫ)
	                table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));    //�ı������״
	                this.setText("<html><u>" + value.toString() + "</u></html>");//��ʾ��������ʽ
	            }
	            setBackground(table.getSelectionBackground());
	        }
	        else if(isSelected)
	        {
	            setForeground(table.getSelectionForeground());    //�����Ԫ��ѡ��,��ı�ǰ��ɫ�ͱ���ɫ
	            setBackground(table.getSelectionBackground());
	        }
	        else
	        {
	            setBackground(Color.white);//��������»ָ�Ĭ�ϱ���ɫ
	        }
	        return this;
	    } 
	    public void mouseExited(MouseEvent e)
	    {
	        if(criteriaQueriesTable != null)
	        {
	            int oldRow = row;
	            int oldCol = col;
	            row = -1;    //����Ƴ�Ŀ�����,�ָ��������ݵ�Ĭ��ֵ
	            col = -1;
	            
	            if(oldRow != -1 && oldCol != -1)    //��֮ǰ������������Чʱ�ػ��������
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
	            if (oldRow != -1 && oldCol != -1)    //�ػ�ԭ��������
	            {
	                Rectangle rect = criteriaQueriesTable.getCellRect(oldRow,oldCol,false);
	                criteriaQueriesTable.repaint(rect);
	            }
	            if (row != -1 && col != -1)    //�ػ��µ�����
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