public class Daemons extends Proceso {
    private String servicio;
    private boolean activo;

    public Daemons(PID pid, String nombre, int capacidadEjecutar, String servicio, boolean activo) {
        super(pid, nombre, capacidadEjecutar);
        this.servicio = servicio;
        this.activo = activo;
    }

    public Daemons(String servicio, boolean activo) {
        this(new PID(), "daemon-" + servicio, 1, servicio, activo);
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void iniciar() {
        this.activo = true;
        if (pid != null) pid.setEstado("Ejecutando");
    }

    public void detener() {
        this.activo = false;
        if (pid != null) pid.setEstado("Detenido");
    }

    @Override
    public String ejecutar() {
        if (!activo) {
            iniciar();
            return "Daemon[" + servicio + "] (PID " + pid.getNumeroPID() + ") arrancado.";
        } else {
            pid.setEstado("Ejecutando");
            return "Daemon[" + servicio + "] (PID " + pid.getNumeroPID() + ") ya activo.";
        }
    }
}
