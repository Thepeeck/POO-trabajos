public class Stats {
    private int vida;
    private int ataque;
    private int defensa;

    public Stats(int vida, int ataque, int defensa) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }

    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
}