
package practic3;

import java.util.Scanner;
import jugadores.*;
import tablero.Tablero;


public class Practic3 {
    private VectorJugadores j = new VectorJugadores();
    Scanner scanner = new Scanner(System.in);
    Tablero t = new Tablero(8, 8, true);

    public static void main(String[] args) {
        Practic3 p = new Practic3();

        /* 
        Celda t = new Celda(true);
        t.setFicha(new Ficha(true));
        System.out.println(t.pintarCelda(0));
        System.out.println(t.pintarCelda(1));
        System.out.println(t.pintarCelda(2));
         */
    }
    public Practic3(){
        int menu=0;
        while (menu >= 0) {
        System.out.println("\nJuegos Damas chinas\n");
        System.out.println("1- Jugar.");
        System.out.println("2- Ingresar jugadores");
        System.out.println("3- Estadisticaas jugadores. ");
        System.out.println("-1- Salir.");
        menu=IngresoDatos.getEntero("Ingrese la opcion que desea seleccionar:", true);
        switch(menu){
            case 1:
                t.pintarTablero();
                
                
                break;
            case 2:
                j.agregarJugador();
                break;
            case 3:
                j.mostrarInfo();
                break;
            case 4:
                j.seleccionarJugador();
                
                break;
        }
        
        }
        
    }
    
}
