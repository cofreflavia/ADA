package tp0repaso;

import utiles.TecladoIn;

/**
 * Cofre Flavia 
 * 
 * 
 * https://codecollab.io/@flavia/AdeA-TPRepaso
 * 
 * 
 * 
 * La elecion del metodo de ordenamiento está a cargo del usuario, se puede
 * observar el tiempo que tarda en ordenar y así comparar los algoritmos.
 * 
 */



public class main {

    static final String ARCHIVO_LISTA_A = "archivosTexto/ListaA.txt";
    static final String ARCHIVO_LISTA_B = "archivosTexto/ListaB.txt";
    static final String ARCHIVO_LISTA_C = "archivosTexto/ListaC.txt";

    public static void main(String[] args) {
        int longA = 100, longB = 60;
        int[] arregloA = new int[longA];
        int[] arregloB = new int[longB];
        int[] arregloC;

        ArchivoRandomInts.generarArchivo(ARCHIVO_LISTA_A, longA);
        ArchivoRandomInts.leerArchivo(ARCHIVO_LISTA_A, arregloA);

        int[] arregloAuxA = arregloA.clone();

        ArchivoRandomInts.generarArchivo(ARCHIVO_LISTA_B, longB);
        ArchivoRandomInts.leerArchivo(ARCHIVO_LISTA_B, arregloB);

        System.out.println("---------------Ordenar el arregloA con distintos metodos--------------------");
        System.out.println(arregloToString(arregloA));
        elegirOrdenamiento(arregloA);
        System.out.println(arregloToString(arregloAuxA));
        elegirOrdenamiento(arregloAuxA);
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("---------------------Ordenar el arregloB con un metodo----------------------");
        elegirOrdenamiento(arregloB);
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("------------Arreglo C mezcla de arregloA y arregloB ordenados---------------");
        arregloC = mezclar(arregloA, arregloB);
        System.out.println(arregloToString(arregloC));
        System.out.println("-------------------------Fin de arregloC ordenado --------------------------");

    }

    private static int[] mezclar(int[] a, int[] b) {
        int derecha = 0;
        int finDerecha = a.length;
        int izquierda = 0;
        int finIzquierda = b.length;
        int pos = 0;
        int[] arreglo = new int[finDerecha + finIzquierda];

        while (derecha < finDerecha && izquierda < finIzquierda) {
            if (a[derecha] < b[izquierda]) {
                arreglo[pos] = a[derecha];
                derecha++;
                pos++;
            } else {
                arreglo[pos] = b[izquierda];
                izquierda++;
                pos++;
            }
        }
        while (derecha < finDerecha) {
            arreglo[pos] = a[derecha];
            derecha++;
            pos++;
        }
        while (izquierda < finIzquierda) {
            arreglo[pos] = b[izquierda];
            izquierda++;
            pos++;
        }

        return arreglo;

    }

    private static void elegirOrdenamiento(int[] arreglo) {

        int opcion;
        long time_start = 0, time_end = 0;

        menu();
        opcion = TecladoIn.readLineInt();

        switch (opcion) {
            case 1:
                time_start = System.nanoTime();
                MetodosOrdenamiento.bubbleSort(arreglo);
                time_end = System.nanoTime();
                break;
            case 2:
                time_start = System.nanoTime();
                MetodosOrdenamiento.bubbleSortMejorado(arreglo);
                time_end = System.nanoTime();
                break;
            case 3:
                time_start = System.nanoTime();
                MetodosOrdenamiento.selectionSort(arreglo);
                time_end = System.nanoTime();
                break;
            case 4:
                time_start = System.nanoTime();
                MetodosOrdenamiento.insertionSort(arreglo);
                time_end = System.nanoTime();
                break;
            case 5:
                time_start = System.nanoTime();
                MetodosOrdenamiento.mergeSort(arreglo);
                time_end = System.nanoTime();
                break;
            case 6:
                time_start = System.nanoTime();
                MetodosOrdenamiento.quickSort(arreglo);
                time_end = System.nanoTime();
                break;
            case 7:
                time_start = System.nanoTime();
                MetodosOrdenamiento.heapSort(arreglo);
                time_end = System.nanoTime();
                break;
            case 8:
                System.out.println("");
                break;
            default:
                System.out.println(">> INVALIDO: OPCION INCORRECTA <<");
                break;
        }

        if (opcion < 8) {
            System.out.println("---------arreglo ordenado-----------");
            System.out.println(arregloToString(arreglo));
            System.out.println("tiempo transcurrido: " + (time_end - time_start) + " nanoseg");
            System.out.println("------Fin de arreglo ordenado-------");
        }

    }

    private static void menu() {
        System.out.println(" Metodos de ordenamiento ");
        System.out.println(""
                + "1: Burbuja\n"
                + "2: Burbuja Mejorado\n"
                + "3: Selecion\n"
                + "4: Insercion\n"
                + "5: MargeSort\n"
                + "6: QuickSort\n"
                + "7: HeapSort\n"
                + "8: Salir\n"
                + "Ingrese opcion: ");
    }

    static String arregloToString(int[] arreglo) {
        String cadena = "";
        int longitud = arreglo.length;
        for (int i = 0; i < longitud; i++) {
            cadena = cadena + arreglo[i] + " ";
        }
        return cadena;
    }

}