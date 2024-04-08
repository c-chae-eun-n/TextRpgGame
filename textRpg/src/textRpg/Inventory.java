package textRpg;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> invenList;
	private Player player;
	
	public Inventory() {
		invenList = new ArrayList<>();
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
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			int sel = GameManager.scan.nextInt();
			if(sel == 1) {
				wearEquip();
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
	
	private void wearEquip() {
		player.printItem();
		System.out.println(" [1]무기⚔️ [2]갑옷🥼 [3]장신구💍 [4]포션🧪 \n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(" 착용할 🛠️장비🛠️ 번호 입력 : ");
		int sel = GameManager.scan.nextInt();
		if(sel == Item.WEAPON) {
			
		}
		else if(sel == Item.ARMOR) {
			
		}
		else if(sel == Item.RING) {
			
		}
		else if(sel == Item.POTION) {
			
		}
	}
}
