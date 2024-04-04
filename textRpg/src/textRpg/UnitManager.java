package textRpg;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	
	private Random random = new Random();
	private Player player = new Player();
	
	private Vector<Player> playerList = new Vector<>();
	private Vector<Monster> monsterList = new Vector<>();
	
	private String path = "textRpg.";
	private String monsters[] = {"MonsterGhost","MonsterWolf","MonsterBat"};

	private UnitManager() {
		
	}
	
	private static UnitManager instance = new UnitManager();
	
	public UnitManager getInstance() {
		return instance;
	}
	
	public void init() {
		player.init();
	}
}
