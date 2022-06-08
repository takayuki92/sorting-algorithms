package com.company;

import java.io.*;
import java.util.Scanner;
public class MainSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] arr = null;
        Algorithm algorithm = new Algorithm();
        while (true) {
            System.out.println ("+-------------------Menu---------------------+\n" +
                                "|      1.Input                               |\n" +
                                "|      2.Output                              |\n" +
                                "|      3.Bubble sort                         |\n" +
                                "|      4.Selection sort                      |\n" +
                                "|      5.Insertion sort                      |\n" +
                                "|      6.Search > value                      |\n" +
                                "|      7.Search = value                      |\n" +
                                "|      0.Exit                                |\n" +
                                "+--------------------------------------------+");
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.print("Good bye, have a nice day!");
                break;
            }
            switch (choice) {
                case 1 :
                    System.out.println("Choice :" + choice);
                    System.out.print("Input number of elements: ");
                    int n = sc.nextInt();
                     arr = new float[n];
                    System.out.print("Input elements: ");
                    for (int i = 0; i < n; i++) {
                        arr[i] = sc.nextInt();
                        System.out.println((int)arr[i]);
                    }
                    algorithm.writeFile("INPUT.TXT",arr);
                    break;
                case 2 :
                    algorithm.readFile("INPUT.TXT");
                    break;
                case 3 :
                    algorithm.bubbleSort(arr);
                    break;
                case 4 :
                    algorithm.selectionSort(arr);
                    break;
                case 5 :
                    algorithm.insertionSort(arr);
                    break;
                case 6 :
                    System.out.print("Line Search \n Input value: ");
                    float value = sc.nextFloat();
                    algorithm.search(arr, value);
                    break;
                case 7 :
                    System.out.print("Binary Search \n Input value: ");
                    value = sc.nextFloat();
                    int result = algorithm.binarySearch(arr, value);
                    System.out.println("Index of first element: " + result);

                    break;
                default :
                    System.out.print("**Invalid choice. Try again.**");
            }

        }
    }
}

