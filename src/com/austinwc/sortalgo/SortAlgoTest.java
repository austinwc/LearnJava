package com.austinwc.sortalgo;

import com.austinwc.testutils.ApproxTimeElapsed;

import java.util.Arrays;
import java.util.Random;

public class SortAlgoTest {
    private static Integer[] createMixedArray(int size, int upperBound) {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        Integer[] result = new Integer[size];

        for (int i = 0; i < size; i++) result[i] = rand.nextInt(upperBound);

        return result;
    }

    public static void main(String[] args) {
        ApproxTimeElapsed timer = new ApproxTimeElapsed();
        long elapsedMillis;

        // Insertion Sort
        IntegerSort insertSort = new InsertSort();
        Integer[] array = createMixedArray(5000, 10000);

        System.out.println("Testing insert sort on 5000 element array...");
        timer.setStartTime();
        insertSort.sort(array);
        elapsedMillis = timer.getElapsedTime();
        System.out.println("Finished sorting after " + elapsedMillis + " millis");
        System.out.print("Sorted array result: " + Arrays.toString(array));

    }
}
