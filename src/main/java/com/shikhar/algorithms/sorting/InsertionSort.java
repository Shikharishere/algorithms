public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {100, -88, 188, 2};
        System.out.println("Time: " + getTime(arr) + " ms");
    }

    public static void sort(int[] arr, int n) {
        for(int i = 1; i < n; i++) {
            int j = i - 1;
            int currVal = arr[i];
            while(j >= 0 && arr[j] > currVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currVal;
        }
    }

    public static double getTime(int[] arr) {
        int n = arr.length;
        long start = System.nanoTime();

        sort(arr, n);

        long end = System.nanoTime();

        long duration = end - start;

        return duration / 1_000_000.0;
    }
}
