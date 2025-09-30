import PatronCommand.*;

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
    }
}