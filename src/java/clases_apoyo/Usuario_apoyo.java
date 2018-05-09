/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_apoyo;

import java.util.List;

/**
 *
 * @author migue
 */
public class Usuario_apoyo {
    
    private Integer id;
    private String contrasenia;
    private String NIF;
    private String email;
    private String nombre;
    private String apellidos;
    private String sexo;
    private String fecha_nacimiento;
    private Integer codigo_postal;
    private String direccion;
    private String provincia;
    private String Localidad;
    private String fecha_ingreso;
    private String fecha_baja;
    private Integer cuota_total;
    private Integer telefono;
    private Integer movil;
    private String metodo_pago;
    private List<Documento_apoyo> documentos;
    private List<Comentario_apoyo> comentarios;
    private Perfil_apoyo perfiles;
    private List<Pago_cuota_apoyo> pago;
    private Seccion_apoyo seccion;
    private List<Evento_apoyo> eventos;
    private List<Notificacion_apoyo> notificaciones;
    private List<Evento_apoyo> inscripciones;
    private Responsable_Legal_apoyo responsable;
    
    public Usuario_apoyo(Integer id, String contrasenia, String NIF, String email,
           String nombre, String apellidos, String sexo, String fecha_nacimiento, 
           Integer codigo_postal, String direccion, String provincia, 
           String Localidad, String fecha_ingreso, String fecha_baja, 
           Integer cuota_total, Integer telefono, Integer movil, String metodo_pago, 
           List<Documento_apoyo> documentos, List<Comentario_apoyo> comentarios, 
           Perfil_apoyo perfiles, List<Pago_cuota_apoyo> pago, Seccion_apoyo seccion, 
           List<Evento_apoyo> eventos, List<Notificacion_apoyo> notificaciones, 
           List<Evento_apoyo> inscripciones, Responsable_Legal_apoyo responsable){
        this.id=id;
        this.contrasenia=contrasenia;
        this.Localidad=Localidad;
        this.NIF=NIF;
        this.apellidos=apellidos;
        this.codigo_postal=codigo_postal;
        this.comentarios=comentarios;
        this.cuota_total=cuota_total;
        this.direccion=direccion;
        this.documentos=documentos;
        this.email=email;
        this.eventos=eventos;
        this.fecha_baja=fecha_baja;
        this.fecha_ingreso=fecha_ingreso;
        this.fecha_nacimiento=fecha_nacimiento;
        this.inscripciones=inscripciones;
        this.metodo_pago=metodo_pago;
        this.movil=movil;
        this.nombre=nombre;
        this.notificaciones=notificaciones;
        this.pago=pago;
        this.perfiles=perfiles;
        this.provincia=provincia;
        this.responsable=responsable;
        this.responsable=responsable;
        this.seccion=seccion;
        this.sexo=sexo;
        this.telefono=telefono;
    }
    
public Usuario_apoyo(Integer id, String contrasenia, String NIF, String email,
           String nombre, String apellidos, String sexo, String fecha_nacimiento, 
           Integer codigo_postal, String direccion, String provincia, 
           String Localidad, String fecha_ingreso, String fecha_baja, 
           Integer cuota_total, Integer telefono, Integer movil, String metodo_pago, 
           Perfil_apoyo perfiles, Seccion_apoyo seccion){
        this.id=id;
        this.contrasenia=contrasenia;
        this.Localidad=Localidad;
        this.NIF=NIF;
        this.apellidos=apellidos;
        this.codigo_postal=codigo_postal;
        this.comentarios=comentarios;
        this.cuota_total=cuota_total;
        this.direccion=direccion;
        this.documentos=documentos;
        this.email=email;
        this.eventos=eventos;
        this.fecha_baja=fecha_baja;
        this.fecha_ingreso=fecha_ingreso;
        this.fecha_nacimiento=fecha_nacimiento;
        this.inscripciones=inscripciones;
        this.metodo_pago=metodo_pago;
        this.movil=movil;
        this.nombre=nombre;
        this.notificaciones=notificaciones;
        this.pago=pago;
        this.perfiles=perfiles;
        this.provincia=provincia;
        this.responsable=responsable;
        this.responsable=responsable;
        this.seccion=seccion;
        this.sexo=sexo;
        this.telefono=telefono;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * @param NIF the NIF to set
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
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
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the fecha_nacimiento
     */
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the codigo_postal
     */
    public Integer getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * @param codigo_postal the codigo_postal to set
     */
    public void setCodigo_postal(Integer codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the Localidad
     */
    public String getLocalidad() {
        return Localidad;
    }

    /**
     * @param Localidad the Localidad to set
     */
    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    /**
     * @return the fecha_ingreso
     */
    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * @param fecha_ingreso the fecha_ingreso to set
     */
    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * @return the fecha_baja
     */
    public String getFecha_baja() {
        return fecha_baja;
    }

    /**
     * @param fecha_baja the fecha_baja to set
     */
    public void setFecha_baja(String fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    /**
     * @return the cuota_total
     */
    public Integer getCuota_total() {
        return cuota_total;
    }

    /**
     * @param cuota_total the cuota_total to set
     */
    public void setCuota_total(Integer cuota_total) {
        this.cuota_total = cuota_total;
    }

    /**
     * @return the telefono
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the movil
     */
    public Integer getMovil() {
        return movil;
    }

    /**
     * @param movil the movil to set
     */
    public void setMovil(Integer movil) {
        this.movil = movil;
    }

    /**
     * @return the metodo_pago
     */
    public String getMetodo_pago() {
        return metodo_pago;
    }

    /**
     * @param metodo_pago the metodo_pago to set
     */
    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    /**
     * @return the documentos
     */
    public List<Documento_apoyo> getDocumentos() {
        return documentos;
    }

    /**
     * @param documentos the documentos to set
     */
    public void setDocumentos(List<Documento_apoyo> documentos) {
        this.documentos = documentos;
    }

    /**
     * @return the comentarios
     */
    public List<Comentario_apoyo> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(List<Comentario_apoyo> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the perfiles
     */
    public Perfil_apoyo getPerfiles() {
        return perfiles;
    }

    /**
     * @param perfiles the perfiles to set
     */
    public void setPerfiles(Perfil_apoyo perfiles) {
        this.perfiles = perfiles;
    }

    /**
     * @return the pago
     */
    public List<Pago_cuota_apoyo> getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(List<Pago_cuota_apoyo> pago) {
        this.pago = pago;
    }

    /**
     * @return the seccion
     */
    public Seccion_apoyo getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(Seccion_apoyo seccion) {
        this.seccion = seccion;
    }

    /**
     * @return the eventos
     */
    public List<Evento_apoyo> getEventos() {
        return eventos;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(List<Evento_apoyo> eventos) {
        this.eventos = eventos;
    }

    /**
     * @return the notificaciones
     */
    public List<Notificacion_apoyo> getNotificaciones() {
        return notificaciones;
    }

    /**
     * @param notificaciones the notificaciones to set
     */
    public void setNotificaciones(List<Notificacion_apoyo> notificaciones) {
        this.notificaciones = notificaciones;
    }

    /**
     * @return the inscripciones
     */
    public List<Evento_apoyo> getInscripciones() {
        return inscripciones;
    }

    /**
     * @param inscripciones the inscripciones to set
     */
    public void setInscripciones(List<Evento_apoyo> inscripciones) {
        this.inscripciones = inscripciones;
    }

    /**
     * @return the responsable
     */
    public Responsable_Legal_apoyo getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(Responsable_Legal_apoyo responsable) {
        this.responsable = responsable;
    }
    
    
}
