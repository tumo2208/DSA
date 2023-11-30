package Sort;

import java.util.List;

public class BubbleSort {
    /**
     * Swap 2 elements of array.
     * @param arr array
     * @param i first element
     * @param j second element
     */
    private void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    /**
     * Bubble sort.
     * Average time complexity: O(n^2)
     * Best case: O(n) (array is Sorted)
     * When we consider the first loop, if array is sorted, isSorted is always true => loop break.
     * Worse case: O(n^2) (array is reversely sorted) n*(n-1)/2 swaps.
     * @param arr array
     */
    public void sort(List<Integer> arr) {
        int n = arr.size();
        boolean isSorted;
        for (int i = 0; i < n; ++i) {
            isSorted = true;
            //Loop to consider all pair of element and next
            //If element is smaller than before => swap and array isn't sorted.
            //If there are no swaps => array is sorted and loop break.
            for (int j = 0; j < n - i - 1; ++j) {
                if (arr.get(j) > arr.get(j + 1)) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }
}
