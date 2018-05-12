package controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import clases.Evento;
import clases.Seccion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author anton
 */
@SessionScoped
@Named(value ="Eventos")
public class Control_Eventos implements Serializable{

    private List<Evento> eventosj;
    private List<Evento> eventosj2;
    private String event;
    private Long idcrear;
    private Date fechacrear;
    private String titulocrear;
    private String localizacioncrear;
    private String descripcioncrear;
    private String preciocrear;
    private String seccioncrear;

    public Evento buscarEvento(Long id) throws EventoException{
        Evento enc=null;
        for(Evento e : eventosj){
            if(e.getId().equals(id)){
                enc=e;
            }
        }
        if(enc==null){
            throw new EventoException("Evento no encontrado");
        }
        return enc;
    }
    
    public String borrarEvento(Long id) throws EventoException{
        Evento b=buscarEvento(id);
        eventosj.remove(b);
        eventosj2.remove(b);
        return "Lista_eventos.xhtml";
    }
    
    
    
    public String CrearEvento(){
        
        if(eventosj.isEmpty() || eventosj==null){
            Random rd = new Random();
            idcrear=(long)rd.nextInt(2000);
        } else {
            idcrear=eventosj.get(eventosj.size()-1).getId()+1L;
        }
        Seccion sec=null;
        int precio=Integer.parseInt(preciocrear);
        
        switch (seccioncrear) {
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
        
        
        Evento ev = new Evento(idcrear, titulocrear, fechacrear, localizacioncrear, descripcioncrear, precio, sec);
        
        eventosj.add(ev);
        eventosj2.add(ev);
        
        fechacrear=null;
        idcrear=null;
        titulocrear=null;
        localizacioncrear=null;
        descripcioncrear=null;
        preciocrear=null;
        seccioncrear=null;
        
        
        return "Lista_eventos.xhtml";
    }
    
    public String cancelarcrear(){
        fechacrear=null;
        idcrear=null;
        titulocrear=null;
        localizacioncrear=null;
        descripcioncrear=null;
        preciocrear=null;
        seccioncrear=null;
        
        return "Lista_eventos.xhtml";
    }
    
    /**
     * @return the eventosj
     */
    public List<Evento> getEventosj() {
        return eventosj;
    }

    /**
     * @param eventosj the eventosj to set
     */
    public void setEventosj(List<Evento> eventosj) {
        this.eventosj = eventosj;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
    
   /* public String VerFecha(Evento event){
        Date fecha = event.getFecha();
        try(Scanner sc = new Scanner(fecha.toString())){
            
        }
    }*/

    public Evento verEvento(){
        int ID = Integer.decode(event);
        int i=0;
        while(i<eventosj.size()&&eventosj.get(i).getId()!=ID)i++;
        return eventosj.get(i);
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
    public String getPreciocrear() {
        return preciocrear;
    }

    /**
     * @param preciocrear the preciocrear to set
     */
    public void setPreciocrear(String preciocrear) {
        this.preciocrear = preciocrear;
    }

    /**
     * @return the seccioncrear
     */
    public String getSeccioncrear() {
        return seccioncrear;
    }

    /**
     * @param seccioncrear the seccioncrear to set
     */
    public void setSeccioncrear(String seccioncrear) {
        this.seccioncrear = seccioncrear;
    }

    /**
     * @return the eventosj2
     */
    public List<Evento> getEventosj2() {
        return eventosj2;
    }

    /**
     * @param eventosj2 the eventosj2 to set
     */
    public void setEventosj2(List<Evento> eventosj2) {
        this.eventosj2 = eventosj2;
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

}
