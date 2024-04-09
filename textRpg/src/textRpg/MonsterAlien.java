package textRpg;

public class MonsterAlien extends Monster {
	public MonsterAlien() {
		setName("에일리언👾");
	}

	@Override
	public void skill(Player target) {
		System.out.println(GameManager.yellow + " [" + getName() + "] 물어뜯기-!");
		target.setHp(target.getHp()-(getPower()*2));
		System.out.println(" ["+getName()+"] ["+target.getName()+"]에게 "+(getPower()*2)+" 데미지를 입혔다!\n" + GameManager.exit);
		if(target.getHp() <= 0) {
			System.out.printf(GameManager.red + "          [%s] 🪦사망🪦\n\n", target.getName() + GameManager.exit);
			target.setHp(0);
		}
	}

}
