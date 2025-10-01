package PatronState;



// Inscripcion.java (Contexto)
public class Inscripcion{
    private EstadoInscripcion estado;

    public Inscripcion() {
        // Estado inicial a elección
        this.estado = new EnEspera();
    }

    public String estadoActual() {
        return estado.nombre();}

    // Métodos de alto nivel que delegan en el estado
    public void inscribir() {
        estado.inscribir(this);
    }

    public void ponerEnEspera() {
        estado.ponerEnEspera(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }
}

