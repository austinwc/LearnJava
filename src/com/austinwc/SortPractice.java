package com.austinwc;

import java.util.Arrays;
import java.util.Random;

public class SortPractice {
    public static void insertSort(int[] array) {

        if (array.length == 0) return;

        for (int i = 0; i < array.length; i++) {
            int curr = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > curr) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = curr;
        }
    }

    public static void mergeSort(int[] array) {

    }

    // Merge segments of an array
    private static void merge(int[] a, int s, int m, int e) {

    }

    public static void main(String[] args) {
        int[] unsorted = new int[20];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = rand.nextInt(100);
        }

        System.out.print("Unsorted array is: ");
        System.out.println(Arrays.toString(unsorted));

        System.out.println("Testing insert sort...");
        int[] insertRes = unsorted.clone();
        insertSort(insertRes);
        System.out.print("Sorted array result: ");
        System.out.println(Arrays.toString(insertRes));

    }
}
