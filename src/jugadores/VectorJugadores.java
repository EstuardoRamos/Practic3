
package jugadores;

import practic3.IngresoDatos;
import tablero.Tablero;
//private Tablero t = new

public class VectorJugadores {
    public Jugador[] jugadores = new Jugador[10];
    private int cont =1;
    
    public void agregarJugador(String nombre, int edad){
        if (cont > 10){
            System.out.println("Límite de jugadores alcanzado");
        }
        else{
            jugadores[(cont-1)] = new Jugador( nombre,cont, edad);
        }
        cont++;
    }

    public void agregarJugador(){
        String nombre = IngresoDatos.getTexto("Ingrese nombre: ");
        int edad = IngresoDatos.getEntero("Ingrese edad: ", false);
        agregarJugador(nombre, edad);
    }
    
    public void moverUsuaFicha() {
        System.out.println("Ingrese la posicion inicial");
        int x= IngresoDatos.getEntero("X: ", true);
        System.out.print("X: ");
        int y= IngresoDatos.getEntero("Y: ", true);
        System.out.println("Ingrese la posicion a la que desea mover");
        int x2= IngresoDatos.getEntero("X: ", true);
        int y2= IngresoDatos.getEntero("y: ", true);
    }
    
    public void seleccionarJugador(){
       mostrarInfo();
        System.out.println("Para jugar solo se necesitan dos Jugadores");
        int jug1=IngresoDatos.getEntero("Ingrese id Primer jugador", true);
        int jug2=IngresoDatos.getEntero("Ingrese id Segundo jugador", true);
        jugadores[jug1].getNombre();
        asignarObjeto(jug1);
        jugadores[jug2].getNombre();
        asignarObjeto(jug2);
        System.out.println("Juego Piedra, papel o tijera.");
        System.out.println("Objeto de  "+jugadores[jug1].getNombre()+" es "+jugadores[jug1].getObjeto());
        System.out.println("Objeto de  "+jugadores[jug2].getNombre()+" es "+jugadores[jug2].getObjeto());
        System.out.println(getJuego(jugadores[jug1].getObjeto(), jugadores[jug2].getObjeto()));
        Tablero t = new Tablero(8, 8, true);
        String jugador1 = null;
        String jugador2 = null;
        int id1 = 0;
        int id2 = 0;
        if (getJuego(jugadores[jug1].getObjeto(), jugadores[jug2].getObjeto()).equalsIgnoreCase("gano jugador1")) {
            jugador1=jugadores[jug1].getNombre();
            id1=jug1;
            jugador2=jugadores[jug2].getNombre();
            id2=jug2;
            
        } else{
            if (getJuego(jugadores[jug1].getObjeto(), jugadores[jug2].getObjeto()).equalsIgnoreCase("gano jugador2")) {
            jugador1=jugadores[jug2].getNombre();
            id1=jug2;
            jugador2=jugadores[jug1].getNombre();
            id2=jug1;
        } else{
                System.out.println("Error"); 
            }
        }
        System.out.println("Empieza el juego!!!!!");
        t.jugar(jugadores[id1],jugadores[id2]);
        //getJuego(jugadores[jug1].getNombre(), jugadores[jug1].getNombre());
    }
    
    public void asignarObjeto(int id) {
        int numAl = (int) (Math.random() * 3+1);
            if (numAl == 1) {
                jugadores[id].setObjeto("piedra");
            } else {
                if (numAl == 2) {
                    jugadores[id].setObjeto("papel");
                } else {
                    if (numAl == 3) {
                        jugadores[id].setObjeto("tijera");
                    }

                }
            }
    }
    
    public String getJuego(String objetJug1,String objetJug2 ){
        String armaJugador1=objetJug1;
        String armaJugador2=objetJug2;
    if (armaJugador1.equals("piedra") && armaJugador2.equals("tijera")) {
            return "gano jugador1";
        } else if (armaJugador2.equals("piedra") && armaJugador1.equals("tijera")) {
            return "gano jugador2";
        } else if (armaJugador2.equals("papel") && armaJugador1.equals("piedra")) {
            return "gano jugador2";
        } else if (armaJugador1.equals("papel") && armaJugador2.equals("piedra")) {
            return "gano jugador1";
        } else if (armaJugador1.equals("tijera") && armaJugador2.equals("papel")) {
            return "gano jugador1";
        } else if (armaJugador2.equals("tijera") && armaJugador1.equals("papel")) {
            return "gano jugador2";
        }
        return "empate";
    }
    
    public void mostrarInfo(){
        System.out.println("\n\n Estadisticas jugadores");
        for (int i = 0; i < (cont-1); i++) {
            System.out.println("-"+i+") "+jugadores[i].getInformacion());
        }

        System.out.println("\n\n");
    }
       
    
}
