public class Items {
    private int danioMas;
    private int defensaMas;
    private int pocion;
    private int veneno;

    public Items(int danioMas, int defensaMas, int pocion, int veneno) {
        this.danioMas = danioMas;
        this.defensaMas = defensaMas;
        this.pocion = pocion;
        this.veneno = veneno;
    }

    public void efectoDanio(Enemigo enemigo) {
        enemigo.getStats().setVida(enemigo.getStats().getVida() - danioMas);
        System.out.println("Item causa " + danioMas + " de daño extra al enemigo.");
    }

    public void efectoDefensa(Usuario usuario) {
        usuario.calcularDefensa(defensaMas);
        System.out.println("Item aumenta la defensa en " + defensaMas);
    }

    public void efectoCuracion(Usuario usuario) {
        usuario.calcularVida(pocion);
        System.out.println("Item cura " + pocion + " de vida.");
    }

    public void efectoVeneno(Enemigo enemigo) {
        enemigo.getStats().setVida(enemigo.getStats().getVida() - veneno);
        System.out.println("Item envenena causando " + veneno + " de daño.");
    }
}