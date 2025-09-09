public class Configuracion {
    private int filas;
    private int columnas;

    public Configuracion(int filas, int columnas) {
        if ((filas * columnas) % 2 != 0) {
            throw new IllegalArgumentException("El tablero debe tener un número par de casillas.");
        }
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}