import java.util.Arrays;
import java.util.List;

import PatronCOR.*;
import PatronCommand.*;
import PatronIterator.*;
import PatronMediator.*;
import PatronMemento.*;
import PatronObserver.*;
import PatronState.*;
import PatronStrategy.*;
import PatronVisitor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n===============================================================================");
        System.out.println("Ejercicio 1: Patrón Chain of responibility.\n");

        HandlerCOR asistente = new Asistente();
        HandlerCOR profesor = new ProfesorCOR();
        HandlerCOR coordinador = new Coordinador();

        // Armar la cadena
        asistente.setNext(profesor);
        profesor.setNext(coordinador);

        // Probar solicitudes
        Solicitud s1 = new Solicitud(1, "Consulta simple de horarios");
        Solicitud s2 = new Solicitud(2, "Consulta sobre tema de examen");
        Solicitud s3 = new Solicitud(3, "Problema con la inscripción");
        Solicitud s4 = new Solicitud(4, "Solicitud fuera de alcance");

        asistente.handler(s1);
        asistente.handler(s2);
        asistente.handler(s3);
        asistente.handler(s4);

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

        Usuario profesorMediador = new ProfesorMediator(sala, "Pedro");
        Usuario alumno1 = new AlumnoMediator(sala, "Nicolás");
        Usuario alumno2 = new AlumnoMediator(sala, "Tiago");
        Usuario alumno3 = new AlumnoMediator(sala, "Antonio");

        sala.agregarUsuario(profesorMediador);
        sala.agregarUsuario(alumno1);
        sala.agregarUsuario(alumno2);
        sala.agregarUsuario(alumno3);

        profesorMediador.enviar("Buen día alumnos!!");
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

        System.out.println("\n===============================================================================");
        System.out.println("Ejercicio 6: Patrón Observer.\n");

        //Instanciar Curso
        CursoObserver desarrolloSoftware = new CursoObserver("Desarrollo de Software");
        //Instanciar Alumnos
        AlumnoObserver ana = new AlumnoObserver("Ana");
        AlumnoObserver bruno = new AlumnoObserver("Bruno");
        AlumnoObserver caro = new AlumnoObserver("Caro");

        //Meter a alumnos al curso
        desarrolloSoftware.suscribir(ana);
        desarrolloSoftware.suscribir(bruno);
        desarrolloSoftware.suscribir(caro);

        //Cambio de horario y notificacion
        desarrolloSoftware.cambiarHorario("Lunes 18:00");
        desarrolloSoftware.nuevoAviso("Examen parcial el 15/10");

        // Bruno se desuscribe
        desarrolloSoftware.desuscribir(bruno);

        //Cambio de horario y notificacion
        desarrolloSoftware.cambiarHorario("Miércoles 19:30");
        desarrolloSoftware.nuevoAviso("Trabajos prácticos: fecha límite 22/10");


        System.out.println("\n===============================================================================");
        System.out.println("Ejercicio 7: Patrón State.\n");

        Inscripcion nuevaInscripcion = new Inscripcion();
        System.out.println("Estado inicial: " + nuevaInscripcion.estadoActual());

        nuevaInscripcion.inscribir();        // EnEspera -> Inscrito
        System.out.println("Estado: " + nuevaInscripcion.estadoActual());

        nuevaInscripcion.ponerEnEspera();    // Inscrito -> EnEspera
        System.out.println("Estado: " + nuevaInscripcion.estadoActual());

        nuevaInscripcion.cancelar();         // EnEspera -> Cancelado
        System.out.println("Estado: " + nuevaInscripcion.estadoActual());

        nuevaInscripcion.inscribir();        // No permitido desde Cancelado
        System.out.println("Estado final: " + nuevaInscripcion.estadoActual());

        System.out.println("\n===============================================================================");
        System.out.println("Ejercicio 8: Patrón Strategy. \n");
        AlumnoStrategy juan = new AlumnoStrategy("Juan", new PatronStrategy.PromedioSimple());
        juan.agregarNota(7);
        juan.agregarNota(9);
        juan.agregarNota(5);

        juan.mostrarNotaFinal(); // Promedio Simple

        juan.setEstrategia(new PatronStrategy.PromedioPonderado(java.util.Arrays.asList(0.2, 0.3, 0.5)));
        juan.mostrarNotaFinal(); // Promedio Ponderado

        juan.setEstrategia(new PatronStrategy.ExamenExtra(10));
        juan.mostrarNotaFinal(); // Examen Extra

        System.out.println("\n===============================================================================");
        System.out.println("Ejercicio 9: Patrón Template Method. \n");

        PatronTemplateMethod.ReporteAcademico reporteCurso =
                new PatronTemplateMethod.ReporteCurso("Programación II", 35);
        reporteCurso.generarReporte();

        PatronTemplateMethod.ReporteAcademico reporteAlumno =
                new PatronTemplateMethod.ReporteAlumno("Juan Pérez", 8.5);
        reporteAlumno.generarReporte();

        System.out.println("\n===============================================================================");
        System.out.println("Ejercicio 10: Patrón Visitor. \n");


        List<AlumnoVisitor> alumnos = Arrays.asList(
                new AlumnoRegular("Pedro Torres", 1000.0),
                new AlumnoBecado("Mariana Soto", 1000.0, 40.0),
                new AlumnoRegular("Laura García", 1500.0)
        );

       
        Visitor aplicadorDeBecas = new AplicarBeca();
        System.out.println("");
        System.out.println("VISITOR:");
        for (AlumnoVisitor alumnoVisitor : alumnos) {
            System.out.println("");
            alumnoVisitor.aceptar(aplicadorDeBecas);
        }
        System.out.println("");
    }
}