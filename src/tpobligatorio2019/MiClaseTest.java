/*
 * Cofre Flavia / Ansola Belén / Perello Leonardo
 */
package tpobligatorio2019;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static tpobligatorio2019.miClase.*;

/**
 *
 *
 */
public class MiClaseTest {

    public MiClaseTest() {

    }

    @Test
    public void testRendixSort() {

        String[] ordenAleatorio = RandomAccesos.leerArchivo(1000);
        String[] arreglo = ordenAleatorio.clone();
        selectionSort(arreglo);
        radixSort(ordenAleatorio, ordenAleatorio.length);
        String[] resultadoEsperada = obtenerUltimos(200, arreglo);
        String[] arregloAVerificar = obtenerUltimos(200, ordenAleatorio);

        assertArrayEquals(resultadoEsperada, arregloAVerificar);

    }

    @Test
    public void testHeap() {
        long[] arregloAVerificar = {30, 27, 3, 120};
        long[] resultadoEsperado = {3, 27, 30, 120};
        heapSort(arregloAVerificar);

        assertArrayEquals(resultadoEsperado, arregloAVerificar);
    }

    @Test
    public void testHeapSort() {
        long[] arregloAVerificar = {79, 50, 2, 54, 13, 11, 102, 68};
        long[] resultadoEsperado = arregloAVerificar.clone();

        selectionSort(resultadoEsperado);
        heapSort(arregloAVerificar);
        assertArrayEquals(resultadoEsperado, arregloAVerificar);
    }

    @Test
    public void testObtenerUltimos() {
        String[] ordenAleatorio = RandomAccesos.leerArchivo(100);
        String[] ultimos = obtenerUltimos(4, ordenAleatorio);
        int resultadoEsperado = 4;
        assertEquals(resultadoEsperado, ultimos.length);

    }

    @Test
    public void testEliminarUsuarios() {
        String[] aleatorio = {"2019/08/30 13:21:50--Agus", "2019/08/30 12:20:50--Belen", "2019/09/01 18:45:38--Flavia", "2019/08/31 14:30:17--Leo"};
        String[] resultadoEsperado = {"2019/08/30 13:21:50", "2019/08/30 12:20:50", "2019/09/01 18:45:38", "2019/08/31 14:30:17"};
        String[] eliminado = eliminarUsuarios(aleatorio);
        assertArrayEquals(resultadoEsperado, eliminado);
    }

    @Test
    public void testObtenerFechaHora() {
        String aleatorio = "2019-08-30 13:21:50--Agus";
        String resultadoEsperado = "2019-08-30 13:21:50";
        String fechaHora = obtenerFechaHora(aleatorio);
        assertEquals(resultadoEsperado, fechaHora);
    }

    @Test
    public void TestConvertirListaNros() {
        String[] aleatorio = {"2019/08/30 13:21:50", "2019/08/30 12:20:50", "2019/09/01 18:45:38", "2019/08/31 14:30:17"};
        long[] arrayNros = convertirListaNros(aleatorio);
        long[] resultadoEsperado = {1567182110, 1567178450, 1567374338, 1567272617};//cantidad de segundos transcurridos desde 1970/01/01 00:00:00 
        assertArrayEquals(resultadoEsperado, arrayNros);

    }

    @Test
    public void asignarNumero() {
        long numero = asignarNro("2003/04/01 01:03:41");
        long resultadoEsperado = 1049169821;//cantidad de segundos transcurridos desde 1970/01/01 00:00:00 
        assertEquals(resultadoEsperado, numero);
    }

    @Test
    public void testTiempos1() {
        int[] n = {100, 1000, 10000};
        for (int i = 0; i < 3; i++) {
            String[] a = RandomAccesos.leerArchivo(n[i]);
            double t1 = System.currentTimeMillis();
            radixSort(a, a.length);
            double t2 = System.currentTimeMillis();
            System.out.println("**Para n=" + n[i] + " TIEMPO RADIX=" + (t2 - t1));
        }
        System.out.println("");

    }

    @Test
    public void testTiempos2() {
        int[] n = {100, 1000, 10000};
        for (int i = 0; i < 3; i++) {
            String[] a = RandomAccesos.leerArchivo(100);
            long[] a2 = convertirListaNros(eliminarUsuarios(a));
            double t1 = System.currentTimeMillis();
            heapSort(a2);
            double t2 = System.currentTimeMillis();
            System.out.println("**Para n=" + n[i] + " TIEMPO HeapSort=" + (t2 - t1));
        }
        System.out.println("");
    }

    @Test
    public void testTiempos3() {
        int[] n = {100, 1000, 10000};
        for (int i = 0; i < 3; i++) {
            String[] a = RandomAccesos.leerArchivo(100);
            String[] a2 = eliminarUsuarios(a);
            double t1 = System.currentTimeMillis();
            selectionSort(a2);
            double t2 = System.currentTimeMillis();
            System.out.println("**Para n=" + n[i] + " TIEMPO Selection=" + (t2 - t1));
        }
        System.out.println("");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
