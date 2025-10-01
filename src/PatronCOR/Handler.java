package PatronCOR;

public interface Handler {
    void setNext(Handler next);
    void handler(Solicitud solicitud);
}
