package PatronTemplateMethod;

public class ReporteCurso extends ReporteAcademico {
    private String nombreCurso;
    private int alumnosInscriptos;

    public ReporteCurso(String nombreCurso, int alumnosInscriptos) {
        this.nombreCurso = nombreCurso;
        this.alumnosInscriptos = alumnosInscriptos;
    }

    @Override
    protected void generarContenido() {
        System.out.println("Curso: " + nombreCurso);
        System.out.println("Cantidad de alumnos inscriptos: " + alumnosInscriptos);
    }
}