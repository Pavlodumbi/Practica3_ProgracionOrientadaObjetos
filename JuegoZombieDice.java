import java.util.*;
/**
 * Write a description of class JuegoZombieDice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JuegoZombieDice
{
    private BolsaDados bolsa;
    private ArrayList<JugadorZombie> jugadores;
    private int cantidadJugadores;
    private int jugadorEnTurno;
    private ArrayList<DadoZombie> dadosEnJuego;
    private ArrayList<DadoZombie> dadosJugados;
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
        dadosJugados = new ArrayList(0);
    }

    public void agregarJugadores(String nombre){
        if(jugadores.size() < cantidadJugadores){
            jugadores.add(new JugadorZombie(nombre));
        }
    }


    public void AgarrarDadosBolsa(){
        JugadorZombie jugador = jugadores.get(jugadorEnTurno);
        int corredoresActu = jugador.getCorredores();
        for(int i = 0; i < (3-corredoresActu); i++){
            dadosEnJuego.add(bolsa.agarrarDados());
        }
    }

    public void lanzarDados(){
        for(int i = 0; i < 3; i++){
            DadoZombie dado = dadosEnJuego.get(i);
            dado.lanzar();
        }
    }

    public void procesarDados(){
        int idx = 0;
        for(int i = 0; i < 3; i++){
            JugadorZombie jugador = jugadores.get(jugadorEnTurno);
            DadoZombie dado = dadosEnJuego.get(idx);  
            
            if(dado.getValor() == "brain"){
                jugador.sumarCerebrosTemporales(1);
                dadosJugados.add(dadosEnJuego.remove(idx));
            }
            else if(dado.getValor() == "runner"){
                jugador.sumarCorredores(1);
                idx++;
            }
            else if(dado.getValor() == "shotgun"){
                jugador.sumarEscopetas(1);
                dadosJugados.add(dadosEnJuego.remove(idx));
            }
        }
    }
    
    public JugadorZombie getResultadosJugada(){
        JugadorZombie jugador = jugadores.get(jugadorEnTurno);
        if(jugador.getEscopetas() >=3){
            saltarTurno();
        }
        return jugador;
    }
    
    public void saltarTurno(){
        retornarDadosABolsa();
        if(jugadorEnTurno+1 == cantidadJugadores){
            jugadorEnTurno = 0;
        }else{
            jugadorEnTurno++;
        }
    }
    
    private void retornarDadosABolsa(){
        for(int i = 0; i < dadosEnJuego.size(); i++){
            bolsa.recuperarDados(dadosEnJuego.remove(i));
        }
        
        for(int i = 0; i < dadosJugados.size(); i++){
            bolsa.recuperarDados(dadosJugados.remove(i));
        }
    }
    
    public boolean hayGanador(){
        boolean ganador = false;
        for(int i = 0; i < jugadores.size(); i++){
        JugadorZombie jugador = jugadores.get(i);
        if(jugador.getCerebros() >= 13){
            ganador = true;
        }
        }
        return ganador;
    }
    
    public JugadorZombie getGanador(){
        JugadorZombie ganador = null;
        for(int i = 0; i < jugadores.size(); i++){
            JugadorZombie jugador = jugadores.get(i);
            if(jugador.getCerebros() >=13){
                ganador = jugador;
            }
        }
        return ganador;
    }
    
    public JugadorZombie getJugadorActual(){
        return jugadores.get(jugadorEnTurno);
    }
    
    public ArrayList<DadoZombie> getDadosAgarrados(){
        return dadosEnJuego;
    }

}