package object;

import org.sikuli.basics.Settings;
import org.sikuli.script.App;
import org.sikuli.script.ImagePath;
import thread.*;

/**
 * Created by Kijja on 01-Apr-17.
 */
public class Robot {
    private App nox;

    public Robot() {
        nox = new App("Nox");
        ImagePath.setBundlePath("src/img/");
        Settings.ActionLogs = false;
    }

    public boolean open() {
        if (nox.isRunning(3)) {
            nox.open();
            return true;
        } else {
            System.out.println("Nox not found!");
            return false;
        }
    }

    public void start() {
        LoopAttack loopAttack = new LoopAttack();
        loopAttack.start();

        EnergyListener energyListener = new EnergyListener();
        energyListener.start();

        ConnectionListener connectionListener = new ConnectionListener();
        connectionListener.start();
    }
}
