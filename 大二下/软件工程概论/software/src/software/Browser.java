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
	private static String DEFAULT_URL = null;  //浏览器面板地址。
	private static String DEFAULT_NAME = null;
    private JButton backwardButton;    //后退按钮。
    private JButton forwardButton;    //前进按钮。
    private JTextField addressTextField;    //地址栏。
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
    			System.out.println("运行线程");
    			webPanel = new JFXPanel();
    			view = new WebView();
    			layout = new StackPane();
	            Scene scene = new Scene(layout);
	            layout.getChildren().addAll(view);
	            webPanel.setScene(scene);
	            webPanel.setVerifyInputWhenFocusTarget(true);
	            System.out.println("线程结束");
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
        
                backwardButton.addMouseListener(new MouseAdapter()    //为button设置鼠标监听事件。
                {
                	public void mouseClicked(MouseEvent e)    //其中的鼠标单击事件。
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
        // System.out.println("添加面板");
    	add(webPanel);
        toolBar = new JToolBar();
        add(toolBar, BorderLayout.SOUTH);
        nameLabel = new JLabel("姓名");
        toolBar.add(nameLabel);
        nameTextField = new JTextField("作业");
        nameTextField.setText(DEFAULT_NAME);
        nameTextField.setEditable(false);
        toolBar.add(nameTextField);
        workLabel = new JLabel("作业");
        toolBar.add(workLabel);
        
        workComboBox = new JComboBox<Object>();
        toolBar.add(workComboBox);
        gradeLabel = new JLabel("分数");
        toolBar.add(gradeLabel);
        gradeTextField = new JTextField();
        gradeTextField.setColumns(10);
        toolBar.add(gradeTextField);
        submitButton = new JButton("提交");
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
        forwardButton.addMouseListener(new MouseAdapter()    //为button设置鼠标监听事件。
        {
        	public void mouseClicked(MouseEvent e)    //其中的鼠标单击事件。
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
						 System.out.println("响应回车事件");
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
         * 设置标题栏为当前访问页面的标题。 
         */  
        view.getEngine().setOnAlert(new EventHandler<WebEvent<String>>()
        {
            @Override  
            public void handle(WebEvent<String> event)
            {  
                System.out.println("this is event"+event);  
            }  
        });  
  
        //加载新的地址  
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
                    	System.out.println("关闭窗口");
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