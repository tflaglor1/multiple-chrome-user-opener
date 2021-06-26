package finalProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

//create an array of proxy objects and here they parse them
public class proxy {

	String ip;
	String port;
	String user;
	String pass;
	Robot r;
	public proxy(String x) throws AWTException
	{
		String[] lines= x.split("\\r?\\n"); //seperates it by line which basically seperates each proxy
		
		//loop to put each part of each proxy into arrays
		for(int i=0; i<lines.length;i++) 
		{
				String proxyList[]=lines[i].split(":");	//splits by colon
				ip=proxyList[0];
				port=proxyList[1];
				user=proxyList[2];
				pass=proxyList[3];
		}
		
		r=new Robot();//initializes robot
	}
	
	public String getIPandPort()
	{
		return ip+":"+port;
	}
	
	public String getUser()
	{
		return user;
	}
	public String getPass()
	{
		return pass;
	}
	
	public void pasteUser() throws InterruptedException
	{
		//sets StringSelection to the thing needing to be copied
		StringSelection userPaste= new StringSelection(user);
		Clipboard userclipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
		userclipboard.setContents(userPaste, null); //puts the String into the clipboard
		
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		//releases keys
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		//goes to sign in button
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	
	public void pastePass() throws InterruptedException
	{
		//sets StringSelection to the thing needing to be copied
		StringSelection userPaste= new StringSelection(pass);
		Clipboard userclipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
		userclipboard.setContents(userPaste, null); //puts the String into the clipboard
		
		System.out.println(pass+" "+user);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		//releases keys
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		//goes to sign in button
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	
	public void clickEnter()
	{
		//clicks Enter
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
}
