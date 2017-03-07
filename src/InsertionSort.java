/*
 * Created on March 5, 2017
 * @author: Stuehmer
 */

public class InsertionSort {
    private int memCount = 0;

    public native int[] insertsort(int[] values);

    public int getMemCount() {
        return memCount;
    }
}
