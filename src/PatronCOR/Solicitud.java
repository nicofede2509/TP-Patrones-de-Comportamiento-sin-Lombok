package PatronCOR;

public class Solicitud {
    private int nivel;
    private String mensaje;

    public Solicitud(int nivel, String mensaje) {
        this.nivel = nivel;
        this.mensaje = mensaje;
    }

    public int getNivel() {
        return nivel;
    }

    public String getMensaje() {
        return mensaje;
    }
}

