/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_apoyo;

import java.util.List;

/**
 *
 * @author anton
 */
public class Seccion_apoyo {
    
    private Integer id;
    private String Nombre;
    private Integer Edad_minima;
    private Integer Edad_maxima;
    private List<Usuario_apoyo> usuarios;
    private List<Evento_apoyo> eventos;
    
    public Seccion_apoyo(Integer id, String Nombre, Integer Edad_minima, Integer Edad_maxima, List<Usuario_apoyo> usuarios, List<Evento_apoyo> eventos){
        this.id=id;
        this.Nombre=Nombre;
        this.Edad_minima=Edad_minima;
        this.Edad_maxima=Edad_maxima;
        this.usuarios=usuarios;
        this.eventos=eventos;
    }
    
    public Seccion_apoyo(Integer id, String Nombre, Integer Edad_minima, Integer Edad_maxima){
        this.id=id;
        this.Nombre=Nombre;
        this.Edad_minima=Edad_minima;
        this.Edad_maxima=Edad_maxima;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Edad_minima
     */
    public Integer getEdad_minima() {
        return Edad_minima;
    }

    /**
     * @param Edad_minima the Edad_minima to set
     */
    public void setEdad_minima(Integer Edad_minima) {
        this.Edad_minima = Edad_minima;
    }

    /**
     * @return the Edad_maxima
     */
    public Integer getEdad_maxima() {
        return Edad_maxima;
    }

    /**
     * @param Edad_maxima the Edad_maxima to set
     */
    public void setEdad_maxima(Integer Edad_maxima) {
        this.Edad_maxima = Edad_maxima;
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

    /**
     * @return the eventos
     */
    public List<Evento_apoyo> getEventos() {
        return eventos;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(List<Evento_apoyo> eventos) {
        this.eventos = eventos;
    }
    
}
