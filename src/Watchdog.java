import java.util.TimerTask;

@SuppressWarnings("deprecation")
public class Watchdog extends TimerTask {

    Thread watched;

    public Watchdog (Thread target) {
        watched = target;
    }

    public void run() {
        watched.stop();
        System.out.println("Timed out.");
    }
}
