package widgets;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Widgets {
	
	 WebDriver driver = new ChromeDriver();

	 @BeforeClass
		private void launch_website() {
			driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		}
	 @Test (enabled=false)
	private void auto_suggestion_text_box() {
        driver.findElement(By.xpath("//a[text() =' Auto Complete']")).click();
        WebElement txt_box_auto_suggestion = driver.findElement(By.id("tags"));
        txt_box_auto_suggestion.sendKeys("a");    
        driver.findElement(By.xpath("//div[text()='Java']")).click();
        txt_box_auto_suggestion.clear();
        
        txt_box_auto_suggestion.sendKeys("s");
        
        List<WebElement> s_text_auto_suggestion = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
       for (WebElement s_suggestions : s_text_auto_suggestion) {
    	   if (s_suggestions.getText().equals("AppleScript")) {
		    	   s_suggestions.click();
		    	  System.out.println(txt_box_auto_suggestion.getText());
		    	   break;
			}
	}
      // Assert.assertTrue(true);
     
	}
	 
	 @Test (enabled=false)
	 private void slider() throws InterruptedException {
		 driver.findElement(By.xpath("//a[text()=' Slider']")).click();  
		 WebElement slider = driver.findElement(By.id("ageInputId"));
         WebElement slider_value = driver.findElement(By.id("ageOutputId"));
         String initial_slider_value = slider_value.getText();
       System.out.println(slider_value.getLocation());
         
         System.out.println(slider.getLocation());
         
        Actions ac=new Actions(driver);
        
        System.out.println(slider.getSize());
        ac.dragAndDropBy(slider,150,190).perform();
            
       System.out.println(slider.getLocation());
	 if (slider_value.getText().equals("75")) {
		Assert.assertTrue(true);
	}
	 }
	 @Test (enabled=false)
	 private void progress_bar() {
         driver.findElement(By.xpath("//a[normalize-space()='Progress Bar']")).click();
         driver.findElement(By.xpath("//button[@id='startProgressTimer']")).click();
         WebElement progress_bar_element = driver.findElement(By.xpath("//div[@role='progressbar']"));
        
         if (progress_bar_element.isDisplayed()) {
			Assert.assertTrue(true);
		}
	 
	 
	 }
	 
	 @Test (enabled=false)
	 private void tabs() throws InterruptedException {
		 WebElement link_tabs = driver.findElement(By.xpath("//a[normalize-space()='Tabs']"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1500)","");
		Thread.sleep(3000);
		 Actions ac=new Actions(driver);
		ac.moveToElement(link_tabs).perform();
		Thread.sleep(3000);
		link_tabs.click();
		 
		 
		
            driver.findElement(By.xpath("//button[@id='nav-home-tab']")).click();
            boolean vrfy_tab_home = driver.findElement(By.xpath("//div[@id='nav-home']//p[@class='text-justify']")).isDisplayed();
            driver.findElement(By.xpath("//button[@id='nav-profile-tab']")).click();
            boolean vrfy_tab_profile = driver.findElement(By.xpath("//div[@id='nav-profile']//p[@class='text-justify']")).isDisplayed();
            driver.findElement(By.xpath("//button[@id='nav-contact-tab']")).click();
            boolean vrfy_tab_contact = driver.findElement(By.xpath("//div[@id='nav-contact']//p[@class='text-justify']")).isDisplayed();
           
	if (vrfy_tab_home==vrfy_tab_profile==vrfy_tab_contact ) {
		Assert.assertTrue(true);
	} 
	}
	 
	 @Test
	 private void scroll_top() throws InterruptedException {

JavascriptExecutor js=(JavascriptExecutor)driver;
       js.executeScript("window.scrollBy (0,1500)", "");
       
       Thread.sleep(3000);
WebElement scroll_top_element = driver.findElement(By.xpath("//a[normalize-space()='Scoll Top']"));
scroll_top_element.click();
@Nullable
Object initial_scroll_offset = js.executeScript("return window.pageYOffset;");
     System.out.println(initial_scroll_offset);
       js.executeScript("window.scrollBy(0,1000)", "");
      @Nullable
	Object aftr_scroll = js.executeScript("return window.pageYOffset;");
  System.out.println(aftr_scroll);
      driver.findElement(By.xpath("//button[@id='btn-back-to-top']")).click();
      Object aftr_clk_top_scroll_btn_offset = js.executeScript("return window.pageYOffset;");
      System.out.println(aftr_clk_top_scroll_btn_offset);


	 }
	
}
