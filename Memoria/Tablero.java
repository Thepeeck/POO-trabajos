import java.util.*;

public class Tablero {
    private int filas;
    private int columnas;
    private Ficha[][] fichas;

    public Tablero(int filas, int columnas, List<String> simbolos) {
        this.filas = filas;
        this.columnas = columnas;
        this.fichas = new Ficha[filas][columnas];
        inicializar(simbolos);
    }

    private void inicializar(List<String> simbolos) {
        List<String> pares = new ArrayList<>();
        for (String s : simbolos) {
            pares.add(s);
            pares.add(s);
        }
        Collections.shuffle(pares);

        int idx = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                fichas[i][j] = new Ficha(pares.get(idx));
                idx++;
            }
        }
    }

    public Ficha getFicha(int fila, int columna) {
        return fichas[fila][columna];
    }

    public boolean todasEmparejadas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!fichas[i][j].isEmparejada()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(fichas[i][j] + " ");
            }
            System.out.println();
        }
    }
}