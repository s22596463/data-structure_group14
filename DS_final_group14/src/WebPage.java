import java.io.IOException;

public class WebPage{

	String name;
	String urlstr;
	int score;
	KeywordCounter kwc;

	public WebPage(String n,String u) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.urlstr = u;
		this.score = -1;
		kwc = new KeywordCounter(this);
	}
	
	public String getUrlstr() {
		return this.urlstr;
	}
	
	public String getName() {
		return this.name;
	}
	

	public int getScore(String k) throws IOException {
		
		if(score == -1)
			score = kwc.countKeyword(k);
		return score;
    }


}