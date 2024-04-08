package textRpg;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Item> itemList;
	
	private Shop() {
		itemList = new ArrayList<>();
	}
	
	private static Shop instance = new Shop();
	
	public static Shop getInstance() {
		return instance;
	}
	
	public void shopMenu() {
		while(true) {
			System.out.println("~~~~~~~~~~~~~ [🛒상점🛒] ~~~~~~~~~~~~~\n");
			System.out.println(" [1]무기⚔️     [2]갑옷🥼     [3]장신구💍\n");
			System.out.println(" [4]포션🧪     [5]관리자⛔   [0]뒤로가기🔙\n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			int sel = GameManager.scan.nextInt();
			if(sel == Item.WEAPON) {
				
			}
			else if(sel == Item.AMOR) {
				
			}
			else if(sel == Item.RING) {
				
			}
			else if(sel == Item.POTION) {
				
			}
			else if(sel == Item.ADMIN) {
				setItem();
			}
			else if(sel == 0) {
				break;
			}
		}
	}
	
	private void setItem() {
		while(true) {
			System.out.println(GameManager.red + "~~~~~~~~~~~~~ [⛔관리자⛔] ~~~~~~~~~~~~\n");
			System.out.println(" [1]무기⚔️      [2]갑옷🥼     [3]장신구💍\n");
			System.out.println(" [4]포션🧪      [0]뒤로가기🔙\n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + GameManager.exit);
			int sel = GameManager.scan.nextInt();
			if(sel == Item.WEAPON) {
				setWeapon();
			}
			else if(sel == Item.AMOR) {
				
			}
			else if(sel == Item.RING) {
				
			}
			else if(sel == Item.POTION) {
				
			}
			else if(sel == 0) {
				break;
			}
		}
	}
	
	private void setWeapon() {
		Item item = null;
		
		String name = setName();
		
		int rNum = GameManager.random.nextInt(6)+5;
	    int rNum2 = GameManager.random.nextInt(20)+30;
	    int power = rNum + rNum2;
	    
	    System.out.print(" 아이템 가격 : ");
	    int price = 0;
	    while(true) {
	    	try {
				String input = GameManager.scan.next();
	    		price = Integer.parseInt(input);
			} catch (Exception e) {
				System.err.println(" 숫자만 입력하세요.");
			}
	    	if(price >= 1) {
	    		break;
	    	}
	    }
		
		item = new Weapon(name, power, price);
		itemList.add(item);
		System.out.println(" " + item.getName() + " 아이템이 추가되었습니다.\n" + GameManager.exit);
	}
	
	private boolean isValid(String name) {
		boolean isValid = false;
		
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).getName().equals(name))
				isValid = true;
		}
		
		return isValid;
	}
	
	private String setName() {
		String name = "";

		System.out.print(GameManager.red + " 아이템 이름 : ");
		while(true) {
			name = GameManager.scan.next();
			if(isValid(name)) {
				System.err.println(" 이미 존재하는 이름입니다.");
				continue;
			}else {
				break;
			}
		}
		
		return name;
	}
}
