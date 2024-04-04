package textRpg;

public class Player extends Unit {
	
	public static int money;
	public static Guild guild = new Guild();
	public static Inventory inven = new Inventory();
	
	

	public void init() {
		money = 1000;
	}
}
