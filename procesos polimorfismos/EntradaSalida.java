public class EntradaSalida extends Proceso {
    private String dispositivo;
    private int tiempoEspera;

    public EntradaSalida(PID pid, String nombre, int capacidadEjecutar, String dispositivo, int tiempoEspera) {
        super(pid, nombre, capacidadEjecutar);
        this.dispositivo = dispositivo;
        this.tiempoEspera = tiempoEspera;
    }

    public EntradaSalida(String dispositivo, int tiempoEspera) {
        this(new PID(), "E/S-" + dispositivo, 1, dispositivo, tiempoEspera);
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public String ejecutar() {
        pid.setEstado("Bloqueado por I/O");
        if (tiempoEspera <= 0) {
            pid.setEstado("Terminado");
            return "EntradaSalida[" + nombre + "] (PID " + pid.getNumeroPID() + ") completó I/O inmediatamente.";
        } else {
            tiempoEspera--;
            pid.setEstado(tiempoEspera == 0 ? "Terminado" : "Listo");
            return "EntradaSalida[" + nombre + "] (PID " + pid.getNumeroPID() + ") espera " + tiempoEspera + " unidades de I/O.";
        }
    }
}
