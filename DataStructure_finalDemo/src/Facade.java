import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Facade extends UserInterface{
	
	KeywordList userlist = viewcontrol.getInput();
    WebPage p1 = new WebPage("¤T¥ß","https://www.setn.com/Klist.aspx?ProjectID=5301&PageType=6");
    
    
	public String execute() throws IOException {
	    p1.countEveryKeyword(userlist);
	    //System.out.println(p1.calculate(userlist));
	    //System.out.println(userlist.getKeyword(0));
	    String outcome1 = ""+p1.calculate(userlist);
	    return outcome1;
	}
	
	
	

}   

		

