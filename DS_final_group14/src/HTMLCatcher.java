import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class HTMLCatcher {

 // ���ݪ�����url
 public static List<String> allwaiturl = new ArrayList<>();
 // �����L��url
 private static Set<String> alloverurl = new HashSet<>();
 // �O���Ҧ�url���`�׶i�檦���P�_
 private static Map<String, Integer> allurldepth = new HashMap<>();
 // �����o�`�� 
 private static int maxdepth = 1;
 
 public static List<String> urlList = new ArrayList<>();

 public String urlStr;
 
 public HTMLCatcher(String urlStr) {
  this.urlStr = urlStr;
 }
 
 public static List<String> workurl(String strurl, int depth) {
   // �P�_��eurl�O�_�����L
   if (!(alloverurl.contains(strurl) && depth <= maxdepth)) {
   // �Ы�url�����֤߹�H
   try {
    URL url = new URL(strurl);
    // �q�Lurl�ЫػP�������s��
    URLConnection conn = url.openConnection();
    // �q�L�챵���o������^���ƾ�
    InputStream is = conn.getInputStream();

    // �@�����Ū�������ƾڡA�öi�椺�e���R
    // �]����BufferedReader�MInputStreamReader��r�`�y��Ƭ��r�Ŭy���w�Ĭy
    // �i���ഫ�ɡA�ݭn�B�z�s�X�榡���D
    BufferedReader br = new BufferedReader(new InputStreamReader(is, "GB2312"));

   
    String line = null;
    // ���h��F�����ǰt�W�h�����Ӻ������챵
    Pattern p = Pattern.compile("<a .*href=.+</a>");
   
    while ((line = br.readLine()) != null) {
     Matcher m = p.matcher(line);
     while (m.find()) {
      String href = m.group();
      // ���W�챵�a�}�úI���r�Ŧ�
      // ���L�޸�
      href = href.substring(href.indexOf("href="));
      if (href.charAt(5) == '\"') {
       href = href.substring(6);
      } else {
       href = href.substring(5);
      }
      // �I����޸��Ϊ̪Ů�Ϊ̨�">"����
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
       // ��X�Ӻ����s�b���챵
       // System.out.println(href);
       // �Nurl�a�}��춤�C��
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
   // �N��eurl�k�C��alloverurl��
   alloverurl.add(strurl);
     }
  return urlList;
 }
}