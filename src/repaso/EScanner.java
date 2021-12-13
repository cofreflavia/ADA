package repaso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EScanner {
    static final int CANTNUMEROS = 10;
    static final int MAX_VALOR = 1000000;
    static final String NOMBRE_ARCHIVO = "adea28082020/ejemploIO/numeros.txt";


    public static void leerArchivo_2(){
    	try{
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
    		Scanner s = new Scanner(buff);
    		//Si falla la lectura del float, cambiar el '.' por coma, cuestion de configuracion de idiomas.
    		s = new Scanner("123141   4243.433     unaPalabra \n o muchas palabras seguidas.");

    		System.out.println("Scanner nos da herramientas comodas para leer datos primitivos de distinto tipo");
    		System.out.println(s.nextInt() +" " + s.nextFloat() + " " + s.next() + " "+ s.next());
    		System.out.println(s.nextLine());
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