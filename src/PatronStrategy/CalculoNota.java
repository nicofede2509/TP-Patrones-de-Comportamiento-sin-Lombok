package PatronStrategy;

import java.util.List;

public interface CalculoNota {
    double calcular(List<Integer> notas);
    String getNombre();
}