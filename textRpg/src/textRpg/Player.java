package textRpg;

public class Player extends Unit {
	
	public static Guild guild = Guild.getInstance();
	public static Inventory inven = Inventory.getInstance();
	
	public Player() {}
	
	public Player(String name, int level, int maxHp, int power, int def, int exp) {
		super(name, level, maxHp, power, def, exp);
	}
	
	@Override
	public void skill(Monster target) {
		// TODO Auto-generated method stub
		super.skill(target);
	}
	
	public void guildMenu() {
		guild.guildMenu();
	}
}
