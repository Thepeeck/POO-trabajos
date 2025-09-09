import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Juego juego = null;
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Jugar");
            System.out.println("2. Configurar tablero");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    if (juego == null) {
                        sc.nextLine(); 
                        System.out.print("Ingrese nombre del Jugador 1: ");
                        String j1 = sc.nextLine();
                        System.out.print("Ingrese nombre del Jugador 2: ");
                        String j2 = sc.nextLine();
                        juego = new Juego(4, 4, j1, j2); 
                    }
                    jugarPartida(juego, sc);
                }
                case 2 -> {
                    System.out.print("Ingrese filas: ");
                    int filas = sc.nextInt();
                    System.out.print("Ingrese columnas: ");
                    int columnas = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Ingrese nombre del Jugador 1: ");
                    String j1 = sc.nextLine();
                    System.out.print("Ingrese nombre del Jugador 2: ");
                    String j2 = sc.nextLine();
                    juego = new Juego(filas, columnas, j1, j2);
                    System.out.println("✅ Tablero configurado a " + filas + "x" + columnas);
                }
                case 3 -> System.out.println("👋 Saliendo del juego...");
                default -> System.out.println("⚠️ Opción inválida.");
            }
        } while (opcion != 3);
    }

    private static void jugarPartida(Juego juego, Scanner sc) {
        while (!juego.juegoTerminado()) {
            Jugador actual = juego.getTurnoActual();
            System.out.println("\nTurno de: " + actual.getNombre());
            juego.mostrarTablero(false);

            // Primera ficha
            System.out.print("Ingrese fila1 col1: ");
            int f1 = sc.nextInt(), c1 = sc.nextInt();
            if (!juego.validarSeleccion(f1, c1)) {
                System.out.println("❌ Selección inválida. Intente de nuevo.");
                continue;
            }
            juego.destaparFicha(f1, c1);
            juego.mostrarTablero(false);

            // Segunda ficha
            System.out.print("Ingrese fila2 col2: ");
            int f2 = sc.nextInt(), c2 = sc.nextInt();
            if (f1 == f2 && c1 == c2) {
                System.out.println("❌ No puede elegir la misma ficha dos veces.");
                continue;
            }
            if (!juego.validarSeleccion(f2, c2)) {
                System.out.println("❌ Selección inválida. Intente de nuevo.");
                continue;
            }

            juego.jugarTurno(f1, c1, f2, c2);
        }
        juego.mostrarGanador();
    }
}

