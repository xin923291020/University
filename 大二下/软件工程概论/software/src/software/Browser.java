package software;

import com.sun.javafx.application.PlatformImpl;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Browser extends JPanel
{
	private static final long serialVersionUID = -5525619122115277041L;
	private static String DEFAULT_URL = null;  //���������ַ��
	private static String DEFAULT_NAME = null;
    private JButton backwardButton;    //���˰�ť��
    private JButton forwardButton;    //ǰ����ť��
    private JTextField addressTextField;    //��ַ����
    private WebView view;
    static JFXPanel webPanel;
    
    private JToolBar toolBar;
    private JLabel nameLabel;
    private JLabel workLabel;
    private JLabel gradeLabel;
    private JTextField nameTextField;
    private JTextField gradeTextField;
    private JButton submitButton;
	private JComboBox<Object> workComboBox;
    StackPane layout;
    public void webPanelInit()
    {
    	PlatformImpl.startup(new Runnable()
    	{
    		public void run()
    		{
    			System.out.println("�����߳�");
    			webPanel = new JFXPanel();
    			view = new WebView();
    			layout = new StackPane();
	            Scene scene = new Scene(layout);
	            layout.getChildren().addAll(view);
	            webPanel.setScene(scene);
	            webPanel.setVerifyInputWhenFocusTarget(true);
	            System.out.println("�߳̽���");
    		}
    	});
    }
    public Browser()
    {
    	webPanelInit();
        setLayout(new BorderLayout());
        JToolBar AddressBar = new JToolBar();
        add(AddressBar, BorderLayout.NORTH);
        AddressBar.setBorderPainted(true);
        AddressBar.setFloatable(false);
        backwardButton = new JButton("back");
        AddressBar.add(backwardButton);
        
                backwardButton.addMouseListener(new MouseAdapter()    //Ϊbutton�����������¼���
                {
                	public void mouseClicked(MouseEvent e)    //���е���굥���¼���
                	{
                		PlatformImpl.startup(new Runnable()
                		{
                			public void run()
                			{
                				int currentIndex = view.getEngine().getHistory().getCurrentIndex();
                				if (currentIndex > 0)
                				{
                					view.getEngine().getHistory().go(-1);
                					addressTextField.setText(view.getEngine().getLocation());
                				}
                			}
                		});
                	}
                });
        
        forwardButton = new JButton("forward");
        AddressBar.add(forwardButton);
        AddressBar.addSeparator();
        addressTextField = new JTextField(DEFAULT_URL);
        AddressBar.add(addressTextField);
        try
        {
        	webPanelInit();
        	Thread.sleep(1000);
            view.getEngine().locationProperty().addListener(new ChangeListener<String>()
            {  
                @Override  
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
                {  
                	addressTextField.setText(newValue);  
                }  
            });
        }
        catch(InterruptedException ex)
        {
        }
        // System.out.println("������");
    	add(webPanel);
        toolBar = new JToolBar();
        add(toolBar, BorderLayout.SOUTH);
        nameLabel = new JLabel("����");
        toolBar.add(nameLabel);
        nameTextField = new JTextField("��ҵ");
        nameTextField.setText(DEFAULT_NAME);
        nameTextField.setEditable(false);
        toolBar.add(nameTextField);
        workLabel = new JLabel("��ҵ");
        toolBar.add(workLabel);
        
        workComboBox = new JComboBox<Object>();
        toolBar.add(workComboBox);
        gradeLabel = new JLabel("����");
        toolBar.add(gradeLabel);
        gradeTextField = new JTextField();
        gradeTextField.setColumns(10);
        toolBar.add(gradeTextField);
        submitButton = new JButton("�ύ");
        toolBar.add(submitButton);
        GradeDatabaseConnection gradeDC = new GradeDatabaseConnection();
        try
        {
        	 ResultSet rs = gradeDC.executeQuery("select distinct grademember from grademembers"); 
			 while(rs.next())
			 {
		    	  workComboBox.addItem(rs.getString(1));
			 }
		}
        catch(SQLException e1)
        {
			e1.printStackTrace();
		}
        forwardButton.addMouseListener(new MouseAdapter()    //Ϊbutton�����������¼���
        {
        	public void mouseClicked(MouseEvent e)    //���е���굥���¼���
        	{
        		PlatformImpl.startup(new Runnable()
        		{
        			public void run()
        			{
        				try
        				{
        					view.getEngine().getHistory().go(1);
        					addressTextField.setText(view.getEngine().getLocation());
        				}
        				catch(IndexOutOfBoundsException e)
        				{
        				}
        			}
        		});
        	}
        });
        addressTextField.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				 PlatformImpl.startup(new Runnable()
	             {
					 public void run()
					 {
						 System.out.println("��Ӧ�س��¼�");
						 view.getEngine().load(addressTextField.getText());
					 }
				 });
			}
        });
        submitButton.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mouseClicked(MouseEvent e)
        	{
        		String grade = gradeTextField.getText();
        		String select = (String) workComboBox.getSelectedItem();
        		String sql = "update studentgrade set " + select + " = '" + grade + "' where Name   = '" + DEFAULT_NAME.trim()+ "'";
        		System.out.println(sql);
        		gradeDC.executeUpdate(sql);
        	}
        });
        
        /** 
         * ���ñ�����Ϊ��ǰ����ҳ��ı��⡣ 
         */  
        view.getEngine().setOnAlert(new EventHandler<WebEvent<String>>()
        {
            @Override  
            public void handle(WebEvent<String> event)
            {  
                System.out.println("this is event"+event);  
            }  
        });  
  
        //�����µĵ�ַ  
        @SuppressWarnings("unused")
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>()
        {  
            @Override  
            public void handle(ActionEvent event) 
            {  
            	view.getEngine().load(addressTextField.getText().startsWith("http://")?addressTextField.getText().trim():"http://"+addressTextField.getText().trim());  
            }  
        };
    }
    public static void init(String url,String name)
    {
    	DEFAULT_URL = url;
    	DEFAULT_NAME = name;
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        SwingUtilities.invokeLater(new Runnable()
        {
			public void run()
            {
                JFrame localJFrame = new JFrame("JavaFx Browser Demo");
                localJFrame.getContentPane().add(new Browser());
                localJFrame.setSize(800,600);
                localJFrame.setLocationRelativeTo(null);
                localJFrame.setVisible(true);
                ImageIcon img = new ImageIcon("F:\\eclipse\\Java eclipse\\software\\src\\software\\icon2.png");
                localJFrame.setIconImage(img.getImage());
                localJFrame.addWindowListener(new WindowAdapter()
                {
                    public void windowClosing(WindowEvent paramAnonymousWindowEvent)
                    {
                    	System.out.println("�رմ���");
                    	localJFrame.dispose();
                    }
                });
            }
        });
    }
    public static void release()
    {
    	PlatformImpl.exit();
    }
}