package repaso;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



/**
 *
 * @author cofreflavia
 */

public class E2Scanner {
    static final int CANTNUMEROS = 10;
    static final int MAX_VALOR = 1000000;
    static final String NOMBRE_ARCHIVO = "adea28082020/ejemploIO/numeros.txt";

    public static void leerArchivo_1(){
    	try{
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
    		Scanner s = new Scanner(buff);
    		for (int i = 0; i < CANTNUMEROS  ; i++){
    			//System.out.println( Integer.parseInt(buff.readLine()));
    			System.out.println(s.nextInt());
    		}
    		buff.close();
    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
}