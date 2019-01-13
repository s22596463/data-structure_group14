import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class KeywordCounter{
	
	String urlstr;
 	String content;

	public KeywordCounter(WebPage w) {
		// TODO Auto-generated constructor stub
		this.urlstr = w.getUrlstr();
	}

	public String fetchContent() throws IOException {
		
		URL url = new URL(this.urlstr);
		String retVal = "";
		URLConnection conn = url.openConnection();
		InputStreamReader in = new InputStreamReader(conn.getInputStream(),"UTF8");
		BufferedReader bf = new BufferedReader(in);
		String line = null;
		while((line = bf.readLine()) != null){
			retVal += line + "\n";
		}
		return retVal;
	}
	
	public int countKeyword(Keyword k) throws IOException{
		
		   if(content == null) {
		      content = fetchContent();
		   }
		   content = content.toUpperCase();
		   String keywordstr = k.getName();
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
	
	public void countEveryKeyword(KeywordList kl) { 
		for(int i=0 ; i<kl.getSize() ; i++) {
			try {
				kl.getKeyword(i).setCount(countKeyword(kl.getKeyword(i)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	


}
