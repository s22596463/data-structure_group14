import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Facade {
	
	String outcome1;
	WebPage p1 = new WebPage("¤T¥ß","https://www.setn.com/Klist.aspx?ProjectID=5301&PageType=6");
    
	public Facade() {
		
	} 
    
	public void execute(KeywordList kl) throws IOException {
		
		KeywordCounter kc = new KeywordCounter(this.p1);
		kc.countEveryKeyword(kl);
	    p1.calculate(kl); 
	}
	
	public String showOutcome() {
		return p1.getScore();
	}
	

	}
	
	
	



		

