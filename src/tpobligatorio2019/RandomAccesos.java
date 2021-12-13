/*
 * Cofre Flavia / Ansola Belén / Perello Leonardo
 */
package tpobligatorio2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

/**
 *
 *
 */
public class RandomAccesos {

    static final int CANT_REGISTROS = 20000;

    static final String NOMBRE_ARCHIVO = "src/tpobligatorio1/regDeAccesos.txt";

    public static void generarArchivo() {
        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
            long rangebegin = Timestamp.valueOf("2000-01-01 00:00:00").getTime();
            long rangeend = Timestamp.valueOf("2019-09-06 23:59:59").getTime();
            long diff = rangeend - rangebegin + 1;

            for (int i = 0; i < CANT_REGISTROS; i++) {
                Timestamp rand = new Timestamp(rangebegin + (long) (Math.random() * diff));
                rand.setNanos(0);

                String n = rand + "";
                buff.write(n.substring(0, 4) + "/" + n.substring(5, 7) + "/" + n.substring(8, 19) + "--" + "User " + (int) (Math.random() * 1000) + 1 + "\n");

            }
            buff.close();

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static String[] leerArchivo(int cantDeString) {

        String[] arreglo = new String[cantDeString];

        try {
            BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
            for (int i = 0; i < cantDeString; i++) {
                arreglo[i] = buff.readLine();

            }
            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
        return arreglo;
    }

}
