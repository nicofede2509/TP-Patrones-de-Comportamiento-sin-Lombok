package PatronStrategy;

import java.util.List;

public class PromedioSimple implements CalculoNota {
    @Override
    public double calcular(List<Integer> notas) {
        return notas.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    @Override
    public String getNombre() {
        return "Promedio Simple";
    }
}