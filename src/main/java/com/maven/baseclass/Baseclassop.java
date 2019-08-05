package com.maven.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.seleniumhq.jetty9.util.IO;

public class Baseclassop {
	public static WebDriver driver;
public  static WebDriver getBrowser(String browserName) {
	try {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resource\\com\\maven\\resource\\chromedriver.exe");
			driver =new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
			driver =new ChromeDriver();
					
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("ie")){
		}else {
			throw new Exception("Browser Name is Invalid");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException();
	}
}
	public static void getUrl(String url) {
		driver.get(url);
	}

public static boolean elementIsDisplayed(WebElement element) {
	try {
		boolean displayed=element.isDisplayed();
		return displayed;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException();
	}
	}
	public static boolean elementIsEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public static void waitforElementVisibility(WebElement element)	{
		try {
			WebDriverWait wb=new WebDriverWait(driver,60);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		}
		public static void inputValuestoWebelement(WebElement element,String value) {
			try {
				waitforElementVisibility(element);
				if(elementIsDisplayed(element)&& elementIsEnabled(element)) {
					element.sendKeys(value);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			public static void clickonWebElement(WebElement element)	{
				try {
					waitforElementVisibility(element);
					if(elementIsDisplayed(element))
					{
						element.click();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	public static void selectDropDownOption(WebElement element,String option,String value) {
		try {
			Select s=new Select(element);
			if(option.equalsIgnoreCase("visibletext")) {
				s.selectByVisibleText(value);
			}else if(option.equalsIgnoreCase("visibletext")) {
				s.selectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
			
		}
	}

	public static void takeScreenShot(String fileName)throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir") + "\\ScreenShot\\"+ fileName +".png");
		FileUtils.copyFile(src,des);
		}
	
	public static void scrollUsingElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(),element");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
			
		}
	}
	public static void scrollUsingCoOrdinates(String width,String height) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public static void scrollToTopOfThePage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("(window.scrollBy(0,-document.body.scrollHeight))");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public static void dragAndDrop(WebElement sourceElement,WebElement placedElement) {
		try {
			Actions ac=new Actions(driver);
			ac.dragAndDrop(sourceElement,placedElement).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		throw new RuntimeException();
	}
	
	
public static void simpleAlert(WebElement element) {
	try {
		waitforElementVisibility(element);
		Alert simpleAlert=driver.switchTo().alert();
		simpleAlert.accept();
		driver.switchTo().defaultContent();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException();
		
	}
	
}

public static void confirmAlert(WebElement element,String userChoice) {
	try {
		waitforElementVisibility(element);
		Alert confirmAlert =driver.switchTo().alert();
		if(userChoice.equalsIgnoreCase("ok")) {
			confirmAlert.accept();
			driver.switchTo().defaultContent();
		}else if(userChoice.equalsIgnoreCase("cancel")) {
			confirmAlert.dismiss();
			driver.switchTo().defaultContent();
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException();
	}
	}
public static void promptAlert(WebElement element,String condition,String value) {
	try {
		waitforElementVisibility(element);
		Alert promptAlert=driver.switchTo().alert();
		if(condition.equalsIgnoreCase("accept")) {
			promptAlert.sendKeys(value);
			driver.switchTo().defaultContent();
			}else if(condition.equalsIgnoreCase("dismiss")) {
			promptAlert.dismiss();
			promptAlert.sendKeys("value");
			driver.switchTo().defaultContent();
}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException();
	}
}
public static void rightClick(WebElement element) {
	try {
		waitforElementVisibility(element);	
		Actions ac=new Actions(driver);
		ac.contextClick(element).build().perform();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException();
	}
}
public static void doubleClick(WebElement element) {
	try {
		waitforElementVisibility(element);
		Actions ac=new Actions(driver);
		ac.doubleClick(element).build().perform();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException();
	}
	
}
}

				
				
				
		
	
		
	



	
