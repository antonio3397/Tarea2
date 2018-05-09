package controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import clases.Evento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author anton
 */
@ManagedBean(name="Eventos")
@ViewScoped
public class Control_Eventos implements Serializable{

    private List<Evento> eventosj;
    
    @PostConstruct
    public void init() {
        
        eventosj = new ArrayList<>();
        eventosj.add(new Evento(1L, "Viaje al monte", new Date(2018-1900,3,24), "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        eventosj.add(new Evento(2L, "Viaje al monte 2", new Date(2018-1900,6,24), "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        eventosj.add(new Evento(3L, "Salvemos a las ardillas", new Date(2019-1900,9,27), "EEUU", "Viaje a EEUU para salvar a las ardillas", 1200));
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

}
