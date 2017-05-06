package thread;

import object.Robot;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import static org.sikuli.script.Constants.FOREVER;

/**
 * Created by Kijja on 01-Apr-17.
 */
public class LoopAttack extends Robot implements Runnable {
	static Thread thread;
	final private static String threadName = "ATTACK";

	private Screen screen = new Screen();
	private Match match;
	private String type;
	
	
	int cnt = 0;

	public void start() {
		if (thread == null) {
			thread = new Thread(this, threadName);
			thread.start();
		} else {
			thread.interrupt();
			thread = null;
			start();
		}
	}

	@Override
	public void run() {
		while (true) {
			attack();
		}
	}

	private void attack() {
		try {
			System.out.println(threadName + ": Wait start_stage.png");
			screen.wait("start_stage.png", FOREVER);
			cnt++;
			System.out.println(threadName + ": Click start_stage.png Round = "+cnt);
			screen.click("start_stage.png");

			while (!searchImage()) {
			}

			switch (type) {
			case "WIN":
				System.out.println(threadName + ": Wait reward.png");
				screen.wait("reward.png", FOREVER);

				screen.wait(4.0);

				System.out.println(threadName + ": Click reward.png");
				screen.click("reward.png");
				screen.delayClick(1000);
				screen.click();

				match = screen.exists("ok.png");
				if (match != null && match.getScore() > 0) {
					System.out.println(threadName + ": Click ok.png");
					screen.click("ok.png");
				}

				match = screen.exists("recive.png");
				if (match != null && match.getScore() > 0) {
					System.out.println(threadName + ": Click recive.png");
					screen.click("recive.png");
				}

				System.out.println(threadName + ": Wait replay.png");
				screen.wait("replay.png", FOREVER);
				System.out.println(threadName + ": Click replay.png");
				screen.click("replay.png");
				break;

			case "LOSE":
				System.out.println(threadName + ": Wait dead.png");
				screen.wait("dead.png", FOREVER);
				System.out.println(threadName + ": Click no_dead.png");
				screen.click("no_dead.png");
				System.out.println(threadName + ": Wait defeated.png");
				screen.wait("defeated.png", FOREVER);
				System.out.println(threadName + ": Click defeated.png");
				screen.click("defeated.png");
				System.out.println(threadName + ": Wait replay.png");
				screen.wait("replay.png", FOREVER);
				System.out.println(threadName + ": Click replay.png");
				screen.click("replay.png");
				break;
			}

		} catch (FindFailed findFailed) {
			findFailed.printStackTrace();
		}
	}

	private boolean searchImage() {
		try {
			screen.wait("reward.png");
			type = "WIN";
			return true;
		} catch (FindFailed e) {
		}

		try {
			screen.wait("dead.png");
			type = "LOSE";
			return true;
		} catch (FindFailed e) {
		}

		return false;
	}
}
