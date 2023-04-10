package scripts;

import java.io.IOException;

import org.testng.annotations.Test;
import generic.OpeningClosingClass;
import pom.Homepage;

public class OpeningLoginpage extends OpeningClosingClass
{
  @Test
  public  void openloginpage() throws IOException 
  {
	// call all the methods from the pom class. 
	  Homepage hp = new Homepage(driver);
	  
	  hp.clickonloginlink();
	  
	  hp.verifytitleofloginpage("ECODERS-LoginPage");
  }
}
