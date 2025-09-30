package PatronMediator;

public class AlumnoMediator extends Usuario{

    public AlumnoMediator(ChatMediator mediador, String nombre) {
        super(mediador, nombre);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("Alumno " + nombre + " envía: " + mensaje);
        mediador.enviarMensaje(mensaje, this);
    }

    @Override
    public void recibir(String mensaje) {
        System.out.println("Alumno " + nombre + " recibe: " + mensaje);
    }
}
