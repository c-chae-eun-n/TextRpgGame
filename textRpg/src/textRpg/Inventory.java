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
}
