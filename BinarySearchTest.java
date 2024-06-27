package Algoritmusok;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchTest {
    private static final int MAX_ARRAY_SIZE = 100;
    private static final int MAX_ELEMENT_VALUE = 1000;

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int size = random.nextInt(MAX_ARRAY_SIZE) + 1;
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = random.nextInt(MAX_ELEMENT_VALUE) + 1;
            }
            Arrays.sort(arr); // ensure the array is sorted for binary search
            int x = random.nextInt(MAX_ELEMENT_VALUE) + 1;
            int expectedIndex = Arrays.binarySearch(arr, x);
            int actualIndex = binarySearch(arr, x);
            if (expectedIndex != actualIndex) {
                System.out.println("Test failed for array " + Arrays.toString(arr) +
                        " and element " + x +
                        ". Expected index: " + expectedIndex +
                        ", actual index: " + actualIndex);
            }
        }
        System.out.println("Tests complete.");
    }

    private static int binarySearch(int[] arr, int x) {
        System.out.println("Searching for " + x + " in " + Arrays.toString(arr));
        return binSearch(arr, 0, arr.length - 1, x);
    }

    private static int binSearch(int[] arr, int u, int v, int x) {
        if (u > v) {
            return -1;
        }
        int m = (u + v) / 2;
        if (arr[m] > x) {
            return binSearch(arr, u, m - 1, x);
        }
        if (arr[m] < x) {
            return binSearch(arr, m + 1, v, x);
        }
        return m;
    }
}
