package PatronCOR;

public class Coordinador implements HandlerCOR {
    private HandlerCOR next;

    @Override
    public void setNext(HandlerCOR next) {
        this.next = next;
    }

    @Override
    public void handler(Solicitud solicitud) {
        if (solicitud.getNivel() == 3) {
            System.out.println("Coordinador atiende: " + solicitud.getMensaje());
        } else if (next != null) {
            System.out.println("Coordinador no puede atender. Pasando a siguiente nivel.");
            next.handler(solicitud);
        } else {
            System.out.println("Nadie pudo atender la solicitud: " + solicitud.getMensaje());
        }
    }
}

