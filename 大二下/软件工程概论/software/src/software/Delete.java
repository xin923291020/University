package software;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Delete extends JFrame
{
	private static final long serialVersionUID = 7009674199773508406L;
	private JPanel contentPane;
	private JLabel label = new JLabel("");
	private JButton cancelButton;
	private JButton deleteButton;
	private JTable table;
	private DefaultTableModel defaultModel;
	private ListSelectionModel selectionModel;
	private JScrollPane scrollPane;

	public Delete()
	{
		setDefaultCloseOperation(Delete.DISPOSE_ON_CLOSE);
		setBounds(100,100,670,500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		deleteButton = new JButton("删除");
		deleteButton.setBounds(104, 394, 134, 33);
		contentPane.add(deleteButton);
		cancelButton = new JButton("取消");
		cancelButton.setBounds(328, 397, 134, 33);
		contentPane.add(cancelButton);
		
		GradeDatabaseConnection con = new GradeDatabaseConnection();
		String sql = "select * from grademembers";
		ResultSet rs = con.executeQuery(sql);
		Vector<String> head = new Vector<String>();
		Vector<Vector<String>> body = new Vector<Vector<String>>();
		try
		{
			head.add("打分项");
			while(rs.next())
			{
				Vector<String> line = new Vector<String>();
				line.add(rs.getString(1));
			    body.add(line);
			}
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		defaultModel = new DefaultTableModel(body,head);
		table = new JTable(defaultModel);
		table.setBounds(100,70,450,275);
        table.setCellSelectionEnabled(true);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(100,70,450,275);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				int rows = table.getSelectedRow();
				int columns = table.getSelectedColumn();
				String tempString = (String) table.getValueAt(rows,columns);
				label.setText(tempString);
			}
			
		});
		cancelButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==cancelButton)
				{
					Delete.this.dispose();//关闭页面
				}
			}
		});
		deleteButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==deleteButton)
				{
					String sql1 = "delete from grademembers where grademember = '" + label.getText() + "'";
					String sql2 = "alter table studentgrade drop column " + label.getText();
					con.executeUpdate(sql1);
					con.executeUpdate(sql2);
					JOptionPane.showMessageDialog(null,"删除成功");
					Delete.this.dispose();
				}
			}
		});
	}
}