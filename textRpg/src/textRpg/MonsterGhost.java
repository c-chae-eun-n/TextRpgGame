package textRpg;

public class MonsterGhost extends Monster {
	public MonsterGhost(){
		setName("유령👻");
	}
	
	@Override
	public void skill(Player target) {
		System.out.println(GameManager.yellow + " [" + getName() + "] 암흑 스킬-!");
		target.setStun(true);
		System.out.println(" ["+getName()+"] ["+target.getName()+"]에게 💫스턴💫\n" + GameManager.exit);
	}
}
