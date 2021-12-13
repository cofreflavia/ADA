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
public class HeapSort {

    public void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {  // Tfor=tini+Σmaxmin (tcond+tinter+tinc) Tini=1asig=1+Tinter+tinc
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {  // Tfor=tini+Σmaxmin (tcond+tinter+tinc) Tini=1asig=1+Tinter+tinc
            int temp = arr[0];              //T1=1asig+1acceso= 2
            arr[0] = arr[i];                //T2=1asig+1acceso= 2
            arr[i] = temp;                  //T3=1asig+1acceso= 2

            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;                  //T4=1asig+2OpMat= 3
        int r = 2 * i + 2;                  //T5=1asig+2OpMat= 3

        if (l < n && arr[l] > arr[largest]) {   //Tcond = 21operLogica +2acc=4
            largest = l;                        //T6 = 1asig=1;
        }

        if (r < n && arr[r] > arr[largest]) {   //Tcond = 31operLogica +2acc=5
            largest = r;                        //T7 = 1asig=1;
        }

        if (largest != i) {                     //Tcond = 1operLogica +1asig=2
            int swap = arr[i];                  //T8 =1OpLogica+1asig=2;
            arr[i] = arr[largest];              //T9 = 1asig+2acc=3;
            arr[largest] = swap;                //T10 = 1asig+1acc=2;

            heapify(arr, n, largest);
        }
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int n = 1000;
        int arr[] = new int[n];
        Aleatorio.intAleatorio(n, n);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Aleatorio.intAleatorio(1, 1000);
        }
        long inicio = System.nanoTime(); // Tomamos la hora del sistema en nanosegundos
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        System.out.println("Sorted array is");
        ob.printArray(arr);
        long fin = System.nanoTime();
        System.out.println("Se tardo: " + (fin - inicio) + " nanosegundos en obtener los numeros");
    }
}
