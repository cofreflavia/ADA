package tp0repaso;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cofreflavia
 */
public class ArchivoRandomInts {

    static final int MAX_VALOR = 1000;

    public static void generarArchivo(String nombreArchivo, int longitud) {
        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(nombreArchivo));
            Random generador = new Random();
            for (int i = 0; i < longitud; i++) {
                int num = generador.nextInt(MAX_VALOR);
                buff.write(num + "\n");
            }
            buff.close();

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo de lectura no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static int[] leerArchivo(String nombreArchivo, int[] arreglo) {
        int longitud = arreglo.length;
        try {
            BufferedReader buff = new BufferedReader(new FileReader(nombreArchivo));
            for (int i = 0; i < longitud; i++) {
                arreglo[i] = Integer.parseInt(buff.readLine());
            }
            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo de lectura no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
        return arreglo;
    }



}