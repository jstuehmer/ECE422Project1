import java.util.Timer;
import java.util.Arrays;

public class BackupVariant extends Thread {

    private int[] values;
    private double failProb;
    private String fileOut;
    private Timer t;

    public BackupVariant(String fileIn, String fileOut, double failProb, int tLimit) {

        values = FileHelper.readFile(fileIn);
        this.failProb = failProb;
        this.fileOut = fileOut;

        t = new Timer();
        Watchdog w = new Watchdog(this);
        t.schedule(w, tLimit);
    }

    @Override
    public void run() {
        try {
            InsertionSort insertionSort = new InsertionSort();
            System.loadLibrary("insertionsort");
            int[] result = insertionSort.insertsort(values);

            if (Failure.failOccurs(insertionSort.getMemCount(), failProb)) {
                t.cancel();
                System.out.println("-backup variant experienced a failure");
                return;
            }

            FileHelper.writeFile(fileOut, result);
            t.cancel();

        } catch (Error e) {
            t.cancel();
            throw e;
        }
    }
}
