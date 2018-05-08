/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

/**
 *
 * @author anton
 */
@Named(value = "eventos")
@ManagedBean
@SessionScoped
public class Eventos{

    private List<Evento> eventosj;
    
    @PostConstruct
    public void init() {
        eventosj = new ArrayList<Evento>();
        getEventosj().add(new Evento(1, "Viaje al monte", "24/03/2018", "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        getEventosj().add(new Evento(2, "Viaje al monte 2", "24/06/2018", "Córdoba", "Viaje a córdoba a una de las sierras mas bonitas", 20));
        getEventosj().add(new Evento(3, "Salvemos a las ardillas", "27/09/2019", "EEUU", "Viaje a EEUU para salvar a las ardillas", 1200));
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
    
    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
         
    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
