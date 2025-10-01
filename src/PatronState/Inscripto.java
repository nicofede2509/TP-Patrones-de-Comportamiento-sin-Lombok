package PatronState;


// Inscrito.java
public class Inscripto implements EstadoInscripcion {
    @Override
    public String nombre() { return "Inscrito"; }

    @Override
    public void inscribir(Inscripcion ctx) {
        System.out.println("Ya está inscrito. No cambia.");
    }

    @Override
    public void ponerEnEspera(Inscripcion ctx) {
        System.out.println("Pasando de Inscrito -> EnEspera");
        ctx.setEstado(new EnEspera());
    }

    @Override
    public void cancelar(Inscripcion ctx) {
        System.out.println("Cancelando inscripción (Inscrito -> Cancelado)");
        ctx.setEstado(new Cancelado());
    }
}
