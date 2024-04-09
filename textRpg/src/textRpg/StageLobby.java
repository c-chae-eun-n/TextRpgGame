package textRpg;

public class StageLobby extends Stage {
	private final int BATTLE = 1;
	private final int SETTING = 2;
	private final int EXIT = 0;

	@Override
	public boolean update() {
		System.out.println("~~~~~~~~~~~~ [🏰성 내부🏰] ~~~~~~~~~~~~\n");
		System.out.println(" [1]전투하러가기⚔️ [2]준비하기🔧‍ [0]종료하기🏴\n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		int sel = -1;
		while(sel != BATTLE && sel != SETTING && sel != EXIT) {
			sel = GameManager.scan.nextInt();
			
			if(sel == BATTLE) 
				GameManager.nextStage = "BATTLE";
			else if(sel == SETTING) 
				GameManager.nextStage = "SETTING";
			else if(sel == EXIT) 
				GameManager.nextStage = "";
		}
		return false;
	}

	@Override
	public void init() {
	}
}
