package textRpg;

public class Player extends Unit {
	
	public static Guild guild = Guild.getInstance();
	private Inventory inven;
	
	public Player() {}
	
	public Player(String name, int kind, int level, int maxHp, int power, int def, int exp) {
		super(name, kind, level, maxHp, power, def, exp);
		inven = new Inventory();
	}
	
	public Player(String name, int kind, int level, int hp, int maxHp, int power, int def, int maxExp, int exp, int potion, int money, boolean party, Item weapon, Item armor, Item ring) {
		super(name, kind, level, hp, maxHp, power, def, maxExp, exp, potion, money, party, weapon, armor, ring);
	}
	
	public void skill(Player p, Monster target) {
		if(p.getKind() == Unit.WARRIOR) {
			warriorSkill(p, target);
		}
		else if(p.getKind() == Unit.WIZARD) {
			wizardSkill(p, target);
		}
		else if(p.getKind() == Unit.HEALER) {
			healerSkill();
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
		int rNum = GameManager.random.nextInt(2)+2;
		System.out.println(GameManager.yellow + "     [" + getName() + "] " + rNum + "배 공격력 강화!!");
		target.setHp(target.getHp()-getPower()*rNum);
		System.out.println("     [" + target.getName() + "]에게 " + getPower()*rNum + " 데미지를 입혔다!\n" + GameManager.exit);
		if(target.getHp() <= 0) {
			System.out.println(GameManager.red + "       [" + target.getName() + "]을(를) 처치했습니다.\n" + GameManager.exit);
			target.setHp(0);
			p.getRandomPotion();
		}
	}
	
	private void healerSkill() {
		System.out.println(GameManager.yellow + "     [" + getName() + "] 전 길드원 🧪HP🧪 회복!!\n" + GameManager.exit);
		for(int i=0; i<Player.guild.guildListSize(); i++) {
			int rNum = GameManager.random.nextInt(50)+30;
			Player player = Player.guild.getGuildList(i);
			if(player.getHp() == 0)
				continue;
			
			player.setHp(player.getHp()+rNum);
			if(player.getHp() >= player.getMaxHp())
				player.setHp(player.getMaxHp());
		}
	}
}
