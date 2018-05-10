/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author josealonso
 */
@Named(value = "control_Registro")
@Dependent
public class Control_Registro {
    
    Usuario user;
    //private Usuario user=new Usuario();
    private List<Usuario> list_User=new ArrayList<>();
    /**
     * Creates a new instance of Control_Registro
     */
    public Control_Registro() {
    }

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * @return the list_User
     */
    public List<Usuario> getList_User() {
        return list_User;
    }

    /**
     * @param list_User the list_User to set
     */
    public void setList_User(List<Usuario> list_User) {
        this.list_User = list_User;
    }
    
    public void agregarPersona (){
        this.list_User.add(user);
    }
    
}
