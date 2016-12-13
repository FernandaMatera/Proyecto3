import java.util.ArrayList;
import java.util.Collections;
import proyecto3.Usuario;

/**
 *
 * @author Luis
 */
public class Sistema {
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioAuxiliar;

    public Sistema(ArrayList<Usuario> usuarios, Usuario usuarioAuxiliar) {
        this.usuarios = usuarios;
        this.usuarioAuxiliar = usuarioAuxiliar;
    }

    Sistema() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean agregarUsario (Usuario usuario){
        
        return usuarios.add(usuario);
        
    }
    
    public int cantidadUsuarios()
    {
        return this.usuarios.size();
    }
    
    
     public String listarDescendente ()
    {
        String listado = "";
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for (Usuario existente : this.usuarios)
        {
            usuarios.add(existente);              
        }
        for (Usuario existente : this.usuarios)
        {
            usuarios.add(existente);
        }
        //Collections.sort(usuarios);
        for (int i = usuarios.size()-1; i > 0; i--){
            listado+= usuarios.get(i).toString() + "\n";
        }
        return listado;
        
    }
}