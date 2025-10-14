/**
 * Enfermero/a: tipo de turno y bonificación nocturna si aplica.
 */
public class Enfermero extends TrabajadorMedico {
    private boolean turnoNocturno;
    private String nivelCertificacion;
    private double bonificacionNocturna; // monto fijo adicional

    public Enfermero(String nombre, String departamento, int experiencia, double salarioBase,
                     boolean turnoNocturno, String nivelCertificacion, double bonificacionNocturna) {
        super(nombre, departamento, experiencia, salarioBase);
        this.turnoNocturno = turnoNocturno;
        this.nivelCertificacion = nivelCertificacion;
        this.bonificacionNocturna = bonificacionNocturna;
    }

    public boolean isTurnoNocturno() { return turnoNocturno; }
    public String getNivelCertificacion() { return nivelCertificacion; }

    @Override
    public double calcularSalario() {
        return salarioBase + (turnoNocturno ? bonificacionNocturna : 0.0);
    }
}
