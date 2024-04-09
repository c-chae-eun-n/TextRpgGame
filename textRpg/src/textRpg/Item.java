package textRpg;

public class Item {
	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int RING = 3;
	public static final int ADMIN = 4;
	
	private int kind, power, price;
	private String name;
	
	public Item(String name, int kind, int power, int price) {
		this.name = name;
		this.kind = kind;
		this.power = power;
		this.price = price;
	}
	
	public int getKind() {
		return this.kind;
	}

	public int getPower() {
		return this.power;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return String.format("%s    power : %d    %d원\n", name, power, price);
	}
}
