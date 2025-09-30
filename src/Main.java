import PatronCommand.*;
import PatronIterator.*;
import PatronMediator.*;
import PatronMemento.*;

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

        System.out.println("\n===============================================================================");
        System.out.println("Ejercicio 4: Patrón Mediador.\n");

        ChatMediator sala = new ChatRoom();

        Usuario profesor = new Profesor(sala, "Pedro");
        Usuario alumno1 = new AlumnoMediator(sala, "Nicolás");
        Usuario alumno2 = new AlumnoMediator(sala, "Tiago");
        Usuario alumno3 = new AlumnoMediator(sala, "Antonio");

        sala.agregarUsuario(profesor);
        sala.agregarUsuario(alumno1);
        sala.agregarUsuario(alumno2);
        sala.agregarUsuario(alumno3);

        profesor.enviar("Buen día alumnos!!");
        alumno1.enviar("Hola profe, buenos días");
        alumno2.enviar("Profe, tengo una duda");
        alumno3.enviar("Yo también profe");


        System.out.println("\n===============================================================================");
        System.out.println("Ejercicio 5: Patrón Memento.\n");

        Examen examen = new Examen();
        Historial historial = new Historial();

        examen.contestarPregunta("Respuesta 1: A");
        historial.guardar(examen.save());

        examen.contestarPregunta("Respuesta 2: C");
        historial.guardar(examen.save());

        examen.contestarPregunta("Respuesta 3: B");
        examen.mostrarRespuestas();

        examen.restore(historial.deshacer());
        examen.mostrarRespuestas();

        examen.restore(historial.deshacer());
        examen.mostrarRespuestas();
    }


}