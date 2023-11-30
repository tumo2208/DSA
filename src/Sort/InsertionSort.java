package Sort;

import java.util.List;

public class InsertionSort {
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
     * Insertion Sort.
     * Average time complexity: O(n^2)
     * Best case: O(n) (array is sorted)
     * Worst case: O(n^2) (array is reversely sorted)
     * @param arr array
     */
    public void sort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            //All element before i is sorted.
            for (int j = i - 1; j >= 0; --j) {
                // If elements is smaller than elements before => swap.
                if (arr.get(j) > arr.get(j + 1)) {
                    swap(arr, j, j + 1);
                }
                //Else, this is bigger than all elements before => Loop break.
                else {
                    break;
                }
            }
        }
    }
}
