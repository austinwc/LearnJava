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

    private static void runTests(String sortName, IntegerSort sortAlgo) {
        ApproxTimeElapsed timer = new ApproxTimeElapsed();
        Integer[] array;
        long elapsedMillis;

        System.out.println("====== Testing " + sortName + " ======");

        // Random Input
        array = createMixedArray(10000, 10000);
        System.out.println("Testing on random elements...");
        timer.setStartTime();
        sortAlgo.sort(array);
        elapsedMillis = timer.getElapsedTime();
        System.out.println("Finished sorting after " + elapsedMillis + " milliseconds");
        System.out.println();

        // Reversed Input
        array = createReversedArray(10000);
        System.out.println("Testing on reversed elements...");
        timer.setStartTime();
        sortAlgo.sort(array);
        elapsedMillis = timer.getElapsedTime();
        System.out.println("Finished sorting after " + elapsedMillis + " milliseconds");
        System.out.println();

        // Sorted Input
        array = createSortedArray(10000);
        System.out.println("Testing on sorted elements...");
        timer.setStartTime();
        sortAlgo.sort(array);
        elapsedMillis = timer.getElapsedTime();
        System.out.println("Finished sorting after " + elapsedMillis + " milliseconds");
        System.out.println("\n");
    }

    public static void main(String[] args) {

        // Insertion Sort O(N^2)
        runTests("Insertion Sort", new InsertSort());

        // Heap Sort O(NlogN)
        runTests("Heap Sort", new HeapSort());

        // Quick Sort O(NlogN) -> worst case O(N^2)
        runTests("Quick Sort", new QuickSort());

        // Randomized Quick Sort O(NlogN)
        runTests("Randomized Quick Sort", new RandomizedQuickSort());
    }
}
