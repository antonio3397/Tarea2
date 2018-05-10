/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Evento;
import clases.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author DavidDR
 */
@Named(value = "Inscripciones")
@RequestScoped
public class Control_Inscripciones implements Serializable {

    private Usuario user;

    public Usuario getUsuario() {
        return user;
    }

    public void setUsuario(Usuario user) {
        this.user = user;
    }

    public /*String*/ List<Evento> events() {
        //FacesContext ctx = FacesContext.getCurrentInstance();
        //List<Evento> events = this.getUsuario().getEventos();
        
        /*if (events().isEmpty()) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "No te has registrado a ningún evento todavía"));
        }
        */
        
        return this.getUsuario().getEventos();
    }

    public String misEventos() {

        return "inscripciones.xhtml";
    }

    /**
     * Creates a new instance of Control_MiPerfil
     */
    public Control_Inscripciones() {
    }

}
