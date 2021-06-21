package tablero;

import tablero.Ficha;

public class Celda {

    private boolean esColor;
    private Ficha ficha;

    private char celda = '█';
    private char celdaColor = '█';
    //█▓

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLUE = "\u001B[30m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void setFicha(Ficha f) {
        this.ficha = f;
    }

    public boolean getEsColor() {
        return this.esColor;
    }

    public Ficha getFicha() {
        Ficha tmp = this.ficha;
        this.ficha = null;
        return tmp;
    }

    public boolean coloNoValido() {
        return esColor == true;
    }

    public boolean ocupadaPorFicha() {
        return (ficha != null);
    }

    public Celda(boolean esColor) {
        this.esColor = esColor;
        this.ficha = null;
    }

    public String pintarCelda(int linea) {
        String res = "";
        if (esColor) {
            res = imprimir(ANSI_WHITE, linea);
        } else {
            res = imprimir(ANSI_BLUE, linea);
        }

        return res;

    }

    public void contadorFichas() {
        int cont = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (ficha != null) {
                    cont += 1;
                }
            }
        }
    }

    private String imprimir(String color, int linea) {
        String res = "";
        if (ficha != null) {
            if ((linea == 0) || (linea == 2)) {
                res = "" + color + celdaColor + celdaColor + ficha.getCaracter() + ficha.getCaracter() + color + celdaColor + celdaColor;
            }
            if (linea == 1) {
                res = "" + color + celdaColor + ficha.getCaracter() + ficha.getId() + ficha.getCaracter() + color + celdaColor;
            }
            //res=""+ color+celdaColor+  ficha.getCaracter()+ficha.getCaracter()+ficha.getCaracter()+ficha.getCaracter()       +color+ celdaColor;

        } else {
            res = "" + color + celdaColor + celdaColor + celdaColor + celdaColor + celdaColor + celdaColor;
        }

        return res;
    }

}
