package tpobligatorio2019.ordenamiento;


/**
 *
 * @author Flavia
 */
public class Ordena {

    /**
     * Implementa el algoritmo de ordenamiento por selección.
     *
     * @param a arreglo de enteros desordenado
     *
     */
    public static void selectionSort(int[] a) {
        int i, j, min;
        int aux;
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

    /**
     * Implementa el algoritmo de ordenamiento por inserción.
     *
     * @param a arreglo de enteros desordenado
     */
    public static void insertionSort(int[] a) {
        int temp;
        int j;
        int longitud = a.length;

        for (int p = 1; p < longitud; p++) {
            temp = a[p];
            j = p;

            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j = j - 1;
            }

            a[j] = temp;
        }
    }

    /**
     * Implementa el algoritmo de ordenación quick sort.
     *
     * @param arreglo arreglo de enteros desordenado
     */
    public static void quickSort(int[] arreglo) {
        int longitud = arreglo.length;
        quickSort(arreglo, 0, longitud - 1);
    }

    private static void quickSort(int[] a, int izquierda, int derecha) {
        int pivote = a[izquierda];
        int temp;
        int i = izquierda;
        int j = derecha;

        // Intercambia elementos mayores y menores al pivote
        while (i < j) {
            while (a[i] <= pivote && i < j) {
                i++;
            }
            while (pivote < a[j]) {
                j--;
            }
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        a[izquierda] = a[j];
        a[j] = pivote;

        // Ordena arreglo izquierdo
        if (izquierda < j - 1) {
            quickSort(a, izquierda, j - 1);
        }

        // Ordena arreglo derecho
        if (j + 1 < derecha) {
            quickSort(a, j + 1, derecha);
        }
    }

    /**
     * Implementa el algoritmo de ordenamiento burbuja.
     *
     * @param a arreglo de personas desordenado
     */
    public static void bubbleSort(int[] a) {
        int i, j;
        int longitud = a.length;
        int temp;

        for (i = 0; i < longitud - 1; i++) {
            for (j = 0; j < longitud - 1 - i; j++) {
                if (a[j + 1] < a[j]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Implementa el algoritmo de ordenamiento burbuja.
     *
     * @param a arreglo de personas desordenado
     */
    public static void bubbleSortMejorado(int[] a) {
        boolean desordenado = true;
        int i, j;
        int longitud = a.length;
        int temp;

        for (i = 0; i < longitud - 1 && desordenado; i++) {
            desordenado = false;
            for (j = 0; j < longitud - 1 - i; j++) {
                if (a[j + 1] < a[j]) {
                    desordenado = true;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

    }
    
    
    
    
    
    // Java program for implementation of Heap Sort 
	public static void heapSort(int arr[]) 
	{ 
		int n = arr.length; 

		// Build heap (rearrange array) 
		for (int i = n / 2 - 1; i >= 0; i--) 
			heapify(arr, n, i); 

		// One by one extract an element from heap 
		for (int i=n-1; i>=0; i--) 
		{ 
			// Move current root to end 
			int temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp; 

			// call max heapify on the reduced heap 
			heapify(arr, i, 0); 
		} 
	} 

	// To heapify a subtree rooted with node i which is 
	// an index in arr[]. n is size of heap 
	static void heapify(int arr[], int n, int i) 
	{ 
		int largest = i; // Initialize largest as root 
		int l = 2*i + 1; // left = 2*i + 1 
		int r = 2*i + 2; // right = 2*i + 2 

		// If left child is larger than root 
		if (l < n && arr[l] > arr[largest]) 
			largest = l; 

		// If right child is larger than largest so far 
		if (r < n && arr[r] > arr[largest]) 
			largest = r; 

		// If largest is not root 
		if (largest != i) 
		{ 
			int swap = arr[i]; 
			arr[i] = arr[largest]; 
			arr[largest] = swap; 

			// Recursively heapify the affected sub-tree 
			heapify(arr, n, largest); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver program 
	public static void main(String args[]) 
	{ 
		int arr[] = {12, 11, 13, 5, 6, 7}; 
		

		heapSort(arr); 

		System.out.println("Sorted array is"); 
		printArray(arr); 
	} 
} 

