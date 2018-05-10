/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Evento;
import clases.Perfil;
import clases.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author DavidDR
 */
@Named(value = "controlador_Login")
@RequestScoped
public class Controlador_Login implements Serializable {

    private String password;
    private String email;
    private List<Usuario> users;
    
    private String otro;

    private Usuario user;
    
   @Inject
   private MiSesion ctrl;
  
   public Controlador_Login() {
        users = new ArrayList<>();
        users.add(new Usuario(121L, "123456", "78556410V", "paco_mg99@hotmail.com", "Francisco", "Marin Garzón", "Hombre", new Date(1997 - 1900, 3, 2), 29610, "C/Luisa Ordoñez n15 1ºB", "Málaga", "Málaga", new Date(2015 - 1900, 3, 2), 50, 921121314, 654121314, "Tarjeta_Crédito", new Perfil(Perfil.Rol.EDUCANDO)));
        users.add(new Usuario(122L, "234567", "71156411N", "paula_vp@hotmail.com", "Paula", "Vergara Perez", "Mujer", new Date(1997 - 1900, 11, 6), 29615, "C/Santa Rosa n17 5ºC", "Málaga", "Málaga", new Date(2015 - 1900, 10, 11), 75, 921675432, 654960584, "Tarjeta_Crédito", new Perfil(Perfil.Rol.COORDGEN)));
        
        List<Evento> events = new ArrayList<>();
        events.add(new Evento(1L, "Viaje al monte", new Date(2018-1900,3,24), "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        users.get(0).setEventos(events);
    }

    public String autenticar() {

        
        Iterator<Usuario> iter = users.iterator();

        boolean pV = false, exist = false;
        Usuario aux = null;

        while (iter.hasNext() && !exist) {
            aux = iter.next();

            if (aux.getEmail().equals(getEmail())) {
                exist = true;
                if (aux.getContrasenia().equals(getPassword())) {
                    pV = true;
                }
            }
        }

        if (!exist) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email no registrado", "Email no registrado"));
            return null;
        }
        if (!pV) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password incorrecto", "Password incorrecto"));
            return null;
        }

        ctrl.setUsers(users);
        ctrl.setUser(aux);
        return "Inicio.xhtml";
    }
    
        public Usuario verUsuario(){
        int ID = Integer.decode(otro);
        int i=0;
        while(i<users.size()&&users.get(i).getId()!=ID)i++;
        return users.get(i);
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * @return the otro
     */
    public String getOtro() {
        return otro;
    }

    /**
     * @param otro the otro to set
     */
    public void setOtro(String otro) {
        this.otro = otro;
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
     * @return the ctrl
     */
    public MiSesion getCtrl() {
        return ctrl;
    }

    /**
     * @param ctrl the ctrl to set
     */
    public void setCtrl(MiSesion ctrl) {
        this.ctrl = ctrl;
    }

}
