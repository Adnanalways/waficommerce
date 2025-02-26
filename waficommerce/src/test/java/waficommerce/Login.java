package waficommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
			driver.manage().window().maximize();
		driver.get("https://dev.waficommerce.com/");
	}
	
	@Test (priority=1)
	public void login() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()[normalize-space()='Login']]")).click();
		driver.findElement(By.xpath("//a[text()='switch']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Input_Name']")).sendKeys("QA");
		driver.findElement(By.xpath("//button[span[text()='Save']]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"LoginInput_UserNameOrEmailAddress\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"LoginInput_Password\"]")).sendKeys("1q2w3E*");
		driver.findElement(By.xpath("//*[@id=\"lpx-wrapper\"]/div[2]/div[2]/div/div/div/div[2]/div/form/div[4]/button")).click();
		
		System.out.println("login successfully");
		
	}
	@Test (priority=2)
	public void inventory() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"lpx-wrapper\"]/div[1]/div/lpx-navbar/nav/lpx-navbar-routes/ul/li[3]/lpx-sub-navbar/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#lpx-wrapper > div.lpx-sidebar-container > div > lpx-navbar > nav > lpx-navbar-routes > ul > li:nth-child(3) > lpx-sub-navbar > ul > li:nth-child(5) > lpx-sub-navbar > a")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#lpx-wrapper > div.lpx-content-container > div.lpx-content > app-product > div > div.card-header > div:nth-child(1) > div.text-lg-end.pt-2.col-2")).click();
		driver.findElement(By.xpath("//select[@id='product-group']/option[@value='2: 3a14a635-ab00-a8fe-d537-f5ef2a5f9324']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='product-subgroup']/option[@value='1: 3a14a637-7edb-ea02-8266-466d95b493d9']")).click();
		driver.findElement(By.xpath("//select[@formcontrolname='unitOfMeasurementTableId']/option[@value='1: 3a182be2-cc46-8dd4-2a54-fc93f8bdc30e']")).click();
		driver.findElement(By.cssSelector("#product-name")).sendKeys("cooker");
		driver.findElement(By.cssSelector("#product-code")).sendKeys("joy-10");
		driver.findElement(By.cssSelector("#customer-item-code")).sendKeys("adnan-10");
		driver.findElement(By.cssSelector("#product-reOrderLevel")).sendKeys("10");
		driver.findElement(By.cssSelector("#product-description")).sendKeys("testing by adnan selenium with java");
		driver.findElement(By.cssSelector("#retail-price")).sendKeys("500");
		driver.findElement(By.xpath("//input[@id='retail-discount' and @formcontrolname='wholesaleDiscount']")).sendKeys("5");
		driver.findElement(By.cssSelector("#product-purchase")).sendKeys("480");
		driver.findElement(By.xpath("//input[@id='retail-discount' and @formcontrolname='retailDiscount']")).sendKeys("3");
	    driver.findElement(By.xpath("//div[@id='abp-modal-footer']//button[normalize-space(text())='Save']")).click();
	    
	    if(driver.getPageSource().contains("product already exist with the name cooker")) {
	    	System.out.println("Pass - Product already exists");
	    }else {
	    	System.out.println("Fail - Product creation test failed");
	    }
	    driver.findElement(By.xpath("//div[@id='abp-modal-footer']//button[contains(text(), 'Close')]")).click();
	    driver.findElement(By.xpath("//div[@class='footer']//button[@id='confirm' and text()='Yes']")).click();
	}
	
	
	@Test (priority=2)
	public void purchasestest() throws InterruptedException  {
		driver.findElement(By.cssSelector("#lpx-wrapper > div.lpx-sidebar-container > div > lpx-navbar > nav > lpx-navbar-routes > ul > li:nth-child(4) > lpx-sub-navbar > a")).click();
		driver.findElement(By.cssSelector("#lpx-wrapper > div.lpx-sidebar-container > div > lpx-navbar > nav > lpx-navbar-routes > ul > li:nth-child(4) > lpx-sub-navbar > ul > li:nth-child(1) > lpx-sub-navbar > a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='text-lg-end pt-2']//button[@id='create']/span[text()='New Purchase']")).click();
		driver.findElement(By.xpath("//*[@id=\"reference-number\"]")).sendKeys("adnan-13");
		driver.findElement(By.xpath("//*[@id=\"abp-modal-body\"]/form/div/div[4]/div/ng-select/div/div/div[2]")).click();
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted' and text()='Zorita Morris']")).click();
		driver.findElement(By.xpath("//select[@formcontrolname='purchaseMadeBy']//option[text()=' Intern ']")).click();
		driver.findElement(By.xpath("//textarea[@id='purchase-description' and @formcontrolname='description']")).sendKeys("test by adnan new purchases");
		driver.findElement(By.xpath("//*[@id=\"abp-modal-body\"]/form/div/div[9]/div/table/tbody/tr/td[3]/ng-multiselect-dropdown/div/div[1]/span")).click();
		driver.findElement(By.cssSelector("#abp-modal-body > form > div > div:nth-child(9) > div > table > tbody > tr > td:nth-child(3) > ng-multiselect-dropdown > div > div.dropdown-list > ul.item2 > li:nth-child(5) > div")).click();
		driver.findElement(By.xpath("//input[@type='number' and @min='1' and contains(@class, 'narrow-columns')]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"abp-modal-body\"]/form/div/div[9]/div/table/tbody/tr/td[6]/input")).click();
		driver.findElement(By.xpath("//div[@class='mt-2 col-md-4']//input[@id='purchase-total-discount' and @formcontrolname='totalDiscount' and @min='0']")).sendKeys("3");
		driver.findElement(By.xpath("//input[@type='number' and @id='purchase-input-cash' and @formcontrolname='inputCash' and @min='0']")).sendKeys("6997");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='abp-modal-footer']//button[normalize-space(text())='Save']")).click();
		
		System.out.println("new purchase successful");
		
	}
	
	@Test (priority=3)
	public void sales() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#lpx-wrapper > div.lpx-sidebar-container > div > lpx-navbar > nav > lpx-navbar-routes > ul > li:nth-child(5) > lpx-sub-navbar > a")).click();
		driver.findElement(By.cssSelector("#lpx-wrapper > div.lpx-sidebar-container > div > lpx-navbar > nav > lpx-navbar-routes > ul > li:nth-child(5) > lpx-sub-navbar > ul > li:nth-child(1) > lpx-sub-navbar > a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='create' and span[text()='New Sale'] and i[contains(@class, 'fa-plus')]]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ng-select[@formcontrolname='customerId']//div[@role='option' and span[text()='Customer abc']]")).click();
		//driver.findElement(By.cssSelector("#lpx-wrapper > div.lpx-content-container > div.lpx-content > app-sale-create-update > form > div > div > div.col-md-10 > div:nth-child(1) > div:nth-child(1) > div > div > div > div > div:nth-child(1) > div.col-md-9 > div > div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ng-dropdown-panel//div[@role='option']//span[contains(text(), 'Samsung Galaxy S25 Ultra-China - (12)')]")).click();
		driver.findElement(By.xpath("//textarea[@id='sale-description']")).sendKeys("test by adnan");
		driver.findElement(By.xpath("//input[@id='quantity-input']")).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='number' and contains(@class, 'form-control-sm') and @style='background: white;']")).sendKeys("5");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/app-root/abp-dynamic-layout/abp-application-layout/lpx-layout/div/div[2]/div[2]/app-sale-create-update/form/div/div/div[2]/div/div/div/div[4]/div[2]/input")).sendKeys("10");
		driver.findElement(By.xpath("/html/body/app-root/abp-dynamic-layout/abp-application-layout/lpx-layout/div/div[2]/div[2]/app-sale-create-update/form/div/div/div[2]/div/div/div/div[5]/div[2]/input")).sendKeys("5");
		driver.findElement(By.xpath("/html/body/app-root/abp-dynamic-layout/abp-application-layout/lpx-layout/div/div[2]/div[2]/app-sale-create-update/form/div/div/div[2]/div/div/div/div[7]/div[2]/input")).sendKeys("10000");
		driver.findElement(By.xpath("/html/body/app-root/abp-dynamic-layout/abp-application-layout/lpx-layout/div/div[2]/div[2]/app-sale-create-update/form/div/div/div[2]/div/div/div/div[8]/div[2]/input")).sendKeys("700");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("/html/body/app-root/abp-dynamic-layout/abp-application-layout/lpx-layout/div/div[2]/div[2]/app-sale-create-update/form/div/div/div[2]/div/div/div/div[11]/div[2]/input")).sendKeys("300");
		driver.findElement(By.cssSelector("#lpx-wrapper > div.lpx-content-container > div.lpx-content > app-sale-create-update > form > div > div > div.col-md-2 > div > div > div > div.row.mt-1.mb-1 > div > input")).click();
		driver.findElement(By.cssSelector("#lpx-wrapper > div.lpx-content-container > div.lpx-content > app-sale-create-update > form > div > div > div.col-md-2 > div > div > div > button.btn.btn-success.btn-sm.me-2")).click();
		//System.out.println("An internal error occurred during your request");
		
		if(driver.getPageSource().contains("An internal error occurred during your request")) {
			System.out.println("pass");
			
		}else {
			System.out.println("fail");
		}
		
		
	}
	

}
