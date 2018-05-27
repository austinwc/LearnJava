package com.austinwc.sortalgo;

public class QuickSort implements IntegerSort{
    @Override
    public final void sort(Integer[] array) {
        helperQuickSort(array, 0, array.length - 1);
    }

    private void helperQuickSort(Integer[] array, int low, int high) {

        if (low < high) {
            int part = partition(array, low, high);
            helperQuickSort(array, low, part - 1);
            helperQuickSort(array, part + 1, high);
        }
    }

    private int partition(Integer[] array, int low, int high) {
       int part = low;
       selectPivot(array, low, high);

       for (int i = low; i < high; i++) {
           if (array[i] < array[high]) {
               swap(array, part++, i);
           }
       }
       swap(array, part, high);
       return part;
    }

    protected void swap(Integer[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    /*
     *  Selects a pivot point inclusively between low and high
     *  and moves the pivot to slot marked by high
     */
    protected void selectPivot(Integer[] array, int low, int high) {
        // Trivially select high as pivot
    }
}
