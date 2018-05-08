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
public class Responsable_Legal_apoyo {
    
    private Long id;
    private String Nombre;
    private String Apellidos;
    private String Email;
    private List<Usuario_apoyo> usuarios;
    
    public Responsable_Legal_apoyo(Long id, String Nombre, String Apellidos, String Email, List<Usuario_apoyo> usuarios){
        this.id=id;
        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.Email=Email;
        this.usuarios=usuarios;
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
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
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
