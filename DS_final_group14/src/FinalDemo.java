
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FinalDemo
 */
@WebServlet("/FinalDemo")
public class FinalDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinalDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if (request.getParameter("searchkeyword") == null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}

		GoogleQuery google = new GoogleQuery(request.getParameter("searchkeyword")+"政治選舉");
		HashMap<String, String> query = google.query();

		String keyword = request.getParameter("keyword");

		List<WebPage> sorts = new ArrayList<WebPage>();

		for (Entry<String, String> entry : query.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
			try {
                //不做子網頁的話				
                //WebPage sk = new WebPage(key, value);
                //sk.getScore(keyword);
                //sort(sorts, sk);
		
				WebPage rootpage = new WebPage(key, value);
				WebTree tree = new WebTree(rootpage);
				HTMLCatcher hCatcher = new HTMLCatcher(value);
				hCatcher.workurl(value, 1);
				System.out.println(hCatcher.urlList.size());
				for(int h=0 ; h<hCatcher.urlList.size();h+=5) {
										
					tree.root.addChild(new WebNode(new WebPage("",hCatcher.urlList.get(h))));
				}
				tree.setPostOrderScore(keyword);
				sort(sorts,rootpage);
				System.out.println("sort end");
          						
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String[][] s = new String[sorts.size()][2];
		for (int i = 0; i < sorts.size(); i++) {
			s[i][0] = sorts.get(i).getName() + " ";
			System.out.println(s[i][0]);
			s[i][1] = sorts.get(i).getUrlstr();
		}

		request.setAttribute("query", s);

		request.getRequestDispatcher("googleitem.jsp").forward(request, response);

	}

	public void sort(List<WebPage> sorts, WebPage webPage) {
		if (sorts.size() == 0)
			sorts.add(webPage);
		else {
			for (int i = sorts.size() - 1; i >= -1; i--) {
				if (i == -1) {
					sorts.add(0, webPage);
					break;
				}
				if (sorts.get(i).score >= webPage.score) {
					sorts.add(i + 1, webPage);
					break;
				}

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
