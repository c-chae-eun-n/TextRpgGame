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
			System.out.println(" [4]관리자⛔   [0]뒤로가기🔙\n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.print(" 메뉴 번호 입력 : ");
			int sel = GameManager.scan.nextInt();
			if(sel == Item.WEAPON) {
				 int size = printItemAll(sel);
				 buyItem(sel, size);
			}
			else if(sel == Item.ARMOR) {
				 int size = printItemAll(sel);
				 buyItem(sel, size);
			}
			else if(sel == Item.RING) {
				 int size = printItemAll(sel);
				 buyItem(sel, size);
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
			System.out.println(GameManager.yellow + "~~~~~~~~~~~~~ [⛔관리자⛔] ~~~~~~~~~~~~\n");
			System.out.println(" [1]무기⚔️      [2]갑옷🥼     [3]장신구💍\n");
			System.out.println(" [0]뒤로가기🔙\n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.print(" 추가 할 📦아이템📦 번호 입력 : " + GameManager.exit);
			int sel = GameManager.scan.nextInt();
			if(sel == Item.WEAPON) {
				setWeapon();
			}
			else if(sel == Item.ARMOR) {
				setArmor();
			}
			else if(sel == Item.RING) {
				setRing();	
			}
			else if(sel == 0) {
				break;
			}
		}
	}
	
	private void setWeapon() {
		Item item = null;
		
		String name = setName();
	    int power = setPower();
	    int price = setPrice();
		
		item = new Weapon(name, power, price);
		itemList.add(item);
		System.out.println(" " + item.getName() + " 📦아이템📦이 추가되었습니다.\n" + GameManager.exit);
	}
	
	private void setArmor() {
		Item item = null;
		
		String name = setName();
		int power = setPower();
		int price = setPrice();
		
		item = new Armor(name, power, price);
		itemList.add(item);
		System.out.println(" " + item.getName() + " 📦아이템📦이 추가되었습니다.\n" + GameManager.exit);
	}
	
	private void setRing() {
		Item item = null;
		
		String name = setName();
		int power = setPower();
		int price = setPrice();
		
		item = new Ring(name, power, price);
		itemList.add(item);
		System.out.println(" " + item.getName() + " 📦아이템📦이 추가되었습니다.\n" + GameManager.exit);
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

		System.out.print(GameManager.yellow + " 📦아이템📦 이름 : ");
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
	
	private int setPower() {
		int power = 0;
		
		while(true) {
			power = inputNumber(" 📦아이템📦 파워");
	    	if(power >= 1) {
	    		break;
	    	}
	    }
		
		return power;
	}
	
	private int setPrice() {
		int price = 0;

	    while(true) {
	    	price = inputNumber(" 📦아이템📦 가격");
	    	if(price >= 1) {
	    		break;
	    	}
	    }
		
		return price;
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
		for(int i=0; i<itemList.size(); i++) {
			Item item = itemList.get(i);
			if(sel == item.getKind()) {
				System.out.printf(" [%d] ", index++);
				System.out.println(item);
				size ++;
			}
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		return size;
	}
	
	private void buyItem(int sel, int size) {
		if(size == 0) {
			System.err.println("\t  📦아이템📦이 없습니다.\n\t  관리자에게 문의하세요.\n");
			return;
		}
		
		int num = -1;
		while(true) {
			num = inputNumber(" 구매 할 📦아이템📦 번호 입력");
			if(num >= 1 && num <= size)
				break;
		}
		
		Item item = findItemByNumber(sel, num);
		if(StageSetting.player.getMoney()-item.getPrice() < 0) {
			System.err.println("\n 🪙골드🪙가 부족합니다.\n");
			return;
		}
		StageSetting.player.setMoney(StageSetting.player.getMoney()-item.getPrice());
		StageSetting.player.getInventory().create(item);
	}
	
	private int inputNumber(String message) {
		int number = 0;
		
		System.out.print(message + " : ");
		try {
			String input = GameManager.scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println(" 숫자만 입력하세요.");
		}
		
		return number;
	}
	
	private Item findItemByNumber(int sel, int number) {
		Item item = null;
		
		int count = 0;
		for(int i=0; i<itemList.size(); i++) {
			Item target = itemList.get(i);
			if(sel == target.getKind()) {
				count ++;
				if(count == number) 
					item = target;
			}
		}
		
		return item;
	}
	
	// 검수용
	private void printAll() {
		for(int i=0; i<itemList.size(); i++) {
			System.out.println(itemList.get(i));
		}
	}
}
