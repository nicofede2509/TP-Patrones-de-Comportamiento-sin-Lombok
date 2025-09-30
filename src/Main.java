import PatronCommand.*;
import PatronIterator.*;

public class Main {
    public static void main(String[] args) {

        //Patrón Command
        System.out.println("\n===============================================================================");
        System.out.println("Ejercicio 2: Patrón Command.\n");
        Curso curso1 = new Curso();
        Command inscribir = new InscribirseCursoCommand(curso1);
        Command abandonar = new AbandonarCursoCommand(curso1);
        Command certificado = new SolicitarCertificadoCommand(curso1);

        Invoker controlador = new Invoker();

        controlador.setComando(inscribir);
        controlador.ejecutarComando();

        controlador.setComando(abandonar);
        controlador.ejecutarComando();

        controlador.setComando(certificado);
        controlador.ejecutarComando();

        System.out.println("\n===============================================================================");
        System.out.println("Ejercicio 3: Patrón Iterator.\n");

        Alumno alumno = new Alumno("Juan Pérez");
        alumno.inscribirCurso(new CursoIterador("Matemática I"));
        alumno.inscribirCurso(new CursoIterador("Programación II"));
        alumno.inscribirCurso(new CursoIterador("Bases de Datos"));

        CursoIterator it = alumno.iterator();
        System.out.println("Cursos inscritos por " + alumno.getNombre() + ":");
        while (it.hasNext()) {
            System.out.println("- " + it.next().getNombre());
        }
    }
}