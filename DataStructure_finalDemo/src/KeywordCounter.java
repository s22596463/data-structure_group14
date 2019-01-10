import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class KeywordCounter {
	
	private String urlstr;
 	private String content;
 	
	public KeywordCounter(String urlstr) {
		// TODO Auto-generated constructor stub
		this.urlstr = urlstr;
	}
	private String fetchContent() throws IOException{
		URL url = new URL(this.urlstr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String retval = " ";
		String line = null;
		while((line=br.readLine())!=null) {
			retval = retval + line + "\n";
		}
		
		return retval;
	}	
	
	public int countKeyword(String keyword) throws IOException{
		if(content == null) {
		   content = fetchContent();
		}
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
		
		//to do: indexOf(keyword)
		int count = 0;
		int from = 0;
	
		while(content.indexOf(keyword) != -1) {
			count++;
			from = content.indexOf(keyword)+keyword.length();
			content = content.substring(from,content.length());
		}	
		return count;
	}


}
