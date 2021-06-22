
package jugadores;

import java.util.Scanner;
import tablero.Tablero;
//private Tablero t = new

public class VectorJugadores {
    public Jugador[] jugadores = new Jugador[10];
    private int cont =1;
    
    Scanner scanner = new Scanner(System.in);
    
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
        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese edad: ");
        int edad = scanner.nextInt();
        agregarJugador(nombre, edad);
    }
    
    public void moverUsuaFicha() {
        System.out.println("Ingrese la posicion inicial");
        System.out.print("x: ");
        int x= scanner.nextInt();
        System.out.print("y: ");
        int y= scanner.nextInt();
        System.out.println("Ingrese la posicion a la que desea mover");
        System.out.print("x: ");
        int x2= scanner.nextInt();
        System.out.print("y: ");
        int y2= scanner.nextInt();
    }
    
    public void seleccionarJugador(){
       mostrarInfo();
        System.out.println("Para jugar solo se necesitan dos Jugadores");
        System.out.print("Ingrese id Primer jugador:");
        int jug1=scanner.nextInt();
        System.out.print("Ingrese id Segundo jugador: ");
        int jug2=scanner.nextInt();
        jugadores[jug1].getNombre();
        asignarObjeto(jug1);
        jugadores[jug2].getNombre();
        asignarObjeto(jug2);
        System.out.println("Juego Piedra, papel o tijera.");
        System.out.println("Objeto de  "+jugadores[jug1].getNombre()+" es "+jugadores[jug1].getObjeto());
        System.out.println("Objeto de  "+jugadores[jug2].getNombre()+" es "+jugadores[jug2].getObjeto());
        //System.out.println(getJuego(jugadores[jug1].getObjeto(), jugadores[jug2].getObjeto()));
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
            System.out.println("Gano "+jugadores[jug1].getNombre());
            
        } else{
            if (getJuego(jugadores[jug1].getObjeto(), jugadores[jug2].getObjeto()).equalsIgnoreCase("gano jugador2")) {
            jugador1=jugadores[jug2].getNombre();
            id1=jug2;
            jugador2=jugadores[jug1].getNombre();
            id2=jug1;
            System.out.println("Gano "+jugadores[jug2].getNombre());
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
    public void ordenarPorPunteo(){
        int aux;
        for (int i = 0; i < (cont); i++) {
            for (int j = 0; j < (cont); j++) {
                if((jugadores[j].getPartidasGanadas())>(jugadores[i+1].getPartidasGanadas())){
                    aux=jugadores[j].getPartidasGanadas();
                    jugadores[j].setPartidasGanadas(jugadores[j+1].getPartidasGanadas());
                    jugadores[j+1].setPartidasGanadas(aux);
                }
                
            }
            
        }
    }
    public void ordenBurbuja(){
        //int operaciones = 0;
        //int intercambio = 0;
        //i<array.length   =   i <= (array.length-1)
        for (int i = 1; i < (cont-1); i++) {
            for (int j = 0; j < (cont-1)-i; j++) {
                //operaciones++;
                if (jugadores[j].getPartidasGanadas()<jugadores[j+1].getPartidasGanadas()){
                    /*
                    variable1  = 1
                    variable2 = 2
                        temporal = variable1 = 1
                        variable1 = variable2 = 2
                        variable2 = temporal = 1
                    */
                    //intercambio++;
                    int tmp = jugadores[j].getPartidasGanadas();
                    String auxN=jugadores[j].getNombre();
                    jugadores[j].setPartidasGanadas(jugadores[j+1].getPartidasGanadas()); 
                    jugadores[j].setNombre(jugadores[j+1].getNombre()); 
                    jugadores[j+1].setPartidasGanadas(tmp);
                    jugadores[j+1].setNombre(auxN);
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