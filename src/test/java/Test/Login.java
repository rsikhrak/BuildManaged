package Test;

import org.testng.annotations.Test;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	@Test
public void nagetivelogin() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get("http://magento.com");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).sendKeys("rubina.teletalk@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("send2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
		String error= driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
		System.out.println(error);
		if(!error.equals("Invalid login or password"))
		{System.out.println("test case pass");

		}
		driver.quit();

}
	@Test (priority=1)
	public void MagentoRegister() {
	
WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(driver, 30);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("http://magento.com/");
	driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.id("register")).click();
	driver.findElement(By.name("firstname")).sendKeys("Rojina");
	driver.findElement(By.name("lastname")).sendKeys("Shrestha");
	driver.findElement(By.name("email")).sendKeys("puja3003@yahoo.com");
	driver.findElement(By.name("password")).sendKeys("123456");
	driver.findElement(By.name("password_confirmation")).sendKeys("123456");
	
	driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div/button")).click();
	Select primary= new Select(driver.findElement(By.id("company_type")));
	primary.selectByVisibleText("Develops Magento extensions");
	
	Select role=new Select(driver.findElement(By.id("individual_role")));
	role.selectByValue("business/sales/marketing/merchandising");
	
	Select country=new Select(driver.findElement(By.id("country")));
	country.selectByVisibleText("Australia");
	if(!driver.findElement(By.id("agree_terms")).isSelected());
	{
	driver.findElement(By.id("agree_terms")).click();
	}

	driver.quit();
	}
@Test(priority=2)

public void mouseaction() throws InterruptedException {
// TODO Auto-generated method stub
	WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("http://magento.com");
Actions act=new Actions(driver);
act.moveToElement(driver.findElement(By.partialLinkText("Products"))).perform();
driver.findElement(By.linkText("Business Intelligence")).click();
act.moveToElement(driver.findElement(By.partialLinkText("Solutions"))).perform();
driver.findElement(By.linkText("Business Acceleration")).click();
Thread.sleep(3000);
act.moveToElement(driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[2]/a/span"))).perform();
driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[2]/div/div/div/div/ul/li[2]/ul/li[1]/a")).click();



for(int i=0; i<=6; i++);
{
driver.navigate().back();
Thread.sleep(3000);
}
driver.navigate().back();

act.contextClick(driver.findElement(By.xpath("//*[@id=\"row-id-330307\"]/div/div/div/div/div/div[2]/div/div/div[2]/div/a[1]"))).perform();
driver.quit();


}
@Test
public void naukri() {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

driver.get("http://naukri.com");

Set<String> winids=driver.getWindowHandles();
for(int i=1;i<winids.size();i++)
{
	driver.switchTo().window((String) winids.toArray()[i]);
	if(driver.getTitle().equals("Cognizant"))
	{
		driver.findElement(By.xpath("/html/body/a/img")).click();
	break;
	
	}else
	{
		driver.close();
	}

}
}
}
