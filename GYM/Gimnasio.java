import java.util.*;

public class Gimnasio {
    private ArrayList<Nombre> Miembros;
    private ArrayList<Entrenador> Entrenadores;
    private ArrayList<Rutina> Rutinas;

    public Gimnasio(ArrayList<Nombre> Miembros, ArrayList<Entrenador> Entrenadores, ArrayList<Rutina> Rutinas) {
        this.Miembros = Miembros;
        this.Entrenadores = Entrenadores;
        this.Rutinas = Rutinas;
    }

    public ArrayList<Nombre> GetMiembros() { return Miembros; }
    public ArrayList<Entrenador> GetEntrenadores() { return Entrenadores; }
    public ArrayList<Rutina> GetRutinas() { return Rutinas; }
}
