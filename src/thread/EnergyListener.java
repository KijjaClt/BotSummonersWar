package thread;

import object.Robot;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import static org.sikuli.script.Constants.FOREVER;

/**
 * Created by Kijja on 01-Apr-17.
 */
public class EnergyListener extends Robot implements Runnable {
	private static Thread thread;
    final private String threadName = "ENERGY";

    private Screen screen = new Screen();

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
            energyListening();
        }
    }

    private void energyListening() {
        try {
            System.out.println(threadName + ": Wait energy_out.png");
            screen.wait("energy_out.png", FOREVER);
            System.out.println(threadName + ": Click no_energy.png");
            screen.click("no_energy.png");

            screen.wait(60.0);

            System.out.println(threadName + ": Wait replay.png");
            screen.wait("replay.png", FOREVER);
            System.out.println(threadName + ": Click replay.png");
            screen.click("replay.png");
        } catch (FindFailed findFailed) {
            start();
        }
    }
}
