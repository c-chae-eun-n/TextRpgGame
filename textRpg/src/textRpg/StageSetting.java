package textRpg;

public class StageSetting extends Stage {
	private final int  GUILD = 1;
	private final int SHOP = 2;
	private final int INVENTORY = 3;
	private final int SAVE = 4;
	private final int LOAD = 5;
	private final int EXIT = 0;
	
//	private UnitManager unitManager = UnitManager.getInstance();
	private Shop shop = Shop.getInstance();
	public static Player player = null;
	private boolean isValid = true;

	@Override
	public boolean update() {
		if(player == null)
			tempLogin();
		if(isValid) {
			while(true) {
				System.out.println("~~~~~~~~~~~~~ [🔧설정🔧] ~~~~~~~~~~~~~\n");
				System.out.println(" [1]길드⚜️     [2]상점🛒    [3]인벤토리🎒\n");
				System.out.println(" [4]저장📁     [5]로드📂    [0]뒤로가기🔙\n");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.print(" 메뉴 번호 입력 : ");
				
				int sel = GameManager.scan.nextInt();
				if(sel == GUILD) {
					player.guildMenu();
				}
				else if(sel == SHOP) {
					shop.shopMenu();
				}
				else if(sel == INVENTORY) {
					player.invenMenu();
				}
				else if(sel == SAVE) {
					
				}
				else if(sel == LOAD) {
					
				}
				else if(sel == EXIT) {
					GameManager.nextStage = "LOBBY";
					player = null;
					break;
				}
			}
			return false;
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	public void tempLogin() {
		System.out.print(" 🔧설정🔧 사용 할 플레이어의 이름 입력 : ");
		String name = GameManager.scan.next();
		player = Player.guild.findPlayerByName(name);
		if(player == null) {
			System.err.println("존재하지 않는 플레이어입니다.");
			isValid = false;
		}
	}
}
