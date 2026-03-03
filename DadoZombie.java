
/**
 * Write a description of class DadoZombie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DadoZombie
{
    private String valor;
    private String color;
    private Dado dado;
    private String[] posiblesValores;
    /**
     * Constructor for objects of class DadoZombie
     */
    public DadoZombie(String color)
    {
        dado = new Dado();
        this.color = color;
        posiblesValores = new String[6];
        decidirPosiblesValores();
    }
    
    private void decidirPosiblesValores(){
         if(color == "green"){
            for(int i = 0; i < 6; i++){
                 if(i>=0 && i<=2)
                     posiblesValores[i] = "brain";
                 else if(i>=3 && i <=4)
                     posiblesValores[i] = "runner";
                 else
                    posiblesValores[i] = "shotgun";
            }
        }
        else if(color == "yellow"){
            for(int i = 0; i < 6; i++){
                if(i>=0 && i<=1)
                    posiblesValores[i] = "brain";
                else if(i >=2 && i <=3)
                posiblesValores[i] = "runner";
                else
                posiblesValores[i] = "shotgun";
            }
        }
        else{
            for(int i = 0; i < 6; i++){
                if(i==0)
                    posiblesValores[i] = "brain";
                else if(i >=1 && i <=2)
                posiblesValores[i] = "runner";
                else
                posiblesValores[i] = "shotgun";
            }
        }
    }
    
    public void lanzar(){
         dado.lanzar();
    }

    public String getValor(){
        int temp = dado.getValor();
        valor = posiblesValores[temp - 1];
        return valor;
    }

}