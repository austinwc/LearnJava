package com.austinwc.sortalgo;

import java.util.Random;

public class RandomizedQuickSort extends QuickSort{
    /*
     *  Selects a pivot point inclusively between low and high
     *  and moves the pivot to slot marked by high
     */
    @Override
    protected void selectPivot(Integer[] array, int low, int high) {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int pivot = rand.nextInt(high - low) + low;
        swap(array, high, pivot);
    }
}
