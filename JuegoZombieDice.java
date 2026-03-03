import java.util.*;
/**
 * Write a description of class JuegoZombieDice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JuegoZombieDice
{
    BolsaDados bolsa;
    ArrayList<JugadorZombie> jugadores;
    int cantidadJugadores;
    int jugadorEnTurno;
    ArrayList<DadoZombie> dadosEnJuego;
    boolean jugadoresListos = false;
    /**
     * Constructor for objects of class JuegoZombieDice
     */
    public JuegoZombieDice(int cantidadJugadores)
    {
        jugadorEnTurno = 0;
        this.cantidadJugadores = cantidadJugadores;

        jugadores = new ArrayList(cantidadJugadores);
        bolsa = new BolsaDados();
        dadosEnJuego = new ArrayList(3);
    }

    public void agregarJugadores(String nombre){
        if(jugadores.size() < cantidadJugadores){
            jugadores.add(new JugadorZombie(nombre));
        }
    }

    public void AgarrarDadosBolsa(){
        JugadorZombie jugador = jugadores.get(jugadorEnTurno);
        int corredoresActu = jugador.getCorredores();
        dadosEnJuego = bolsa.agarrarDados(3);
    }

    public void lanzarDados(){
        for(int i = 0; i < 3; i++){
            DadoZombie dado = dadosEnJuego.get(i);
            dado.lanzar();
        }
    }

    public void procesarDados(){
        for(int i = 0; i < 3; i++){
            JugadorZombie jugador = jugadores.get(jugadorEnTurno);
            DadoZombie dado = dadosEnJuego.get(i);

            if(dado.getValor() == "brain")
                jugador.sumarCerebrosTemporales(1);
            else if(dado.getValor() == "runner")
                jugador.sumarCorredores(1);
            else if(dado.getValor() == "shotgun")
                jugador.sumarEscopetas(1);
        }
    }
    
    public JugadorZombie getResultadosJugada(){
        JugadorZombie jugador = jugadores.get(jugadorEnTurno);
        return jugador;
    }

}