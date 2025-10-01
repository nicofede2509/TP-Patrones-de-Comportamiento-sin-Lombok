package PatronState;

// Cancelado.java
public class Cancelado implements EstadoInscripcion {
    @Override
    public String nombre() { return "Cancelado"; }

    @Override
    public void inscribir(Inscripcion ctx) {
        System.out.println("No se puede inscribir: estado Cancelado.");
    }

    @Override
    public void ponerEnEspera(Inscripcion ctx) {
        System.out.println("No se puede poner en espera: estado Cancelado.");
    }

    @Override
    public void cancelar(Inscripcion ctx) {
        System.out.println("Ya estaba cancelado. No cambia.");
    }
}

