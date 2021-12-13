/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpobligatorio2019.ordenamiento;

import utiles.Aleatorio;
import java.util.Arrays;

/**
 *
 * CofreFAI-1504, AnsolaFAI 1169, PerelloFAI-1403
 */
public class RadixSort {

    // A utility function to get maximum value in arr[] 
    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array 
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    static void radixsort(int arr[], int n) {
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    // A utility function to print an array 
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*Driver function to check for above function*/
    public static void main(String[] args) {
        int n = 5000;
        int arr[] = new int[n];
        Aleatorio.intAleatorio(n, n);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Aleatorio.intAleatorio(1, 1000);
        }
        long inicio = System.nanoTime(); // Tomamos la hora del sistema en nanosegundos
        radixsort(arr, n);
        long fin = System.nanoTime();
        System.out.println("Se tardo: " + (fin - inicio) + " nanosegundos en obtener los numeros");
        System.out.println("");
        print(arr, n);
    }
}
