package PatronState;

// EnEspera.java
public class EnEspera implements EstadoInscripcion {
    @Override
    public String nombre() { return "EnEspera"; }

    @Override
    public void inscribir(Inscripcion ctx) {
        System.out.println("Liberó cupo. EnEspera -> Inscrito");
        ctx.setEstado(new Inscripto());
    }

    @Override
    public void ponerEnEspera(Inscripcion ctx) {
        System.out.println("Ya estaba en espera. No cambia.");
    }

    @Override
    public void cancelar(Inscripcion ctx) {
        System.out.println("Cancelando solicitud (EnEspera -> Cancelado)");
        ctx.setEstado(new Cancelado());
    }
}

