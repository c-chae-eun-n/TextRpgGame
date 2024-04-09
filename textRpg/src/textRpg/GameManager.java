package textRpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	public static Scanner scan = new Scanner(System.in);
	public static Random random = new Random();
	
    public static final String red = "\u001B[31m" ;
    public static final String exit = "\u001B[0m" ;
    
    public static final String name = "김철수";
	
	public static String nextStage = "";
	private String curStage = "";
	
	private Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	private UnitManager unitManager = UnitManager.getInstance();
	private Guild guild = Guild.getInstance();
	
	private GameManager() {
	    int rNum = random.nextInt(6)+5;
	    int rNum2 = random.nextInt(20)+30;
	    int hp = rNum * 11;
	    int power = rNum + rNum2;
	    rNum2 = random.nextInt(20)+30;
	    int def = rNum + rNum2;
		Player player = new Player(name, Unit.WARRIOR, 1, hp, power, def, 0);
		unitManager.create(player);
		guild.setGuild(player);
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
