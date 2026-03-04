import java.util.*;
/**
 * Write a description of class UITexto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UITexto
{

    public void main(){
        int cantidadJugadores = ingresarCantidadJugadores();

        JuegoZombieDice juego = new JuegoZombieDice(cantidadJugadores);
        for(int i = 0; i < cantidadJugadores; i++){
            Scanner scanear = new Scanner(System.in);
            System.out.println("Ingresa el nombre del jugador " + (i+1) + ":");
            juego.agregarJugadores(scanear.nextLine());
        }
        
        System.out.println("Juego ZombieDice comienza!!");
        while(!juego.hayGanador()){
            JugadorZombie turno = juego.getJugadorActual();
            System.out.println("Turno del jugador" + turno.getNombre() + ":");
            System.out.println("Cerebros Actuales:" + turno.getCerebros());
            
            System.out.println("Pulsa Enter para agarrar  3 Dados de la bolsa");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            
            juego.AgarrarDadosBolsa();
            ArrayList<DadoZombie> dados = juego.getDadosAgarrados();
            
            for(int i = 0; i < 3; i++){
                DadoZombie dado = dados.get(i);
            }
        }

    }
    public int ingresarCantidadJugadores(){
        int cantidad = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa cantidad Jugadores: ");
        cantidad = scan.nextInt();
        return cantidad;
    }

}