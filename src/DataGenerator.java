import java.util.Arrays;
import java.util.Random;

/*
 * Created on March 1, 2017
 * @author: Stuehmer
 */

// Generate a file of random integers
public class DataGenerator {

    public static void main(String[] args) {

        if (args.length != 2) {
            throw new IllegalArgumentException("DataGenerator expects two arguments");
        }

        String fileName = args[0];
        int numValues = Integer.parseInt(args[1]);
        int values[] = new int[numValues];

        System.out.println("\n***************Generator***************");

        Random r = new Random();
        for (int i = 0; i < numValues; i++) {
            values[i] = r.nextInt();
        }

        FileHelper.writeFile(fileName, values);
        System.out.println(Integer.toString(numValues) +
                 " values written to " + fileName + "\n");
    }
}
