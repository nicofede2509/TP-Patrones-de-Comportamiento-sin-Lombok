package PatronObserver;
import java.util.ArrayList;
import java.util.List;

public class CursoObserver {//Llamada así por duplicación de nombre en otras clases
    private final String nombre;
    private final List<Observer> observadores = new ArrayList<>();
    private String horario; // por ejemplo "Lunes 18:00"

    public CursoObserver(String nombre) {
        this.nombre = nombre;
    }

    // Gestión de suscriptores
    public void suscribir(Observer o) {
        if (o != null && !observadores.contains(o)) {
            observadores.add(o);
        }
    }

    public void desuscribir(Observer o) {
        observadores.remove(o);
    }

    private void notificar(String msg) {
        for (Observer o : observadores) {
            o.update("Curso " + nombre + ": " + msg);
        }
    }

    // Eventos del curso
    public void cambiarHorario(String nuevoHorario) {
        this.horario = nuevoHorario;
        notificar("Nuevo horario -> " + nuevoHorario);
    }

    public void nuevoAviso(String aviso) {
        notificar("Aviso -> " + aviso);
    }

    public String getNombre() { return nombre; }
    public String getHorario() { return horario; }
}
