import java.io.IOException;

public class Test {

	//測試用的
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Viewcontrol vw = new Viewcontrol();
		String s1 = "新聞";
		String s2 = "5";
		vw.catchInput(s1, Integer.parseInt(s2));
		//vw.get().getKeyword(0).getName();
		Facade facade = new Facade();
		facade.execute(vw.get());
		/*Keyword kw = new Keyword("新聞",5);
		WebPage p1 = new WebPage("三立","https://www.setn.com/Klist.aspx?ProjectID=5301&PageType=6");
		KeywordCounter kc = new KeywordCounter(p1);
		kc.countEveryKeyword(vw.get());
		p1.calculate(vw.get());*/
		//System.out.println(facade.showOutcome());
		
		
		/*KeywordList kl = new KeywordList();
		kl.addtolist(kw);
		System.out.println(kl.getKeyword(0).getName());
		WebPage p1 = new WebPage("三立","https://www.setn.com/Klist.aspx?ProjectID=5301&PageType=6");
		KeywordCounter kc = new KeywordCounter(p1);
		kc.countEveryKeyword(kl);
		//kl.getKeyword(0).setCount(kc.countKeyword(kl.getKeyword(0)));
		System.out.println(kl.getKeyword(0).getCount());
		
		System.out.println(kl.getKeyword(0).getCount()*kl.getKeyword(0).getWeight());
		p1.calculate(kl);
		System.out.println(p1.getScore());*/
		
	}

}
