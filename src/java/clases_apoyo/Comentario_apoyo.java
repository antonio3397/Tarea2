/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_apoyo;

/**
 *
 * @author anton
 */
public class Comentario_apoyo {
    
    private Long id;
    private String texto;
    private String fecha_creacion;
    private Evento_apoyo evento;
    private Usuario_apoyo usuario;
    
    public Comentario_apoyo(Long id, String texto, String fecha_creacion, Evento_apoyo evento, Usuario_apoyo usuario){
        this.id=id;
        this.texto=texto;
        this.fecha_creacion=fecha_creacion;
        this.evento=evento;
        this.usuario=usuario;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the fecha_creacion
     */
    public String getFecha_creacion() {
        return fecha_creacion;
    }

    /**
     * @param fecha_creacion the fecha_creacion to set
     */
    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    /**
     * @return the evento
     */
    public Evento_apoyo getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento_apoyo evento) {
        this.evento = evento;
    }

    /**
     * @return the usuario
     */
    public Usuario_apoyo getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario_apoyo usuario) {
        this.usuario = usuario;
    }
    
}
