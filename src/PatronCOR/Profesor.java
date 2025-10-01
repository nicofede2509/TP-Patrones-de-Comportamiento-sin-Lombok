package PatronCOR;


public class Profesor implements Handler {
    private Handler next;
    @Override
    public void setNext(Handler next) {
        this.next = next;
    }


    @Override
    public void handler(Solicitud solicitud) {
        if (solicitud.getNivel() == 2) {
            System.out.println("Profesor atiende: " + solicitud.getMensaje());
        } else if (next != null) {
            next.handler(solicitud);
        }
    }
}
