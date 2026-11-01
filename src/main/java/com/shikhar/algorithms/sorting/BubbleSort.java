public class BubbleSort {

    private enum BubbleSortType {
        BRUTE,
        OPTIMIZED
    };

    public static void main(String[] args) {
        int[] arr = {4, -1, 100, 2};     
        System.out.println("Brute: " + getTime(arr, BubbleSortType.BRUTE));
        System.out.println("Optimized: " + getTime(arr, BubbleSortType.OPTIMIZED));
    } 

    public static void brute(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void optimized(int[] arr, int n) {
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
    }

    public static double getTime(int[] arr, BubbleSortType type)  {
        int n = arr.length;
        long start = System.nanoTime();

        if(type == BubbleSortType.BRUTE) {
            brute(arr, n);
        } else {
            optimized(arr, n);
        }

        long end = System.nanoTime();

        return ((end - start) / 1_000_000.0);
    }


}


