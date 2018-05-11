/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Evento;
import clases.Perfil;
import clases.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author DavidDR
 */
@Named(value = "controlador_Login")
@RequestScoped
public class Controlador_Login implements Serializable {

    private String password;
    private String email;
    private List<Usuario> users;
    private List<Evento> events;
    private String otro;

    private Usuario user;
    
    private Evento eventcrear;
    
    private int añocrear;
    private int mescrear;
    private int diacrear;
    private Long idcrear;
    private String titulocrear;
    private Date fechacrear;
    private String localizacioncrear;
    private String descripcioncrear;
    private Integer preciocrear;

    @Inject
    private MiSesion ctrl;

    @Inject
    private Control_Eventos ctrle;

    public Controlador_Login() {
        users = new ArrayList<>();
        users.add(new Usuario(121L, "123456", "78556410V", "paco_mg99@hotmail.com", "Francisco", "Marin Garzón", "Hombre", new Date(1997 - 1900, 3, 2), 29610, "C/Luisa Ordoñez n15 1ºB", "Málaga", "Málaga", new Date(2015 - 1900, 3, 2), 50, 921121314, 654121314, "Tarjeta_Crédito", new Perfil(Perfil.Rol.EDUCANDO)));
        users.add(new Usuario(122L, "234567", "71156411N", "paula_vp@hotmail.com", "Paula", "Vergara Perez", "Mujer", new Date(1997 - 1900, 11, 6), 29615, "C/Santa Rosa n17 5ºC", "Málaga", "Málaga", new Date(2015 - 1900, 10, 11), 75, 921675432, 654960584, "Tarjeta_Crédito", new Perfil(Perfil.Rol.COORDGEN)));
        events = new ArrayList<>();
        events.add(new Evento(1L, "Viaje al monte", new Date(2018 - 1900, 3, 24), "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        events.add(new Evento(2L, "Viaje al monte 2", new Date(2018 - 1900, 6, 24, 9, 30), "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        events.add(new Evento(3L, "Salvemos a las ardillas", new Date(2019 - 1900, 9, 27, 11, 0), "EEUU", "Viaje a EEUU para salvar a las ardillas", 1200));

        List<Evento> eventsaux = new ArrayList<>();
        eventsaux.add(events.get(0));
        users.get(0).setEventos(eventsaux);
    }

    public String autenticar() {

        Iterator<Usuario> iter = users.iterator();

        boolean pV = false, exist = false;
        Usuario aux = null;

        while (iter.hasNext() && !exist) {
            aux = iter.next();

            if (aux.getEmail().equals(getEmail())) {
                exist = true;
                if (aux.getContrasenia().equals(getPassword())) {
                    pV = true;
                }
            }
        }

        if (!exist) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email no registrado", "Email no registrado"));
            return null;
        }
        if (!pV) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password incorrecto", "Password incorrecto"));
            return null;
        }

        List<Evento> listaEvents;
        listaEvents = new ArrayList<>();
        listaEvents = events;

        ctrl.setUsers(users);
        ctrl.setUser(aux);
        ctrle.setEventosj(listaEvents);
        return "Inicio.xhtml";
    }

    public Usuario verUsuario() {
        int ID = Integer.decode(otro);
        int i = 0;
        while (i < users.size() && users.get(i).getId() != ID) {
            i++;
        }
        return users.get(i);
    }
    
    public void CrearEvento(){
        
        idcrear=events.get(events.size()-1).getId()+1L;
        
        Evento ev = new Evento(idcrear, titulocrear, fechacrear, localizacioncrear, descripcioncrear, preciocrear);
        
        
        
        events.add(ev);
        ctrle.setEventosj(events);
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the users
     */
    public List<Usuario> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<Usuario> users) {
        this.users = users;
    }

    /**
     * @return the otro
     */
    public String getOtro() {
        return otro;
    }

    /**
     * @param otro the otro to set
     */
    public void setOtro(String otro) {
        this.otro = otro;
    }

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * @return the ctrl
     */
    public MiSesion getCtrl() {
        return ctrl;
    }

    /**
     * @param ctrl the ctrl to set
     */
    public void setCtrl(MiSesion ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * @return the events
     */
    public List<Evento> getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(List<Evento> events) {
        this.events = events;
    }

    /**
     * @return the eventcrear
     */
    public Evento getEventcrear() {
        return eventcrear;
    }

    /**
     * @param eventcrear the eventcrear to set
     */
    public void setEventcrear(Evento eventcrear) {
        this.eventcrear = eventcrear;
    }

    /**
     * @return the idcrear
     */
    public Long getIdcrear() {
        return idcrear;
    }

    /**
     * @param idcrear the idcrear to set
     */
    public void setIdcrear(Long idcrear) {
        this.idcrear = idcrear;
    }

    /**
     * @return the titulocrear
     */
    public String getTitulocrear() {
        return titulocrear;
    }

    /**
     * @param titulocrear the titulocrear to set
     */
    public void setTitulocrear(String titulocrear) {
        this.titulocrear = titulocrear;
    }

    /**
     * @return the fechacrear
     */
    public Date getFechacrear() {
        return fechacrear;
    }

    /**
     * @param fechacrear the fechacrear to set
     */
    public void setFechacrear(Date fechacrear) {
        this.fechacrear = fechacrear;
    }

    /**
     * @return the localizacioncrear
     */
    public String getLocalizacioncrear() {
        return localizacioncrear;
    }

    /**
     * @param localizacioncrear the localizacioncrear to set
     */
    public void setLocalizacioncrear(String localizacioncrear) {
        this.localizacioncrear = localizacioncrear;
    }

    /**
     * @return the descripcioncrear
     */
    public String getDescripcioncrear() {
        return descripcioncrear;
    }

    /**
     * @param descripcioncrear the descripcioncrear to set
     */
    public void setDescripcioncrear(String descripcioncrear) {
        this.descripcioncrear = descripcioncrear;
    }

    /**
     * @return the preciocrear
     */
    public Integer getPreciocrear() {
        return preciocrear;
    }

    /**
     * @param preciocrear the preciocrear to set
     */
    public void setPreciocrear(Integer preciocrear) {
        this.preciocrear = preciocrear;
    }

    /**
     * @return the ctrle
     */
    public Control_Eventos getCtrle() {
        return ctrle;
    }

    /**
     * @param ctrle the ctrle to set
     */
    public void setCtrle(Control_Eventos ctrle) {
        this.ctrle = ctrle;
    }

    /**
     * @return the añocrear
     */
    public int getAñocrear() {
        return añocrear;
    }

    /**
     * @param añocrear the añocrear to set
     */
    public void setAñocrear(int añocrear) {
        this.añocrear = añocrear;
    }

    /**
     * @return the mescrear
     */
    public int getMescrear() {
        return mescrear;
    }

    /**
     * @param mescrear the mescrear to set
     */
    public void setMescrear(int mescrear) {
        this.mescrear = mescrear;
    }

    /**
     * @return the diacrear
     */
    public int getDiacrear() {
        return diacrear;
    }

    /**
     * @param diacrear the diacrear to set
     */
    public void setDiacrear(int diacrear) {
        this.diacrear = diacrear;
    }

}
