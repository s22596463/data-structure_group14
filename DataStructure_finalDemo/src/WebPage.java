
public class WebPage extends KeywordCounter{


	String name;
	String url;
	
	
	public WebPage(String n,String u) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.url = u;
	}
	
	public int calculate(KeywordList keywordlist) {
		int score = 0;
		for(int i=0 ; i>keywordlist.getSize() ; i++) {
			Keyword k = keywordlist.getKeyword(i);
			int s = k.getCount()*k.getWeight();
			score = score + s;
		}return score;
	}
	

	
	
	

}
