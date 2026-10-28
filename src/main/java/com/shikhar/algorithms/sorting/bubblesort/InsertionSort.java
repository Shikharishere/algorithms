import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {100, -88, 188, 2};
        int n = arr.length;

        long start = System.nanoTime();

        for(int i = 1; i < n; i++) {
            int j = i - 1;
            int currVal = arr[i];
            while(j >= 0 && arr[j] > currVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currVal;
        }

        long end = System.nanoTime();

        long duration = end - start;

        double durationInMili = duration / 1_000_000.0;

        System.out.println(Arrays.toString(arr));
        System.out.println("Execution Time: " + durationInMili + " ms");
    }
}
