package textRpg;

public class StageLobby extends Stage {

	@Override
	public boolean update() {
		System.out.println("~~~~~~~~~~~~ [🏰성 내부🏰] ~~~~~~~~~~~~");
		System.out.println();
		System.out.println(" [1]전투하러가기⚔️ [2]준비하기🔧‍ [3]종료하기🏴\n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		int sel = 0;
		while(sel != 1 && sel != 2 && sel != 3) {
			sel = GameManager.scan.nextInt();
			
			if(sel == 1) 
				GameManager.nextStage = "BATTLE";
			else if(sel == 2) 
				GameManager.nextStage = "SETTING";
			else if(sel == 3) 
				GameManager.nextStage = "";
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
