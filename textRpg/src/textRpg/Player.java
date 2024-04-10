package textRpg;

public class Player extends Unit {
	
	public static Guild guild = Guild.getInstance();
	private Inventory inven;
	
	public Player() {}
	
	public Player(String name, int kind, int level, int maxHp, int power, int def, int exp) {
		super(name, kind, level, maxHp, power, def, exp);
		inven = new Inventory();
	}
	
	public void skill(Player p, Monster target) {
		if(p.getKind() == Unit.WARRIOR) {
			warriorSkill(p, target);
		}
		else if(p.getKind() == Unit.WIZARD) {
			wizardSkill(p, target);
		}
		else if(p.getKind() == Unit.HEALER) {
			healerSkill(p, target);
		}
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
	
	private void warriorSkill(Player p, Monster target) {
		System.out.println(GameManager.yellow + " [" + getName() + "] 쉴드 발동!!");
		p.setShield(true);
		target.setHp(target.getHp()-getPower()/2);
		System.out.println(" [" + target.getName() + "]가 " + "쉴드 효과에 " + getPower()/2 + " 데미지를 입었다!!\n" + GameManager.exit);
		if(target.getHp() <= 0) {
			System.out.println(GameManager.red + "       [" + target.getName() + "]을(를) 처치했습니다.\n" + GameManager.exit);
			target.setHp(0);
			p.getRandomPotion();
		}
	}
	
	private void wizardSkill(Player p, Monster target) {
		
	}
	
	private void healerSkill(Player p, Monster target) {
		
	}
}
