import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase base TrabajadorMedico según UML.
 * Encapsula atributos comunes y requiere calcularSalario por polimorfismo.
 */
public abstract class TrabajadorMedico {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    protected final int id;
    protected String nombre;
    protected String departamento;
    protected int experiencia; // años
    protected double salarioBase;

    public TrabajadorMedico(String nombre, String departamento, int experiencia, double salarioBase) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.nombre = nombre;
        this.departamento = departamento;
        this.experiencia = experiencia;
        this.salarioBase = salarioBase;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public int getExperiencia() { return experiencia; }
    public void setExperiencia(int experiencia) { this.experiencia = experiencia; }
    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }

    // Salario calculado por cada especialización (polimorfismo)
    public abstract double calcularSalario();

    @Override
    public String toString() {
        return String.format("%s[id=%d, nombre=%s, dept=%s, exp=%d, base=%.2f]",
                this.getClass().getSimpleName(), id, nombre, departamento, experiencia, salarioBase);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrabajadorMedico)) return false;
        TrabajadorMedico t = (TrabajadorMedico) o;
        return this.id == t.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
