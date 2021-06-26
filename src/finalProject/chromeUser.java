package finalProject;


import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class chromeUser //main class that controls everything
{
	//class variables
	int numBrowsers;
	String link;
	int delay;
	WebDriver[] driver;
	
	//constructor that sets the class variables to the text fields from GUI
	public chromeUser(int browser, String browLink, int browDelay)
	{
		numBrowsers=browser;
		link=browLink;
		delay=browDelay*1000; //because it's in miliseconds
		//creates array of Chrome Drivers
		driver=new ChromeDriver[numBrowsers];
	}
	
	//Basic browser opener with no proxies
	public void openBrowsers() throws InterruptedException
	{
				
		for(int i=0;i<driver.length;i++)
		{
			driver[i]= new ChromeDriver(); //instantiates each chrome driver
			driver[i].get(link); //opens chrome browser to that link
			Thread.sleep(delay); //delay
		}
	}
	
	//overloaded method for proxies takes a String from the Text Proxy Area
	public void openBrowsers(String x) throws InterruptedException, AWTException
	{
		//ip:port:user:pass this is normal layout of proxy
		
		
		String[] lines= x.split("\\r?\\n"); //seperates it by line which basically seperates each proxy
		proxy p[]= new proxy[numBrowsers];
		//loop to put each part of each proxy into arrays
	
		
		//starts Browsers
		//If you have less proxies than number of browsers it will just open with no proxies instead of repeating
		WebDriver[] driver=new ChromeDriver[numBrowsers];
		
		ChromeOptions[] options=new ChromeOptions[numBrowsers];
		
		for(int i=0;i<driver.length;i++)
		{
			//if proxy
			if(i<lines.length) //I checked a random part of the proxy in the array to see if null
			{
			//puts proxy into ip:port layout
			p[i]= new proxy(lines[i]); //creates proxy object
			String proxy=p[i].getIPandPort(); //calls method from proxy class
			System.out.println(proxy); //prints proxy to show user
			options[i]=new ChromeOptions().addArguments("--proxy-server=http://"+proxy); //adds to chrome options saying there will be proxy
			
			driver[i]= new ChromeDriver(options[i]); //opens chrome with proxy options
			driver[i].get(link); //opens link
			Thread.sleep(2000);// allows time for the link to open before pasting proxy
				
			//pastes the info and logs into proxy
			p[i].pasteUser();
			p[i].pastePass();
			p[i].clickEnter();
		
			}
			//if no proxy
			else
			{
				driver[i]= new ChromeDriver(); //instantiates each chrome driver
				driver[i].get(link); //opens chrome browser to that link
			}
			
			Thread.sleep(delay); //delay
			
		}
			
	}
	
	public void stop()
	{
		for(int i=0;i<driver.length;i++)
		{
			//closes out all the browsers
			driver[i].quit();
		}
	}
	
	//Main method
	public static void main(String[] args) throws InterruptedException {
		
		//get's location of the project file
		String projectLocation= System.getProperty("user.dir");
		//get's the Chrome driver from the Project 
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		
		GUI y= new GUI(); //creates GUI class variable
		y.createGUI(); //opens the GUI
		
		
	}

}
