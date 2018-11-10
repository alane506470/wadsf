package Springmvc9.test1.collections;

public class Item {
	
	private final String name;
	private final int weight;
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
	//可以再構照函數中設置他們
	public Item(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", weight=" + weight + "]";
	}
	
	
	
}
