package textRpg;

public class UnitManager {

	private UnitManager() {
		
	}
	
	private static UnitManager instance = new UnitManager();
	
	public UnitManager getInstance() {
		return instance;
	}
}
