package PatronMemento;

import java.util.ArrayList;
import java.util.List;

public class Examen {
    private List<String> respuestas = new ArrayList<>();

    public void contestarPregunta(String respuesta) {
        respuestas.add(respuesta);
    }

    public void mostrarRespuestas() {
        System.out.println("Respuestas actuales: " + respuestas);
    }

    public Memento save() {
        return new Memento(respuestas);
    }

    public void restore(Memento m) {
        this.respuestas = new ArrayList<>(m.getRespuestas());}
}