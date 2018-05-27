package com.austinwc.sortalgo;

import java.util.Arrays;

public class MergeSort implements IntegerSort{
    @Override
    public void sort(Integer[] array) {
        helperMergeSort(array, 0, array.length - 1);
    }
    private void helperMergeSort(Integer[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            helperMergeSort(array, low, mid);
            helperMergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private void merge(Integer[] array, int low, int mid, int high) {
        Integer[] a = Arrays.copyOfRange(array, low, mid + 1);
        Integer[] b = Arrays.copyOfRange(array, mid +  1, high + 1);
        int aCount = 0, bCount = 0, i = low;

        while (aCount < a.length && bCount < b.length) {
            if (a[aCount] < b[bCount]) {
                array[i++] = a[aCount++];
            } else {
                array[i++] = b[bCount++];
            }
        }
        while (aCount < a.length) array[i++] = a[aCount++];
        while (bCount < b.length) array[i++] = b[bCount++];
    }
}
