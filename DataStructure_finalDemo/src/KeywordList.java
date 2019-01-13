import java.util.ArrayList;

public class KeywordList {

	ArrayList<Keyword> list;
	
	public KeywordList() { 
		// TODO Auto-generated constructor stub
		list = new ArrayList<Keyword>();
	}

	public void addtolist(Keyword k) {
		// TODO Auto-generated method stub
		list.add(k);
	}
	
	public Keyword getKeyword(int i) {
		return list.get(i);
	}
	
	public int getSize() {
		return list.size();
	}
}
 