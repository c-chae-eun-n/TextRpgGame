package textRpg;

public class MonsterBat extends Monster {
	public MonsterBat() {
		setName("박쥐🦇");
	}

	@Override
	public void skill(Player target) {
		System.out.println(GameManager.yellow + " [" + getName() + "] 바람일으키기-! 생명력 흡혈!!");
		target.setHp(target.getHp()-(getPower()*2));
		setHp(getHp()+(getPower()*2));
		System.out.println(" [" + getName() + "] " + "[" + target.getName() + "]의 " + getPower()*2 + " 생명력 흡혈!!\n" + GameManager.exit);
		if(target.getHp() <= 0) {
			System.out.printf(GameManager.red + "          ["+target.getName()+"] 🪦사망🪦\n\n" + GameManager.exit);
			target.setHp(0);
		}
	}
}
