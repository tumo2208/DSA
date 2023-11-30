package Sort;

import java.util.List;

public class QuickSort {
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
     * Function to find right place of last element in array.
     * Replace all element smaller than last element to first place array
     * Replace all element bigger than last element to last place array
     * @param arr array
     * @param l left index of array to be considered
     * @param r right index of array to be considered
     * @return right place of last element
     */
    private int partition(List<Integer> arr, int l, int r) {
        int res = l;
        int pivot = arr.get(r);
        for (int i = l; i < r; ++i) {
            if (arr.get(i) < pivot) {
                swap(arr, res, i);
                res++;
            }
        }
        swap(arr, res, r);
        return res;
    }

    /**
     * Quick Sort.
     * @param arr array
     * @param l left index of array to be considered
     * @param r right index of array to be considered
     */
    private void sort(List<Integer> arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            sort(arr, l, p - 1);
            sort(arr, p + 1, r);
        }
    }

    /**
     * Quick Sort.
     * Average time complexity: O(nlogn)
     * @param arr array
     */
    public void sort(List<Integer> arr) {
        sort(arr, 0, arr.size() - 1);
    }
}
