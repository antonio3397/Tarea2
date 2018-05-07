/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.List;
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
    
    @OneToMany (mappedBy="perfiles")
    private List<Usuario> usuarios;
    @ManyToMany
    @JoinTable(name="privilegios_asociados",joinColumns = @JoinColumn(name = "perfil_user"),
            inverseJoinColumns = @JoinColumn(name = "privilegios_user"))
    private List<Privilegios> priv;
    public Long getId() {
        return getRol();
    }

    public void setId(Long id) {
        this.setRol(id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getRol() != null ? getRol().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.getRol() == null && other.getRol() != null) || (this.getRol() != null && !this.rol.equals(other.rol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trabajo.Perfil[ id=" + getRol() + " ]";
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
    
}
