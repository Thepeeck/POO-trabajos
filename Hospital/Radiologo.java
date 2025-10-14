/**
 * Radiólogo: equipos certificados y tarifa por estudio.
 */
import java.util.List;

public class Radiologo extends TrabajadorMedico {
    private List<String> equiposCertificados;
    private double tarifaPorEstudio;
    private int estudiosRealizados;

    public Radiologo(String nombre, String departamento, int experiencia, double salarioBase,
                     List<String> equiposCertificados, double tarifaPorEstudio) {
        super(nombre, departamento, experiencia, salarioBase);
        this.equiposCertificados = equiposCertificados;
        this.tarifaPorEstudio = tarifaPorEstudio;
        this.estudiosRealizados = 0;
    }

    public List<String> getEquiposCertificados() { return equiposCertificados; }
    public double getTarifaPorEstudio() { return tarifaPorEstudio; }
    public int getEstudiosRealizados() { return estudiosRealizados; }
    public void registrarEstudio() { this.estudiosRealizados++; }

    @Override
    public double calcularSalario() {
        return salarioBase + (estudiosRealizados * tarifaPorEstudio);
    }
}
