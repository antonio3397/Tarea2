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
public class Documento_apoyo {
    
    private Long id;
    private String estado;
    private String tipo;
    private String fecha_entrega;
    private Evento_apoyo evento;
    private Usuario_apoyo usuario;

    public Documento_apoyo(Long id, String estado, String tipo, String fecha_entrega, Evento_apoyo evento, Usuario_apoyo usuario){
        this.id=id;
        this.estado=estado;
        this.tipo=tipo;
        this.fecha_entrega=fecha_entrega;
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the fecha_entrega
     */
    public String getFecha_entrega() {
        return fecha_entrega;
    }

    /**
     * @param fecha_entrega the fecha_entrega to set
     */
    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
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
