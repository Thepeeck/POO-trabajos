import java.util.Random;

public class Juego {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador turnoActual;

    public Juego(int filas, int columnas, String nombre1, String nombre2) {
        this.tablero = new Tablero(filas, columnas);
        this.jugador1 = new Jugador(nombre1);
        this.jugador2 = new Jugador(nombre2);
        this.turnoActual = jugador1; 
    }

    public Jugador getTurnoActual() {
        return turnoActual;
    }

    public boolean juegoTerminado() {
        return tablero.todosEmparejados();
    }

    public boolean validarSeleccion(int fila, int col) {
        if (fila < 0 || fila >= tablero.getFilas() || col < 0 || col >= tablero.getColumnas()) {
            return false; 
        }
        Ficha ficha = tablero.getFicha(fila, col);
        return !ficha.estaEmparejada() && !ficha.estaRevelada();
    }

    public void destaparFicha(int fila, int col) {
        tablero.getFicha(fila, col).setRevelada(true);
    }

    public void jugarTurno(int f1, int c1, int f2, int c2) {
        Ficha ficha1 = tablero.getFicha(f1, c1);
        Ficha ficha2 = tablero.getFicha(f2, c2);

        ficha2.setRevelada(true); 
        mostrarTablero(false);

        if (ficha1.getSimbolo().equals(ficha2.getSimbolo())) {
            System.out.println("✅ ¡Par encontrado!");
            ficha1.setEmparejada(true);
            ficha2.setEmparejada(true);
            turnoActual.incrementarPuntos();
        } else {
            System.out.println("❌ No son iguales.");
            ficha1.setRevelada(false);
            ficha2.setRevelada(false);
            cambiarTurno();
        }
    }

    private void cambiarTurno() {
        turnoActual = (turnoActual == jugador1) ? jugador2 : jugador1;
    }

    public void mostrarTablero(boolean revelarTodo) {
        tablero.mostrar(revelarTodo);
    }

    public void mostrarGanador() {
        System.out.println("\n=== RESULTADOS ===");
        System.out.println(jugador1.getNombre() + ": " + jugador1.getPuntos() + " puntos");
        System.out.println(jugador2.getNombre() + ": " + jugador2.getPuntos() + " puntos");

        if (jugador1.getPuntos() > jugador2.getPuntos()) {
            System.out.println("🏆 Ganador: " + jugador1.getNombre());
        } else if (jugador2.getPuntos() > jugador1.getPuntos()) {
            System.out.println("Ganador: " + jugador2.getNombre());
        } else {
            System.out.println(" Empate");
        }
    }
}