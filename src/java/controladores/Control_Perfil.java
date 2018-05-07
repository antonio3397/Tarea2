/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author migue
 */
@Named(value="control_Perfil")
@Dependent
public class Control_Perfil {
    
    private Usuario usuario=new Usuario();
    private List<Usuario> listaUsuarios=new ArrayList<>();
    
    
    public Control_Perfil(){
        
        Control_Registro listaRegistrados = new Control_Registro();
      
        int totalUsuarios= listaRegistrados.getList_User().size();
        int i=0;
        while(i<totalUsuarios){
            listaUsuarios.add(listaRegistrados.getList_User().get(i));
            i++;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
  
    
            
            
    
}
