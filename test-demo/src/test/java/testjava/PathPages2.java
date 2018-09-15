package testjava;
public class PathPages2 {

	static String url = "file:///D://mvc-project//eclipse-mars-workspaceNEW//test-demo//src//main//webapp//WEB-INF//Success.html";
	static String title = "Success Page";
	
	public void goTo() {
		
		Browser.goTo(url);
	}

	public boolean isAt() {
		return Browser.title().equals(title);
	}

	
	
}
