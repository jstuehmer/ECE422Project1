/*
 * Created on March 5, 2017
 * @author: Stuehmer
 */

public class HeapSort {

    private static int[] values;

    private static int n;
    private static int left;
    private static int right;
    private static int max;
    private static int memCount = 0;

    public static int[] sort(int[] a) {

        values = a;
        memCount += 1;

        heapify(values);

        for (int i = n; i > 0; i--) {
            swap(values, 0, i);
            n--;
            memCount += 1;
            maxHeap(values, 0);
        }
        return values;
    }

    private static void heapify(int[] a) {
        n = a.length - 1;
        memCount += 1;
        for (int i = n/2; i >= 0; i--) {
            maxHeap(a, i);
        }
    }

    private static void maxHeap(int[] a, int i) {
        
        left = 2 * i;
        right = 2 * i + 1;
        max = i;
        memCount += 6;

        if (left <= n && a[left] > a[i]) {
            max = left;
            memCount += 2;
        }
        if (right <= n && a[right] > a[max]) {
            max = right;
            memCount += 2;
        }
        if (i != max) {
            swap(a, i, max);
            maxHeap(a, max);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        memCount += 10;
    }

    public int getMemCount() {
        return memCount;
    }
}
