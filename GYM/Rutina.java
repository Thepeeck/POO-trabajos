import java.util.*;

public class Rutina {
    private String id;
    private String Nombre;
    private String Descripcion;
    private int Duracion;
    private String NivelDificultad;
    private String RutinaAsignada;
    private ArrayList<Nombre> MiembrosAsignados;

    public Rutina(String id, String Nombre, String Descripcion, int Duracion, String NivelDificultad, String RutinaAsignada, ArrayList<Nombre> MiembrosAsignados) {
        this.id = id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Duracion = Duracion;
        this.NivelDificultad = NivelDificultad;
        this.RutinaAsignada = RutinaAsignada;
        this.MiembrosAsignados = MiembrosAsignados;
    }

    public String GetId() { return id; }
    public void SetId(String id) { this.id = id; }

    public String GetNombre() { return Nombre; }
    public void SetNombre(String Nombre) { this.Nombre = Nombre; }

    public String GetDescripcion() { return Descripcion; }
    public void SetDescripcion(String Descripcion) { this.Descripcion = Descripcion; }

    public int GetDuracion() { return Duracion; }
    public void SetDuracion(int Duracion) { this.Duracion = Duracion; }

    public String GetNivelDificultad() { return NivelDificultad; }
    public void SetNivelDificultad(String NivelDificultad) { this.NivelDificultad = NivelDificultad; }

    public String GetRutinaAsignada() { return RutinaAsignada; }
    public void SetRutinaAsignada(String RutinaAsignada) { this.RutinaAsignada = RutinaAsignada; }

    public ArrayList<Nombre> GetMiembrosAsignados() { return MiembrosAsignados; }
    public void SetMiembrosAsignados(ArrayList<Nombre> MiembrosAsignados) { this.MiembrosAsignados = MiembrosAsignados; }
}