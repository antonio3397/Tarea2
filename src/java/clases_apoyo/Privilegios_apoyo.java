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
public class Privilegios_apoyo {
    private Long id;
    private String nombre;
    private List <Perfil_apoyo> perfil;
    
    public Privilegios_apoyo(Long id, String nombre, List <Perfil_apoyo> perfil){
        this.id=id;
        this.nombre=nombre;
        this.perfil=perfil;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the perfil
     */
    public List <Perfil_apoyo> getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(List <Perfil_apoyo> perfil) {
        this.perfil = perfil;
    }
    
}
