package finalProject;

import java.awt.AWTException;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;

public class GUI {

	private JFrame frmMultpleChromeBrowsers; //creates JFrame
	//creates Text Fields
	private JTextField numBrowsers;
	private JTextField link;
	private JTextField delay;
	chromeUser x;
	
	//class variables
	int numBrow;
	String getLink;
	int getDelay;
	String proxy;
	//Constructor
	public GUI()
	{
	
		initialize(); //calls to initilize the GUI
	}

	/**
	 * Launch the application.
	 */
	public  void createGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmMultpleChromeBrowsers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	 //Initialize the frame
	 
	private void initialize() {
		frmMultpleChromeBrowsers = new JFrame();
		frmMultpleChromeBrowsers.getContentPane().setForeground(Color.BLACK);
		frmMultpleChromeBrowsers.setTitle("Multple Chrome Browsers");
		frmMultpleChromeBrowsers.setBounds(200, 200, 811, 505);
		frmMultpleChromeBrowsers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMultpleChromeBrowsers.getContentPane().setLayout(null);
		
		JLabel browserLabel = new JLabel("How Many Browsers?");
		browserLabel.setForeground(Color.BLACK);
		browserLabel.setBounds(297, 62, 148, 16);
		frmMultpleChromeBrowsers.getContentPane().add(browserLabel);
		
		JLabel linkLabel = new JLabel("What Link");
		linkLabel.setBounds(297, 129, 84, 16);
		frmMultpleChromeBrowsers.getContentPane().add(linkLabel);
		
		JLabel delayLabel = new JLabel("Delay in Seconds");
		delayLabel.setBounds(297, 186, 100, 16);
		frmMultpleChromeBrowsers.getContentPane().add(delayLabel);
		
		numBrowsers = new JTextField();
		numBrowsers.setBounds(601, 59, 116, 22);
		frmMultpleChromeBrowsers.getContentPane().add(numBrowsers);
		numBrowsers.setColumns(10);
		
		link = new JTextField();
		link.setBounds(411, 126, 370, 22);
		frmMultpleChromeBrowsers.getContentPane().add(link);
		link.setColumns(10);
		
		delay = new JTextField();
		delay.setBounds(601, 183, 116, 22);
		frmMultpleChromeBrowsers.getContentPane().add(delay);
		delay.setColumns(10);
		
		JTextArea proxyInput = new JTextArea();
		proxyInput.setBounds(33, 33, 234, 412);
		frmMultpleChromeBrowsers.getContentPane().add(proxyInput);
		
		JButton Start = new JButton("Start");
		//listens to see when start button is clicked
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//I want to add try catch if they don't put in int
				//gets all the texrFields and puts them into variables
				try {
				numBrow=Integer.parseInt(numBrowsers.getText());
				}
				catch(Exception noInt)
				{
					System.out.println("Please put an integer into the number of Browsers");
				}
				getLink=link.getText();
				getDelay=Integer.parseInt(delay.getText());
				proxy=proxyInput.getText();
				System.out.println("Clicked Start");
				
				//no proxy
				if(proxy.equals(""))
				{
				//creates chromeUser object
				x= new chromeUser(numBrow,getLink,getDelay);
				try {
					x.openBrowsers();//opens the browsers
				}
				//I need to change this
				catch (InterruptedException e1) {
					
					System.out.println("error");
					System.exit(0);
				}
				}
				else //if there are proxies
				{
					x= new chromeUser(numBrow,getLink,getDelay);
					try {
						try {
							x.openBrowsers(proxy);
						} catch (AWTException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} //opens browsers with proxies
					} catch (InterruptedException e1) {
						
					}
				}
							
			}
		});
		Start.setBounds(297, 377, 183, 57);
		frmMultpleChromeBrowsers.getContentPane().add(Start);
		
		// I want to add to this and make it close all chrome tasks
		JButton Stop = new JButton("Stop");
		Stop.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			x.stop();
		}
		});
			
		
		Stop.setBounds(601, 377, 183, 57);
		frmMultpleChromeBrowsers.getContentPane().add(Stop);
		
				
		JLabel proxyLabel = new JLabel("Add Proxies Here One Per Line");
		proxyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		proxyLabel.setBounds(54, 13, 183, 16);
		frmMultpleChromeBrowsers.getContentPane().add(proxyLabel);
	}
}
