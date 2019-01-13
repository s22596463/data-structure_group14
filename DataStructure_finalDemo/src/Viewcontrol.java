import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Viewcontrol {
	
	 KeywordList Keywordlist;

	
	 public Viewcontrol() {	
		 this.Keywordlist = new KeywordList();
	 }
	 
	 public void catchInput(String name,int weight) {
	   Keyword keyword = new Keyword(name, weight);
	   Keywordlist.addtolist(keyword);
	 }
	 
	 //´ú¸Õ¥Î
	 public KeywordList get() {
		 return Keywordlist;
	 }
		
}
