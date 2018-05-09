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
public class Perfil_apoyo {
    
    private String rol;
    private List<Usuario_apoyo> usuarios;
    private List<Privilegios_apoyo> priv;
    
    public Perfil_apoyo(String rol, List<Usuario_apoyo> usuarios, List<Privilegios_apoyo> priv){
        this.rol=rol;
        this.usuarios=usuarios;
        this.priv=priv;
    }
    
    public Perfil_apoyo(String rol){
        this.rol=rol;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
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
     * @return the priv
     */
    public List<Privilegios_apoyo> getPriv() {
        return priv;
    }

    /**
     * @param priv the priv to set
     */
    public void setPriv(List<Privilegios_apoyo> priv) {
        this.priv = priv;
    }
    
}
