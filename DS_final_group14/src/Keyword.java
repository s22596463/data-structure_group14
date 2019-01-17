//
public class Keyword {

	String name;
	int weight;
	int count;

	public Keyword(String n) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.weight = 1;
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
