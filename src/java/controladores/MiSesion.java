/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Evento;
import clases.Perfil;
import clases.Seccion;
import clases.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/*
Tipos de id que tiene cada sección:
TODAS -> 0L
CASTORES -> 1L
LOBATOS -> 2L
ROVERS COMPAÑEROS -> 3L
TROPA SCOUT -> 4L
ESCULTAS PIONEROS -> 5L
 */
/**
 *
 * @author DavidDR
 */
@Named(value = "miSesion")
@SessionScoped
public class MiSesion implements Serializable {

    private Usuario user;
    private List<Usuario> users;
    private List<Usuario> users2;
    private Usuario otro;
    private Usuario auxiliar;
    private String seccionmod;

    @Inject
    private Controlador_Login ctr;
    
    @Inject
    private Control_Eventos ctre;

    /**
     * Creates a new instance of MiSesion
     */
    public MiSesion() {
    }

    public String logout() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        user = null;
        return "login.xhtml";
    }

    public Usuario buscarUsuario(Long id) throws UsuarioException {

        Usuario aux = null;

        Iterator<Usuario> iter = users.iterator();
        while (iter.hasNext() && aux == null) {
            Usuario it = iter.next();
            if (it.getId().equals(id)) {
                aux = it;
            }
        }

        if (aux == null) {
            throw new UsuarioException("Usuarios no existente");
        }

        return aux;
    }

    public String modificarboton() {

/*        Iterator<Usuario> iter = users.iterator();
        u = iter.next();
        while (iter.hasNext() && u.getId() == id) {
            u = iter.next();
        }
*/
        setOtro(new Usuario(auxiliar.getId(), auxiliar.getContrasenia(), auxiliar.getNIF(), auxiliar.getEmail(), auxiliar.getNombre(), auxiliar.getApellidos(), auxiliar.getSexo(), auxiliar.getFecha_nacimiento(), auxiliar.getCodigo_postal(), auxiliar.getDireccion(), auxiliar.getProvincia(), auxiliar.getLocalidad(), auxiliar.getFecha_ingreso(), auxiliar.getCuota_total(), auxiliar.getTelefono(), auxiliar.getMovil(), auxiliar.getMetodo_pago(), auxiliar.getPerfiles(), auxiliar.getSeccion()));

        return "ModPerf.xhtml";
    }

    public String aceptarmod() {

        Seccion sec;

        switch (getSeccionmod()) {
            case "Castores":
                sec = new Seccion(1L, Seccion.Secciones.Castores);
                break;
            case "Lobatos":
                sec = new Seccion(2L, Seccion.Secciones.Lobatos);
                break;
            case "Scouts":
                sec = new Seccion(4L, Seccion.Secciones.Tropa_Scout);
                break;
            case "Escultas":
                sec = new Seccion(5L, Seccion.Secciones.Escultas_Pioneros);
                break;
            case "Rovers":
                sec = new Seccion(3L, Seccion.Secciones.Rovers_Compañeros);
                break;
            default:
                sec = otro.getSeccion();
                break;
        }

        otro.setSeccion(sec);

        int i = 0;
        while (i < users.size() && !Objects.equals(otro.getId(), users.get(i).getId())) {
            i++;
        }

        Usuario u = users.get(i);
        u.setNombre(otro.getNombre());
        u.setApellidos(otro.getApellidos());
        u.setNIF(otro.getNIF());
        u.setSexo(otro.getSexo());
        u.setEmail(otro.getEmail());
        u.setFecha_nacimiento(otro.getFecha_nacimiento());
        u.setCodigo_postal(otro.getCodigo_postal());
        u.setDireccion(otro.getDireccion());
        u.setProvincia(otro.getProvincia());
        u.setLocalidad(otro.getLocalidad());
        u.setFecha_ingreso(otro.getFecha_ingreso());
        u.setCuota_total(otro.getCuota_total());
        u.setTelefono(otro.getTelefono());
        u.setMovil(otro.getMovil());
        u.setMetodo_pago(otro.getMetodo_pago());
        u.setSeccion(otro.getSeccion());

        ctr.setUsers(users);

        return "Lista_Usuarios.xhtml";
    }

    public String borrarUsuario(Long id) throws UsuarioException {

        Usuario b = buscarUsuario(id);

        users.remove(b);
        users2.remove(b);

        return "Lista_Usuarios.xhtml";
    }

    /**
     * @return the users
     */
    public List<Usuario> getUsers() {
        return users;
    }

    public String verUsuario(Long id) {

        Iterator<Usuario> iter = users.iterator();
        Usuario u = iter.next();
        while (iter.hasNext() && !Objects.equals(id, u.getId())) {
            u = iter.next();
        }
        if (Objects.equals(id, u.getId())) {
            setAuxiliar(u);
        }

        return "OtroPerfil.xhtml";
    }
    
    public String inscribirse(Evento e) throws EventoException{
        user.getEventos().add(e);
        
        return "Eventos.xhtml";
        
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<Usuario> users) {
        this.users = users;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public boolean isCoordGen() {
        return this.user.getPerfiles().getRol().equals(Perfil.Rol.COORDGEN);
    }

    public boolean isCordSec() {
        return this.user.getPerfiles().getRol().equals(Perfil.Rol.COORDSEC);
    }

    public boolean isScouter() {
        return this.user.getPerfiles().getRol().equals(Perfil.Rol.SCOUTER);
    }

    public boolean isEducando() {
        return this.user.getPerfiles().getRol().equals(Perfil.Rol.EDUCANDO);
    }

    public String getSeccion() {
        String salida = "";
        switch (user.getSeccion().getNombre()) {
            case Castores:
                salida = "Castores";
                break;
            case Escultas_Pioneros:
                salida = "Escultas";
                break;
            case Lobatos:
                salida = "Lobatos";
                break;
            case Rovers_Compañeros:
                salida = "Rovers";
                break;
            case Tropa_Scout:
                salida = "Scouts";
                break;
            default:
                break;
        }

        return salida;
    }

    /**
     * @return the users2
     */
    public List<Usuario> getUsers2() {
        return users2;
    }

    /**
     * @param users2 the users2 to set
     */
    public void setUsers2(List<Usuario> users2) {
        this.users2 = users2;
    }

    /**
     * @return the otro
     */
    public Usuario getOtro() {
        return otro;
    }

    /**
     * @param otro the otro to set
     */
    public void setOtro(Usuario otro) {
        this.otro = otro;
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
     * @return the ctr
     */
    public Controlador_Login getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(Controlador_Login ctr) {
        this.ctr = ctr;
    }

    /**
     * @return the auxiliar
     */
    public Usuario getAuxiliar() {
        return auxiliar;
    }

    /**
     * @param auxiliar the auxiliar to set
     */
    public void setAuxiliar(Usuario auxiliar) {
        this.auxiliar = auxiliar;
    }

}
