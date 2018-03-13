/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author kenia_000
 */
public class Venta {
    public static final String usuario_id = "usuario_id";
    public static final String total_d = "total";
    public static final String venta_id = "venta_id";
    public static final String MAX_val = "MAX(venta_id)";
    public static final String fecha_act = "fecha";
    public static final String hora_h = "hora";
    public static final String metodo_clave_m = "metodo_clave";
    
    public static final String dia_f = "fecha";
    public static final String mes_f = "hora";
    ///public static final String metod_clav = "metodo_clave";
    
    private BigDecimal id_pedido;
    
    private BigDecimal vent_id;
    
    private BigDecimal total;
    
    private Timestamp fecha;
    
    private String hora;
    
    
    private BigDecimal MAX;
    
    
    private String metodo_clave;

    
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    /**
     * Método para obtener un id_pedido de un objeto Pedido.
     * @return the id_pedido
     */
    public BigDecimal getUsuario_id() {
        return id_pedido;
    }

    /**
     * Método para asignar un id_pedido de un objeto Pedido.
     * @param id_pedido the id_pedido to set
     */
    public void setUsuario_id(BigDecimal id_pedido) {
        java.math.BigDecimal oldId_pedido = this.id_pedido;
        this.id_pedido = id_pedido;
        propertyChangeSupport.firePropertyChange(usuario_id, oldId_pedido, id_pedido);
    }

    /**
     * Método para obtener una fecha_pedido de un objeto Pedido.
     * @return the fecha_pedido
     */
    public BigDecimal getVenta_id() {
        return vent_id;
    }

    /**
     * Método para asignar una fecha_pedido de un objeto Pedido.
     * @param fecha_pedido the fecha_pedido to set
     */
    public void setVenta_id(BigDecimal vent_id) {
        java.math.BigDecimal oldVenta_id = this.vent_id;
        this.vent_id = vent_id;
        propertyChangeSupport.firePropertyChange(venta_id, oldVenta_id, vent_id);
    }

    /**
     * Método para obtener un total de un objeto Pedido.
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Método para asignar un total de un objeto Pedido.
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        java.math.BigDecimal oldTotal = this.total;
        this.total = total;
        propertyChangeSupport.firePropertyChange(total_d, oldTotal, total);
    }

    /**
     * Método para obtener una fecha_entrega de un objeto Pedido.
     * @return the fecha_entrega
     */
    

    /**
     * Método para asignar una fecha_entrega de un objeto Pedido.
     * @param fecha_entrega the fecha_entrega to set
     */
    /*public void setFecha_entrega(Timestamp fecha_entrega) {
        java.sql.Timestamp oldFecha_entrega = this.fecha_entrega;
        this.fecha_entrega = fecha_entrega;
        propertyChangeSupport.firePropertyChange(PROP_FECHA_ENTREGA, oldFecha_entrega, fecha_entrega);
    }

    */

    public BigDecimal getMax() {
        return MAX;
    }

    public void setMax(BigDecimal MAX) {
        java.math.BigDecimal oldTotal = this.MAX;
        this.MAX = MAX;
        propertyChangeSupport.firePropertyChange(MAX_val, oldTotal, MAX);
    }

    public int toInteger(){
        return MAX.intValue();
    }


    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * Método para asignar un nombre_ingrediente a un objeto Ingrediente.
     * @param fecha_pedido the id_proveedor to set
     */
    public void setFecha(Timestamp fecha_pedido) {
        java.sql.Timestamp oldFecha_pedido = this.fecha;
        this.fecha = fecha_pedido;
        propertyChangeSupport.firePropertyChange(fecha_act, oldFecha_pedido, fecha_pedido);
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMetodo_clave() {
        return metodo_clave;
    }

    public void setMetodo_clave(String metodo_clave) {
        this.metodo_clave = metodo_clave;
    }
    
    
    
    
    
    
    
}
