import java.util.*;

public class Entrenador {
    private int id;
    private String EntrenadorAsignado;
    private String especialidad;
    private ArrayList<Nombre> MiembrosAsignados;

    public Entrenador(int id, String EntrenadorAsignado, String especialidad, ArrayList<Nombre> MiembrosAsignados) {
        this.id = id;
        this.EntrenadorAsignado = EntrenadorAsignado;
        this.especialidad = especialidad;
        this.MiembrosAsignados = MiembrosAsignados;
    }

    public int GetId() { return id; }
    public void SetId(int id) { this.id = id; }

    public String GetEntrenadorAsignado() { return EntrenadorAsignado; }
    public void SetEntrenadorAsignado(String EntrenadorAsignado) { this.EntrenadorAsignado = EntrenadorAsignado; }

    public String GetEspecialidad() { return especialidad; }
    public void SetEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public ArrayList<Nombre> GetMiembrosAsignados() { return MiembrosAsignados; }
    public void SetMiembrosAsignados(ArrayList<Nombre> MiembrosAsignados) { this.MiembrosAsignados = MiembrosAsignados; }
}