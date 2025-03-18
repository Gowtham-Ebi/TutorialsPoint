package elements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.Implementation.Context.Disabled;

public class Elements {
	
	WebDriver driver =new ChromeDriver();
	
	@BeforeClass
	private void launch_website() {
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.findElement(By.xpath("//button[normalize-space()='Elements']")).click();
	}
	
	@Test(enabled=true)
	
	public void txt_box() {
	     
		WebElement btn_element=driver.findElement(By.xpath("//a[normalize-space()='Text Box']"));
		btn_element.click();
		driver.findElement(By.id("fullname")).sendKeys("Gowthamm");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gowthamebi@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("533,meel srteet,thanjavur,600007.");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Inbaraj");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
	
	}
	
	@Test (enabled=true)
	private void checkbox() {
		
		WebElement btn_element=driver.findElement(By.xpath("//a[normalize-space()='Text Box']"));
		btn_element.click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Check Box']")).click();
		
		WebElement c_bs_1 = driver.findElement(By.id("c_bs_1"));
		c_bs_1.isSelected();
		
		WebElement c_bs_2 = driver.findElement(By.id("c_bs_2"));
		c_bs_2.click();
	
	}
	
	@Test(enabled=true)
	
	private void radio_btn_TC__1() {
		WebElement radio_btn_element = driver.findElement(By.xpath("//a[normalize-space()='Radio Button']")); radio_btn_element.click();
		
		WebElement  radio_btn_yes= driver.findElement(By.xpath("//input[@value='igottwo']"));
		WebElement  radio_btn_impressive= driver.findElement(By.xpath("//input[@value='igotthree']"));
		
		
		radio_btn_yes.click();
		System.out.println(driver.findElement(By.id("check")).getText());
		
		
		radio_btn_impressive.click();
		System.out.println(driver.findElement(By.id("check1")).getText());
		
		
	}
	
	@Test(enabled=false)
	private void web_table_TC001() {
		
       driver.findElement(By.xpath("//a[normalize-space()='Web Tables']")).click();
       
       driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
       driver.findElement(By.xpath("//div[@id='staticBackdropLive']//input[@id='firstname']")).sendKeys("Gowtham");
       driver.findElement(By.xpath("//div[@id='staticBackdropLive']//input[@id='lastname']")).sendKeys("Inbaraj");
       driver.findElement(By.xpath("//div[@id='staticBackdropLive']//input[@id='email']")).sendKeys("gowtham321@gmail.com");
       driver.findElement(By.xpath("//div[@id='staticBackdropLive']//input[@id='age']")).sendKeys("27"); 
      driver.findElement(By.xpath("//div[@id='staticBackdropLive']//input[@id='salary']")).sendKeys("20,000");
       driver.findElement(By.xpath("//div[@id='staticBackdropLive']//input[@id='deparment']")).sendKeys("Mech");
       driver.findElement(By.xpath("//input[@value='Login']")).click();
       
	  

     
	}
	
	@Test(enabled=true)
	private void button_element() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Buttons']")).click();
		Actions ac=new Actions(driver);
		
		WebElement clk_button = driver.findElement(By.xpath("//button[normalize-space()='Click Me']"));
		WebElement dbl_clk_button = driver.findElement(By.xpath("//button[normalize-space()='Double Click Me']"));
		
		boolean cnfm_clk_button = driver.findElement(By.id("welcomeDiv")).isDisplayed();
		WebElement cnfm_dbl_clk_button = driver.findElement(By.id("doublec"));
		ac.moveToElement(clk_button).perform();
		ac.click(clk_button).perform();
		
		ac.moveToElement(dbl_clk_button).perform();
		ac.doubleClick().perform();
		
	
	}
	
	@Test
	private void link_element() throws InterruptedException {
  
		driver.findElement(By.cssSelector("a[href='links.php']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[normalize-space()='HomewPWPU']")).click();
       
        
        Set<String> link_vrfy = driver.getWindowHandles();
        List<String> li=new ArrayList<String>(link_vrfy);
  
        driver.switchTo().window(li.get(1));
        
        @Nullable
		String currentUrl = driver.getCurrentUrl();
        String chk_currentUrl ="https://www.tutorialspoint.com/index.htm";  
  
      
        driver.switchTo().window(li.get(0));
        
      
  
  
 
	}
	
	

}
