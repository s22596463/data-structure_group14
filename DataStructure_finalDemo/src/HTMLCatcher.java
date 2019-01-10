import java.net.URL;	
import java.io.*;
import java.net.URLConnection;

	 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class HTMLCatcher {
	 

	

	public static void main(String[] args) throws IOException {

	URL url = new URL("https://2018elections.tvbs.com.tw/#");
	
	URLConnection conn = url.openConnection();

	conn.connect();

	String type = conn.getContentType();

	System.out.println("Context: "+type);

	

	InputStreamReader in = new InputStreamReader(conn.getInputStream(),"UTF-8");

	int data = in.read();

	while (data != -1){

	System.out.print((char)data);

	data = in.read();

	}

	in.close();

	}

	}
