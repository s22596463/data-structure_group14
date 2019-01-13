import java.util.ArrayList;

public class Keyword {

	String name;
	int weight;
	int count;

	public Keyword(String n, int w) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.weight = w;
		this.count = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getCount() {
		return this.count;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setWeight(int w) {
		this.weight = w;
	}
	
	public void setCount(int c) {
		this.count = c;
	}
	
	
}
