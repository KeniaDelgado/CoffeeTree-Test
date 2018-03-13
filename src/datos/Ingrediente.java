
package datos;

import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Ingrediente extends BaseModel{
    public static final String ingrediente_id = "ingrediente_id";
    public static final String  nombre = "nombre";
    public static final String cant_disp = "cant_disp";
    public static final String fecha_cad = "fecha_cad";
    public static final String fecha_ped = "fecha_ped";
    public static final String  medida = "medida";

    private BigDecimal id_ingrediente;
    
    private String nombre_ingrediente;
    
    private String medida_nomb;
    
    private BigDecimal cantidad_disponible;
    
    private Timestamp fecha_caducidad;
    
    private Timestamp fecha_pedido;
    
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

  
    public BigDecimal getIngrediente_id() {
        return id_ingrediente;
    }

    public void setIngrediente_id(BigDecimal id_ingrediente) {
        java.math.BigDecimal oldId_ingrediente = this.id_ingrediente;
        this.id_ingrediente = id_ingrediente;
        propertyChangeSupport.firePropertyChange(ingrediente_id, oldId_ingrediente, id_ingrediente);
    }

 
    public String getNombre() {
        return nombre_ingrediente;
    }

  
    public void setNombre(String nombre_ingrediente) {
        java.lang.String oldNombre_ingrediente = this.nombre_ingrediente;
        this.nombre_ingrediente = nombre_ingrediente;
        propertyChangeSupport.firePropertyChange(nombre, oldNombre_ingrediente, nombre_ingrediente);
    }


    public BigDecimal getCant_disp() {
        return cantidad_disponible;
    }

 
    public void setCant_disp(BigDecimal cantidad_disponible) {
        java.math.BigDecimal oldCant_disp = this.cantidad_disponible;
        this.cantidad_disponible = cantidad_disponible;
        propertyChangeSupport.firePropertyChange(cant_disp, oldCant_disp, cantidad_disponible);
    }


    public Timestamp getFecha_cad() {
        return fecha_caducidad;
    }

  
    public void setFecha_cad(Timestamp fecha_caducidad) {
        java.sql.Timestamp oldFecha_caducidad = this.fecha_caducidad;
        this.fecha_caducidad = fecha_caducidad;
        propertyChangeSupport.firePropertyChange(fecha_cad, oldFecha_caducidad, fecha_caducidad);
    }

    public Timestamp getFecha_ped() {
        return fecha_pedido;
    }

 
    public void setFecha_ped(Timestamp fecha_pedido) {
        java.sql.Timestamp oldFecha_pedido = this.fecha_pedido;
        this.fecha_pedido = fecha_pedido;
        propertyChangeSupport.firePropertyChange(fecha_ped, oldFecha_pedido, fecha_pedido);
    }
    
    public String getMedida() {
        return medida_nomb;
    }

  
    public void setMedida(String nombre_Med) {
        java.lang.String oldNombre_ingrediente = this.medida_nomb;
        this.medida_nomb = nombre_Med;
        propertyChangeSupport.firePropertyChange(medida, oldNombre_ingrediente, nombre_Med);
    }
    
}
