public class Action {
    private int turnos;
    private String efectos;
    private int nivel;

    public Action(int turnos, String efectos, int nivel) {
        this.turnos = turnos;
        this.efectos = efectos;
        this.nivel = nivel;
    }

    public int getTurnos() { return turnos; }
    public String getEfectos() { return efectos; }
    public int getNivel() { return nivel; }

    public void setTurnos(int turnos) { this.turnos = turnos; }
    public void setEfectos(String efectos) { this.efectos = efectos; }
    public void setNivel(int nivel) { this.nivel = nivel; }
}