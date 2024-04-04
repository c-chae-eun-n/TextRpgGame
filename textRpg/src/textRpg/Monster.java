package textRpg;

public class Monster {
	private int hp, maxHp, power;
	private String name;
	
	public Monster() {
		
	}
	
	public Monster(String name, int maxHp, int power) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.power = power;
	}
	
	public void init(int maxHp, int power) {
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.power = power;
	}
}
