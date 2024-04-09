package textRpg;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> invenList;
	
	public Inventory() {
		invenList = new ArrayList<>();
	}
	
	public void inventoryMenu() {
		while(true) {
			System.out.println("~~~~~~~~~~~~ [🎒인벤토리🎒] ~~~~~~~~~~~~\n");
			System.out.println(" [1]착용🪞 [2] 제거🚫 [3]판매💰 [0]뒤로가기🔙\n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.print(" 메뉴 번호 입력 : ");
			int sel = GameManager.scan.nextInt();
			if(sel == 1) {
				wearEquip();
			}
			else if(sel == 2) {
				removeEquip();
			}
			else if(sel == 3) {
				
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
		while(true) {
			StageSetting.player.printItem();
			System.out.println(" [1]무기⚔️ [2]갑옷🥼 [3]장신구💍 [0]뒤로가기🔙\n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(" 착용할 🛠️장비🛠️ 번호 입력 : ");
			int sel = GameManager.scan.nextInt();
			if(sel == Item.WEAPON || sel == Item.ARMOR || sel == Item.RING) {
				int size = printItemAll(sel);
				wearItem(sel, size);
			}
			else if(sel == 0) {
				break;
			}
		}
	}
	
	private void removeEquip() {
		while(true) {
			StageSetting.player.printItem();
			System.out.println(" [1]무기⚔️ [2]갑옷🥼 [3]장신구💍 [0]뒤로가기🔙\n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(" 제거할 🛠️장비🛠️ 번호 입력 : ");
			int sel = GameManager.scan.nextInt();
			if(sel == Item.WEAPON || sel == Item.ARMOR || sel == Item.RING) {
				removeItem(sel);
			}
			else if(sel == 0) {
				break;
			}
		}
	}
	
	private int printItemAll(int sel) {
		int size = 0;
		
		if(sel == Item.WEAPON)
			System.out.println("~~~~~~~~~~~~~ [⚔️무기⚔️] ~~~~~~~~~~~~~\n");
		else if(sel == Item.ARMOR)
			System.out.println("~~~~~~~~~~~~~ [🥼갑옷🥼] ~~~~~~~~~~~~~\n");
		else if(sel == Item.RING)
			System.out.println("~~~~~~~~~~~~~ [💍장신구💍] ~~~~~~~~~~~~\n");
		
		int index = 1;
		for(int i=0; i<invenList.size(); i++) {
			Item item = invenList.get(i);
			if(sel == item.getKind()) {
				System.out.printf(" [%d] %s    power : %d\n", index ++, item.getName(), item.getPower());
				size ++;
			}
		}
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		return size;
	}
	
	private void wearItem(int sel, int size) {
		if(size == 0) {
			System.err.println("\t  📦아이템📦이 없습니다.\n");
			return;
		}
		
		int num = -1;
		while(true) {
			System.out.print(" 착용 할 📦아이템📦 번호 입력 : ");
			num = GameManager.scan.nextInt();
			if(num >= 1 && num <= size)
				break;
		}
		
		Item item = findItemByNumber(sel, num);
		if(sel == Item.WEAPON) {
			StageSetting.player.setWeapon(item);
		}
		else if(sel == Item.ARMOR) {
			StageSetting.player.setArmor(item);
		}
		else if(sel == Item.RING) {
			StageSetting.player.setRing(item);
		}
		StageSetting.player.setPower(StageSetting.player.getPower() + item.getPower());
		System.out.println(" " + item.getName() + " 📦아이템📦을 착용하였습니다.");
		System.out.printf(" 파워가 %d 증가하였습니다.\n\n", item.getPower());
	}
	
	private void removeItem(int sel) {
		if(sel == Item.WEAPON && StageSetting.player.getWeapon() == null) {
			System.err.println("\t착용중인 📦아이템📦이 없습니다.\n");
			return;
		}else if(sel == Item.WEAPON && StageSetting.player.getWeapon() != null) {
			StageSetting.player.setWeapon(null);
			System.out.println(" 📦아이템📦을 제거하였습니다.");
		}
		
		else if(sel == Item.ARMOR && StageSetting.player.getArmor() == null) {
			System.err.println("\t착용중인 📦아이템📦이 없습니다.\n");
			return;
		}else if(sel == Item.ARMOR && StageSetting.player.getArmor() != null) {
			StageSetting.player.setArmor(null);
			System.out.println(" 📦아이템📦을 제거하였습니다.");
		}
		
		else if(sel == Item.RING && StageSetting.player.getRing() == null) {
			System.err.println("\t착용중인 📦아이템📦이 없습니다.\n");
			return;
		}else if(sel == Item.RING && StageSetting.player.getRing() != null) {
			StageSetting.player.setRing(null);
			System.out.println(" 📦아이템📦을 제거하였습니다.");
		}
	}
	
	private Item findItemByNumber(int sel, int number) {
		Item item = null;
		
		int count = 0;
		for(int i=0; i<invenList.size(); i++) {
			Item target = invenList.get(i);
			if(sel == target.getKind()) {
				count ++;
				if(count == number) 
					item = target;
			}
		}
		
		return item;
	}
}
