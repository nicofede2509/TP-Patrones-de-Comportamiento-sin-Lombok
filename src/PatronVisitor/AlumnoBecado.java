package PatronVisitor;

public class AlumnoBecado implements AlumnoVisitor {

    private String nombre;
    private double cuota;
    private double porcentajeBeca;

    public AlumnoBecado(String nombre, double cuota, double porcentajeBeca) {
        this.nombre = nombre;
        this.cuota = cuota;
        this.porcentajeBeca = porcentajeBeca;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCuota() {
        return cuota;
    }

    public double getPorcentajeBeca() {
        return porcentajeBeca;
    }

    @Override
    /*public void aceptar(Visitor v) {
        v.visitar(this);
    }*/
    public void aceptar(Visitor v) {
        v.visitar(this);
    }
}
