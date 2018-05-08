/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_apoyo;

/**
 *
 * @author migue
 */
public class Usuario_apoyo {
   private int ID_usuario;
   private int contrasena;
   private String NIF;
   private String email;
   private String nombre;
   private String apellidos;
   private String sexo;
   private String fecha_nacimiento;
   private int cod_postal;
   private String direccion;
   private String localidad;
   private String fecha_ingreso;
   private String fecha_baja;
   private int telefono;
   private int movil;
   private String metodo_pago;
   private int cuota_total;
   private String rol;
   
   
  /*  private List<Documento> documentos;
    private List<Comentario> comentarios;
    private List<Pago_cuota> pago;
    private List<Evento_apoyo> eventos;
    
    private List<Notificacion> notificaciones;
    
    private List<Evento> inscripciones;
    
    private Responsable_Legal responsable;
   
   */
   
   
   public Usuario_apoyo(){
       
   }
   
   
   
   public Usuario_apoyo(int ID_usuario, int contrasena, String NIF, String rol, String email, String nombre, String apellidos, String sexo, String fecha_nacimiento, int cod_postal, String direccion, String localidad, String fecha_ingreso, String fecha_baja, int telefono, int movil, String metodo_pago, int cuota_total){
       
        this.ID_usuario=ID_usuario;
        this.contrasena=contrasena;
        this.NIF=NIF;
        this.rol=rol;
        this.email=email;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.sexo=sexo;
        this.fecha_nacimiento=fecha_nacimiento;
        this.cod_postal=cod_postal;
        this.direccion=direccion;
        this.localidad=localidad;
        this.fecha_ingreso=fecha_ingreso;
        this.fecha_baja=fecha_baja;
        this.telefono=telefono;
        this.movil=movil;
        this.metodo_pago=metodo_pago;
        this.cuota_total=cuota_total;
   }
   
   
   
   
    
   public Usuario_apoyo(int ID_usuario, int contrasena, String NIF,String rol, String email, String nombre, String apellidos, String sexo, String fecha_nacimiento, int cod_postal, String direccion, String localidad, String fecha_ingreso, int telefono, int movil, String metodo_pago, int cuota_total){
       
        this.ID_usuario=ID_usuario;
        this.contrasena=contrasena;
        this.NIF=NIF;
        this.rol=rol;
        this.email=email;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.sexo=sexo;
        this.fecha_nacimiento=fecha_nacimiento;
        this.cod_postal=cod_postal;
        this.direccion=direccion;
        this.localidad=localidad;
        this.fecha_ingreso=fecha_ingreso;
        this.telefono=telefono;
        this.movil=movil;
        this.metodo_pago=metodo_pago;
        this.cuota_total=cuota_total;
   }

    public int getID_usuario() {
        return ID_usuario;
    }

    public void setID_usuario(int ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(int cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(String fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public int getCuota_total() {
        return cuota_total;
    }

    public void setCuota_total(int cuota_total) {
        this.cuota_total = cuota_total;
    }        
}
