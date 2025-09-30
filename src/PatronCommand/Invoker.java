package PatronCommand;

public class Invoker {
    private Command comando;

    public void setComando(Command comando) {
        this.comando = comando;
    }
    public void ejecutarComando(){
        comando.execute();
    }
}
