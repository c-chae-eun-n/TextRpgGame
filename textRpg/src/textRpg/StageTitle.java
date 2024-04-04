package textRpg;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		printHouse();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		printMessage();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		printContent();
		System.out.println("[1] 성으로 간다  [2] 성으로 가지 않는다");
		int sel = GameManager.scan.nextInt();
		if(sel == 1) {
			printCastle();
			GameManager.nextStage = "LOBBY";
			return false;
		}
		System.out.println("🤷🏻‍♀️나 말고 누군가가 구해주겠지..~~🤷🏻‍♂️");
		GameManager.nextStage = "";
		return false;
	}

	@Override
	public void init() {}

	private void printHouse() {
		System.out.println();
		System.out.println("어느 숲속마을.....");
		System.out.println("🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳");
		System.out.println("🌳🌳🌳🌳🌳🌳🌳🌳🏠🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳");
		System.out.println("🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳🌳");
	}
	
	private void printMessage() {
		System.out.println();
		System.out.println("🍃🍃➰️〰️🍃🍂🍃🍃➰〰️〰️📨");
		System.out.println("편지가 날아왔다!!");
	}
	
	private void printContent() {
		System.out.println("------------------------------------");
		System.out.println("|                                  |");
		System.out.println("| 📢 납치당한 공주를 구할 ⚔️용사⚔️ 찾습니다  |");
		System.out.println("| 📢 용감한 용사들은 모두 성으로 모여주세요!! |");
		System.out.println("|                                  |");
		System.out.println("------------------------------------");
	}
	
	private void printCastle() {
		System.out.println("성으로 가는 길이 나타났다..!!");
		System.out.println("🌳🌳🌳🌳🌌🌌🌳🌳🌳🌳🌳🌳🌳🌳");
		System.out.println("🌳🌳🌳🌳🌳🌌🌳🌳🌳🌳🌳🌳🌳🌳");
		System.out.println("🌳🌳🌳🌳🌳🌌🌌🌌🌳🌳🌳🌳🌳🌳");
		System.out.println("🌳🌳🌳🌳🌳🌳🌳🌌🌳🌳🌳🌳🌳🌳");
		System.out.println("🧱🧱🧱🧱🧱🧱🧱🏰🧱🧱🧱🧱🧱🧱");
	}
}
