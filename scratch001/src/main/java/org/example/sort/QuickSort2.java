package org.example.sort;

public class QuickSort2 {

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivotValue = array[high];

        int i = low - 1; // this is the boundary index;
                         // anything to the left is smaller than the pivot and anything to the right is higher

        for (int j = low; j < high; j++) {
            int val = array[j];
            if (val <= pivotValue) {
                i++;
                swap(array, i , j);
            }
        }

        // still one index left (as i started at low - 1):
        swap(array, i + 1, high);

        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }


    public static void main(String[] args) {

        int[] input = new int[] {6, 3, 9, 5, 6, 7, 3, 4, 1, 2, 9, 8, 4, 7, 8, 4, 5, 7 ,1, 2 ,4};
        printArray(input);
        quickSort(input, 0, input.length - 1);
        printArray(input);

    }


}
