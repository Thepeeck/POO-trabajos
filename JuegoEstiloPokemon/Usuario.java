public class Usuario {
    private String rol;
    private Stats stats;

    public Usuario(String rol, Stats stats) {
        this.rol = rol;
        this.stats = stats;
    }

    public void calcularAtaque(Enemigo enemigo) {
        int danio = Math.max(0, stats.getAtaque() - enemigo.getStats().getDefensa());
        enemigo.getStats().setVida(enemigo.getStats().getVida() - danio);
        System.out.println("Jugador ataca a " + enemigo.getTipo() + " causando " + danio + " de daño.");
    }

    public void calcularDefensa(int defensa) {
        stats.setDefensa(stats.getDefensa() + defensa);
    }

    public void calcularVida(int vida) {
        stats.setVida(stats.getVida() + vida);
    }

    public String getRol() { return rol; }
    public Stats getStats() { return stats; }
}