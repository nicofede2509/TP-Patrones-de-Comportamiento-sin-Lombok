package PatronTemplateMethod;

public class ReporteAlumno extends ReporteAcademico {
    private String nombreAlumno;
    private double promedio;

    public ReporteAlumno(String nombreAlumno, double promedio) {
        this.nombreAlumno = nombreAlumno;
        this.promedio = promedio;
    }

    @Override
    protected void generarContenido() {
        System.out.println("Alumno: " + nombreAlumno);
        System.out.println("Promedio: " + promedio);
    }
}