package PatronStrategy;

import java.util.List;

public class ExamenExtra implements CalculoNota {
    private int notaExtra;

    public ExamenExtra(int notaExtra) {
        this.notaExtra = notaExtra;
    }

    @Override
    public double calcular(List<Integer> notas) {
        double promedio = notas.stream().mapToInt(Integer::intValue).average().orElse(0);
        return Math.max(promedio, notaExtra); // se queda con la mejor nota
    }

    @Override
    public String getNombre() {
        return "Examen Extra";
    }
}