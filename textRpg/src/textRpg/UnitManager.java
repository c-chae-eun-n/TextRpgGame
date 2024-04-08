package textRpg;

import java.util.Vector;

public class UnitManager {
	
	public Player player = new Player();
	
	private Vector<Player> playerList = new Vector<>();
	private Vector<Monster> monsterList = new Vector<>();
	
	private String path = "textRpg.";
	private String monsters[] = {"MonsterGhost","MonsterWolf","MonsterBat"};

	private UnitManager() {
		
	}
	
	private static UnitManager instance = new UnitManager();
	
	public static UnitManager getInstance() {
		return instance;
	}
	
	public void init() {
		player.init();
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
