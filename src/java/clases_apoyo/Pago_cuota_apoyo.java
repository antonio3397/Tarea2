/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_apoyo;

/**
 *
 * @author anton
 */
public class Pago_cuota_apoyo {
    
    private Long id;
    private Integer cantidad_pagada;
    private String fecha_del_pago;
    private String Tipo_pago;
    private Usuario_apoyo usuarios;
    
    public Pago_cuota_apoyo(Long id, Integer cantidad_pagada, String fecha_del_pago, String Tipo_pago, Usuario_apoyo usuarios){
        this.id=id;
        this.cantidad_pagada=cantidad_pagada;
        this.fecha_del_pago=fecha_del_pago;
        this.Tipo_pago=Tipo_pago;
        this.usuarios=usuarios;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the cantidad_pagada
     */
    public Integer getCantidad_pagada() {
        return cantidad_pagada;
    }

    /**
     * @param cantidad_pagada the cantidad_pagada to set
     */
    public void setCantidad_pagada(Integer cantidad_pagada) {
        this.cantidad_pagada = cantidad_pagada;
    }

    /**
     * @return the fecha_del_pago
     */
    public String getFecha_del_pago() {
        return fecha_del_pago;
    }

    /**
     * @param fecha_del_pago the fecha_del_pago to set
     */
    public void setFecha_del_pago(String fecha_del_pago) {
        this.fecha_del_pago = fecha_del_pago;
    }

    /**
     * @return the Tipo_pago
     */
    public String getTipo_pago() {
        return Tipo_pago;
    }

    /**
     * @param Tipo_pago the Tipo_pago to set
     */
    public void setTipo_pago(String Tipo_pago) {
        this.Tipo_pago = Tipo_pago;
    }

    /**
     * @return the usuarios
     */
    public Usuario_apoyo getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Usuario_apoyo usuarios) {
        this.usuarios = usuarios;
    }
    
}
