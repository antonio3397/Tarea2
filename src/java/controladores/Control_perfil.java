/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Usuario;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author anton
 */
@Named(value = "perfil")
@SessionScoped
public class Control_perfil {
    
    private Usuario user;

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
}
