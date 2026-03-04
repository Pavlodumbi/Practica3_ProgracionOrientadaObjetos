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
        int decision = 100;
        boolean penalizo = false;
        JuegoZombieDice juego = new JuegoZombieDice(cantidadJugadores);
        for(int i = 0; i < cantidadJugadores; i++){
            String nombre = ingresarNombre(i+1);
            juego.agregarJugadores(nombre);
        }

        System.out.println("Juego Comienza");
        Scanner scan = new Scanner(System.in);
        while(!juego.hayGanador()){
            //Mostrar Jugador
            JugadorZombie actual = juego.getJugadorActual();
            System.out.println("Turno del jugador " + actual.getNombre() + ":");
            System.out.println("Cerebros Actuales:" + actual.getCerebros());

            //Agarrar Dados
            do{
                System.out.println("Pulsa Enter para agarrar 3 Dados de la bolsa");
                scan.nextLine();
                juego.AgarrarDadosBolsa();
                //Mostrar los dados en consola
                mostrarDados(juego.getDadosAgarrados());

                //Lanzar dados
                System.out.println("Enter para Lanzar.");
                scan.nextLine();
                juego.lanzarDados();

                //mostrar lanzada
                mostrarJugada(juego.getDadosAgarrados());

                //procesar los dados en el juego
                juego.procesarDados();

                //Mostrar cambios en el jugador
                mostrarCambiosJugador(juego.getResultadosJugada());

                //Decidir siguiente jugada
                decision = decidirSiguienteJugada();
                if(decision == 2 || actual.getEscopetas()>=3){
                    penalizo = juego.saltarTurno();
                    if(penalizo == true){
                        System.out.println("Saltando turno debido a que obtuviste 3 escopetas o mas");
                    }
                }
            }while(decision == 1 && penalizo == false);
        }

    }

    private int ingresarCantidadJugadores(){
        int cantidad = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Cuantos Jugadores: ");
        cantidad = scan.nextInt();
        return cantidad;
    }

    private String ingresarNombre(int idxJugador){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el nombre del jugador " + idxJugador + ":");
        return scan.nextLine();
    }

    private void mostrarDados(ArrayList<DadoZombie> dados){
        String colores = "";
        for(int i = 0; i < 3; i++){
            DadoZombie dado = dados.get(i);
            colores += dado.getColor() + " ";
        }
        System.out.println("Han salido 3 dados, con los colores: " + colores);
    }

    private void mostrarJugada(ArrayList<DadoZombie> dadosLanzados){
        System.out.println("Los dados han sido lanzados y ha caido lo siguiente:");
        for(int i = 0; i < 3; i++){
            DadoZombie dado = dadosLanzados.get(i);
            System.out.println("Dado " + (i+1) +": " + dado.getColor() + ", " + dado.getValor()); 
        }
    }

    private void mostrarCambiosJugador(JugadorZombie actual){
        System.out.println("Datos del jugador:");
        System.out.println("Cerebros: " + actual.getCerebros());
        System.out.println("Cerebros Temporales: " + actual.getTempCerebros());
        System.out.println("Escopetas: " + actual.getEscopetas());
        System.out.println("Corredores: " + actual.getCorredores());

    }

    private int decidirSiguienteJugada(){
        int decision = 100;
        Scanner scanear = new Scanner(System.in);
        do{
            System.out.println("\n" + "Desea volver a lanzar o convertir los cerebros temporales a totales");
            System.out.println(" Ingresa 1 para lanzar");
            System.out.println("Ingresa 2 para saltar Turno");
            decision = scanear.nextInt();
        }while(decision <1 || decision >2);
        return decision;
    }

}