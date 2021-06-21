
package tablero;


public class Ficha {
    private boolean esNegra;

    private char celda = '█';
    private char celdaColor = '█';
    //█▓
    public static final String ANSI_RED = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[37m";

    private String id;



    
    public String getCaracter(){
        String res =(esNegra)?""+ANSI_RED+celda:""+ANSI_YELLOW+celda;
        return res;
    }

    public Ficha(boolean esNegra , String id){
        this.esNegra = esNegra;
        this.id = id;
    }

    public String getId(){
        return id;
    }
    
}
