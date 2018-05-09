/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



/**
 *
 * @author anton
 */

@ManagedBean(name="PerfilUsuario")
@ViewScoped
public class Control_Perfil {

    private List<Usuario_apoyo> usuarios;

  
  /*
    
    
    public Control_Perfil() {
        usuarios = new ArrayList<Usuario_apoyo>();
        usuarios.add(new Usuario_apoyo(120, 012, "22432567S", "Educando", "jms@gmail.com", "Jose", "Martin Segura", "masc", "01/12/2004", 23010, "C/Marin de los Santos, 23", "Sevilla", "13/5/2012", 999112233, 666554433, "efectivo", 35));
        usuarios.add(new Usuario_apoyo(121, 123456, "78556410V","Admin","paco_mg99@hotmail.com", "Francisco", "Marin Garzon", "masc", "02/03/1997", 29610,"C/Luisa Ordoñez n15 1ºB" , "Malaga", "02/03/2015", 921121314,654121314, "tarjeta_credito", 50));
        usuarios.add(new Usuario_apoyo(122, 234567, "71156411N","Scouter","paula_vp@hotmail.com", "Paula", "Vergara Perez", "fem", "06/11/1997", 29615,"C/Santa Rosa n17 5ºC" , "Malaga", "11/10/2015", 921675432,654960584, "tarjeta_credito", 75));
    
    }
    
    public Usuario getUsuario() {
        return usuario;
    }*/

    @PostConstruct
    public void init(){
        
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario_apoyo(121, "123456", "78556410V", new Perfil_apoyo(Perfil_apoyo.Rol.ADMIN), "paco_mg99@hotmail.com", "Francisco", "Marin Garzón", "Hombre", "02/03/1997", 29610, "C/Luisa Ordoñez n15 1ºB", "Málaga", "02/03/2015", 921121314, 654121314, "Tarjeta_Crédito", 50));
        usuarios.add(new Usuario_apoyo(122, "234567", "71156411N", new Perfil_apoyo(Perfil_apoyo.Rol.EDUCANDO), "paula_vp@hotmail.com", "Paula", "Vergara Perez", "Mujer", "06/11/1997", 29615, "C/Santa Rosa n17 5ºC", "Málaga", "11/10/2015", 921675432, 654960584, "Tarjeta_Crédito", 75));

    }

    public List<Usuario_apoyo> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario_apoyo> usuarios) {
        this.usuarios = usuarios;
    }
}
