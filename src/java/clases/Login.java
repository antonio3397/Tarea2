/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel Lillo
 */
@Named(value="miLogin")
@RequestScoped
public class Login {
    private String u;
    private String password;
    private List<Usuario> users;

    public Login() {
        users = new ArrayList<>();
        users.add(new Usuario("Educando", "asdf", clases_apoyo.Perfil_apoyo.Rol.EDUCANDO));
        users.add(new Usuario("Admin", "qwer", clases_apoyo.Perfil_apoyo.Rol.ADMIN));
    }
    
    public String autenticar(){
        
        return "posiblePlantilla.xhtml";//me da fallos y no entiendo por que
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Usuario> getUsers() {
        return users;
    }

    public void setUsers(List<Usuario> users) {
        this.users = users;
    }
    
}
