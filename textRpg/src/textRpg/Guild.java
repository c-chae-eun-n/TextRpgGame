package textRpg;

import java.util.Vector;

public class Guild {
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
	
	
}
