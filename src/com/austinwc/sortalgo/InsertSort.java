package com.austinwc.sortalgo;

/*
 * Insertion sort algorithm -> O(n^2)
 */
public class InsertSort implements IntegerSort{
    @Override
    public void sort(Integer[] array) {
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
}
