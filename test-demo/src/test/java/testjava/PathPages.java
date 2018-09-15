package testjava;
public class PathPages {

	static String url = "file:///D://mvc-project//eclipse-mars-workspaceNEW//test-demo//src//main//webapp//WEB-INF//LoanApplicationPage.html";
	static String title = "Loan Application Page";
	
	public void goTo() {
		
		Browser.goTo(url);
	}

	public boolean isAt() {
		return Browser.title().equals(title);
	}

	
	
}
