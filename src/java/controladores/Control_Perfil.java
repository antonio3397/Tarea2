/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Usuario;
import clases_apoyo.Usuario_apoyo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author migue
 */
@Named(value = "control_Perfil")
@Dependent
public class Control_Perfil {

    
    private List<Usuario_apoyo> usuarios;
    
    
    public Control_Perfil() {
        usuarios = new ArrayList<Usuario_apoyo>();
        usuarios.add(new Usuario_apoyo(121, 123456, "78556410V","Admin","paco_mg99@hotmail.com", "Francisco", "Marin Garzon", "masc", "02/03/1997", 29610,"C/Luisa Ordoñez n15 1ºB" , "Malaga", "02/03/2015", 921121314,654121314, "tarjeta_credito", 50));
        usuarios.add(new Usuario_apoyo(122, 234567, "71156411N","Scouter","paula_vp@hotmail.com", "Paula", "Vergara Perez", "fem", "06/11/1997", 29615,"C/Santa Rosa n17 5ºC" , "Malaga", "11/10/2015", 921675432,654960584, "tarjeta_credito", 75));
    
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

    private Usuario usuario= new Usuario();
    private List<Usuario> listaUsuarios= new ArrayList<>();
    
}
