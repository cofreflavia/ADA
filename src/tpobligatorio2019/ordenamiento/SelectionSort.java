/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpobligatorio2019.ordenamiento;

import utiles.Aleatorio;

/**
 *
 * CofreFAI-1504, AnsolaFAI 1169, PerelloFAI-1403
 */
class SelectionSort {

    void sort(int arr[]) {
        int n = arr.length;

        // Límite de movimiento uno por uno de un arreglo sin ordenar
        for (int i = 0; i < n - 1; i++) {
            // Encuentra el elemento mínimo 
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Intercambie el elemento mínimo encontrado con el primer elemento
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Prints the array 
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver code to test above 
    public static void main(String args[]) {

        int n = 1000;
        int arr[] = new int[n];
        Aleatorio.intAleatorio(n, n);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Aleatorio.intAleatorio(1, 1000);
        }
        long inicio = System.nanoTime(); // Tomamos la hora del sistema en nanosegundos
        SelectionSort ob = new SelectionSort();
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
        long fin = System.nanoTime();
        System.out.println("Se tardo: " + (fin - inicio) + " nanosegundos en obtener los numeros");
    }
}
