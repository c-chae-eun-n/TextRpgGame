package textRpg;

public class Item {
	public static final int WEAPON = 1;
	public static final int AMOR = 2;
	public static final int RING = 3;
	public static final int POTION = 4;
	
	private int kind, power, price;
	private String name;
	
	public Item(String name, int kind, int power, int price) {
		this.kind = kind;
		this.power = power;
		this.price = price;
		this.name = name;
	}
	
	public void printSetItemMenu() {
		System.out.println(GameManager.red + "~~~~~~~~~~~~~ [⛔관리자⛔] ~~~~~~~~~~~~\n");
		System.out.println(" [1]무기        [2]갑옷       [3]장신구\n");
		System.out.println(" [4]포션        [0]뒤로가기\n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + GameManager.exit);
	}
}
