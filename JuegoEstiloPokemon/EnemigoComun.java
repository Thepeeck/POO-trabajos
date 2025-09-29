public class EnemigoComun extends Enemigo {
    private String rol;

    public EnemigoComun(String tipo, String rol, Stats stats) {
        super(tipo, stats);
        this.rol = rol;
    }

    public void setRol(String rol) { this.rol = rol; }
    public String getRol() { return rol; }

    public void habilidadEspecial(Usuario usuario) {
        System.out.println(tipo + " (" + rol + ") usa un ataque rápido!");
        int danio = stats.getAtaque();
        usuario.getStats().setVida(usuario.getStats().getVida() - danio);
    }
}
