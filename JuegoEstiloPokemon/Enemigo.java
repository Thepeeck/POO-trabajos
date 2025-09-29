public class Enemigo {
    protected String tipo;
    protected Stats stats;

    public Enemigo(String tipo, Stats stats) {
        this.tipo = tipo;
        this.stats = stats;
    }

    public void calcularAtaque(Usuario usuario) {
        int danio = Math.max(0, stats.getAtaque() - usuario.getStats().getDefensa());
        usuario.getStats().setVida(usuario.getStats().getVida() - danio);
        System.out.println(tipo + " ataca causando " + danio + " de daño.");
    }

    public void calcularDefensa(int defensa) {
        stats.setDefensa(stats.getDefensa() + defensa);
    }

    public void calcularVida(int vida) {
        stats.setVida(stats.getVida() + vida);
    }

    public boolean estaVivo() {
        return stats.getVida() > 0;
    }

    public Stats getStats() { return stats; }
    public String getTipo() { return tipo; }
}