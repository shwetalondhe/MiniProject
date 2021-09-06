package sel;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;

public class onlinecart {

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\QA testing\\seleniumC\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")));

		act.moveToElement(driver.findElement(By.xpath(
				"//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]")));
		act.click().build().perform();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("7620112981");
		act.moveToElement(driver.findElement(By.xpath("//input[@id='continue']")));
		act.click().build().perform();

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Shweta@1999");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("laptop");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        Thread.sleep(2000);
		List<WebElement> results=driver.findElements(By.xpath("//div[@class='s-expand-height s-include-content-margin s-latency-cf-section s-border-bottom']"));
		List<WebElement> links;
		int size;
	    int counter = 0;
		for(WebElement element:results)
		{
			links=element.findElements(By.tagName("a"));
			size=links.size();
			for(int i=0;i<size;i++)
		{
				if(links.get(i).getText().length()>20)
				{
					System.out.println(links.get(i).getText());
					counter++;
				}
			}
			if(counter>=5)
			break;
			
				}
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("headphone");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Redmi Mobiles");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(2000);
		
		System.out.println("End of Code");
		Thread.sleep(2000);
		driver.close();
	}

}