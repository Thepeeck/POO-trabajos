/**
 * Doctor General: tarifa por consulta y capacidad por día.
 */
public class DoctorGeneral extends TrabajadorMedico {
    private int capacidadPorDia;
    private double tarifaConsulta;
    private int consultasRealizadas;

    public DoctorGeneral(String nombre, String departamento, int experiencia, double salarioBase,
                         int capacidadPorDia, double tarifaConsulta) {
        super(nombre, departamento, experiencia, salarioBase);
        this.capacidadPorDia = capacidadPorDia;
        this.tarifaConsulta = tarifaConsulta;
        this.consultasRealizadas = 0;
    }

    public int getCapacidadPorDia() { return capacidadPorDia; }
    public void setCapacidadPorDia(int capacidadPorDia) { this.capacidadPorDia = capacidadPorDia; }
    public double getTarifaConsulta() { return tarifaConsulta; }
    public void setTarifaConsulta(double tarifaConsulta) { this.tarifaConsulta = tarifaConsulta; }
    public int getConsultasRealizadas() { return consultasRealizadas; }
    public void registrarConsulta() { this.consultasRealizadas++; }

    @Override
    public double calcularSalario() {
        return salarioBase + (consultasRealizadas * tarifaConsulta);
    }
}
