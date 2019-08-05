package com.maven.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	public WebDriver driver;
	public SignInPage (WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(id="email")
		private WebElement emailField;
		
		@FindBy(xpath="//input[@type='password']")
		private WebElement Password;
		
		@FindBy(id="SubmitLogin")
		private WebElement signIn;
		
		@FindBy(id="search_query_top")
		private WebElement search;
		
		
		public WebElement getSearch() {
			return search;
		}

		
		public WebElement getSignIn() {
			return signIn;
		}

		public WebElement getEmailField() {
			return emailField;
		}
		
		public WebElement getsignIn() {
			return signIn;
		}
		public WebElement getPassword() {
			return Password;
		}
	
		public WebDriver getDriver() {
			return driver;
		}

		

		
	
}
		