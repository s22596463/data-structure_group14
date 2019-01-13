import java.util.ArrayList;

public class Keyword {

	String name;
	int weight;
	int count;

	public Keyword(String n, int w) {
		// TODO Auto-generated constructor stub
		name = n;
		weight = w;
		count = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getCount() {
		return count;
	}

	public void setName(String n) {
		name = n;
	}

	public void setWeight(int w) {
		weight = w;
	}
	
	public void setCount(int c) {
		count = c;
	}
	
	
}
