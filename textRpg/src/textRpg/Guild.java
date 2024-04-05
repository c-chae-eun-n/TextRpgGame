package textRpg;

import java.util.Random;
import java.util.Vector;

public class Guild {
	private final int LIST = 1;
	private final int ADD = 2;
	private final int DELETE = 3;
	private final int RECRUIT = 4;
	private final int CHANGE = 5;
	private final int EXIT = 0;
	
	private Random random = new Random();
	
	
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
				setGuild(recruitPlayer());
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
	
	private Player recruitPlayer() {
	    String[] n1 = { "박", "이", "김", "최", "허", "지", "오" };
	    String[] n2 = { "채", "예", "주", "민", "재", "지", "유" };
	    String[] n3 = { "리", "지", "민", "수", "영", "은", "원" };
	    
	    String name = n1[random.nextInt(n1.length)];
	    name += n2[random.nextInt(n2.length)];
	    name += n3[random.nextInt(n3.length)];
	    
	    int rNum = random.nextInt(6)+5;
	    int rNum2 = random.nextInt(20)+30;
	    int hp = rNum * 11;
	    int power = rNum + rNum2;
	    rNum2 = random.nextInt(20)+30;
	    int def = rNum + rNum2;
	    int level = rNum;
	    int exp = rNum * 9;
	    Player player = new Player(name, level, hp, power, def, exp);

		System.out.println("~~~~~~~~~~~~~ [⚜️길드원⚜️] ~~~~~~~~~~~~\n");
		player.printStatus();
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("⚜️길드원⚜️ 모집을 완료했습니다.\n");
		
	    return player;
	}
}
