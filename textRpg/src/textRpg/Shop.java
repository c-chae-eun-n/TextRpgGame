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
}
