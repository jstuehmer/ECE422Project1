import java.util.Arrays;

public class Adjudicator {

    public static boolean acceptanceTest(String fileIn, String fileOut) {

        if (!FileHelper.fileExists(fileIn) || !FileHelper.fileExists(fileOut)) {
            return false;
        }

        int[] values = FileHelper.readFile(fileIn);
        int[] result = FileHelper.readFile(fileOut);
        Arrays.sort(values);

        if (!Arrays.equals(values, result)) {
            return false;
        }
        return true;
    }
}
