
public class Viewcontrol {
	
	 KeywordList Keywordlist = new KeywordList();
	 
	 public void catchInput(String name,int weight) {
	
	   Keyword keyword = new Keyword(name, weight);
	   Keywordlist.addtolist(keyword);
	   System.out.print(name+weight);
	 }
	
	 public KeywordList getInput() {
		 return Keywordlist;
	 }
	
	
	
	
	
}
