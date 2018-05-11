/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Perfil;
import clases.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author DavidDR
 */
@Named(value = "miSesion")
@SessionScoped
public class MiSesion implements Serializable {

    private Usuario user;
    private List<Usuario> users;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    /**
     * Creates a new instance of MiSesion
     */
    public MiSesion() {
    }
    
    public String logout() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        user = null;
        return "login.xhtml";
    }
    
    public Usuario buscarUsuario(Long id) throws UsuarioException {
        
        Usuario aux = null;

        for (Usuario u : users) {
            if (u.getId().equals(id)) {
                aux = u;
            }
        }
        if (aux == null) {
            throw new UsuarioException("Usuarios no existente");
        }

        return aux;
    }

    public String borrarUsuario(Long id) throws UsuarioException {

        Usuario b = buscarUsuario(id);

        users.remove(b);

        return "Lista_Usuarios.xhtml";
    }

    /**
     * @return the users
     */
    public List<Usuario> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<Usuario> users) {
        this.users = users;
    }
    
    public boolean isCoord() {
        return this.user.getPerfiles().getRol().equals(Perfil.Rol.COORDGEN);
    }
    
}
