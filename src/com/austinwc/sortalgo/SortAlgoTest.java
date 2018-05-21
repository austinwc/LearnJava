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

    private static Integer[] createReversedArray(int size) {
        Integer[] result = new Integer[size];

        for (int i = 0; i < result.length; i++) result[i] = result.length - i;
        return result;
    }

    private static Integer[] createSortedArray(int size) {
        Integer[] result = new Integer[size];

        for (int i = 0; i < result.length; i++) result[i] = i;
        return result;
    }

    private static void runTest(String sortName, IntegerSort sortAlgo) {
        ApproxTimeElapsed timer = new ApproxTimeElapsed();
        Integer[] array;
        long elapsedMillis;


        // Random Input
        array = createMixedArray(5000, 10000);
        System.out.println("Testing " + sortName + " on 5000 random elements...");
        timer.setStartTime();
        sortAlgo.sort(array);
        elapsedMillis = timer.getElapsedTime();
        System.out.println("Finished sorting after " + elapsedMillis + " milliseconds");
        System.out.println("Sorted array result: " + Arrays.toString(array));
        System.out.println();

        // Reversed Input
        array = createReversedArray(5000);
        System.out.println("Testing " + sortName + " on 5000 elements in reverse order...");
        timer.setStartTime();
        sortAlgo.sort(array);
        elapsedMillis = timer.getElapsedTime();
        System.out.println("Finished sorting after " + elapsedMillis + " milliseconds");
        System.out.println("Sorted array result: " + Arrays.toString(array));
        System.out.println();

        // Sorted Input
        array = createSortedArray(5000);
        System.out.println("Testing " + sortName + " on 5000 sorted elements...");
        timer.setStartTime();
        sortAlgo.sort(array);
        elapsedMillis = timer.getElapsedTime();
        System.out.println("Finished sorting after " + elapsedMillis + " milliseconds");
        System.out.println("Sorted array result: " + Arrays.toString(array));
        System.out.println("\n");
    }

    public static void main(String[] args) {

        // Insertion Sort O(N^2)
        runTest("Insertion Sort", new InsertSort());

        // Insertion Sort O(N^2)
        runTest("Heap Sort", new HeapSort());
    }
}
