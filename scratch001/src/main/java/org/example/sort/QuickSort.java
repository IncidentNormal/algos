package org.example.sort;

public class QuickSort {

    // Main function to perform Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, low, high);

            // Recursively sort the subarrays
            quickSort(array, low, pivotIndex - 1);  // Sort the left side
            quickSort(array, pivotIndex + 1, high); // Sort the right side
        }
    }

    // Partition function to arrange elements around the pivot
    private static int partition(int[] array, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = array[high];
        int i = low - 1; // Pointer for the smaller element

        // Rearrange elements around the pivot
        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                swap(array, i, j);
            }
        }

        // Swap the pivot element with the element at i + 1
        swap(array, i + 1, high);

        // Return the index of the pivot element after partition
        return i + 1;
    }

    // Helper function to swap elements in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main function to test the Quick Sort implementation
    public static void main(String[] args) {
        int[] array = {9, 3, 7, 5, 6, 2, 8};
        System.out.println("Original array:");
        printArray(array);

        // Perform Quick Sort
        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array:");
        printArray(array);
    }

    // Helper function to print the array
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
