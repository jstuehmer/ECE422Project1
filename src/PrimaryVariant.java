import java.util.Timer;

public class PrimaryVariant extends Thread {

    private int[] values;
    private double failProb;
    private String fileOut;
    private Timer t;

    public PrimaryVariant(String fileIn, String fileOut, double failProb, int tLimit) {

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
            HeapSort heapSort = new HeapSort();
            int[] result = heapSort.sort(values);

            if (Failure.failOccurs(heapSort.getMemCount(), failProb)) {
                t.cancel();
                System.out.println("-primary variant experienced a failure");
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
