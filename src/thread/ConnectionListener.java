package thread;

import object.Robot;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import static org.sikuli.script.Constants.FOREVER;

/**
 * Created by Kijja on 01-Apr-17.
 */
public class ConnectionListener extends Robot implements Runnable {
	private static Thread thread;
    final private String threadName = "CONNECTION";

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
            connectionListening();
        }
    }

    private void connectionListening() {
        try {
            System.out.println(threadName + ": Wait connection.png");
            screen.wait("connection.png", FOREVER);
            System.out.println(threadName + ": Click yes.png");
            screen.click("yes.png");
            screen.wait(1.0);
        } catch (FindFailed findFailed) {
            start();
        }
    }
}
