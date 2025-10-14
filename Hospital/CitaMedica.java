import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Representa una cita médica con historial de cambios.
 */
public class CitaMedica {
    private static final AtomicInteger ID_GEN = new AtomicInteger(1);
    private final int id;
    private String paciente;
    private TrabajadorMedico medico;
    private LocalDateTime fechaHora;
    private String tipoCita;
    private EstadoCita estado;
    private final List<String> historial; // registro de cambios

    public CitaMedica(String paciente, TrabajadorMedico medico, LocalDateTime fechaHora, String tipoCita) {
        this.id = ID_GEN.getAndIncrement();
        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
        this.tipoCita = tipoCita;
        this.estado = EstadoCita.PROGRAMADA;
        this.historial = new ArrayList<>();
        addHistorial(String.format("Creada: %s -> %s (%s)", formatFecha(fechaHora), medico.getNombre(), tipoCita));
    }

    public int getId() { return id; }
    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    public TrabajadorMedico getMedico() { return medico; }
    public void setMedico(TrabajadorMedico medico) {
        addHistorial(String.format("Medico cambiado: %s -> %s", this.medico != null ? this.medico.getNombre() : "null", medico.getNombre()));
        this.medico = medico;
    }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) {
        addHistorial(String.format("Fecha cambiada: %s -> %s", formatFecha(this.fechaHora), formatFecha(fechaHora)));
        this.fechaHora = fechaHora;
    }

    public String getTipoCita() { return tipoCita; }
    public void setTipoCita(String tipoCita) { this.tipoCita = tipoCita; }

    public EstadoCita getEstado() { return estado; }
    public void setEstado(EstadoCita estado) {
        addHistorial("Estado: " + this.estado + " -> " + estado);
        this.estado = estado;
    }

    public List<String> getHistorial() { return historial; }

    private void addHistorial(String entry) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        historial.add(time + " - " + entry);
    }

    private String formatFecha(LocalDateTime f) {
        return f == null ? "null" : f.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @Override
    public String toString() {
        return String.format("Cita[id=%d, paciente=%s, medico=%s, fecha=%s, tipo=%s, estado=%s]",
                id, paciente, medico.getNombre(), formatFecha(fechaHora), tipoCita, estado);
    }
}
