public class Validador {

    public boolean coordenadaValida(int fila, int columna, int filas, int columnas) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public boolean seleccionValida(Tablero tablero, int f1, int c1, int f2, int c2) {
        if (f1 == f2 && c1 == c2) return false;
        Ficha ficha1 = tablero.getFicha(f1, c1);
        Ficha ficha2 = tablero.getFicha(f2, c2);
        return !ficha1.isEmparejada() && !ficha2.isEmparejada();
    }
}