import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Proceso> procesos = new ArrayList<>();

        ProcesosCPU p1 = new ProcesosCPU(new PID(), "Compilador", 5, 4, "Compilacion", 12);
        ProcesosCPU p2 = new ProcesosCPU(2, "Renderizado", 8);

        EntradaSalida io1 = new EntradaSalida(new PID(), "LecturaDisco", 1, "Disco", 2);
        EntradaSalida io2 = new EntradaSalida("Teclado", 0);

        Daemons d1 = new Daemons("ServicioRed", true);
        Daemons d2 = new Daemons("Logger", false);

        procesos.add(p1);
        procesos.add(p2);
        procesos.add(io1);
        procesos.add(io2);
        procesos.add(d1);
        procesos.add(d2);

        for (Proceso proc : procesos) {
            String resultado = proc.ejecutar();
            System.out.println(resultado);
            System.out.println("  -> Estado del PID: " + proc.getPID().getEstado());
        }

        for (int ronda = 1; ronda <= 2; ronda++) {
            System.out.println("\n--- Ronda adicional " + ronda + " ---");
            for (Proceso proc : procesos) {
                System.out.println(proc.ejecutar());
            }
        }
    }
}
