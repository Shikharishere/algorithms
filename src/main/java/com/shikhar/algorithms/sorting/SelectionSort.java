public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {100, 2 , 900, -100}; 
        

        System.out.println("Time: " + getTime(arr) + " ms");
     } 

    public static void sort(int[] arr, int n) {
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
    }

    public static double getTime(int[] arr) {
        int n = arr.length;

        long start = System.nanoTime();

        sort(arr, n);

        long end = System.nanoTime();

        return (end - start) / 1_000_000.0;
    }
}
