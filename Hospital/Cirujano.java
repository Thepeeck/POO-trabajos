/**
 * Cirujano: horas de cirugía y tarifa por hora + bono por riesgo.
 */
public class Cirujano extends TrabajadorMedico {
    private double horasCirugia;
    private double tarifaPorHora;
    private double bonoRiesgo;

    public Cirujano(String nombre, String departamento, int experiencia, double salarioBase,
                    double horasCirugia, double tarifaPorHora, double bonoRiesgo) {
        super(nombre, departamento, experiencia, salarioBase);
        this.horasCirugia = horasCirugia;
        this.tarifaPorHora = tarifaPorHora;
        this.bonoRiesgo = bonoRiesgo;
    }

    public double getHorasCirugia() { return horasCirugia; }
    public void setHorasCirugia(double horasCirugia) { this.horasCirugia = horasCirugia; }
    public double getTarifaPorHora() { return tarifaPorHora; }
    public void setTarifaPorHora(double tarifaPorHora) { this.tarifaPorHora = tarifaPorHora; }
    public double getBonoRiesgo() { return bonoRiesgo; }
    public void setBonoRiesgo(double bonoRiesgo) { this.bonoRiesgo = bonoRiesgo; }

    @Override
    public double calcularSalario() {
        return salarioBase + (horasCirugia * tarifaPorHora) + bonoRiesgo;
    }
}
