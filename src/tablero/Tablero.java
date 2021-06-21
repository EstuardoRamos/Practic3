
package tablero;

import jugadores.*;
import practic3.IngresoDatos;


public class Tablero {
    private Celda[][] tablero; 
    private final int x,y;
    private Jugador jugador1;
    private Jugador jugador2;

    private boolean juegoEnBlancas;
    //private VectorJugadores j = new VectorJugadores();
    


    public Tablero(int x, int y, boolean juegoEnBlancas){
        this.juegoEnBlancas = juegoEnBlancas;
        this.x = x;
        this.y = y;
        tablero = new Celda[x][y];
        inicializarTablero();
        inicializarFichas(0, 3, true, "BB");
        inicializarFichas(5, 8, false, "NN");
        
        //tablero[0][1].setFicha(new Ficha(false));

    } 

    private void inicializarFichas(int ini, int cant, boolean esBlanca, String id){
        for (int i = ini; i < cant; i++) {
            for (int j = 0; j < x; j++) {
                if (tablero[j][i].getEsColor() == !juegoEnBlancas){
                    tablero[j][i].setFicha(new Ficha(!esBlanca, id ));
                }
            }
           
        }
    }
    public void comerFichas(int x, int y){
        if (tablero[x][y].getEsColor()==true);
        
    }
    public void ingresarCoordenas(int cont) {
        //pintarTablero();
        System.out.println("Ingrese la posicion Inicial ");
        int x = IngresoDatos.getEntero("x: ", true);
        int y = IngresoDatos.getEntero("y: ", true);
        System.out.println("Ingrese la posicion final");
        int x2 = IngresoDatos.getEntero("x: ", true);
        int y2 = IngresoDatos.getEntero("y: ", true);
        moverFicha(x, y, x2, y2,cont);
    }
    
    public void jugar(Jugador juga1,Jugador juga2){
        jugador1=juga1;
        jugador2=juga2;
        String ganador;
        pintarTablero();
        int cont1=0;
        int cont2=0;
         while(jugador1.getPuntaje()!=2 ||jugador2.getPuntaje()!=2){
            System.out.println("Jugador 1: " + jugador1.getNombre()+"  Puntaje: "+jugador1.getPuntaje()+"  Color fichas amarillas");
            System.out.println("Jugador 2: " + jugador2.getNombre()+"  Puntaje: "+jugador2.getPuntaje()+"  Color fichas rojas");
             System.out.println("Turno: "+jugador1.getNombre());
            ingresarCoordenas(cont1);
            pintarTablero();
            System.out.println("Jugador 1: " + jugador1.getNombre()+"  Puntaje: "+jugador1.getPuntaje());
            System.out.println("Jugador 2: " + jugador2.getNombre()+"  Puntaje: "+jugador2.getPuntaje());
            System.out.println("Turno: "+jugador2.getNombre());
            ingresarCoordenas(cont2);
            pintarTablero();
        }
         if (jugador1.getPuntaje()>jugador2.getPuntaje()){
             ganador=jugador1.getNombre();
             jugador1.setPartidasGanadas(jugador1.getPartidasGanadas()+1);
         }
         else{
             ganador=jugador2.getNombre();
             jugador2.setPartidasGanadas(jugador2.getPartidasGanadas()+1);
         }
             
        System.out.println("Felicidades ha ganado "+ganador);
    }

    public boolean moverFicha(int posXIni, int posYIni, int posXFin, int posYFin, int cont) {
        boolean resultado = false;
        if (tablero[posXIni][posYIni].ocupadaPorFicha()) {

            if ((posXFin == (posXIni + 1)) && (posYFin == (posYIni + 1))) {
                if (!tablero[posXFin][posYFin].ocupadaPorFicha() && tablero[posXFin][posYFin].getEsColor() == false) {
                    tablero[posXFin][posYFin].setFicha(tablero[posXIni][posYIni].getFicha());
                    resultado = true;
                } else {
                    if (tablero[posXFin][posYFin].ocupadaPorFicha() && tablero[posXFin][posYFin].getEsColor() == false) {
                        tablero[posXFin][posYFin].setFicha(null);
                        tablero[posXFin + 1][posYFin + 1].setFicha(tablero[posXIni][posYIni].getFicha());
                        System.out.println("comio");
                        jugador1.setPuntaje(jugador1.getPuntaje()+1);
                        resultado = true;
                    }
                }

            } else {
                if ((posXFin == (posXIni - 1)) && (posYFin == (posYIni + 1))) {
                    if (!tablero[posXFin][posYFin].ocupadaPorFicha() && tablero[posXFin][posYFin].getEsColor() == false) {
                        tablero[posXFin][posYFin].setFicha(tablero[posXIni][posYIni].getFicha());
                        resultado = true;
                    } else {
                        if (tablero[posXFin][posYFin].ocupadaPorFicha() && tablero[posXFin][posYFin].getEsColor() == false) {
                            tablero[posXFin][posYFin].setFicha(null);
                            tablero[posXFin - 1][posYFin + 1].setFicha(tablero[posXIni][posYIni].getFicha());
                            System.out.println("comio");
                            jugador1.setPuntaje(jugador1.getPuntaje()+1);
                            resultado = true;
                        }
                    }

                } else {
                    if ((posXFin == (posXIni + 1)) && (posYFin == (posYIni - 1))) {
                        if (!tablero[posXFin][posYFin].ocupadaPorFicha() && tablero[posXFin][posYFin].getEsColor() == false) {
                            tablero[posXFin][posYFin].setFicha(tablero[posXIni][posYIni].getFicha());
                            resultado = true;
                        } else {
                            if (tablero[posXFin][posYFin].ocupadaPorFicha() && tablero[posXFin][posYFin].getEsColor() == false) {
                                tablero[posXFin][posYFin].setFicha(null);
                                tablero[posXFin + 1][posYFin - 1].setFicha(tablero[posXIni][posYIni].getFicha());
                                System.out.println("comio");
                                jugador2.setPuntaje(jugador2.getPuntaje()+1);
                                cont+=1;
                                resultado = true;
                            }
                        }

                    } else {
                        if ((posXFin == (posXIni - 1)) && (posYFin == (posYIni - 1))) {
                            if (!tablero[posXFin][posYFin].ocupadaPorFicha() && tablero[posXFin][posYFin].getEsColor() == false) {
                                tablero[posXFin][posYFin].setFicha(tablero[posXIni][posYIni].getFicha());
                                resultado = true;
                            } else {
                                if (tablero[posXFin][posYFin].ocupadaPorFicha() && tablero[posXFin][posYFin].getEsColor() == false) {
                                    tablero[posXFin][posYFin].setFicha(null);
                                    tablero[posXFin - 1][posYFin - 1].setFicha(tablero[posXIni][posYIni].getFicha());
                                    System.out.println("comio");
                                    jugador2.setPuntaje(jugador2.getPuntaje()+1);
                                    cont+=1;
                                    resultado = true;
                                }
                            }

                        }
                    }
                }
            }

        }
        System.out.println("Casilla invalida");
        return resultado;
    }

    

    private void inicializarTablero(){
        boolean esColorInicio = false;
        boolean esColorIteracion = false;
        for ( int i = 0; i < y; i++) {
            esColorIteracion = !esColorInicio;
            for (int j = 0; j < x; j++) {
                tablero[j][i] = new Celda(esColorIteracion);
                esColorIteracion = !esColorIteracion;
                
            }
            esColorInicio = !esColorInicio;
        }
    }

    public void pintarTablero(){
        System.out.println("    0    1     2     3    4     5     6    7");
        for ( int i = 0; i < y; i++) {            
            //System.out.print(i);
            for (int k = 0; k <3; k++) {
                System.out.print(i);
                for (int j = 0; j < x; j++) {
                    System.out.print(tablero[j][i].pintarCelda(k));
                }
                System.out.println("");
            }
            //System.out.print(i);
        }
        System.out.println("\n\n");
    }
}
