package PatronVisitor;
public interface Visitor {
    void visitar(AlumnoRegular a);
    void visitar(AlumnoBecado a);
}