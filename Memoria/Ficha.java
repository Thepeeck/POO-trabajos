public class Ficha {
    private String simbolo;
    private boolean descubierta;
    private boolean emparejada;

    public Ficha(String simbolo) {
        this.simbolo = simbolo;
        this.descubierta = false;
        this.emparejada = false;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public boolean isEmparejada() {
        return emparejada;
    }

    public void revelar() {
        if (!emparejada) {
            descubierta = true;
        }
    }

    public void ocultar() {
        if (!emparejada) {
            descubierta = false;
        }
    }

    public void emparejar() {
        emparejada = true;
        descubierta = true;
    }

    @Override
    public String toString() {
        return descubierta ? simbolo : "❓";
    }
}
