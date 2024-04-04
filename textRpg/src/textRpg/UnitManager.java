package textRpg;

import java.util.Vector;

public class UnitManager {
	
	private Vector<Player> playerList = new Vector<>();
	private Vector<Monster> monsterList = new Vector<>();

	private UnitManager() {
		
	}
	
	private static UnitManager instance = new UnitManager();
	
	public UnitManager getInstance() {
		return instance;
	}
}
