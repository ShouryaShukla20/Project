package testjava;
import org.junit.Assert;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs3 {
	 private LoanApplicationPage page=new LoanApplicationPage();
	 private Success page2=new Success();
	 String fnm,lnm;
	
	@Given("^I am on LoanApplicationPage$")
	public void i_am_on_LoanApplicationPage() throws Exception {
	    page.goTo();
	    Assert.assertTrue(page.isAt());
	    
	}

	@Given("^I have entered firstname into the form$")
	public void i_have_entered_firstname_into_the_form(DataTable arg1) throws Exception {
	   
		System.out.println(arg1.asList(String.class).get(0));
		page.setFirstName(arg1.asList(String.class).get(0));
		fnm=arg1.asList(String.class).get(0);
	   
	
	}

	@Given("^I have entered lastname into the form$")
	public void i_have_entered_lastname_into_the_form(DataTable arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		page.setLastName(arg1.asList(String.class).get(0));
		System.out.println(arg1.asList(String.class).get(0));
		lnm=arg1.asList(String.class).get(0);
	}

	@When("^I press submit$")
	public void i_press_add() throws Exception {
		

		
		page.setCheck();
		page2.goTo();
		
		
	  
	}
	
	@Then("^the success HTML page should be opened and verified$")
	public void the_success_HTML_page_should_be_opened_and_verified() throws Exception {
	   
	  Assert.assertEquals(fnm,page2.getFName1());
	  Assert.assertEquals(lnm,page2.getLastName1());
	}
	

	


}
                                                                               