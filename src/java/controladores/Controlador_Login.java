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
    
    private String nombremod;
    private String apellidosmod;
    private String nifmod;
    private String sexomod;
    private String emailmod;
    private Date nacimientomod;
    private int codigopostalmod;
    private String direcmod;
    private String provmod;
    private String localmod;
    private Date ingresomod;
    private int cuotamod;
    private int telefonomod;
    private int movilmod;
    private String metodopagomod;
    private String seccionmod;
    private Usuario usermod;

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

        users.get(0).getEventos().add(events.get(0));
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
        
        return users.get(i);
    }
    
    public String modificarboton(Usuario u){
        usermod=u;
        nombremod=u.getNombre();
        apellidosmod=u.getApellidos();
        nifmod=u.getNIF();
        sexomod=u.getSexo();
        emailmod=u.getEmail();
        nacimientomod=u.getFecha_nacimiento();
        codigopostalmod=u.getCodigo_postal();
        direcmod=u.getDireccion();
        provmod=u.getProvincia();
        localmod=u.getLocalidad();
        ingresomod=u.getFecha_ingreso();
        cuotamod=u.getCuota_total();
        telefonomod=u.getTelefono();
        movilmod=u.getMovil();
        metodopagomod=u.getMetodo_pago();
        
        return "ModPerf.xhtml";
    }
    
    public String aceptarmod(){
        
        Seccion sec;
        
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
                sec= usermod.getSeccion();
                break;
        }
        
        int i=0;
        boolean enc=false;
        while(i<users.size() && !enc){
            if(users.get(i).getId().equals(usermod.getId())){
                enc=true;
            }
            i++;
        }
        users.get(i-1).setNombre(nombremod);
        users.get(i-1).setApellidos(apellidosmod);
        users.get(i-1).setNIF(nifmod);
        users.get(i-1).setSexo(sexomod);
        users.get(i-1).setEmail(emailmod);
        users.get(i-1).setFecha_nacimiento(nacimientomod);
        users.get(i-1).setCodigo_postal(codigopostalmod);
        users.get(i-1).setDireccion(direcmod);
        users.get(i-1).setProvincia(provmod);
        users.get(i-1).setLocalidad(localmod);
        users.get(i-1).setFecha_ingreso(ingresomod);
        users.get(i-1).setCuota_total(cuotamod);
        users.get(i-1).setTelefono(telefonomod);
        users.get(i-1).setMovil(movilmod);
        users.get(i-1).setMetodo_pago(metodopagomod);
        users.get(i-1).setSeccion(sec);
        
        return "Lista_Usuarios.xhtml";
    }
    
    public String cancelarmod(){
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

    /**
     * @return the nombremod
     */
    public String getNombremod() {
        return nombremod;
    }

    /**
     * @param nombremod the nombremod to set
     */
    public void setNombremod(String nombremod) {
        this.nombremod = nombremod;
    }

    /**
     * @return the apellidosmod
     */
    public String getApellidosmod() {
        return apellidosmod;
    }

    /**
     * @param apellidosmod the apellidosmod to set
     */
    public void setApellidosmod(String apellidosmod) {
        this.apellidosmod = apellidosmod;
    }

    /**
     * @return the nifmod
     */
    public String getNifmod() {
        return nifmod;
    }

    /**
     * @param nifmod the nifmod to set
     */
    public void setNifmod(String nifmod) {
        this.nifmod = nifmod;
    }

    /**
     * @return the sexomod
     */
    public String getSexomod() {
        return sexomod;
    }

    /**
     * @param sexomod the sexomod to set
     */
    public void setSexomod(String sexomod) {
        this.sexomod = sexomod;
    }

    /**
     * @return the emailmod
     */
    public String getEmailmod() {
        return emailmod;
    }

    /**
     * @param emailmod the emailmod to set
     */
    public void setEmailmod(String emailmod) {
        this.emailmod = emailmod;
    }

    /**
     * @return the nacimientomod
     */
    public Date getNacimientomod() {
        return nacimientomod;
    }

    /**
     * @param nacimientomod the nacimientomod to set
     */
    public void setNacimientomod(Date nacimientomod) {
        this.nacimientomod = nacimientomod;
    }

    /**
     * @return the codigopostalmod
     */
    public int getCodigopostalmod() {
        return codigopostalmod;
    }

    /**
     * @param codigopostalmod the codigopostalmod to set
     */
    public void setCodigopostalmod(int codigopostalmod) {
        this.codigopostalmod = codigopostalmod;
    }

    /**
     * @return the direcmod
     */
    public String getDirecmod() {
        return direcmod;
    }

    /**
     * @param direcmod the direcmod to set
     */
    public void setDirecmod(String direcmod) {
        this.direcmod = direcmod;
    }

    /**
     * @return the provmod
     */
    public String getProvmod() {
        return provmod;
    }

    /**
     * @param provmod the provmod to set
     */
    public void setProvmod(String provmod) {
        this.provmod = provmod;
    }

    /**
     * @return the localmod
     */
    public String getLocalmod() {
        return localmod;
    }

    /**
     * @param localmod the localmod to set
     */
    public void setLocalmod(String localmod) {
        this.localmod = localmod;
    }

    /**
     * @return the ingresomod
     */
    public Date getIngresomod() {
        return ingresomod;
    }

    /**
     * @param ingresomod the ingresomod to set
     */
    public void setIngresomod(Date ingresomod) {
        this.ingresomod = ingresomod;
    }

    /**
     * @return the cuotamod
     */
    public int getCuotamod() {
        return cuotamod;
    }

    /**
     * @param cuotamod the cuotamod to set
     */
    public void setCuotamod(int cuotamod) {
        this.cuotamod = cuotamod;
    }

    /**
     * @return the telefonomod
     */
    public int getTelefonomod() {
        return telefonomod;
    }

    /**
     * @param telefonomod the telefonomod to set
     */
    public void setTelefonomod(int telefonomod) {
        this.telefonomod = telefonomod;
    }

    /**
     * @return the movilmod
     */
    public int getMovilmod() {
        return movilmod;
    }

    /**
     * @param movilmod the movilmod to set
     */
    public void setMovilmod(int movilmod) {
        this.movilmod = movilmod;
    }

    /**
     * @return the metodopagomod
     */
    public String getMetodopagomod() {
        return metodopagomod;
    }

    /**
     * @param metodopagomod the metodopagomod to set
     */
    public void setMetodopagomod(String metodopagomod) {
        this.metodopagomod = metodopagomod;
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
}
