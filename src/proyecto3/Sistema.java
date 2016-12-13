/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<Usuario> user = new ArrayList<>();
        for (Usuario existente : this.usuarios)
        {
            user.add(existente);              
        }
        
        Collections.sort(user, Collections.reverseOrder());
        
        
        for (int i = user.size()-1; i > 0; i--){
            listado+= user.get(i).toString() + "\n";
        }
        return listado;
        
    }
    
    
}
