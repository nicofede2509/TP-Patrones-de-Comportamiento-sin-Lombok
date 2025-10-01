package PatronCOR;

public interface HandlerCOR {
    void setNext(HandlerCOR next);
    void handler(Solicitud solicitud);
}
