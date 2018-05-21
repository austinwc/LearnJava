package com.austinwc.sortalgo;

/*
 * Implements Heap Sort -> O(NlogN)
 *
 * Overview:
 *  - turn array into heap
 *  - swap max element with end of heap
 *  - re-heapify and repeat
 *
 *  Heap Creation:
 *   - Second half of any array is all leaves
 *   - re-heapify from bottom up
 */
public class HeapSort implements IntegerSort{
    @Override
    public void sort(Integer[] array) {
        if (array.length == 0) return;

        // Turn array into heap -> O(N/2 logN)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }

        for (int len = array.length - 1; len >= 0; len--) {
            swap(array, 0, len);
            heapify(array, 0, len);
        }
    }

    private void heapify(Integer[] array, int root, int size) {
        int largest = root;
        int left = left(root), right = right(root);

        if (left < size && array[left] > array[largest]) largest = left;
        if (right < size && array[right] > array[largest]) largest = right;

        if (root != largest) {
            swap(array, largest, root);
            heapify(array, largest, size);
        }
    }

    private void swap(Integer[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return i * 2 + 1; }
    private int right(int i) { return i * 2 + 2; }

}
