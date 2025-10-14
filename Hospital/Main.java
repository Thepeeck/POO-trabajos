import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Clase Main para demostrar el funcionamiento básico del sistema.
 * Crea personal, agenda citas y ejecuta reagendamientos automáticos.
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        // Crear personal (15 para pruebas de "Contratacion masiva")
        for (int i = 1; i <= 5; i++) {
            manager.agregarPersonal(new DoctorGeneral("Dr. General " + i, "Medicina", 5 + i, 1500 + i*100, 20, 30.0 + i));
        }
        for (int i = 1; i <= 4; i++) {
            manager.agregarPersonal(new Cirujano("Dr. Cirujano " + i, "Cirugia", 8 + i, 2200 + i*120, 2.0 * i, 200.0 + i*10, 300.0));
        }
        for (int i = 1; i <= 3; i++) {
            manager.agregarPersonal(new Enfermero("Enfermero " + i, "Urgencias", 3 + i, 800 + i*50, i % 2 == 0, "Nivel " + i, 100.0));
        }
        // Radiologos
        manager.agregarPersonal(new Radiologo("Rad. 1", "Imagenes", 6, 1300, Arrays.asList("RX-2000","MRI-1"), 50.0));
        manager.agregarPersonal(new Radiologo("Rad. 2", "Imagenes", 4, 1200, Arrays.asList("RX-2000"), 60.0));

        System.out.println("\n==== Personal contratado ====");
        for (TrabajadorMedico t : manager.listarPersonal()) System.out.println(t);

        // Agendar 20 citas en un dia (agenda saturada)
        LocalDateTime base = LocalDateTime.now().plusDays(1).withHour(8).withMinute(0).withSecond(0).withNano(0);
        List<TrabajadorMedico> staff = manager.listarPersonal();

        int created = 0;
        for (int i = 0; i < 20; i++) {
            TrabajadorMedico m = staff.get(i % staff.size());
            LocalDateTime slot = base.plusMinutes((i % 10) * 30); // algunos slots se repiten para generar conflictos
            CitaMedica cita = new CitaMedica("Paciente " + (i+1), m, slot, "Consulta"); 
            boolean ok = manager.agendarCita(cita);
            if (ok) created++;
        }
        System.out.println("\nCitas creadas correctamente: " + created);

        // Simular ausencia de un doctor (crisis de personal)
        TrabajadorMedico ausente = staff.get(0);
        manager.manejarAusencia(ausente);

        // Mostrar reporte de nomina por departamento
        System.out.println("\n==== Nomina por departamento ====");
        Map<String, Double> nomina = manager.reporteNominaPorDepartamento();
        for (String dept : nomina.keySet()) {
            System.out.println(dept + " -> " + String.format("%.2f", nomina.get(dept)));
        }

        // Listar citas reagendadas y su historial
        System.out.println("\n==== Citas reagendadas/historiales ====");
        for (CitaMedica c : manager.listarTodasCitas()) {
            if (c.getEstado() == EstadoCita.REAGENDADA) {
                System.out.println(c);
                for (String h : c.getHistorial()) System.out.println("   " + h);
            }
        }

        // Analisis de utilizacion
        System.out.println("\n==== Utilizacion por medico ====");
        for (Map.Entry<TrabajadorMedico, Long> e : manager.usoPorMedico().entrySet()) {
            System.out.println(e.getKey().getNombre() + " -> " + e.getValue() + " citas");
        }
    }
}
