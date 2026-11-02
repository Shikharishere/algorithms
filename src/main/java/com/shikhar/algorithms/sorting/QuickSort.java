package com.shikhar.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    private enum PartitionType { 
        LOMUTO,
        HOARE,
        DUTCHFLAG 
    };

    public static void sort(int[] arr, int lo, int hi, PartitionType type) {
        switch (type) {
            case LOMUTO:
                if(lo < hi) {
                    int pivot = lomutoPartition(arr, lo, hi);
                    sort(arr, lo, pivot - 1, type);
                    sort(arr, pivot + 1, hi, type);
                }
                break;
            case HOARE:
                if(lo < hi) {
                    int pivot = hoarePartition(arr, lo, hi);
                    sort(arr, lo, pivot, type);
                    sort(arr, pivot + 1, hi, type);
                }
                break;
            case DUTCHFLAG:
                dutchFlagSort(arr, lo, hi); 
                break;
            default:
                break;
        }
    }

    private static void dutchFlagSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int lt = lo; // tracks ends of (< pivot) zone
        int i = lo + 1; // current element scanner
        int gt = hi; // tracks start of (> pivot) zone
        int pivot = arr[lo];

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt, i);
                lt++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, gt, i);
                gt--;
                // we do not incr i yet because we haven't inspected yet
                // the swapped in element from gt
            } else {
                i++;
            }
        }

        dutchFlagSort(arr, lo, lt - 1);
        dutchFlagSort(arr, gt + 1, hi);
    }

    private static int hoarePartition(int[] arr, int lo, int hi) {
        // using middle or low element as pivot
        int pivot = arr[lo + (hi - lo) / 2];
        int i = lo - 1;
        int j = hi + 1;

        while(true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);

            if(i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    private static int lomutoPartition(int[] arr, int lo, int hi) {
        // picking last element as pivot
        int pivot = arr[hi];
        // boundary for elements >= pivot
        int firstHigh = lo;

        for(int i = lo; i < hi; i++) {
            if(arr[i] < pivot) {
                swap(arr, i, firstHigh);
                firstHigh++;
            }
        }

        swap(arr, hi, firstHigh);
        return firstHigh;
    }



    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static double getTime(int[] arr, PartitionType type) {
        int n = arr.length - 1;
        long start = System.nanoTime();

        sort(arr, 0, n, type);

        long end = System.nanoTime();

        return (end - start) / 1_000_000.0;
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 44, 2, 2222, 2};

        System.out.println("Time(Lomuto): " + getTime(arr, PartitionType.LOMUTO));

        System.out.println(Arrays.toString(arr));

        int[] arr1 = {12, 3, 44, 2, 2222, 2};

        System.out.println("Time(Hoare): " + getTime(arr1, PartitionType.HOARE));

        System.out.println(Arrays.toString(arr));

        int[] arr2 = {12, 3, 44, 2, 2222, 2};

        System.out.println("Time(DutchFlag): " + getTime(arr2, PartitionType.DUTCHFLAG));

        System.out.println(Arrays.toString(arr));
    }
}
