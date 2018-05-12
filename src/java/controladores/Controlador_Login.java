/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Evento;
import clases.Perfil;
import clases.Seccion;
import clases.Seccion.Secciones;
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

    private Usuario usermod;
    private String seccionmod;

    @Inject
    private MiSesion ctrl;

    @Inject
    private Control_Eventos ctrle;

    public Controlador_Login() {
        users = new ArrayList<>();
        users.add(new Usuario(121L, "1234", "78556410V", "paco_mg99@hotmail.com", "Francisco", "Marin Garzón", "Hombre", new Date(1997 - 1900, 3, 2), 29610, "C/Luisa Ordoñez n15 1ºB", "Málaga", "Málaga", new Date(2015 - 1900, 3, 2), 50, 921121314, 654121314, "Tarjeta_Crédito", new Perfil(Perfil.Rol.EDUCANDO), new Seccion(1L, Seccion.Secciones.Castores)));
        users.add(new Usuario(122L, "1234", "71156411N", "paula_vp@hotmail.com", "Paula", "Vergara Perez", "Mujer", new Date(1997 - 1900, 11, 6), 29615, "C/Santa Rosa n17 5ºC", "Málaga", "Málaga", new Date(2015 - 1900, 10, 11), 75, 921675432, 654960584, "Tarjeta_Crédito", new Perfil(Perfil.Rol.COORDGEN), new Seccion(0L, Seccion.Secciones.TODAS)));
        users.add(new Usuario(123L, "1234", "22551122H", "pepe_ss@gmail.com", "José", "Salas Segura", "Hombre", new Date(1997 - 1900, 11, 6), 29700, "C/Agustina n22 2ºI", "Málaga", "Málaga", new Date(2015 - 1900, 4, 1), 80, 950221436, 651203344, "Efectivo", new Perfil(Perfil.Rol.SCOUTER), new Seccion(1L, Seccion.Secciones.Castores)));
        users.add(new Usuario(124L, "1234", "12345678A", "anam_gg@gmail.com", "Ana María", "González Gómez", "Mujer", new Date(1997 - 1900, 22, 4), 29720, "C/Manuela Carmona n1 1ºF", "Málaga", "Málaga", new Date(2015 - 1900, 2, 1), 65, 953646811, 621300044, "Efectivo", new Perfil(Perfil.Rol.COORDSEC), new Seccion(2L, Seccion.Secciones.Lobatos)));
        events = new ArrayList<>();
        events.add(new Evento(1L, "Viaje al monte", new Date(2018 - 1900, 3, 24), "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20, new Seccion(1L, Secciones.Castores)));
        events.add(new Evento(2L, "Viaje al monte 2", new Date(2018 - 1900, 6, 24, 9, 30), "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20, new Seccion(2L, Secciones.Lobatos)));
        events.add(new Evento(3L, "Salvemos a las ardillas", new Date(2019 - 1900, 9, 27, 11, 0), "EEUU", "Viaje a EEUU para salvar a las ardillas", 1200, new Seccion(3L, Secciones.Rovers_Compañeros)));

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
        ctrl.setUsers(users);
        ctrl.setUser(aux);

        List<Usuario> auxs = new ArrayList<>();
        if (aux.getPerfiles().getRol().equals(Perfil.Rol.COORDSEC) || aux.getPerfiles().getRol().equals(Perfil.Rol.SCOUTER)) {
            for (Usuario u : users) {
                if (!u.equals(aux) && u.getSeccion().equals(aux.getSeccion())) {
                    auxs.add(u);
                }
            }
        } else {
            for (Usuario u : users) {
                if (!u.equals(aux)) {
                    auxs.add(u);
                }
            }
        }
        ctrl.setUsers2(auxs);

        ctrle.setEventosj(events);
        List<Evento> events2 = new ArrayList<>();
        if (aux.getPerfiles().getRol().equals(Perfil.Rol.COORDGEN)) {
            for (Evento e : events) {
                events2.add(e);
            }
        } else {
            for (Evento e : events) {
                if (aux.getSeccion().equals(e.getSeccion())) {
                    events2.add(e);
                }
            }
        }
        
        ctrle.setEventosj2(events2);

        return "Inicio.xhtml";
    }

    public Usuario verUsuario() {
        int ID = Integer.decode(otro);
        int i = 0;
        while (i < users.size() && users.get(i).getId() != ID) {
            i++;
        }
        
        usermod=users.get(i);
        return users.get(i);
    }
    
    public String aceptarCambios(){
        
        boolean enc=false;
        int i=0;
        Seccion sec=null;
        
        while(!enc && i<users.size()){
            if(users.get(i).getId().equals(usermod.getId())){
                enc=true;
            }
            i++;
        }
        
        switch (seccionmod) {
            case "Castores":
                sec= new Seccion(1L, Seccion.Secciones.Castores);
                break;
            case "Lobatos":
                sec= new Seccion(2L, Seccion.Secciones.Lobatos);
                break;
            case "Scouts":
                sec= new Seccion(4L, Seccion.Secciones.Tropa_Scout);
                break;
            case "Escultas":
                sec= new Seccion(5L, Seccion.Secciones.Escultas_Pioneros);
                break;
            case "Rovers":
                sec= new Seccion(3L, Seccion.Secciones.Rovers_Compañeros);
                break;
            default:
                break;
        }
        
        usermod.setSeccion(sec);
        
        users.get(i-1).setApellidos(usermod.getApellidos());
        users.get(i-1).setCodigo_postal(usermod.getCodigo_postal());
        users.get(i-1).setContrasenia(usermod.getContrasenia());
        users.get(i-1).setCuota_total(usermod.getCuota_total());
        users.get(i-1).setDireccion(usermod.getDireccion());
        users.get(i-1).setEmail(usermod.getEmail());
        users.get(i-1).setFecha_baja(usermod.getFecha_baja());
        users.get(i-1).setFecha_ingreso(usermod.getFecha_ingreso());
        users.get(i-1).setFecha_nacimiento(usermod.getFecha_nacimiento());
        users.get(i-1).setLocalidad(usermod.getLocalidad());
        users.get(i-1).setMetodo_pago(usermod.getMetodo_pago());
        users.get(i-1).setMovil(usermod.getMovil());
        users.get(i-1).setNIF(usermod.getNIF());
        users.get(i-1).setNombre(usermod.getNombre());
        users.get(i-1).setProvincia(usermod.getProvincia());
        users.get(i-1).setSeccion(usermod.getSeccion());
        users.get(i-1).setSexo(usermod.getSexo());
        users.get(i-1).setTelefono(usermod.getTelefono());
        
        
        return "Lista_Usuarios.xhtml";
    }
    
    public String rechazarCambios(){
        usermod=null;
        return "Lista_Usuarios.xhtml";
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
     * @return the usermod
     */
    public Usuario getUsermod() {
        return usermod;
    }

    /**
     * @param usermod the usermod to set
     */
    public void setUsermod(Usuario usermod) {
        this.usermod = usermod;
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
     * @return the seccionmod
     */
    public String getSeccionmod() {
        return seccionmod;
    }

    /**
     * @param seccionmod the seccionmod to set
     */
    public void setSeccionmod(String seccionmod) {
        this.seccionmod = seccionmod;
    }
}
