package com.company;

public class ReverseSortTest {
    /**
     * reversing Bubble Sort Test
     * @param arr
     */
    public void reverseBubbleSortTest(int[] arr) {
        int n = arr.length;
        int[] arrayTest = new int[n];
        for (int i = 0; i < n; i++) {
            arrayTest[i] = arr[i];
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ( n - 1 ); i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayTest[j] < arrayTest[j+1])
                {
                    int temp = arrayTest[j];
                    arrayTest[j] = arrayTest[j+1];
                    arrayTest[j+1] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        for (int k = 0; k < n; k++) {
            System.out.print(arrayTest[k] + " ");
        }
        System.out.println();
        System.out.println("Total execution time: "+ (endTime-startTime));
    }

    /**
     * reversing Selection Sort Test
     * @param arr
     */
    public void reverseSelectionSortTest(int[] arr) {
        int n = arr.length;
        int[] arrayTest = new int[n];
        for (int i = 0; i < n; i++) {
            arrayTest[i] = arr[i];
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n-1; i++) {
            int index = i;
            for (int j = i+1; j < n; j++) {
                if (arrayTest[j] > arrayTest[index]) {
                    index = j;
                }
            }
            int temp = arrayTest[index];
            arrayTest[index] = arrayTest[i];
            arrayTest[i] = temp;

        }
        long endTime = System.currentTimeMillis();
        for (int k = 0; k < n; k++) {
            System.out.print(arrayTest[k] + " ");
        }
        System.out.println();
        System.out.println("Total execution time: "+ (endTime-startTime));
    }

    /**
     * reversing Insertion Sort Test
     * @param arr
     */
    public void reverseInsertionSortTest(int[] arr) {
        int n = arr.length;
        int[] arrayTest = new int[n];
        for (int i = 0; i < n; i++) {
            arrayTest[i] = arr[i];
        }
        long startTime = System.currentTimeMillis();
        int j,l;
        for (int i = 1; i < n; i++ ) {
            l = arrayTest[i];
            j = i - 1;
            while (j >=0 && l > arrayTest[j]) {
                int temp = arrayTest[j];
                arrayTest[j] = arrayTest[j+1];
                arrayTest[j+1] = temp;
                j--;
            }

        }
        long endTime = System.currentTimeMillis();
        for (int k = 0; k < n; k++) {
            System.out.print(arrayTest[k] + " ");
        }
        System.out.println();
        System.out.println("Total execution time: "+ (endTime-startTime));
    }

    public static void main(String[] args) {
        ReverseSortTest task = new ReverseSortTest();
        int[] arrayTest = new int[10000];
        System.out.println("System will randomly create ten thousands (10000) of numbers for you.");
        for (int i = 0; i < 10000; i++) {
            arrayTest[i] = (int)Math.floor((Math.random()*9999)+1);
        }
        int m = arrayTest.length;
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < m -1 - i; j++) {
                if (arrayTest[j] > arrayTest[j+1]) {
                    int temp = arrayTest[j];
                    arrayTest[j] = arrayTest[j+1];
                    arrayTest[j+1] = temp;
                }
            }
        }
        for (int k = 0; k < m; k++) {
            System.out.print(arrayTest[k] + " ");
        }
        System.out.println("Start:");
        System.out.println("1. Bubble sort Test: ");
        task.reverseBubbleSortTest(arrayTest);
        System.out.println("2. Selection sort Test: ");
        task.reverseSelectionSortTest(arrayTest);
        System.out.println("3. Insertion sort Test: ");
        task.reverseInsertionSortTest(arrayTest);
    }
}
