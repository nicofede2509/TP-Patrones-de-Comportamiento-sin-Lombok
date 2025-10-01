package PatronVisitor;

public class AplicarBeca implements Visitor {

    // Lógica para AlumnoRegular
    @Override
    public void visitar(AlumnoRegular a) {
        double descuento = a.getCuota() * 0.05; // 5% de descuento general
        double cuotaFinal = a.getCuota() - descuento;
        System.out.println("Aplicando descuento de $" + descuento +
                " a " + a.getNombre() + ". Cuota final: $" + cuotaFinal);
    }

    // Lógica para AlumnoBecado
    @Override
    public void visitar(AlumnoBecado a) {
        double descuento = a.getCuota() * (a.getPorcentajeBeca() / 100.0);
        double cuotaFinal = a.getCuota() - descuento;
        System.out.println("Aplicando beca (" + a.getPorcentajeBeca() + "%) por $" + descuento +
                " a " + a.getNombre() + ". Cuota final: $" + cuotaFinal);
    }
}
