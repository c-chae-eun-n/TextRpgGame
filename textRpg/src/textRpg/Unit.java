package textRpg;

public class Unit {
	public static final int WARRIOR = 1;
	public static final int WIZARD = 2;
	public static final int HEALER = 3;
	
	private String name;
	private int kind, level, hp, maxHp, power, def, maxExp, exp, potion, money;
	private boolean isStun, isShield;
	private boolean party;
	private Item weapon, armor, ring;
	
	public Unit() {
		
	}
	
	public Unit(String name, int kind ,int level, int hp, int power, int def, int exp) {
		this.name = name;
		this.kind = kind;
		this.level = level;
		this.maxHp = hp;
		this.hp = hp;
		this.power = power;
		this.def = def;
		this.exp = exp;
		this.maxExp = 143;	//
		this.potion = 0;
		this.money = 1000;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	
	public Unit(String name, int kind, int level, int hp, int maxHp, int power, int def, int maxExp, int exp, int potion, int money, boolean party, Item weapon, Item armor, Item ring) {
		this.name = name;
		this.kind = kind;
		this.level = level;
		this.hp = hp;
		this.maxHp = maxHp;
		this.power = power;
		this.def = def;
		this.maxExp = maxExp;
		this.exp = exp;
		this.potion = potion;
		this.money = money;
		this.party = party;
		this.weapon = weapon;
		this.armor = armor;
		this.ring = ring;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKind() {
		return kind;
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
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
		String info = "";
		if(kind == WARRIOR)
			info = "전사";
		else if(kind == WIZARD)
			info = "마법사";
		else if(kind == HEALER)
			info = "힐러";
		System.out.printf("  [%s(%s)][lv.%d] (Party : %b)\n", name, info, level, party);
		System.out.println();
		System.out.printf("            [HP    :  %d]\n", hp);
		System.out.printf("            [DEF   :  %d]\n", def);
		System.out.printf("            [POWER :  %d]\n", power);
		System.out.println();
		if(exp != 0 && maxExp/exp < 2) {
			System.out.printf("       (%d/%d ■■■■■■■■■■■■  )\n", exp, maxExp);
		}else if(exp != 0 && maxExp/exp < 3) {
			System.out.printf("       (%d/%d ■■■■■■■       )\n", exp, maxExp);
		}else {
			System.out.printf("       (%d/%d ■■■■          )\n", exp, maxExp);
		}
	}
	
	public void printItem() {
		System.out.println("~~~~~~~~~~~~ [🎒내 장비🎒] ~~~~~~~~~~~~\n");
		System.out.printf("             [%s][lv.%d]\n", name, level, party);
		if(weapon == null) {
			System.out.println("           [⚔️무기⚔️  : 없음]");
		} else {
			System.out.println("           [⚔️무기⚔️  : "+weapon.getName()+"]");
		}
		if(armor == null) {
			System.out.println("           [🛡️방어구🛡️ : 없음]");
		} else {
			System.out.println("           [🛡️방어구🛡️ : "+armor.getName()+"]");
		}
		if(ring == null) {
			System.out.println("           [💍반지💍  : 없음]");
		} else {
			System.out.println("           [💍반지💍  : "+ring.getName()+"]");
		}
		if(potion == 0) {
			System.out.println("           [🧪포션🧪  : 없음]");
		} else {
			System.out.println("           [🧪포션🧪  : "+getPotion()+"개]");
		}
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public void attack(Monster target) {
		target.setHp(target.getHp()-power);
		System.out.println("     [" + target.getName() + "]에게 " + power + " 데미지를 입혔다!\n");
		if(target.getHp() <= 0) {
			System.out.println(GameManager.red + "       [" + target.getName() + "]을(를) 처치했습니다.\n" + GameManager.exit);
			target.setHp(0);
			getRandomPotion();
		}
	}
	
	public void getRandomPotion() {
		int rNum = GameManager.random.nextInt(4);
		if(rNum != 0) {
			setPotion(getPotion() + rNum);
			System.out.printf("       [%s] 🧪포션🧪 %d개 획득!\n\n", name, rNum);
		}
	}
	
	public void healHp() {
		if(getPotion() == 0) {
			System.err.println("       🧪포션🧪 부족!! 회복 불가!!\n");
			return;
		}
		int rNum = GameManager.random.nextInt(50)+30;
		setHp(getHp()+rNum);
		setPotion(getPotion()-1);
		System.out.printf("       [%s] 🧪HP🧪 %d 회복!\n\n", name, rNum);
	}
	
	@Override
	public String toString() {
		String info = "";
		if(kind == WARRIOR)
			info = "전사";
		else if(kind == WIZARD)
			info = "마법사";
		else if(kind == HEALER)
			info = "힐러";
		return String.format("[%s (%s)] [%d/%d][%d]", name, info, hp, maxHp, power);
	}
}
