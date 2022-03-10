package src.main.java;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        System.out.println("Selection Sort : "+ Arrays.toString(sort.selectionSort(new int[]{64, 25, 12, 22, 11})));
        System.out.println("Selection Sort : " + Arrays.toString(sort.selectionSort(new int[]{64, 25, 12, 22, 11, 1})));
        System.out.println("Selection Sort : " + Arrays.toString(sort.selectionSort(new int[]{64, 25})));
        System.out.println("Selection Sort : " + Arrays.toString(sort.selectionSort(new int[]{64})));
        System.out.println("Bubble Sort : " + Arrays.toString(sort.bubbleSort(new int[]{64, 25, 12, 22, 11})));
        System.out.println("Bubble Sort : " + Arrays.toString(sort.bubbleSort(new int[]{64, 25, 12, 22, 11, 1})));
        System.out.println("Bubble Sort : " + Arrays.toString(sort.bubbleSort(new int[]{64, 25})));
        System.out.println("Bubble Sort : " + Arrays.toString(sort.bubbleSort(new int[]{64})));
        System.out.println("Insertion Sort : " + Arrays.toString(sort.insertionSort(new int[]{64, 25, 12, 22, 11})));
        System.out.println("Insertion Sort : " + Arrays.toString(sort.insertionSort(new int[]{64, 25, 12, 22, 11, 1})));
        System.out.println("Insertion Sort : " + Arrays.toString(sort.insertionSort(new int[]{64, 25})));
        System.out.println("Insertion Sort : " + Arrays.toString(sort.insertionSort(new int[]{64})));
    }

    public int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    private void swap(int[] arr, int index, int minIndex) {
        int tmp = arr[index];
        arr[index] = arr[minIndex];
        arr[minIndex] = tmp;
    }

    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }

    public int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i]; // as flag
            for (int j = i - 1; j >= 0; j--) {
                // current value greater than val, move to right index
                if (arr[j] > val) {
                    swap(arr, j+1, j);
                }
            }
        }
        return arr;
    }

    public int[] quickSort(int [] nums) {
        int left = 0;
        int right = nums.length;
        return nums;
    }

    private void quickSortImpl(int[] arr, int left, int right) {
        int pivotIndex = (left+right) / 2;
        int pivotVal = arr[pivotIndex];
        int i = left - 1;
        int j = right + 1;
        while (i <= j) {
            if (arr[i] < pivotVal) {

            }
            if (arr[j] > pivotIndex) {

            }
            i++;
            j--;
        }
    }

}
