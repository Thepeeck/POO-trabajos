public class Jefe extends Enemigo {
    private String rol;

    public Jefe(String tipo, String rol, Stats stats) {
        super(tipo, stats);
        this.rol = rol;
    }

    public void habilidadEspecial(Usuario usuario) {
        System.out.println(tipo + " JEFE usa un poder devastador!");
        int danio = stats.getAtaque() * 2;
        usuario.getStats().setVida(usuario.getStats().getVida() - danio);
    }
}