/*
	Luke Kim - 1478875
	COSC 3320: Algorithms and Data Structures – Assignment 1 - Problem 4
	Due: February 3, 2020
*/

package com.company;
import java.util.Scanner;

public class Main {

    /*
     This binary search function takes in four parameters.
     These include the array, its first and last elements, and the key the function will search for.
     The search is recursive and will run until all options have been exhausted or the key is found
    */
    static int binarySearch(int array[], int first, int last, int key) {
        if (last >= 1) {
            int mid = 1 + (last - 1) / 2;

            // If the middle of the array is our key then we have successfully found the key
            if (array[mid] == key) {
                return mid;
            }

            // If the key is smaller than the middle of the array, the function recursively decreases the search space
            if (array[mid] > key) {
                return binarySearch(array, first, mid - 1, key);
            }

            return binarySearch(array, mid + 1, last, key);
        }
        return -1;
    }

    public static void main(String[] args) {

        // This array stores the sizes that the sequence of arrays will take
        int sizes[] = {128, 512, 2048, 8192, 32768, 131072, 524288, 297152};

        Main object = new Main();
        double start, stop, end_result;
        try (Scanner scan = new Scanner(System.in)) {

            // This for loop runs eight times to match the number of elements in the sizes array
            for (int i = 0; i < 8; i++) {
                // This variable will be assigned the same value as the current index of the array sizes
                int size = sizes[i];
                int array[] = new int[size];
                for (int j = 0; j < size; j++) {
                    array[j] = 7;
                }

                // This function times the binarySearch function on the current size of the array
                start = System.currentTimeMillis();
                for (int k = 0; k < 10000000; k++) {
                    binarySearch(array, 0, size, 1);
                }
                stop = System.currentTimeMillis();

                end_result = ((stop - start) / 1000);

                System.out.println("Time for size " + size + " is: " + end_result + " seconds");
            }

        }
    }
}
