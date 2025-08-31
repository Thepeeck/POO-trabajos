import java.util.*;

public class Nombre {
    private int id;
    private String Nombre;
    private int edad;
    private String TipoMembresia;

    public Nombre(int id, String Nombre, int edad, String TipoMembresia) {
        this.id = id;
        this.Nombre = Nombre;
        this.edad = edad;
        this.TipoMembresia = TipoMembresia;
    }

    public int GetId() { return id; }
    public void SetId(int id) { this.id = id; }

    public String GetNombre() { return Nombre; }
    public void SetNombre(String Nombre) { this.Nombre = Nombre; }

    public int GetEdad() { return edad; }
    public void SetEdad(int edad) { this.edad = edad; }

    public String GetTipoMembresia() { return TipoMembresia; }
    public void SetTipoMembresia(String TipoMembresia) { this.TipoMembresia = TipoMembresia; }
}
