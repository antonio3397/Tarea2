/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author anton
 */
@Entity
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rol;
    private String nombre_rol;
    @OneToMany (mappedBy="perfiles")
    private List<Usuario> usuarios;
    @ManyToMany
    @JoinTable(name="privilegios_asociados",joinColumns = @JoinColumn(name = "perfil_user"),
            inverseJoinColumns = @JoinColumn(name = "privilegios_user"))
    private List<Privilegios> priv;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.rol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perfil other = (Perfil) obj;
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        return true;
    }
  
    /**
     * @return the priv
     */
    public List<Privilegios> getPriv() {
        return priv;
    }

    /**
     * @param priv the priv to set
     */
    public void setPriv(List<Privilegios> priv) {
        this.priv = priv;
    }

    /**
     * @return the rol
     */
    public Long getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Long rol) {
        this.rol = rol;
    }

    /**
     * @return the nombre_rol
     */
    public String getNombre_rol() {
        return nombre_rol;
    }

    /**
     * @param nombre_rol the nombre_rol to set
     */
    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
