package textRpg;

import java.util.Vector;

public class UnitManager {
	
	private Vector<Player> playerList;
	private Vector<Monster> monsterList;
	
	private String path = "textRpg.";
	private String monsters[] = {"MonsterGhost","MonsterWolf","MonsterBat"};

	private UnitManager() {
		playerList = new Vector<>();
		monsterList = new Vector<>();
	}
	
	private static UnitManager instance = new UnitManager();
	
	public static UnitManager getInstance() {
		return instance;
	}
	
	public void create(Player player) {
		playerList.add(player);
	}
	
	public void monsterRandomSet(int size) {
		for(int i=0; i<size; i++) {
			int rIdx = GameManager.random.nextInt(monsters.length);
			try {
				Class<?> clazz = Class.forName(path + monsters[rIdx]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Monster monster = (Monster) obj;
				
				int hp = GameManager.random.nextInt(100) + 100;
				int power = GameManager.random.nextInt(10) + 10;
				monster.init(hp, power);
				monsterList.add(monster);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
