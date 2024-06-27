package Algoritmusok;

import java.util.Arrays;

class Functions {

    static void swap(int[] arr, int i, int j) {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    class Search {

        static int linearSearch(int[] arr, int x) {
            System.out.println("Searching for " + x + "in " + Arrays.toString(arr));
            int i = 0;
            while (i < arr.length && arr[i] != x) {
                i++;
            }
            return i;
        }

        // monoton novekvoen rendezett tombon megkeresi x indexet
        static int binarySearch(int[] arr, int x) {
            System.out.println("Searching for " + x + "in " + Arrays.toString(arr));
            return binSearch(arr, 0, arr.length - 1, x);
        }

        // u -> low
        // v -> high
        // m -> middle
        private static int binSearch(int[] arr, int u, int v, int x) {
            // u >= v is lehet
            if (u > v) {
                return 0;
            }
            int m = (u + v) / 2;
            // System.out.println("m: " + m);

            // leszoritas
            if (arr[m] > x) {
                return binSearch(arr, u, m - 1, x);
            }

            if (arr[m] < x) {
                return binSearch(arr, m + 1, v, x);
            }
            // if (arr[m] == x)
            return m;
        }

        static void naiveInsertionSort(int[] arr) {
            System.out.println("Array: " + Arrays.toString(arr));
            for (int i = 1; i < arr.length; i++) { // n - 1
                int j = i;
                while (j > 0 && arr[j - 1] > arr[j]) { // n - 1
                    swap(arr, j - 1, j);
                    j--;
                }
            }
        }

        static void insertionSort(int[] arr) {
            System.out.println("Array: " + Arrays.toString(arr));
            for (int i = 1; i < arr.length; i++) {
                // System.out.println("(" + i + ") " + Arrays.toString(arr));
                int db = 0;
                if (arr[i - 1] > arr[i]) {
                    db++;
                    int x = arr[i];
                    arr[i] = arr[i - 1];
                    int j = i - 2;

                    while (j >= 0 && arr[j] > x) {
                        db++;
                        arr[j + 1] = arr[j];
                        j--;
                    }
                    arr[j + 1] = x;
                }
                System.out.println("db: " + db);
                System.out.println("(" + i + ") " + Arrays.toString(arr));
            }
        }

        static void bubbleSort(int[] arr, int n) {
            System.out.println("Array: " + Arrays.toString(arr));
            for (int i = n - 1; i >= 1; i--) { // n - 1
                for (int j = 0; j <= i - 1; j++) { // i - 1
                    if (arr[j] > arr[j + 1]) { // i - 1
                        swap(arr, j, j + 1); // i - 1
                    }
                    // System.out.println("(" + i + ") " + Arrays.toString(arr));
                }
            }
        }
    }
}
