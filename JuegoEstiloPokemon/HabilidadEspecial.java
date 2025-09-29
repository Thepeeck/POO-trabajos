public class HabilidadEspecial {
    private String pasivo;
    private int activo;

    public HabilidadEspecial(String pasivo, int activo) {
        this.pasivo = pasivo;
        this.activo = activo;
    }

    public String getPasivo() { return pasivo; }
    public int getActivo() { return activo; }

    public void setPasivo(String pasivo) { this.pasivo = pasivo; }
    public void setActivo(int activo) { this.activo = activo; }