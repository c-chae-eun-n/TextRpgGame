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
		int pIndex = 0;
		int mIndex = 0;
		boolean turn = true;
		
		while(true) {
			if(turn) {
				try {
					Thread.sleep(600);
				} catch (Exception e) {
				}
				if(pIndex < playerSize) {
					playerAttack(pIndex);
					pIndex ++;
				} else {
					turn = !turn;
					pIndex = 0;
					printStatus();
				}
			}else if(!turn) {
				if(mIndex < monsterList.size()) {
					monsterAttack(mIndex);
					mIndex ++;
				} else {
					turn = !turn;
					mIndex = 0;
				}
			}
			checkLive();
			if(monsterDead <= 0)
				break;
			else if(playerDead <= 0) {
				for(int i=0; i<playerSize; i++) {
					Player player = Player.guild.getGuildList(i);
					player.setHp(player.getMaxHp());
				}
				break;
			}
		}
		GameManager.nextStage = "LOBBY";
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
	
	private void playerAttack(int index) {
		Player p = Player.guild.getGuildList(index);
		
		if(p.getHp() <= 0)
			return;
		
		printStatus();
		printPlayerAttackMenu(p);
		int sel = 0;
		while(sel != 1 && sel != 2) {
			sel = GameManager.scan.nextInt();
		}
		if(sel == 1) {
			while(true) {
				int idx = GameManager.random.nextInt(monsterList.size());
				if(monsterList.get(idx).getHp() > 0) {
					p.attack(monsterList.get(idx));
					break;
				}
			}
		}
		else if(sel == 2) {
			
		}
	}
	
	private void printPlayerAttackMenu(Player p) {
		System.out.println("~~~~~~~~~~~ [🗡️공격 선택🗡️] ~~~~~~~~~~~~");
		System.out.printf("    [%s (%s)] [1]일반공격 [2]스킬\n", p.getName(), p.getKind()==1 ? "전사" : (p.getKind()==2 ? "마법사" : "힐러"));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	private void monsterAttack(int index) {
		Monster m = monsterList.get(index);
		if(m.getHp() <= 0)
			return;
		while(true) {
			int idx = GameManager.random.nextInt(playerSize);
			if(Player.guild.getGuildList(idx).getHp() > 0) {
				m.attack(Player.guild.getGuildList(idx));
				break;
			}
		}
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
