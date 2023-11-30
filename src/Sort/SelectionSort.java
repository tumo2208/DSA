package Sort;

import java.util.List;

public class SelectionSort {
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
     * Selection Sort.
     * Average time complexity: O(n^2)
     * Best case: O(n^2) (array is sorted) 0 swaps
     * Worst case: O(n^2) (array is sorted from 0 to n - 2 but arr[n - 1] is smaller than all other elements) n swaps
     * All case need n*(n-1)/2 comparisions.
     * @param arr array
     */
    public void sort(List<Integer> arr) {
        int n = arr.size();
        int _min;
        for (int i = 0; i < n - 1; ++i) {
            _min = i;
            //Loop to find index of elements that is smaller than arr[_min]
            for (int j = i + 1; j < n; ++j) {
                if (arr.get(j) < arr.get(_min)) {
                    _min = j;
                }
            }
            //Swap arr[_min] with arr[i] in order to Swap minimum elements to first place of arrays.
            swap(arr, i, _min);
        }
    }
}
