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
            String nombre = ingresarNombre(i+1);
            juego.agregarJugadores(nombre);
        }
        
        
        System.out.println("Juego Comienza");
        Scanner scan = new Scanner(System.in);
        while(!juego.hayGanador()){
            String colores = "";
            JugadorZombie turno = juego.getJugadorActual();
            System.out.println("Turno del jugador " + turno.getNombre() + ":");
            System.out.println("Cerebros Actuales:" + turno.getCerebros());
            
            System.out.println("Pulsa Enter para agarrar 3 Dados de la bolsa");
            String trash = scan.nextLine();
            
            juego.AgarrarDadosBolsa();
            ArrayList<DadoZombie> dados = juego.getDadosAgarrados();
            
            for(int i = 0; i < 3; i++){
                DadoZombie dado = dados.get(i);
                colores += dado.getColor() + " ";
            }
            System.out.println("Han salido 3 dados, con los colores: " + colores);
        }

    }
    public int ingresarCantidadJugadores(){
        int cantidad = 0;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Cuantos Jugadores: ");
        cantidad = scan.nextInt();
        return cantidad;
    }
    
    public String ingresarNombre(int idxJugador){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el nombre del jugador " + idxJugador + ":");
        return scan.nextLine();
    }
}