package PatronCOR;


public class ProfesorCOR implements HandlerCOR {
    private HandlerCOR next;

    @Override
    public void setNext(HandlerCOR next) {
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
