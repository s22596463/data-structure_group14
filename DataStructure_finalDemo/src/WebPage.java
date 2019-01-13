
public class WebPage {

	String name;
	String urlstr;
	int score;

	public WebPage(String n,String u) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.urlstr = u;
		this.score = 0;
	}
	
	
	public String getUrlstr() {
		return this.urlstr;
	}
	
	public void calculate(KeywordList keywordlist) {
		for(int i=0 ; i<keywordlist.getSize() ; i++) {
			int s = keywordlist.getKeyword(i).getCount()*keywordlist.getKeyword(i).getWeight();
		    score += s;
		}
	}
	
	public String getScore() {
		// TODO Auto-generated method stub
		return Integer.toString(score);
	}
	

	
	
	

}
