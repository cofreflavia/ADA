/*
 * Cofre Flavia / Ansola Belén / Perello Leonardo
 */
package tpobligatorio2019;

import java.sql.Timestamp;
import java.util.*;

/**
 *
 *
 */
public class miClase {

    static void selectionSort(long[] a) {
        int i, j, min;
        long aux;
        int longitud = a.length;

        for (i = 0; i < longitud - 1; i++) {
            min = i;

            for (j = i + 1; j < longitud; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            aux = a[i];
            a[i] = a[min];
            a[min] = aux;
        }
    }

    public static void selectionSort(String[] array) {
        for (int j = 0; j < array.length - 1; j++) {

            int min = j;
            for (int k = j + 1; k < array.length; k++) {
                if (array[k].compareTo(array[min]) < 0) {
                    min = k;
                }

            }
            String temp = array[j];
            array[j] = array[min];
            array[min] = temp;
        }

    }

    public static void heapSort(long[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end 
            long temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
        }
    }

    static void heapify(long[] arr, int n, int i) {
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 

        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root 
        if (largest != i) {
            long swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest);
        }
    }


    /*
     * Radix sort an array of Strings
     * Assume all are all ASCII
     * Assume all have length bounded by maxLen
     */
    @SuppressWarnings("unchecked")
    public static void radixSort(String[] arr, int maxLen) {
        final int BUCKETS = 256;

        ArrayList<String>[] wordsByLength = new ArrayList[maxLen + 1];
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];

        for (int i = 0; i < wordsByLength.length; i++) {
            wordsByLength[i] = new ArrayList<>();
        }

        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (String s : arr) {
            wordsByLength[s.length()].add(s);
        }

        int idx = 0;
        for (ArrayList<String> wordList : wordsByLength) {
            for (String s : wordList) {
                arr[idx++] = s;
            }
        }

        int startingIndex = arr.length;
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            startingIndex -= wordsByLength[pos + 1].size();

            for (int i = startingIndex; i < arr.length; i++) {
                buckets[arr[i].charAt(pos)].add(arr[i]);
            }

            idx = startingIndex;
            for (ArrayList<String> thisBucket : buckets) {
                for (String s : thisBucket) {
                    arr[idx++] = s;
                }

                thisBucket.clear();
            }
        }
    }

    static String[] obtenerUltimos(int i, String[] regAccesos) {
        int num = regAccesos.length - i;
        String[] nuevo = new String[i];
        int k = 0;
        for (int j = num; j < regAccesos.length; j++) {
            nuevo[k] = regAccesos[j];
            k++;
        }
        return nuevo;
    }

    static long[] obtenerUltimos(int i, long[] regAccesos) {
        int num = regAccesos.length - i;
        long[] nuevo = new long[i];
        int k = 0;
        for (int j = num; j < regAccesos.length; j++) {
            nuevo[k] = regAccesos[j];
            k++;
        }
        return nuevo;
    }

    static String[] eliminarUsuarios(String[] aleatorio) {
        String[] nuevo = new String[aleatorio.length];
        for (int i = 0; i < aleatorio.length; i++) {
            nuevo[i] = obtenerFechaHora(aleatorio[i]);
        }
        return nuevo;
    }

    static String obtenerFechaHora(String fechaHoraUsuario) {
        String fechaHora = fechaHoraUsuario.substring(0, 19);
        return fechaHora;
    }

    static long[] convertirListaNros(String[] arreglo) {
        long[] nuevoArreglo = new long[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            nuevoArreglo[i] = asignarNro(arreglo[i]);
        }
        return nuevoArreglo;
    }

    static long asignarNro(String fechaHora) {//cantidad de segundos transcurridos desde 1970/01/01 00:00:00  
        long mil = 1000;
        long segundos = Timestamp.parse(fechaHora) / mil;
        return segundos;
    }

    static String arregloToString(String[] arreglo) {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            cadena = cadena + arreglo[i] + "\n";
        }
        return cadena;
    }

    static String arregloToString(long[] arreglo) {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            cadena = cadena + arreglo[i] + "\n";
        }
        return cadena;
    }

    public static void main(String[] arg) {
        System.out.println("----------------------------Creacion de archivo de 20 000 registros de acceso--------------------------------");
        RandomAccesos.generarArchivo();

        System.out.println("-------------------------Arreglo de 1000 registros de acceso-------------------------------------------");
        String[] arreglo = RandomAccesos.leerArchivo(1000);
        System.out.println(arregloToString(arreglo));
        System.out.println("----------------------------Fin de arreglo de 1000 registros de acceso----------------------------------------");

        String[] arregloA = arreglo.clone();
        String[] arregloB = arreglo.clone();

        System.out.println("----------------------Arreglo ordenado por Radix-----------------------");
        radixSort(arregloA, arregloA.length);
        System.out.println(arregloToString(arregloA));
        System.out.println("------------------Fin de arreglo ordenado por Radix--------------------");

        System.out.println("----------------Arreglo de ultimos 200 reg de acceso-------------------");
        String[] arrayDosCientos = obtenerUltimos(200, arregloA);
        System.out.println(arregloToString(arrayDosCientos));
        System.out.println("-------------Fin de arreglo de ultimos 200 reg de acceso---------------");

        System.out.println("\n");

        String[] arregloFechaHora = eliminarUsuarios(arregloB);

        System.out.println("-------------Arreglo de accesos sin usuarios---------------------------");
        System.out.println(arregloToString(arregloFechaHora));
        System.out.println("---------Fin de arreglo de accesos sin usuario-------------------------");
        long[] arregloNros = convertirListaNros(arregloFechaHora);
        System.out.println("------------Arreglo de números únicos asignado a cada uno de los registros de acceso-------------");
        System.out.println(arregloToString(arregloNros));
        System.out.println("--------------------Fin de arreglo de números----------------------------------------");

        System.out.println("----------------------Arreglo ordenado por Heap--------------------------------------");
        heapSort(arregloNros);
        System.out.println(arregloToString(arregloNros));
        System.out.println("---------------------Fin de arreglo ordenado por Heap--------------------------------");

        System.out.println("------------------------------Arreglo de ultimos 200 --------------------------------");
        long[] ultimos2 = obtenerUltimos(200, arregloNros);
        System.out.println(arregloToString(ultimos2));
        System.out.println("----------------------------Fin de arreglo de ultimos 200----------------------------");

    }

}
