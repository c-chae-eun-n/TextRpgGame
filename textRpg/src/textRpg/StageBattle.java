package textRpg;

import java.util.ArrayList;

public class StageBattle extends Stage {

	private UnitManager unitManager = null;
	private ArrayList<Monster> monsterList = new ArrayList<>();
	private int monsterDead, playerDead, playerSize;
	
	public StageBattle() {
		unitManager = UnitManager.getInstance();
	}
	
	@Override
	public boolean update() {
		boolean run = true;
		int pIndex = 0;
		int mIndex = 0;
		boolean turn = true;
		
		while(true) {
			if(turn) {
				printStatus();
//				int n = GameManager.scan.nextInt();
				if(pIndex < playerSize) {
					pIndex ++;
				}
			}else if(!turn) {
				
			}
			checkLive();
			if(monsterDead <= 0 || playerDead <= 0)
				break;
		}
		return false;
	}

	@Override
	public void init() {
		playerSize = Player.guild.guildListSize();
		unitManager.clearMonsterList();
		int rNum = GameManager.random.nextInt(3)+3;
		monsterList = unitManager.monsterRandomSet(rNum);
		monsterDead = monsterList.size();
		playerDead = playerSize;
	}

	private void printStatus() {
		System.out.printf("~~~~~~~~ [⚔️%d VS %d BATTLE⚔️] ~~~~~~~~\n\n", playerDead, monsterDead);
		System.out.println("~~~~~~~~~~~ [🧙‍♀️PLAYER🧙‍♀️] ~~~~~~~~~~~~\n");
		for(int i=0; i<playerSize; i++) 
			System.out.println("     "+Player.guild.getGuildList(i));
		System.out.println("\n~~~~~~~~~~~ [💀MONTER💀] ~~~~~~~~~~~~\n");
		for(int i=0; i<monsterList.size(); i++) 
			System.out.println("      "+monsterList.get(i));
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	private void checkLive() {
		int num = 0;
		for (int i=0; i<playerSize; i++) {
			if (Player.guild.getGuildList(i).getHp() <= 0) {
				num += 1;
			}
		}
		playerDead = playerSize - num;
		num = 0;
		for (int i=0; i<monsterList.size(); i++) {
			if (monsterList.get(i).getHp() <= 0) {
				num += 1;
			}
		}
		monsterDead = monsterList.size() - num;

	}
}
