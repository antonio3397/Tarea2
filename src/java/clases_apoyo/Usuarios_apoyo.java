/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_apoyo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author DavidDR
 */
@ManagedBean(name = "Usuarios")
@ViewScoped
public class Usuarios_apoyo {

    private List<Usuario_apoyo> usuariosj;

    @PostConstruct
    public void init() {
        setUsuariosj(new ArrayList<>());
        //getUsuariosj().add(new Usuario_apoyo(0, contrasena, NIF, rol, email, nombre, apellidos, sexo, fecha_nacimiento, 0, direccion, localidad, fecha_ingreso, 0, 0, metodo_pago, 0))
        getUsuariosj().add(new Usuario_apoyo(120, "012345", "33455667L", "Educando", "correofalso123@falso.xd", "Nombre", "Apellidos", "masc", "01/02/2002", 1230, "C/Falsa, 1234", "Falsolandia", "01/01/2011", 961002211, 651001233, "efectivo", 200));
        getUsuariosj().add(new Usuario_apoyo(121, "123456", "78556410V", "Admin", "paco_mg99@hotmail.com", "Francisco", "Marin Garzon", "masc", "02/03/1997", 29610, "C/Luisa Ordoñez n15 1ºB", "Malaga", "02/03/2015", 921121314, 654121314, "tarjeta_credito", 50));
        getUsuariosj().add(new Usuario_apoyo(122, "234567", "71156411N", "Scouter", "paula_vp@hotmail.com", "Paula", "Vergara Perez", "fem", "06/11/1997", 29615, "C/Santa Rosa n17 5ºC", "Malaga", "11/10/2015", 921675432, 654960584, "tarjeta_credito", 75));
    }

    /**
     * @return the usuariosj
     */
    public List<Usuario_apoyo> getUsuariosj() {
        return usuariosj;
    }

    /**
     * @param usuariosj the usuariosj to set
     */
    public void setUsuariosj(List<Usuario_apoyo> usuariosj) {
        this.usuariosj = usuariosj;
    }

}
