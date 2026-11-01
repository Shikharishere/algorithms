import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void sort(int[] values) {
        if(values == null || values.length == 0) {
            return;
        }

        int N = values.length;
        int minValue = Integer.MAX_VALUE;    
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            if(values[i] < minValue) minValue = values[i];
            if(values[i] > maxValue) maxValue = values[i];
        }
        
        // all elements are same
        if(minValue == maxValue) {
            return;
        }

        // range of values
        int M = maxValue - minValue + 1;
        int bucketCount = (M / N) + 1;
        
        // initializing buckets
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for(int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());

        // placing elements to buckeets
        for(int i = 0; i < N; i++) {
            int bi = (values[i] - minValue) / N;
            List<Integer> bucket = buckets.get(bi);
            bucket.add(values[i]);
        }

        // sorting each bucket and then stiching together a sorted array
        for(int bi = 0, j = 0; bi < bucketCount; bi++) {
            List<Integer> bucket = buckets.get(bi);
            if(bucket != null) {
                Collections.sort(bucket);
                for(int k = 0; k < bucket.size(); k++) {
                    values[j++] = bucket.get(k); 
                }
            }
        }
    } 

    public static double getTime(int[] arr) {
        long start = System.nanoTime();

        sort(arr); 
        
        long end = System.nanoTime();

        return (end - start) / 1_000_000.0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 55, 3, 2, -1};

        System.out.println("Time: " + getTime(arr)); 
        
        int[] arr2 = {1, 1, 1, 1, 1};

        System.out.println("Time: " + getTime(arr2)); 
    }
}
