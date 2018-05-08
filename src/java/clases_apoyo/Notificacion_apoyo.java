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
public class Notificacion_apoyo {
    
    private Long usuario_id;
    private Long evento_id;
    private String titulo;
    private String texto;
    private Usuario_apoyo usuario;
    private Evento_apoyo evento;
    
    public Notificacion_apoyo(Long usuario_id, Long evento_id, String titulo, String texto, Usuario_apoyo usuario, Evento_apoyo evento){
        
        this.usuario_id=usuario_id;
        this.evento_id=evento_id;
        this.titulo=titulo;
        this.texto=texto;
        this.usuario=usuario;
        this.evento=evento;
        
    }

    /**
     * @return the usuario_id
     */
    public Long getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    /**
     * @return the evento_id
     */
    public Long getEvento_id() {
        return evento_id;
    }

    /**
     * @param evento_id the evento_id to set
     */
    public void setEvento_id(Long evento_id) {
        this.evento_id = evento_id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    
}
