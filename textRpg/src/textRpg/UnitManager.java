package textRpg;

import java.util.ArrayList;

public class UnitManager {
	
	private ArrayList<Player> playerList;
	private ArrayList<Monster> monsterList;
	
	private String path = "textRpg.";
	private String monsters[] = {"MonsterGhost","MonsterAlien","MonsterBat"};

	private UnitManager() {
		playerList = new ArrayList<>();
		monsterList = new ArrayList<>();
	}
	
	private static UnitManager instance = new UnitManager();
	
	public static UnitManager getInstance() {
		return instance;
	}
	
	public void create(Player player) {
		playerList.add(player);
	}
	
	public ArrayList<Monster> monsterRandomSet(int size) {
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
		
		return monsterList;
	}
	
	public void clearMonsterList() {
		monsterList.clear();
	}
}
