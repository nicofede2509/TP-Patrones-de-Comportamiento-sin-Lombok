package PatronState;

public interface EstadoInscripcion {
    String nombre();

    // Acciones posibles (el estado decide si permite o no la transición)
    void inscribir(Inscripcion ctx);
    void ponerEnEspera(Inscripcion ctx);
    void cancelar(Inscripcion ctx);
}
