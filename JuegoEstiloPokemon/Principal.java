import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear jugador
        Usuario jugador = new Usuario("Guerrero", new Stats(100, 20, 5));
        Items items = new Items(10, 5, 30, 15);

        // Crear enemigos
        EnemigoComun goblin = new EnemigoComun("Goblin", "Normal", new Stats(40, 10, 2));
        Jefe orcoJefe = new Jefe("Orco", "Jefe", new Stats(80, 15, 5));
        List<Enemigo> enemigos = Arrays.asList(goblin, orcoJefe);

        System.out.println("¡La batalla comienza!");

        while (jugador.getStats().getVida() > 0 && enemigos.stream().anyMatch(Enemigo::estaVivo)) {
            System.out.println("\nJugador HP: " + jugador.getStats().getVida());
            for (Enemigo e : enemigos) {
                System.out.println(e.getTipo() + " HP: " + e.getStats().getVida());
            }

            System.out.println("\nTurno del jugador. Elige acción:");
            System.out.println("1. Atacar");
            System.out.println("2. Usar item");
            System.out.println("3. Pasar turno");
            int opcion = sc.nextInt();

            if (opcion == 1) {
                jugador.calcularAtaque(goblin.estaVivo() ? goblin : orcoJefe);
            } else if (opcion == 2) {
                items.efectoCuracion(jugador);
            } else {
                System.out.println("Jugador pasa turno.");
            }

            // Turnos enemigos
            for (Enemigo e : enemigos) {
                if (e.estaVivo()) {
                    if (new Random().nextBoolean()) {
                        e.calcularAtaque(jugador);
                    } else {
                        if (e instanceof EnemigoComun) {
                            ((EnemigoComun) e).habilidadEspecial(jugador);
                        } else if (e instanceof Jefe) {
                            ((Jefe) e).habilidadEspecial(jugador);
                        }
                    }
                }
            }
        }

        if (jugador.getStats().getVida() > 0) {
            System.out.println("¡Has ganado la batalla!");
        } else {
            System.out.println("Has sido derrotado...");
        }

        sc.close();
    }
}