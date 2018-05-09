/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases_apoyo.Privilegios_apoyo;
import clases_apoyo.Perfil_apoyo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author anton
 */
@ManagedBean(name="Perfiles")
@ApplicationScoped
public class Control_Perfil {
    
    private Perfil_apoyo edu;
    private Perfil_apoyo cg;
    private Perfil_apoyo cs;
    private Perfil_apoyo sc;
    
    @PostConstruct
    public void init() {
        setEdu(new Perfil_apoyo("Educando"));
        setCg(new Perfil_apoyo("CoordGen"));
        setCs(new Perfil_apoyo("CoordSec"));
        setSc(new Perfil_apoyo("Scouter"));
    }

    /**
     * @return the edu
     */
    public Perfil_apoyo getEdu() {
        return edu;
    }

    /**
     * @param edu the edu to set
     */
    public void setEdu(Perfil_apoyo edu) {
        this.edu = edu;
    }

    /**
     * @return the cg
     */
    public Perfil_apoyo getCg() {
        return cg;
    }

    /**
     * @param cg the cg to set
     */
    public void setCg(Perfil_apoyo cg) {
        this.cg = cg;
    }

    /**
     * @return the cs
     */
    public Perfil_apoyo getCs() {
        return cs;
    }

    /**
     * @param cs the cs to set
     */
    public void setCs(Perfil_apoyo cs) {
        this.cs = cs;
    }

    /**
     * @return the sc
     */
    public Perfil_apoyo getSc() {
        return sc;
    }

    /**
     * @param sc the sc to set
     */
    public void setSc(Perfil_apoyo sc) {
        this.sc = sc;
    }
}
