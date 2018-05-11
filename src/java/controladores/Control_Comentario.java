/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author franc
 */

@ManagedBean(name = "Comentarios")
@SessionScoped
public class Control_Comentario {
    private List<Comentario> Comentarios;
    @Inject
    private Control_Eventos ev;
    @Inject
    MiSesion lg;
            
    @PostConstruct
    public void init() {
        try {
            Comentarios = new ArrayList<>();
            Comentarios.add(new Comentario(1L, "Ay que emoción, ojala ya poder ir allí", new Date(2018-1900,3,3,20,02,00), ev.buscarEvento(1L), lg.buscarUsuario(121L)));
            Comentarios.add(new Comentario(2L, "Ay, espero poder ir a esta excursion. Me hace mucha ilu ver ardillitas >.< ", new Date(2018-1900,8,8,15,30,30), ev.buscarEvento(3L), lg.buscarUsuario(121L)));
            Comentarios.add(new Comentario(3L, "Este evento está bien organizado? Es que hace una calor alli que nos vamos a morir", new Date(2018-1900,3,3,15,03,26), ev.buscarEvento(2L), lg.buscarUsuario(122L)));
            Comentarios.add(new Comentario(4L, "Pero que tonteria de excursion. Es mas, es imposible conseguir ese dinero aunque vendiesemos magdalenas", new Date(2018-1900,8,8,20,20,20),  ev.buscarEvento(3L), lg.buscarUsuario(122L)));
            Comentarios.add(new Comentario(5L, "Ay, que negativo eres uwu. Yo casi tengo el dinero para ir", new Date(2018-1900,10,8,10,9,59),  ev.buscarEvento(3L), lg.buscarUsuario(121L)));
            Comentarios.add(new Comentario(6L, "Meh. Seguramente sea otra excursión igual que cuando fuimos a los montes de Malaga", new Date(2018-1900,3,3,21,03,02),  ev.buscarEvento(1L), lg.buscarUsuario(122L)));
        } catch (EventoException | UsuarioException ex) {
            Logger.getLogger(Control_Comentario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Comentario> getComentarios() {
        return Comentarios;
    }

    public void setComentarios(List<Comentario> Comentarios) {
        this.Comentarios = Comentarios;
    }
    
    public List<Comentario> buscarComentarios(String event) throws EventoException{
        List<Comentario> aux = new ArrayList<>();
        long ID = Integer.decode(event);
        Evento evento = ev.buscarEvento(ID);
        for(Comentario comment: Comentarios){
            if(comment.getEvento().equals(evento))aux.add(comment);
        }
        return aux;
    }
    
    public boolean hayComentarios(String event) throws EventoException{
        return buscarComentarios(event).isEmpty();
    }
    
    public void agnadirComentario(String men, Date dia, String event, Usuario user) throws EventoException{
        long ID = Integer.decode(event);
        Evento evento = ev.buscarEvento(ID);
        long tam = Comentarios.size();
        Comentario coment = new Comentario(ID, men, dia, evento, user);
        Comentarios.add(coment);
        
    }
    
    
}
