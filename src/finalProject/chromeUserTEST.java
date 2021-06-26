package finalProject;

import java.awt.AWTException;

import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class chromeUserTEST {
	
	private int numBrowsers()
	{
		return Integer.parseInt(JOptionPane.showInputDialog("How many Browsers?"));	
	}
	
	private int getDelay()
	{
		return 10;
	}
	
	private void openBrowsers(ChromeDriver[] driver, String link)
	{
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		//get's location of the project file
		String projectLocation= System.getProperty("user.dir");
		//get's the Chrome driver from the Project location
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		
		//finalProject x=new finalProject();
		
	
				
		
		
		
		//Proxy p=new Proxy();
		//ChromeOptions options=new ChromeOptions();
		//p.setHttpProxy("45.134.110.180:3128");
		//options.setCapability(CapabilityType.PROXY, p);
		
		String proxy="45.134.110.180:3128";
		ChromeOptions options=new ChromeOptions().addArguments("--proxy-server=http://"+proxy);
		
		
		String user="C10m";
		String pass="UEXGR3";
		
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://www.inviul.com/set-proxy-selenium/");
		Thread.sleep(4000);
		//driver.switchTo().activeElement.sendKeys("C10m");
		//driver.switchTo().alert().accept();
		
		//driver.switchTo().alert().sendKeys("UEXGR3");
		//driver.switchTo().alert().accept();
		
		
		
		
		
	}

}
