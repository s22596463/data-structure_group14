import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Facade {
	
	String outcome1;
	String outcome2;
	WebPage p1 = new WebPage("三立","https://www.setn.com/Klist.aspx?ProjectID=5301&PageType=6");
	WebPage p2 = new WebPage("TVBS","https://2018elections.tvbs.com.tw/#");
	WebPage p3 = new WebPage("民視","https://news.ftv.com.tw/news/tag/2018%E9%81%B8%E8%88%89");
	WebPage p4 = new WebPage("聯合","https://udn.com/search/tagging/2/%E4%B9%9D%E5%90%88%E4%B8%80%E9%81%B8%E8%88%89");
	
	public Facade() {
		
	} 
    
	public void execute(KeywordList kl) throws IOException {
		
		KeywordCounter kc1 = new KeywordCounter(this.p1);
		kc1.countEveryKeyword(kl);
	    p1.calculate(kl); 
	    
	    KeywordCounter kc2 = new KeywordCounter(this.p2);
		kc2.countEveryKeyword(kl);
	    p2.calculate(kl);   
	    
	    KeywordCounter kc3 = new KeywordCounter(this.p3);
		kc3.countEveryKeyword(kl);
	    p3.calculate(kl); 
	    
	    KeywordCounter kc4 = new KeywordCounter(this.p4);
		kc4.countEveryKeyword(kl);
	    p4.calculate(kl); 
	      
	}
	
	public String showOutcome1() {
		return p1.getScore();
	}
	
	public String showOutcome2() {
		return p2.getScore();
	}

	public String showOutcome3() {
		return p3.getScore();
	}
	
	public String showOutcome4() {
		return p4.getScore();
	}
	
	}
	
	
	



		

