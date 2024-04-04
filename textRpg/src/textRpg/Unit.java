package textRpg;

public class Unit {
	private String name;
	private int level, hp, maxHp, power, def, exp, potion;
	private boolean isStun, isShield;
	private boolean party;
	private Item weapon, armor, ring;
	
	public Unit() {
		
	}
	
	public Unit(String name, int level, int hp, int power, int def, int exp) {
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = hp;
		this.power = power;
		this.def = def;
		this.exp = exp;
		this.potion = 0;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
}
