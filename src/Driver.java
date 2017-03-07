/*
 * Created on March 5, 2017
 * @author: Stuehmer
 */

public class Driver {

    public static void main(String[] args) {

        if (args.length != 5) {
            throw new IllegalArgumentException("Driver expects 5 arguments");
        }

        String fileIn = args[0];
        String fileOut = args[1];
        double primFail = Double.parseDouble(args[2]);
        double backFail = Double.parseDouble(args[3]);
        int tLimit = Integer.parseInt(args[4]);

        System.out.println("\n****************Sorter****************");
        FileHelper.deleteFile(fileOut);

        // Execute Primary
        PrimaryVariant primary = new PrimaryVariant(fileIn, fileOut, primFail, tLimit);
        primary.start();

        try {
            primary.join();
            if (Adjudicator.testPasses(fileIn, fileOut)) {
                System.out.println("primary variant passed\n");
                return;
            } else {
                System.out.println("primary variant failed to pass adjudicator");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Execute Backup
        BackupVariant backup = new BackupVariant(fileIn, fileOut, backFail, tLimit);
        backup.start();

        try {
            backup.join();
            if (Adjudicator.testPasses(fileIn, fileOut)) {
                System.out.println("backup variant passed\n");
                return;
            } else {
                System.out.println("backup variant failed to pass adjudicator\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FileHelper.deleteFile(fileOut);
    }
}
        
