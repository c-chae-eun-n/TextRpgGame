package textRpg;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> invenList;
	
	private Inventory() {
		invenList = new ArrayList<>();
	}
	
	private static Inventory instance = new Inventory();
	
	public static Inventory getInstance() {
		return instance;
	}
	
	public void create(Item item) {
		invenList.add(item);
		System.out.println(" 📦"+item.getName()+" 아이템📦 구매가 완료되었습니다.\n");
	}
}
