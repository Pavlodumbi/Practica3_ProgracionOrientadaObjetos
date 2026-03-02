import java.util.Random;

/**
 * Esta clase modela un dado que puede
 * tener N lados. Por default crea un dado
 * de 6 lados.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (febrero 2026)
 */
public class Dado
{
    private int caras;
    private int valor;
    
    /**
     * Constructor por default.
     * Crea un dado de 6 lados
     * con valor de 1.
     */
    public Dado() {
        caras = 6;
        valor = 1;
    }
    
    /**
     * Crea un dado con la cantidad de
     * lados especificada.
     * 
     * @param lados Cantidad de lados que tendrá el dado.
     */
    public Dado(int lados) {
        caras = lados;
        valor = 1;
    }
    
    /**
     * Lanza el dado y cambia su valor.
     */
    public void lanzar() {
        Random rnd = new Random();    
        valor = rnd.nextInt(1, caras+1);
    }
    
    /**
     * Regresa el valor actual del dado.
     * @return valor actual del dado
     */
    public int getValor() {
        return valor;
    }
        
    /**
     * Muestra en la consola el valor actual
     * del dado. 
     * <B>Este método no sigue buenas prácticas.</B>
     */
    public void mostrar() {
        System.out.println("El dado vale " + valor + " " + 1.5);
    }
}