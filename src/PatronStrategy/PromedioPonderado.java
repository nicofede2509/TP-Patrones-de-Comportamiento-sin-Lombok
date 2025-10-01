package PatronStrategy;

import java.util.List;

public class PromedioPonderado implements CalculoNota {
    private List<Double> pesos;

    public PromedioPonderado(List<Double> pesos) {
        this.pesos = pesos;
    }

    @Override
    public double calcular(List<Integer> notas) {
        double suma = 0, totalPesos = 0;
        for (int i = 0; i < notas.size() && i < pesos.size(); i++) {
            suma += notas.get(i) * pesos.get(i);
            totalPesos += pesos.get(i);
        }
        return (totalPesos == 0) ? 0 : suma / totalPesos;
    }

    @Override
    public String getNombre() {
        return "Promedio Ponderado";
    }
}