package com.maven.testscript;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.cucumber.baseclass.Baseclassop;
import com.maven.pom.Homepage;
import com.maven.pom.SignInPage;

public class Junit extends Baseclassop{
	public static WebDriver driver;
	@BeforeClass
	
	public static void beforeClass() throws Exception{
		System.out.println("Driver Initialization");
		driver=getBrowser("chrome");
		getUrl("http://automationpractice.com/index.php");
	}
	@Before
	public void before() {
		System.out.println("Login the app");
		Homepage hp=new Homepage(driver);
		SignInPage sp=new SignInPage(driver);
		
		clickonWebElement(hp.getSignInLink());
		inputValuestoWebelement(sp.getEmailField(),"rpjeni1991@gmail.com");
		inputValuestoWebelement(sp.getPassword(),"bryanberty");
		clickonWebElement(sp.getsignIn());
		//getTextinWebelement(hp.getSignInLink());
	}
		@Test
		public void test1() {
		System.out.println("Test scenario 1- place order using search");	
		}
		
		@Test
		public void test2() {
			System.out.println("Test scenario 2-place order using header navigator");
			
		}	@Test
			public void test3() {
			System.out.println("Test scenario 3-contact us page automation");
		}
		
		@After
		public void after() {
			System.out.println("Log out the app");
		}
		@AfterClass
		public void afterClass() {
			driver.quit();
			System.out.println("driver quit");
		}
}
		
	
