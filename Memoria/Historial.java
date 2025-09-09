import java.util.*;

public class Historial {
    private List<String> eventos;

    public Historial() {
        eventos = new ArrayList<>();
    }

    public void registrar(String evento) {
        eventos.add(evento);
    }

    public List<String> getEventos() {
        return eventos;
    }
}