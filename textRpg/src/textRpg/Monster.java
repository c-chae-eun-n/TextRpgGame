package textRpg;

public abstract class Monster {
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
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void init(int maxHp, int power) {
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.power = power;
	}
	
	public void attack(Unit target) {
		target.setHp(power - target.getDef());
		System.out.println();
		System.out.printf("[%s]가 [%s]에게 %d의 데미지를 입힙니다.\n", name, target.getName(), power - target.getDef());
		
		if(target.getHp() <= 0) {
			System.out.printf("[%s] 🪦사망🪦\n", target.getName());
			target.setHp(0);
		}
	}
	
	@Override
	public String toString() {
		return String.format("[%s] [%d/%d][%d]", name, hp, maxHp, power);
	}
}
