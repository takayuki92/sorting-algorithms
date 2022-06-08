package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    /**
     * Writing the array read from the input array arr to file
     * @param fileName The file name of the file to write value
     * @param arr The input float array
      */
    public void writeFile(String fileName, float[] arr) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (float num : arr) {
                bw.write(num + " ");
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println();
        }
    }

    /**
     * Read the file then input to the array arr
     * @param fileName The file name of the file to read
     * @return Returning a array read from the file
     */
    public float[] readFile(String fileName) {
        List<String> list = new ArrayList<>();//List that holds numbers of a file
        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName)); //load data from a file
            String num;
            while (true) {
                num = br.readLine();
                list.add(num);
                if (num == null) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
        String[] b = list.toArray(list.toArray(new String[0]));
        float[] a = new float[b.length];
        for (int i = 0; i < b.length; i++) {
            a[i] = Float.parseFloat(b[i]);
            System.out.println(a[i]);
        }
        return a;
    }

    /**
     * File writting for sorting methods
     *
     */
    public void writeFileForSorting(String fileName, float[] b) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));){
            for (float num : b) {
                bw.write(num + " ");
            }
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            System.out.println();
        }
    }

    /*Sorting the input array arr using Bubble Sort Algorithm*/
    public float[] bubbleSort(float[] arr) {
        float[] b = new float[arr.length];
        for (int i = 0; i < arr.length; i++) {
            b[i] = arr[i];
        }
        for (int i = 0; i < b.length-1; i++) {
            for (int j = 0; j < b.length -1 -i; j++) {
                if (b[j] > b[j+1]) {
                    int temp = (int) b[j];
                   b[j] = b [j+1];
                    b[j+1] = temp;
                }

            }
            for (int k = 0; k < b.length; k++) {
                System.out.print(b[k] + " ");
            }
            System.out.println();
            this.writeFileForSorting("OUTPUT1.TXT",b);
        }
        return b;
    }

    /*Sorting the input array arr using Selection Sort Algorithm*/
    public float[] selectionSort(float[] arr) {
        float[] b = new float[arr.length];
        for (int i = 0; i < arr.length; i++) {
            b[i] = arr[i];
        }
        int minIndex;
        for (int i = 0; i < b.length-1;i++) {
            minIndex = i;
            for (int j = i + 1; j < b.length; j++) {
                if (b[j] < b[minIndex]) {
                    minIndex = j;
                }

            }
            float temp = b[minIndex];
            b[minIndex] = b[i];
            b[i] = temp;

            for (int k = 0; k < b.length; k++) {
                System.out.print(b[k] + " ");
            }
            System.out.println();
            this.writeFileForSorting("OUTPUT2.TXT",b);
        }
        return b;
    }

    /*Sorting the input array arr using Insertion Sort Algorithm*/
    public float[] insertionSort(float[] arr) {
        float[] b = new float[arr.length];
        for (int i = 0; i < arr.length; i++) {
            b[i] = arr[i];
        }
        int j;
        float k, temp;
        for (int i = 1; i < b.length; i++) {
            k = b[i];
            j = i - 1;
            while (j >= 0 && k < b[j]) {
                temp = b[j];
                b[j] = b[j+1];
                b[j+1] = temp;
                j--;
            }
            for (int l = 0; l < b.length; l++) {
                System.out.print(b[l] + " ");
            }
            System.out.println();
            this.writeFileForSorting("OUTPUT3.TXT",b);
        }
        return b;
    }

    /**
     * Searching the indices of elements in array arr greater than value. Printing
     * and writing all indices to the console screen.
     * @param arr Input array using for searching
     * @param value The value for searching
     */
    public void search(float[] arr, float value) {
        List<Float> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                list.add((float) i);
            }
        }
        Float[] b = list.toArray(new Float[0]);
        System.out.print("Chi so la: ");
        for (int i = 0; i < b.length; i++) {
           System.out.println(b[i] + " ");
        }
    }

    /**
     * Searching by using the Binary Search algorithm. Return first index of value if it
     * is present in array arr, otherwise, return -1.
     * and shown on the console screen.
     * @param arr Input array using for searching
     * @param value The value for searching
     *
     */
    public int binarySearch(float[] arr, float value) {
       float[] b = this.bubbleSort(arr);
       int left = 0;
       int right = arr.length -1;
       while (left <= right) {
           int middle = (left+right)/2;
           if(value < arr[middle]) { // too high
               right = middle -1;
           } else if(value > arr[middle]) { //too low
               left = middle + 1;
           } else { //just right
               b[0] = arr[middle];
                return middle;
           }
       }
       return -1;
    }
}
