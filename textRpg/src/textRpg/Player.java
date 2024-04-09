package textRpg;

public class Player extends Unit {
	
	public static Guild guild = Guild.getInstance();
	private Inventory inven;
	
	public Player() {}
	
	public Player(String name, int kind, int level, int maxHp, int power, int def, int exp) {
		super(name, kind, level, maxHp, power, def, exp);
		inven = new Inventory();
	}
	
	@Override
	public void skill(Monster target) {
		// TODO Auto-generated method stub
		super.skill(target);
	}
	
	public void guildMenu() {
		guild.guildMenu();
	}
	
	public void invenMenu() {
		inven.inventoryMenu();
	}
	
	public Inventory getInventory() {
		return this.inven;
	}
}
