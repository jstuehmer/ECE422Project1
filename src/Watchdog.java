import java.util.TimerTask;

/*
 * Created on March 1, 2017
 * @author: Stuehmer
 */

@SuppressWarnings("deprecation")
public class Watchdog extends TimerTask {

    Thread watched;
    private String threadName;

    public Watchdog(Thread target, String name) {
        watched = target;
        threadName = name;
    }

    public void run() {
        watched.stop();
        System.out.println(getThreadName() + " timed out");
    }

    public String getThreadName() {
        return threadName;
    }
}
