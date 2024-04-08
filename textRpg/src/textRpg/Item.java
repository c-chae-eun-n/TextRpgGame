package textRpg;

public class Item {
	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int RING = 3;
	public static final int POTION = 4;
	public static final int ADMIN = 5;
	
	private int kind, power, price;
	private String name;
	
	public Item(String name, int kind, int power, int price) {
		this.kind = kind;
		this.power = power;
		this.price = price;
		this.name = name;
	}
	
	public int getKind() {
		return kind;
	}

	public int getPower() {
		return power;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

}
