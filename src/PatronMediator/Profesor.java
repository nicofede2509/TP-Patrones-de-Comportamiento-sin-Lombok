package PatronMediator;

public class Profesor extends Usuario{

    public Profesor(ChatMediator mediador, String nombre) {
        super(mediador, nombre);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("Profesor " + nombre + " envía: " + mensaje);
        mediador.enviarMensaje(mensaje, this);
    }

    @Override
    public void recibir(String mensaje) {
        System.out.println("Profesor " + nombre + " recibe: " + mensaje);
    }
}
