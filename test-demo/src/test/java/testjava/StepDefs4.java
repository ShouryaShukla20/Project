package testjava;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs4 {
	 private LoanApplicationPage page=new LoanApplicationPage();
	 private Success page2=new Success();
	 String fnm,lnm; static int i=1;
	
	 @Given("^I am on LoanApplicationPagee$")
	 public void i_am_on_LoanApplicationPagee() throws Exception {
		  page.goTo();
		    Assert.assertTrue(page.isAt());
	 }

	 @Given("^I have entered \"([^\"]*)\" into the form$")
	 public void i_have_entered_into_the_form(String arg1) throws Exception {
		 System.out.println(arg1);
			page.setFirstName(arg1);
			fnm=arg1;
	 }

	 @Given("^I have also entered \"([^\"]*)\" into the form$")
	 public void i_have_also_entered_into_the_form(String arg1) throws Exception {
		 page.setLastName(arg1);
			System.out.println(arg1);
			lnm=arg1;
	 }

	 @When("^I press submitt$")
	 public void i_press_submitt() throws Exception {

			page.setCheck();
			page2.goTo();
	 }

	 @Then("^the success HTML page should be opened and verifiedd$")
	 public void the_success_HTML_page_should_be_opened_and_verifiedd() throws Exception {
		
		 if(i==2){
			 System.out.println(i+"****");
			 Assert.assertEquals(fnm,page2.getFName2());
			 
			 Assert.assertEquals(lnm,page2.getLastName2());
			 i=0;
		 }
		 if(i==1){
			 System.out.println(i+"*-*-*-*");
		 Assert.assertEquals(fnm,page2.getFName1());
		 
		 Assert.assertEquals(lnm,page2.getLastName1());
		 i++;
	 }
		
	 }

	

	


}
                                                                               