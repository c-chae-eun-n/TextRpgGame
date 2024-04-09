package textRpg;

import java.util.ArrayList;

public class StageBattle extends Stage {

	private UnitManager unitManager = null;
	private ArrayList<Monster> monsterList = new ArrayList<>();
	private int monsterDead, playerDead;
	
	public StageBattle() {
		unitManager = UnitManager.getInstance();
	}
	
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
