import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class KeywordCounter {

	String urlstr;
 	String content;

	public KeywordCounter(WebPage w) {
		// TODO Auto-generated constructor stub
		this.urlstr = w.getUrlstr();
	}

	public String fetchContent() throws IOException {
		String retVal = "";
		URL url = new URL(this.urlstr);
		URLConnection conn = url.openConnection();
		InputStreamReader in = new InputStreamReader(conn.getInputStream(),"UTF8");
		BufferedReader bf = new BufferedReader(in);
		String line = null;
		while((line = bf.readLine()) != null){
			retVal += line + "\n";
		}
		
		return retVal;
	}
	
	public int countKeyword(String k) throws IOException{
		
		   if(content == null) {
		      content = fetchContent();
		   }
		   content = content.toUpperCase();
		   String keywordstr = k;
		   keywordstr = keywordstr.toUpperCase();
		
		    //to do: indexOf(keyword)
		    int c = 0;
		    int from = 0;
	
		    while(content.indexOf(keywordstr) != -1) {
			      c++;
			      from = content.indexOf(keywordstr) + keywordstr.length();
			      content = content.substring(from,content.length());
		    }
		    return c;
	}
	
}
