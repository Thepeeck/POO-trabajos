import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manager central que administra personal y citas.
 * Implementa asignación inteligente y reagendamiento automático.
 */
public class Manager {
    private final List<TrabajadorMedico> personal;
    private final List<CitaMedica> citas;

    public Manager() {
        this.personal = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    // Contratar / agregar personal
    public void agregarPersonal(TrabajadorMedico t) {
        personal.add(t);
    }

    public List<TrabajadorMedico> listarPersonal() {
        return new ArrayList<>(personal);
    }

    // Reporte de nómina por departamento
    public Map<String, Double> reporteNominaPorDepartamento() {
        Map<String, Double> res = new HashMap<>();
        for (TrabajadorMedico t : personal) {
            res.merge(t.getDepartamento(), t.calcularSalario(), Double::sum);
        }
        return res;
    }

    // Agendar cita (si hay conflicto, intenta reasignar a otro médico del mismo departamento)
    public boolean agendarCita(CitaMedica cita) {
        // Chequear conflicto con el mismo médico
        boolean conflict = citas.stream()
                .filter(c -> c.getMedico().equals(cita.getMedico()))
                .anyMatch(c -> c.getFechaHora().equals(cita.getFechaHora()) && c.getEstado() != EstadoCita.CANCELADA);

        if (!conflict) {
            citas.add(cita);
            System.out.println("[NOTIFICACION] Cita agendada: " + cita);
            return true;
        } else {
            System.out.println("[INFO] Conflicto detectado al agendar con el mismo médico. Intentando reasignar..."); 
            // buscar otro medico del mismo departamento disponible en esa hora
            for (TrabajadorMedico t : personal) {
                if (!t.equals(cita.getMedico()) && t.getDepartamento().equals(cita.getMedico().getDepartamento())) {
                    boolean busy = citas.stream()
                            .filter(c -> c.getMedico().equals(t))
                            .anyMatch(c -> c.getFechaHora().equals(cita.getFechaHora()) && c.getEstado() != EstadoCita.CANCELADA);
                    if (!busy) {
                        cita.setMedico(t);
                        citas.add(cita);
                        System.out.println("[NOTIFICACION] Cita reasignada automaticamente al medico: " + t.getNombre());
                        return true;
                    }
                }
            }
            System.out.println("[WARN] No se pudo agendar ni reasignar la cita en la hora solicitada.");
            return false;
        }
    }

    // Reagendamiento automático: intenta mover la cita al siguiente slot (ej: +30 min) hasta encontrar disponibilidad
    public boolean reagendarAutomatico(int citaId) {
        CitaMedica target = citas.stream().filter(c -> c.getId() == citaId).findFirst().orElse(null);
        if (target == null) return false;

        LocalDateTime start = target.getFechaHora();
        TrabajadorMedico medico = target.getMedico();

        // Intenta 48 slots (hasta 24 horas en pasos de 30 minutos)
        for (int i = 1; i <= 48; i++) {
            LocalDateTime candidate = start.plusMinutes(i * 30L);
            boolean conflict = citas.stream()
                    .filter(c -> c.getMedico().equals(medico) && c.getId() != target.getId())
                    .anyMatch(c -> c.getFechaHora().equals(candidate) && c.getEstado() != EstadoCita.CANCELADA);

            if (!conflict) {
                target.setFechaHora(candidate);
                target.setEstado(EstadoCita.REAGENDADA);
                System.out.println("[NOTIFICACION] Cita " + target.getId() + " reagendada a " + candidate + " con medico " + medico.getNombre());
                return true;
            }
        }

        // Si no hay hueco con el mismo médico, intentar reasignar a otro del departamento en el mismo día
        List<TrabajadorMedico> candidates = personal.stream()
                .filter(t -> t.getDepartamento().equals(medico.getDepartamento()) && !t.equals(medico))
                .collect(Collectors.toList());

        for (TrabajadorMedico alt : candidates) {
            for (int i = 0; i <= 48; i++) {
                LocalDateTime candidate = start.plusMinutes(i * 30L);
                boolean conflict = citas.stream()
                        .filter(c -> c.getMedico().equals(alt))
                        .anyMatch(c -> c.getFechaHora().equals(candidate) && c.getEstado() != EstadoCita.CANCELADA);

                if (!conflict) {
                    target.setMedico(alt);
                    target.setFechaHora(candidate);
                    target.setEstado(EstadoCita.REAGENDADA);
                    System.out.println("[NOTIFICACION] Cita " + target.getId() + " reasignada y reagendada a " + candidate + " con medico " + alt.getNombre());
                    return true;
                }
            }
        }

        System.out.println("[ERROR] No fue posible reagendar la cita automaticamente."); 
        return false;
    }

    // Force cancel and reassign all appointments from absent doctor
    public void manejarAusencia(TrabajadorMedico ausente) {
        System.out.println("[ADMIN] Procesando ausencia para: " + ausente.getNombre());
        List<CitaMedica> afectadas = new ArrayList<>();
        for (CitaMedica c : citas) {
            if (c.getMedico().equals(ausente) && c.getEstado() != EstadoCita.COMPLETADA && c.getEstado() != EstadoCita.CANCELADA) {
                afectadas.add(c);
            }
        }
        for (CitaMedica c : afectadas) {
            // intentar reagendar automáticamente
            boolean ok = reagendarAutomatico(c.getId());
            if (!ok) {
                c.setEstado(EstadoCita.CANCELADA);
                System.out.println("[NOTIFICACION] Cita " + c.getId() + " cancelada por ausencia del medico y sin disponibilidad."); 
            }
        }
    }

    // Listar citas por estado
    public List<CitaMedica> listarCitasPorEstado(EstadoCita estado) {
        return citas.stream().filter(c -> c.getEstado() == estado).collect(Collectors.toList());
    }

    public List<CitaMedica> listarTodasCitas() {
        return new ArrayList<>(citas);
    }

    // Analisis de utilizacion: numero de citas por medico
    public Map<TrabajadorMedico, Long> usoPorMedico() {
        Map<TrabajadorMedico, Long> map = new HashMap<>();
        for (CitaMedica c : citas) {
            map.merge(c.getMedico(), 1L, Long::sum);
        }
        return map;
    }
}
