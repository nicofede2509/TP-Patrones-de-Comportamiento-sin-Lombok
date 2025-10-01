package PatronMediator;

import java.util.ArrayList;
import java.util.List;
public class ChatRoom implements ChatMediator{
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void enviarMensaje(String msg, Usuario usuario) {
        for(Usuario user : usuarios){
            if(user != usuario){
                user.recibir(msg);
            }
        }
    }
}
