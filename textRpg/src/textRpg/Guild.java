package textRpg;

import java.util.Vector;

public class Guild {
	private final int LIST = 1;
	private final int ADD = 2;
	private final int DELETE = 3;
	private final int RECRUIT = 4;
	private final int CHANGE = 5;
	private final int EXIT = 0;
	
	
	private Vector<Player> guildList;
	
	private Guild() {
		guildList = new Vector<>();
	}
	
	private static Guild instance = new Guild();
	
	public static Guild getInstance() {
		return instance;
	}
	
	public void setGuild(Player player) {
		guildList.add(player);
	}
	
	public Player getGuildPlayer(int num) {
		return guildList.get(num);
	}
	
	public void guildMenu() {
		while(true) {
			System.out.println("~~~~~~~~~~~~~ [⚜️길드⚜️] ~~~~~~~~~~~~~\n");
			System.out.println(" [1]길드 목록  [2]길드원 모집  [3]길드원 삭제\n");
			System.out.println(" [4]파티 모집  [5]파티원 교체  [0]뒤로가기\n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			int sel = GameManager.scan.nextInt();
			if(sel == LIST) {
				printPlayerStatusAll();
			}
			else if(sel == ADD) {
				
			}
			else if(sel == DELETE) {
				
			}
			else if(sel == RECRUIT) {
				
			}
			else if(sel == CHANGE) {
				
			}
			else if(sel == EXIT) {
				break;
			}
		}
	}
	
	private void printPlayerStatusAll() {
		if(guildList.size() == 0) {
			System.err.println("⚜️길드원⚜️이 없습니다!\n⚜️길드원⚜️을 모집해서 ⚜️길드⚜️를 만들어보세요!\n");
			return;
		}
		for(int i=0; i<guildList.size(); i++) {
			Player player = guildList.get(i);
			System.out.println("~~~~~~~~~~~~~ [⚜️길드원⚜️] ~~~~~~~~~~~~\n");
			player.printStatus();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
	}
	
	private void printPlayerStatus(int sel) {
		guildList.get(sel).printStatus();
	}
}
