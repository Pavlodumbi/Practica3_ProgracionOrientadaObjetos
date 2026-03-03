import java.util.*;
/**
 * Write a description of class BolsaDados here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BolsaDados
{

    ArrayList<DadoZombie> dados;
    /**
     * Constructor for objects of class BolsaDados
     */
    public BolsaDados()
    {
        dados = new ArrayList(13);

        for(int i = 0; i < 13; i++)
        {
            if(i >= 0 && i < 6){
                DadoZombie temp = new DadoZombie("green");
                dados.add(temp);
            }
            else if(i>=6 && i <10){
                DadoZombie temp = new DadoZombie("yellow");
                dados.add(temp);
            }
            else{
                DadoZombie temp = new DadoZombie("red");
                dados.add(temp);
            }
        }

    }
    public ArrayList<DadoZombie> agarrarDados(int cuantos){
        Random rand = new Random();
        ArrayList<DadoZombie> dadosAgarrados = new ArrayList(cuantos);
        for(int i = 0; i < cuantos; i++){
            int dadoIndex = rand.nextInt(dados.size());
            dadosAgarrados.add(dados.remove(dadoIndex));
        }
        return dadosAgarrados;
    }

}