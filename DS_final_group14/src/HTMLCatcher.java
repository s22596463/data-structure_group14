import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class HTMLCatcher {

 // 等待爬取的url
 public static List<String> allwaiturl = new ArrayList<>();
 // 爬取過的url
 private static Set<String> alloverurl = new HashSet<>();
 // 記錄所有url的深度進行爬取判斷
 private static Map<String, Integer> allurldepth = new HashMap<>();
 // 爬取得深度 
 private static int maxdepth = 1;
 
 public static List<String> urlList = new ArrayList<>();

 public String urlStr;
 
 public HTMLCatcher(String urlStr) {
  this.urlStr = urlStr;
 }
 
 public static List<String> workurl(String strurl, int depth) {
   // 判斷當前url是否爬取過
   if (!(alloverurl.contains(strurl) && depth <= maxdepth)) {
   // 創建url爬取核心對象
   try {
    URL url = new URL(strurl);
    // 通過url創建與網頁的連接
    URLConnection conn = url.openConnection();
    // 通過鏈接取得網頁返回的數據
    InputStream is = conn.getInputStream();

    // 一般按行讀取網頁數據，並進行內容分析
    // 因此用BufferedReader和InputStreamReader把字節流轉化為字符流的緩衝流
    // 進行轉換時，需要處理編碼格式問題
    BufferedReader br = new BufferedReader(new InputStreamReader(is, "GB2312"));

   
    String line = null;
    // 正則表達式的匹配規則提取該網頁的鏈接
    Pattern p = Pattern.compile("<a .*href=.+</a>");
   
    while ((line = br.readLine()) != null) {
     Matcher m = p.matcher(line);
     while (m.find()) {
      String href = m.group();
      // 找到超鏈接地址並截取字符串
      // 有無引號
      href = href.substring(href.indexOf("href="));
      if (href.charAt(5) == '\"') {
       href = href.substring(6);
      } else {
       href = href.substring(5);
      }
      // 截取到引號或者空格或者到">"結束
      try {
       href = href.substring(0, href.indexOf("\""));
      } catch (Exception e) {
       try {
        href = href.substring(0, href.indexOf(" "));
       } catch (Exception e1) {
        href = href.substring(0, href.indexOf(">"));
       }
      }
      if (href.startsWith("http:") || href.startsWith("https:")) {
       // 輸出該網頁存在的鏈接
       // System.out.println(href);
       // 將url地址放到隊列中
       allwaiturl.add(href);
       allurldepth.put(href, depth + 1);
       if(!urlList.contains("href"))
    	   urlList.add(href);
      }
     }
    }
    br.close();
   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
     }
   // 將當前url歸列到alloverurl中
   alloverurl.add(strurl);
     }
  return urlList;
 }
}