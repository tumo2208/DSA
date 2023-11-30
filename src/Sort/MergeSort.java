package Sort;

import java.util.List;

public class MergeSort {
    /**
     * Function to merge 2 arrays.
     * @param arr array
     * @param l left index of array to be considered
     * @param m mid index of array to be considered
     * @param r right index of array to be considered
     */
    private void merge(List<Integer> arr, int l, int m, int r) {
        //Create two arrays.
        int size1 = m - l + 1;
        int size2 = r - m;
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        for (int i = l; i <= m; ++i) {
            arr1[i - l] = arr.get(i);
        }
        for (int j = m + 1; j <= r; ++j) {
            arr2[j - m - 1] = arr.get(j);
        }

        //i is index of arr1 and j is index of arr2
        //k is index of arr
        int i = 0;
        int j = 0;
        int k = l;
        while (i < size1 && j < size2) {
            //If arr1[i] < arr2[j] => arr[k] = arr1[i] and otherwise
            if (arr1[i] < arr2[j]) {
                arr.set(k, arr1[i]);
                i++;
            } else {
                arr.set(k, arr2[j]);
                j++;
            }
            k++;
        }

        //Completely consider all elements of array 1 that have not yet been considered.
        while (i < size1) {
            arr.set(k, arr1[i]);
            i++;
            k++;
        }
        while (j < size2) {
            arr.set(k, arr2[j]);
            j++;
            k++;
        }
    }

    /**
     * Merge Sort
     * @param arr array
     * @param l left index of array to be considered
     * @param r right index of array to be considered
     */
    private void sort(List<Integer> arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /**
     * Merge Sort.
     * Average time complexity: O(nlogn)
     * Best case: O(nlogn) (array is sorted)
     * @param arr array
     */
    public void sort(List<Integer> arr) {
        sort(arr, 0, arr.size() - 1);
    }
}
