/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Perfil;
import clases.Seccion;
import clases.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

/*
Tipos de id que tiene cada sección:
TODAS -> 0L
CASTORES -> 1L
LOBATOS -> 2L
ROVERS COMPAÑEROS -> 3L
TROPA SCOUT -> 4L
ESCULTAS PIONEROS -> 5L
 */
/**
 *
 * @author DavidDR
 */
@Named(value = "miSesion")
@SessionScoped
public class MiSesion implements Serializable {

    private Usuario user;
    private List<Usuario> users;
    private List<Usuario> users2;

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

        Iterator<Usuario> iter = users.iterator();
        while (iter.hasNext() && aux == null) {
            Usuario it = iter.next();
            if (it.getId().equals(id)) {
                aux = it;
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
        users2.remove(b);

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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public boolean isCoordGen() {
        return this.user.getPerfiles().getRol().equals(Perfil.Rol.COORDGEN);
    }

    public boolean isCordSec() {
        return this.user.getPerfiles().getRol().equals(Perfil.Rol.COORDSEC);
    }

    public boolean isScouter() {
        return this.user.getPerfiles().getRol().equals(Perfil.Rol.SCOUTER);
    }

    public boolean isEducando() {
        return this.user.getPerfiles().getRol().equals(Perfil.Rol.EDUCANDO);
    }
    
    public String getSeccion() {
        String salida = "";
        if (user.getSeccion().getNombre().equals(Seccion.Secciones.Castores)) {
            salida = "Castores";
        } else if (user.getSeccion().getNombre().equals(Seccion.Secciones.Escultas_Pioneros)){
            salida = "Escultas";
        } else if (user.getSeccion().getNombre().equals(Seccion.Secciones.Lobatos)) {
            salida = "Lobatos";
        } else if (user.getSeccion().getNombre().equals(Seccion.Secciones.Rovers_Compañeros)) {
            salida = "Rovers";
        } else if (user.getSeccion().getNombre().equals(Seccion.Secciones.Tropa_Scout)) {
            salida = "Scouts";
        }
        
       return salida;
    }
    
    /**
     * @return the users2
     */
    public List<Usuario> getUsers2() {
        return users2;
    }

    /**
     * @param users2 the users2 to set
     */
    public void setUsers2(List<Usuario> users2) {
        this.users2 = users2;
    }

}
