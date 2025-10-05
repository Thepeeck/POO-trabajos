public abstract class Proceso {
    protected PID pid;
    protected String nombre;
    protected int capacidadEjecutar;

    public Proceso(PID pid, String nombre, int capacidadEjecutar) {
        this.pid = pid;
        this.nombre = nombre;
        this.capacidadEjecutar = capacidadEjecutar;
    }

    public PID getPID() {
        return pid;
    }

    public void setPID(PID pid) {
        this.pid = pid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadEjecutar() {
        return capacidadEjecutar;
    }

    public void setCapacidadEjecutar(int capacidadEjecutar) {
        this.capacidadEjecutar = capacidadEjecutar;
    }

    public abstract String ejecutar();
}
