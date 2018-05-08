/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

/**
 *
 * @author anton
 */
@ManagedBean(name="Eventos")
@ViewScoped
public class Eventos{

    private List<Evento> eventosj;
    
    @PostConstruct
    public void init() {
        eventosj = new ArrayList<>();
        eventosj.add(new Evento(1, "Viaje al monte", "24/03/2018", "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        eventosj.add(new Evento(2, "Viaje al monte 2", "24/06/2018", "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        eventosj.add(new Evento(3, "Salvemos a las ardillas", "27/09/2019", "EEUU", "Viaje a EEUU para salvar a las ardillas", 1200));
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
