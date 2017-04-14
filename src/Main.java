import object.Robot;

/**
 * Created by Kijja on 01-Apr-17.
 */
public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();

        if (robot.open()) {
            robot.start();
        }
    }
}