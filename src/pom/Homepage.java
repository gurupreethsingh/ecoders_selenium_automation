package pom;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic.Verificationclass;

public class Homepage extends Verificationclass
{
	// find the WebElements using @FindBy() annotations.
	@FindBy(xpath="(//li[@class='nav-item'])[2]")
	WebElement loginlink;

	// initialize all the webelements using pagefactory.
	public Homepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements( driver, this);
	}
	
	//create function for each action to be performed. 
	public void clickonloginlink() {
		loginlink.click();
	}
	
	public void verifytitleofloginpage(String expectedtitle) throws IOException {
		// call the method from Verification class. 
		verifyallpagetitle(expectedtitle);
	}
}