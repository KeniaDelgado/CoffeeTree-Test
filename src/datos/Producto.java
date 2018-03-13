
package datos;

import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;


public class Producto extends BaseModel{
    public static final String producto_id = "producto_id";
    public static final String nombre = "nombre";
    public static final String precio = "precio";

    private BigDecimal id_producto;
    
    private String nombre_producto;
    
    private BigDecimal precio_producto;
 
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    public BigDecimal getProducto_id() {
        return id_producto;
    }

   
    public void setProducto_id(BigDecimal id_producto) {
        java.math.BigDecimal oldId_producto = this.id_producto;
        this.id_producto = id_producto;
        propertyChangeSupport.firePropertyChange(producto_id, oldId_producto, id_producto);
    }

    
    public String getNombre() {
        return nombre_producto;
    }

    
    public void setNombre(String nombre_producto) {
        java.lang.String oldNombre_ingrediente = this.nombre_producto;
        this.nombre_producto = nombre_producto;
        propertyChangeSupport.firePropertyChange(nombre, oldNombre_ingrediente, nombre_producto);
    }

    
    public BigDecimal getPrecio() {
        return precio_producto;
    }

    
    public void setPrecio(BigDecimal precio_producto) {
        java.math.BigDecimal oldPrecio_producto = this.precio_producto;
        this.precio_producto = precio_producto;
        propertyChangeSupport.firePropertyChange(precio, oldPrecio_producto, precio_producto);
        
    }

    @Override
    public String toString() {
        return this.nombre_producto; 
    }
    
    
   

   
    
}
