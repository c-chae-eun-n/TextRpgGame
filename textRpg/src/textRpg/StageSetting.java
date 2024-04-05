package textRpg;

public class StageSetting extends Stage {
	private final int  GUILD = 1;
	private final int SHOP = 2;
	private final int INVENTORY = 3;
	private final int SAVE = 4;
	private final int LOAD = 5;
	private final int EXIT = 0;
	
	private UnitManager unitManager = UnitManager.getInstance();

	@Override
	public boolean update() {
		System.out.println("~~~~~~~~~~~~~ [🔧설정🔧] ~~~~~~~~~~~~~\n");
		System.out.println(" [1]길드        [2]상점       [3]인벤토리\n");
		System.out.println(" [4]저장        [5]로드       [0]종료\n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		while(true) {
			int sel = GameManager.scan.nextInt();
			if(sel == GUILD) {
				unitManager.player.guildMenu();
			}
			else if(sel == SHOP) {
				
			}
			else if(sel == INVENTORY) {
				
			}
			else if(sel == SAVE) {
				
			}
			else if(sel == LOAD) {
				
			}
			else if(sel == EXIT) {
				GameManager.nextStage = "LOBBY";
				break;
			}
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
