package textRpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameManager {
	public static Scanner scan = new Scanner(System.in);
	public static String nextStage = "";
	private String curStage = "";
	
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	private void init() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("SETTING", new StageSetting());
		stageList.put("BOSS", new StageBoss());
		nextStage = "TITLE";
	}

}
