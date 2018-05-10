/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author anton
 */
@ManagedBean(name = "usuarios")
@SessionScoped
public class Control_Usuarios {

    private Usuario user;
    private List<Usuario> usuariosreg;

    


    /*@PostConstruct
    public void init() {
        setUsuariosreg(new ArrayList<>());
        getUsuariosreg().add(new Usuario(121L, "123456", "78556410V", "paco_mg99@hotmail.com", "Francisco", "Marin Garzón", "Hombre", new Date(1997 - 1900, 3, 2), 29610, "C/Luisa Ordoñez n15 1ºB", "Málaga", "Málaga", new Date(2015 - 1900, 3, 2), 50, 921121314, 654121314, "Tarjeta_Crédito", new Perfil(Perfil.Rol.SCOUTER)));
        getUsuariosreg().add(new Usuario(122L, "234567", "71156411N", "paula_vp@hotmail.com", "Paula", "Vergara Perez", "Mujer", new Date(1997 - 1900, 11, 6), 29615, "C/Santa Rosa n17 5ºC", "Málaga", "Málaga", new Date(2015 - 1900, 10, 11), 75, 921675432, 654960584, "Tarjeta_Crédito", new Perfil(Perfil.Rol.COORDGEN)));
    }
*/
    
    public Usuario buscarUsuario(Long id) throws UsuarioException {
        
        Usuario aux = null;

        for (Usuario u : usuariosreg) {
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

        usuariosreg.remove(b);

        return "Lista_Usuarios.xhtml";
    }

    /**
     * @return the usuariosreg
     */
    public List<Usuario> getUsuariosreg() {
        return usuariosreg;
    }

    /**
     * @param usuariosreg the usuariosreg to set
     */
    public void setUsuariosreg(List<Usuario> usuariosreg) {
        this.usuariosreg = usuariosreg;
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
}
