package PatronStrategy;

import java.util.ArrayList;
import java.util.List;

public class AlumnoStrategy {
    private String nombre;
    private List<Integer> notas = new ArrayList<>();
    private CalculoNota estrategia;

    public AlumnoStrategy(String nombre, CalculoNota estrategia) {
        this.nombre = nombre;
        this.estrategia = estrategia;
    }

    public void agregarNota(int nota) {
        notas.add(nota);
    }

    public void setEstrategia(CalculoNota estrategia) {
        this.estrategia = estrategia;
    }

    public void mostrarNotaFinal() {
        double resultado = estrategia.calcular(notas);
        System.out.println(nombre + " - Nota final (" + estrategia.getNombre() + "): " + resultado);
    }
}