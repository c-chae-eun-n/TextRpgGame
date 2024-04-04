package textRpg;

public class Player extends Unit {
	
	public static int money;
	public static Guild guild = new Guild();
	public static Inventory inven = new Inventory();
	
	public Player() {}
	
	public Player(String name, int level, int maxHp, int power, int def, int exp) {
		super(name, level, maxHp, power, def, exp);
	}
	

	public void init() {
		money = 1000;
	}
	
}
