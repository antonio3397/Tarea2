/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases_apoyo.Evento_apoyo;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author anton
 */
@Named(value = "control_Eventos")
@Dependent
public class Control_Eventos {

    private Evento_apoyo event;
    
    public String verEvento(){
        return event.getID()+"";
    }

    /**
     * @return the event
     */
    public Evento_apoyo getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Evento_apoyo event) {
        this.event = event;
    }
    
}
