public class HeapSort {

    private static int[] values;

    private static int n;
    private static int left;
    private static int right;
    private static int max;
    private static int memCount = 100;

    public static int[] sort(int[] a) {

        values = a;
        heapify(values);

        for (int i = n; i > 0; i--) {
            swap(values, 0, i);
            n--;
            maxHeap(values, 0);
        }
        return values;
    }

    private static void heapify(int[] a) {
        n = a.length - 1;
        for (int i = n/2; i >= 0; i--) {
            maxHeap(a, i);
        }
    }

    private static void maxHeap(int[] a, int i) {
        
        left = 2 * i;
        right = 2 * i + 1;
        max = i;

        if (left <= n && a[left] > a[i])
            max = left;
        if (right <= n && a[right] > a[max])
            max = right;
        if (i != max) {
            swap(a, i, max);
            maxHeap(a, max);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int getMemCount() {
        return memCount;
    }
}
