package textRpg;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> invenList;
	private Player player;
	
	private Inventory() {
		invenList = new ArrayList<>();
	}
	
	private static Inventory instance = new Inventory();
	
	public static Inventory getInstance() {
		return instance;
	}
	
	public void inventoryMenu() {
		System.out.print(" 📦아이템📦 구매 할 플레이어의 이름 입력 : ");
		String name = GameManager.scan.next();
		player = Player.guild.findPlayerByName(name);
		if(player == null) {
			System.err.println("존재하지 않는 플레이어입니다.");
			return;
		}
		while(true) {
			System.out.println("~~~~~~~~~~~~ [🎒인벤토리🎒] ~~~~~~~~~~~~\n");
			System.out.println(" [1]착용🪞     [2]판매💰    [0]뒤로가기🔙\n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			int sel = GameManager.scan.nextInt();
			if(sel == 1) {
				
			}
			else if(sel == 2) {
				
			}
			else if(sel == 0) {
				break;
			}
		}
	}
	
	public void create(Item item) {
		invenList.add(item);
		System.out.println(" 📦"+item.getName()+" 아이템📦 구매가 완료되었습니다.\n");
	}
}
