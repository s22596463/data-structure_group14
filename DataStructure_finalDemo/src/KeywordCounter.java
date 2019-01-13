import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class KeywordCounter {
	
	private String urlstr;
 	private String content;
 	
	public KeywordCounter() {
		// TODO Auto-generated constructor stub
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
		    int count = 0;
		    int from = 0;
	
		    while(content.indexOf(keywordstr) != -1) {
			      count++;
			      from = content.indexOf(keywordstr) + keywordstr.length();
			      content = content.substring(from,content.length());
		    }return count;
	}
	
	public void countEveryKeyword(KeywordList keywordlist) throws IOException {
		
		for(int i=0 ; i>keywordlist.getSize() ; i++) {
			Keyword k = keywordlist.getKeyword(i);
			int count = countKeyword(k);
			k.setCount(count);
		}
	}
	


}
