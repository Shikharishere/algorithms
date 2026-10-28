import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {100, 2 , 900, -100}; 
        int n = arr.length;
        long start = System.nanoTime();

        int minIndex = -1;

        for(int i = 0; i < n - 1; i++) {
            for(int j = i; j < n; j++) {
                minIndex = j; 
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        long end = System.nanoTime();

        double duration = (end - start) / 1_000_000.0;

        System.out.println(Arrays.toString(arr));
        System.out.println("Duration: " + duration + " ms");
     } 
}
