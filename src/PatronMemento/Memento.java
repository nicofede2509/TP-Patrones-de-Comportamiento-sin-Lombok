package PatronMemento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private final List<String> respuestas;

    public Memento(List<String> respuestas) {
        this.respuestas = new ArrayList<>(respuestas);
    }

    public List<String> getRespuestas() {
        return respuestas;
}
}