package textRpg;

public abstract class Monster {
	private int hp, maxHp, power;
	private String name;
	private boolean isStun;
	
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

	public boolean isStun() {
		return isStun;
	}

	public void setStun(boolean isStun) {
		this.isStun = isStun;
	}
	
	public void init(int maxHp, int power) {
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.power = power;
	}
	
	public void attack(Player target) {
		target.setHp(target.getHp()-power);
		System.out.printf(" [%s] [%s]에게 %d 데미지를 입혔다!\n\n", name, target.getName(), power);
		
		if(target.getHp() <= 0) {
			System.err.printf("          [%s] 🪦사망🪦\n\n", target.getName());
			target.setHp(0);
		}
	}
	
	public abstract void skill(Player target);
	
	@Override
	public String toString() {
		return String.format("[%s] [%d/%d][%d]", name, hp, maxHp, power);
	}
}
