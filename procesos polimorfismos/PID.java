public class PID {
    private static int nextId = 1;
    private final int numeroPID;
    private String estado;

    public PID() {
        this.numeroPID = nextId++;
        this.estado = "Nuevo";
    }

    public PID(int numeroPID, String estado) {
        this.numeroPID = numeroPID;
        this.estado = estado;
    }

    public int getNumeroPID() {
        return numeroPID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PID{" + "numeroPID=" + numeroPID + ", estado='" + estado + '\'' + '}';
    }
}

