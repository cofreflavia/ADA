/**
 * 
 */
package repaso;

/**
 *
 * @author cofreflavia
 */

public class main {
    public static void main(String args[]){
        // El tilde 
        System.out.println("este texto no lo entiende..., por que??");
        
        int  aleatorio = (int) (Math.random()*10.0)+10;
        System.out.println("aleatorio entre 10 y 20: "+aleatorio);
        
        
        natiCoding();
        System.out.println("Buen dia, soy federico");
        
        System.out.println("Buen dia, soy Santino");
        System.out.println("buenos dias!");
        System.out.println("Hola soy lucas");
        System.out.println("Buen dia, soy Nicolas");
        System.out.println("Buen dia, soy Leo");
        ahoraestamal();
        System.out.println("Buen dia, soy Matias");
        System.out.println("buenos dias, soy jose luis ");
        
        
        EScanner.leerArchivo_2();
        //E2Scanner.leerArchivo_1();

        
    }
    public static void natiCoding(){
        System.out.println("este es mi metodo, pilas Nacho, Nadi pone orden");
    }
    
    public static void ahoraestamal(){
        System.out.println("delete *.*");
    }
    

}