package alerts_frames_windows;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Windows {
	
	 WebDriver driver = new ChromeDriver();

	 @BeforeClass
		private void launch_website() {
			driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			driver.findElement(By.xpath("//button[normalize-space()='Alerts, Frames & Windows']")).click();
		}
@Test // (enabled=false)
private void windows() {
            driver.findElement(By.xpath("//a[normalize-space()='Browser Windows']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='New Tab']")).click();
            
            Set<String> windowHandles = driver.getWindowHandles();
for (String windows : windowHandles) {
	@Nullable
	String window_title = driver.switchTo().window(windows).getTitle();
	
	if (window_title.equals("Selenium Practice - Web Tables")) {
		String text = driver.findElement(By.xpath("//h1[normalize-space()='New Tab']")).getText();
		
		driver.close();
	}
}

}

@Test // (enabled=false)
private void alerts_test_cases() {
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
    
	driver.findElement(By.xpath("//a[normalize-space()='Alerts']")).click();
    
	driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click();      
    driver.switchTo().alert().accept();
    
    driver.findElement(By.xpath("//button[@onclick='myMessage()']")).click();
    wait.until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();
    
    driver.findElement(By.xpath("//button[@onclick='myDesk()']")).click();
    driver.switchTo().alert().accept();
    String ok_cnrfm_msg = driver.findElement(By.id("desk")).getText();
   if (ok_cnrfm_msg.equals("You pressed OK!")) {
	   driver.navigate().refresh();
}
   driver.findElement(By.xpath("//button[@onclick='myDesk()']")).click();
   driver.switchTo().alert().dismiss();
   String cnsl_cnrfm_msg = driver.findElement(By.id("desk")).getText();
   if (cnsl_cnrfm_msg.equals("You pressed Cancel!")) {
	   driver.navigate().refresh();
}
    driver.findElement(By.xpath("//button[@onclick='myPromp()']")).click(); 
    driver.switchTo().alert().sendKeys("josdvoubv");
    driver.switchTo().alert().accept();
    
}


@Test // (enabled=false)

private void frames_test_cases() {
       driver.findElement(By.xpath("//a[@href='frames.php']")).click();
      
       WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='new-tab-sample.php'][1]"));
       driver.switchTo().frame(frame1);
       System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='New Tab']")).getText());
       
       driver.switchTo().defaultContent();
       
       WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='new-tab-sample.php'][2]"));
       driver.switchTo().frame(frame2);
       System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='New Tab']")).getText());
       
       driver.switchTo().defaultContent();
       @Nullable
	String parent_frame_title = driver.getTitle();
    String vrfy_prnt_titile="Selenium Practice - Frames";
    
    Assert.assertEquals(parent_frame_title, vrfy_prnt_titile);
       
}

@Test
private void nested_frame() {
	
	driver.findElement(By.xpath("//a[@href='nestedframes.php']")).click();
	
	WebElement frame1 = driver.findElement(By.id("frame1"));
	driver.switchTo().frame(frame1);
	
	/*if (driver.findElement(By.className("logo-desktop")).isDisplayed()) {
		
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		driver.switchTo().frame(0);
		
		
	} */
	
	System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='New Tab']")).getText());
	driver.switchTo().defaultContent();
	String parnt_frame = driver.findElement(By.xpath("//h1[normalize-space()='Nested Frames']")).getText();
	String vrfy_parnt_frame="Nested Frames";
	
	Assert.assertEquals(parnt_frame, vrfy_parnt_frame);
	
	
}




}
