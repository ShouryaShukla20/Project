package testjava;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoanApplicationPage extends PathPages{
	
	public LoanApplicationPage() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	@FindBy(how=How.ID,id="firstName")
	private WebElement firstName;
	
	@FindBy(how=How.ID,id="lastName")
	private WebElement lastName;
	@FindBy(how=How.ID,name="TermsAcceptance")
	private WebElement check;

	@FindBy(how=How.ID,id="formthis")
	private WebElement submitdo;

	

	public void setSubmitdo() {

		submitdo.submit();
	}

	public void setCheck() {
		check.click();
	}

	public String getFirstName() {
		return firstName.getText();
	}

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public String getLastName() {
		return lastName.getText();
	}

	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	

}
