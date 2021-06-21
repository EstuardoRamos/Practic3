package jugadores;

import java.util.Scanner;
import tablero.Tablero;

public class Jugador {

    private String nombre;
    private String objeto;
    private boolean gano;
    private int noJugador;
    private String fichas;
    private int edad;
    private int puntaje;
    private int partidasGanadas;
    Tablero tab = new Tablero(edad, edad, gano);

    public Jugador(String nombre, int noJugador, int edad) {
        this.nombre = nombre;
        this.noJugador = noJugador;
        this.edad = edad;
    }

    public Jugador(String nombre, boolean gano, String fichas, int puntaje) {
        this.nombre = nombre;
        this.gano = gano;
        this.fichas = fichas;
        this.puntaje = puntaje;
    }

    public Jugador(String nombre, int partidasGanadas) {
        this.nombre = nombre;
        this.partidasGanadas = partidasGanadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGano() {
        return gano;
    }

    public void setGano(boolean gano) {
        this.gano = gano;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public int getNoJugador() {
        return noJugador;
    }

    public void setNoJugador(int noJugador) {
        this.noJugador = noJugador;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }
    public String getInformacion() {
        String resultado = " Nombre del jugador: " + nombre + "   Puntos: " + puntaje + "   Partidas ganadas: " + partidasGanadas;
        return resultado;
    }

}