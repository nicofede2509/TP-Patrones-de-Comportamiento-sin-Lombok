package PatronCOR;

public class Asistente implements HandlerCOR {
private HandlerCOR next;
@Override
public void setNext(HandlerCOR next){
    this.next = next ;
}
@Override
    public void handler(Solicitud solicitud) {

        if (solicitud.getNivel() == 1) {
            System.out.println("Asistente atiende: " + solicitud.getMensaje());
        } else if (next != null) {
            next.handler(solicitud);
        }
        else {
            System.out.println("ERROR: La solicitud de nivel " + solicitud.getNivel() + " no pudo ser atendida por nadie.");
        }
    }
}
    

  

