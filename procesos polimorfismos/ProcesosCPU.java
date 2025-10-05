public class ProcesosCPU extends Proceso {
    private int cpu;
    private String tipoTarea;
    private int calculo;

    public ProcesosCPU(PID pid, String nombre, int capacidadEjecutar, int cpu, String tipoTarea, int calculo) {
        super(pid, nombre, capacidadEjecutar);
        this.cpu = cpu;
        this.tipoTarea = tipoTarea;
        this.calculo = calculo;
    }

    public ProcesosCPU(int cpu, String tipoTarea, int calculo) {
        this(new PID(), "CPU-" + cpu + "-" + tipoTarea, calculo, cpu, tipoTarea, calculo);
    }

    public int getCpu() {
        return cpu;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public int getCalculo() {
        return calculo;
    }

    public void setCalculo(int calculo) {
        this.calculo = calculo;
    }

    public String mostrarTarea() {
        return "Tarea: " + tipoTarea + " (calculo restante=" + calculo + ")";
    }

    @Override
    public String ejecutar() {
        pid.setEstado("Ejecutando");
        int trabajoRealizado = Math.min(calculo, Math.max(1, capacidadEjecutar));
        calculo -= trabajoRealizado;

        if (calculo <= 0) {
            pid.setEstado("Terminado");
            return "ProcesosCPU[" + nombre + "] (PID " + pid.getNumeroPID() + ") terminó. " + mostrarTarea();
        } else {
            pid.setEstado("Listo");
            return "ProcesosCPU[" + nombre + "] (PID " + pid.getNumeroPID() + ") ejecutó " + trabajoRealizado +
                    " unidades; resta " + calculo + ".";
        }
    }
}
