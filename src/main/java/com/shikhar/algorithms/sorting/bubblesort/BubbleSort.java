import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, -1, 100, 2};     
        int n = arr.length;
        long start = System.nanoTime();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long end = System.nanoTime();
        System.out.println("Duration: " + ((end - start) / 1_000_000.0) + " ms");

        int[] arr2 = {4, -1, 100, 2};

        optimized(arr2, n);
        System.out.println(Arrays.toString(arr));
    } 

    public static void optimized(int[] arr, int n) {
        long start = System.nanoTime();

        boolean swapped = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) 
                break;
        }

        long end = System.nanoTime();

        System.out.println("Duration: " + ((end - start) / 1_000_000.0) + " ms");
    }
}
