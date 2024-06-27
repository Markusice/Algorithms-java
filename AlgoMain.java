package Algoritmusok;

import java.util.Arrays;

class AlgoMain {

    public static void main(String[] args) {
        // int[] A = { 1, 4, 5, 9, 10 };
        // int x = 4;

        // long start = System.currentTimeMillis();

        // System.out.println("Linear search: " + Functions.Search.linearSearch(A, x));

        // long finish = System.currentTimeMillis();
        // System.out.println("Execution time: " + (finish - start) + "ms");

        // System.out.println("----------------------");

        // start = System.currentTimeMillis();
        // System.out.println("Binary search: " + Functions.Search.binarySearch(A, x));

        // finish = System.currentTimeMillis();
        // System.out.println("Execution time: " + (finish - start) + "ms");
        // System.out.println("----------------------");

        // int[] B = { 1, 12, 5, 20, 10, 51, 34 };
        // System.out.println("B = " + Arrays.toString(B));

        // start = System.currentTimeMillis();

        // Functions.Search.naiveInsertionSort(B);

        // finish = System.currentTimeMillis();
        // System.out.println("Execution time: " + (finish - start) + "ms");

        // System.out.printf("naiveInsertionSort:\n");
        // System.out.println(Arrays.toString(B));
        // System.out.println("----------------------");

        // int[] C = { 24, 9, 2, 10, 19, 28, 24, 12 };

        // Functions.Search.insertionSort(C);

        // System.out.printf("insertionSort:\n");
        // System.out.println(Arrays.toString(C));
        // System.out.println("----------------------");

        int[] D = { 51, 34, 20, 12, 10, 5, 1 };

        Functions.Search.bubbleSort(D, D.length);

        System.out.printf("bubbleSort:\n");
        System.out.println(Arrays.toString(D));
        System.out.println("----------------------");
    }

}
