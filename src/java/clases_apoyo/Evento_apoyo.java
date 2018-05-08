package clases_apoyo;

import java.util.List;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anton
 */
public class Evento_apoyo{
    
    private Integer ID;
    private String titulo;
    private String fecha;
    private String localizacion;
    private String descripcion;
    private int precio;
    private List<Documento_apoyo> documentos;
    private List<Comentario_apoyo> comentarios;
    private Seccion_apoyo seccion;
    private Usuario_apoyo usuario;
    private List<Notificacion_apoyo> notificaciones;
    private List<Usuario_apoyo> usuarios;
    
    public Evento_apoyo(Integer ID, String titulo, String fecha, String localizacion,
           String descripcion, int precio, List<Documento_apoyo> documentos,
           List<Comentario_apoyo> comentarios, Seccion_apoyo seccion, Usuario_apoyo usuario,
           List<Notificacion_apoyo> notificaciones, List<Usuario_apoyo> usuarios){
        this.ID=ID;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.localizacion=localizacion;
        this.precio=precio;
        this.titulo=titulo;
        this.documentos=documentos;
        this.comentarios=comentarios;
        this.seccion=seccion;
        this.usuario=usuario;
        this.notificaciones=notificaciones;
        this.usuarios=usuarios;
    }
    public Evento_apoyo(Integer ID, String titulo, String fecha, String localizacion,
           String descripcion, int precio){
        this.ID=ID;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.localizacion=localizacion;
        this.precio=precio;
        this.titulo=titulo;
    }

    /**
     * @return the ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(Integer ID) {
        this.ID = ID;
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the localizacion
     */
    public String getLocalizacion() {
        return localizacion;
    }

    /**
     * @param localizacion the localizacion to set
     */
    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the documentos
     */
    public List<Documento_apoyo> getDocumentos() {
        return documentos;
    }

    /**
     * @param documentos the documentos to set
     */
    public void setDocumentos(List<Documento_apoyo> documentos) {
        this.documentos = documentos;
    }

    /**
     * @return the comentarios
     */
    public List<Comentario_apoyo> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(List<Comentario_apoyo> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the seccion
     */
    public Seccion_apoyo getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(Seccion_apoyo seccion) {
        this.seccion = seccion;
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
     * @return the notificaciones
     */
    public List<Notificacion_apoyo> getNotificaciones() {
        return notificaciones;
    }

    /**
     * @param notificaciones the notificaciones to set
     */
    public void setNotificaciones(List<Notificacion_apoyo> notificaciones) {
        this.notificaciones = notificaciones;
    }

    /**
     * @return the usuarios
     */
    public List<Usuario_apoyo> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario_apoyo> usuarios) {
        this.usuarios = usuarios;
    }
    
}
