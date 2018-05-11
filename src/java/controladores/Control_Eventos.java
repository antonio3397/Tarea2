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
    private String event;
    private String añocrear;
    private String mescrear;
    private String diacrear;
    private Long idcrear;
    private String titulocrear;
    private String localizacioncrear;
    private String descripcioncrear;
    private String preciocrear;
    private String seccioncrear;
    
   /* 
    @PostConstruct
    public void init() {
        
        eventosj = new ArrayList<>();
        eventosj.add(new Evento(1L, "Viaje al monte", new Date(2018-1900,3,24,9, 30),"Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        eventosj.add(new Evento(2L, "Viaje al monte 2", new Date(2018-1900,6,24,9,30), "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        eventosj.add(new Evento(3L, "Salvemos a las ardillas", new Date(2019-1900,9,27,11,0), "EEUU", "Viaje a EEUU para salvar a las ardillas", 1200));
    }*/

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
        return "Lista_eventos.xhtml";
    }
    
    
    
    public String CrearEvento(){
        
        idcrear=eventosj.get(eventosj.size()-1).getId()+1L;
        Seccion sec=null;
        int año=Integer.parseInt(añocrear);
        int mes=Integer.parseInt(mescrear);
        int dia=Integer.parseInt(diacrear);
        int precio=Integer.parseInt(preciocrear);
        
        Date fechacrear=new Date(año-1900, mes-1, dia);
        
        switch (seccioncrear) {
            case "Castores":
                sec= new Seccion(Seccion.Secciones.Castores);
                break;
            case "Lobatos":
                sec= new Seccion(Seccion.Secciones.Lobatos);
                break;
            case "Scouts":
                sec= new Seccion(Seccion.Secciones.Tropa_Scout);
                break;
            case "Escultas":
                sec= new Seccion(Seccion.Secciones.Escultas_Pioneros);
                break;
            case "Rovers":
                sec= new Seccion(Seccion.Secciones.Rovers_Compañeros);
                break;
            default:
                break;
        }
        
        
        Evento ev = new Evento(idcrear, titulocrear, fechacrear, localizacioncrear, descripcioncrear, precio, sec);
        
        eventosj.add(ev);
        
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
     * @return the añocrear
     */
    public String getAñocrear() {
        return añocrear;
    }

    /**
     * @param añocrear the añocrear to set
     */
    public void setAñocrear(String añocrear) {
        this.añocrear = añocrear;
    }

    /**
     * @return the mescrear
     */
    public String getMescrear() {
        return mescrear;
    }

    /**
     * @param mescrear the mescrear to set
     */
    public void setMescrear(String mescrear) {
        this.mescrear = mescrear;
    }

    /**
     * @return the diacrear
     */
    public String getDiacrear() {
        return diacrear;
    }

    /**
     * @param diacrear the diacrear to set
     */
    public void setDiacrear(String diacrear) {
        this.diacrear = diacrear;
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
}
