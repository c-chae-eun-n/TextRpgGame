package textRpg;

public class Unit {
	private String name;
	private int level, hp, maxHp, power, def, maxExp, exp, potion;
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
		this.setParty(false);
		this.setWeapon(null);
		this.setArmor(null);
		this.setRing(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
	public int getMaxExp() {
		return maxExp;
	}
	
	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getPotion() {
		return potion;
	}

	public void setPotion(int potion) {
		this.potion = potion;
	}

	public boolean isStun() {
		return isStun;
	}

	public void setStun(boolean isStun) {
		this.isStun = isStun;
	}

	public boolean isShield() {
		return isShield;
	}

	public void setShield(boolean isShield) {
		this.isShield = isShield;
	}

	public boolean isParty() {
		return party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmor() {
		return armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing() {
		return ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}
	
	public void printStatus() {
		System.out.printf("     [%s][lv.%d]     (Party : %b)\n", level, party);
		System.out.printf("[HP    :  %d]\n", hp);
		System.out.printf("[DEF   :  %d]\n", def);
		System.out.printf("[POWER :  %d]\n", power);
		if(maxExp/exp > 1) {
			System.out.printf("(%d/%d ■■■■■■■■■■■■  )\n", exp, maxExp);
		}else if(maxExp/exp > 2) {
			System.out.printf("(%d/%d ■■■■■■■■      )\n", exp, maxExp);
		}else if(maxExp/exp > 3) {
			System.out.printf("(%d/%d ■■■■          )\n", exp, maxExp);
		}
	}
	
	public void printItem() {
		if(weapon == null) {
			System.out.println("[⚔️무기⚔️ : 없음]");
		} else {
			
		}
		if(armor == null) {
			System.out.println("[🛡️방어구🛡️ : 없음]");
		} else {
			
		}
		if(ring == null) {
			System.out.println("[💍반지💍 : 없음]");
		} else {
			
		}
		if(potion == 0) {
			System.out.println("[🧪물약🧪 : 없음]");
		} else {
			
		}
	}
	
}
