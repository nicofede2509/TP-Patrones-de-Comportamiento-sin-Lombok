package PatronVisitor;

public class AlumnoRegular implements AlumnoVisitor {

    private String nombre;
    private double cuota;
    public AlumnoRegular(String nombre, double cuota) {
        this.nombre = nombre;
        this.cuota = cuota;
    }
    public String getNombre() {
        return nombre;
    }
    public double getCuota() {
        return cuota;
    }
    @Override
    public void aceptar(Visitor v) {
        v.visitar(this);
    }
}
