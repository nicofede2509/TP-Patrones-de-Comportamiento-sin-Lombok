package PatronTemplateMethod;

public abstract class ReporteAcademico {
    public final void generarReporte() {
        generarEncabezado();
        generarContenido();
        generarPie();
    }

    protected void generarEncabezado() {
        System.out.println("===== Reporte Académico =====");
    }

    protected void generarPie() {
        System.out.println("===== Fin del Reporte =====");
    }

    protected abstract void generarContenido();
}