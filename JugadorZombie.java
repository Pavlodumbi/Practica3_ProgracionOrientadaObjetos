
/**
 * Write a description of class JugadorZombie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JugadorZombie
{
    private String nombre;
    private int cerebrosTotales;
    private int cerebrosTemporales;
    private int corredores;
    private int escopetas;
    /**
     * Constructor for objects of class JugadorZombie
     */
    public JugadorZombie(String nombre)
    {
        this.nombre = nombre;
        cerebrosTotales = 0;
        cerebrosTemporales = 0;
        corredores = 0;
        escopetas = 0;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getCerebros(){
        return cerebrosTotales;
    }
    
    public int getTempCerebros(){
        return cerebrosTemporales;
    }
    
    public int getCorredores(){
        return corredores;
    }
    
    public int getEscopetas(){
        return escopetas;
    }
    

}