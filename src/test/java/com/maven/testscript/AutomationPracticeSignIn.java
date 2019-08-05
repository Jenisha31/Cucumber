package com.maven.testscript;

import org.openqa.selenium.WebElement;

import com.baseclass.Baseclassop;
import com.maven.pom.AddtoCart;
import com.maven.pom.Homepage;
import com.maven.pom.SignInPage;

public class AutomationPracticeSignIn extends Baseclassop {
	
	public static void main(String[] args) {
		driver = getBrowser("chrome");
		getUrl("http://automationpractice.com/index.php");
		Homepage hp=new Homepage(driver);
		SignInPage sp=new SignInPage(driver);
		AddtoCart ac=new AddtoCart(driver);
		
		clickonWebElement(hp.getSignInLink());
		inputValuestoWebelement(sp.getEmailField(),"rpjeni1991@gmail.com");
		inputValuestoWebelement(sp.getPassword(),"bryanberty");
		clickonWebElement(sp.getsignIn());
		inputValuestoWebelement(sp.getSearch(),"women");
        clickonWebElement(ac.getWomen());
        clickonWebElement(ac.getDress());
        clickonWebElement(ac.getAddto());
        
        
		
		
	}

	
	}

	
	


	

