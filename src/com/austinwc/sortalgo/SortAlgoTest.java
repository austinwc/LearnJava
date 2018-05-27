package com.austinwc.sortalgo;

import com.austinwc.testutils.ApproxTimeElapsed;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class SortAlgoTest {
    private static boolean isSorted(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i])
                return false;
        }
        return true;
    }

    private static Integer[] createMixedArray(int size) {
        Random rand = new Random();
        int upperBound = 10000;
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

    private static void runTest(IntegerSort sortAlgo, int inputSize,
                                String inputType, Function<Integer, Integer[]> genInput) {

        ApproxTimeElapsed timer = new ApproxTimeElapsed();
        Integer[] array;
        long elapsedMillis;

        // Test setup
        array = genInput.apply(inputSize);

        // Run test
        System.out.println("Testing on " + inputSize + " " + inputType + " elements...");
        timer.setStartTime();
        sortAlgo.sort(array);
        elapsedMillis = timer.getElapsedTime();

        // Check Result and report
        if (!isSorted(array)) {
            System.out.println("Array: " + Arrays.toString(array));
            throw new IllegalStateException("Array not sorted!");
        }
        System.out.println("Finished sorting after " + elapsedMillis + " milliseconds");
        System.out.println();
    }

    private static void runTests(String sortName, IntegerSort sortAlgo) {
        System.out.println("====== Testing " + sortName + " ======");
        runTest(sortAlgo, 50000, "random", SortAlgoTest::createMixedArray);
        runTest(sortAlgo, 10000, "sorted", SortAlgoTest::createSortedArray);
        runTest(sortAlgo, 10000, "reversed", SortAlgoTest::createReversedArray);
        System.out.println();
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

        // MergeSort O(NlogN) -> space complexity O(N)
        runTests("Merge Sort", new MergeSort());
    }
}
