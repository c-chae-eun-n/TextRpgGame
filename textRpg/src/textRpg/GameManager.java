package textRpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameManager {
	public static Scanner scan = new Scanner(System.in);
	
	public static String nextStage = "";
	private String curStage = "";
	
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	private GameManager() {
		
	}
	
	private static GameManager instance = new GameManager();
	
	public static GameManager getInstance() {
		return instance;
	}
	
	private void init() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("SETTING", new StageSetting());
		stageList.put("BOSS", new StageBoss());
		nextStage = "TITLE";
	}	
	
	private boolean changeStage() {
		System.out.println("현재 스테이지 : " + curStage);
		System.out.println("다음 스테이지 : " + nextStage);
		System.out.println();
		
		if(curStage.equals(nextStage))
			return true;
		
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();
		
		boolean run = true;
		while(run) {
			run = stage.update();
			if(run == false) 
				break;
		}
		
		if(nextStage.equals("")) 
			return false;
		else 
			return true;
	}
	
	public void run() {
		boolean run = true;
		init();
		while(true) {
			run = changeStage();
			if(run == false)
				break;
		}
		System.out.println("게임 종료-");
	}

}
