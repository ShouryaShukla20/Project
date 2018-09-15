package testjava;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Success extends PathPages2{
	public Success() {
		PageFactory.initElements(Browser.driver, this);
	}

	
	@FindBy(how = How.ID, id = "fname1")
	private WebElement fName1;
	@FindBy(how = How.ID, id = "lname1")
	private WebElement lName1;

	public String getFName1() {
		return fName1.getText();
	}

	public String getLastName1() {
		return lName1.getText();
	}
	@FindBy(how = How.ID, id = "fname2")
	private WebElement fName2;
	@FindBy(how = How.ID, id = "lname2")
	private WebElement lName2;

	public String getFName2() {
		return fName2.getText();
	}

	public String getLastName2() {
		return lName2.getText();
	}

	public void goTo() {

		Browser.goTo(url);
	}

	public boolean isAt() {
		return Browser.title().equals(title);
	}
}
