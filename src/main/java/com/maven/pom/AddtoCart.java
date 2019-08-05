package com.maven.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart {
	public WebDriver driver;
	public AddtoCart (WebDriver ldriver) {
		this.driver=ldriver;
		//to initialize webelements
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//a[@title='Women']")
	private WebElement women;
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement dress;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addto;
	
	public WebElement getAddto() {
		return addto;
	}

	public WebDriver getDriver() {
		return driver;
	}

  public WebElement getWomen() {
		return women;
	}
   public WebElement getDress() {
		return dress;
	}


	
	
		 
}
	