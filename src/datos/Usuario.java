package datos;

import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;

/**
 * Clase que contiene los atributos de un Usuario.
 * @author Alejandro Escobedo, Erik Zubia
 */
public class Usuario extends BaseModel{    
    public static final String usuario_id = "usuario_id";
    public static final String contrasena = "contrasena";
    public static final String rol = "rol";
   
    
    private BigDecimal id_usuario;
    private String contra;
    private String rol_us;
    
    
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    /**
     * Método para obtener un usuarioId de un objeto Usuario.
     * @return the usuarioId
     */
    public BigDecimal getId_usuario() {
        return id_usuario;
    }

    /**
     * Método para asignar un usuarioId de un objeto Usuario.
     * @param id_usuario the usuarioId to set
     */
    public void setUsuario_id(BigDecimal id_usuario) {
        java.math.BigDecimal oldId_usuario = this.id_usuario;
        this.id_usuario = id_usuario;
        propertyChangeSupport.firePropertyChange(usuario_id, oldId_usuario, id_usuario);
    }

    /**
     * Método para obtener un usuario de un objeto Usuario.
     * @return the usuario
     */
    public String getContrasena() {
        return contra;
    }

    /**
     * Método para asignar un usuario de un objeto Usuario.
     * @param contra the usuario to set
     */
    public void setContrasena(String contra) {
        
        java.lang.String oldContra = this.contra;
        this.contra = contra;
        propertyChangeSupport.firePropertyChange(contrasena, oldContra, contra);
    }

    /**
     * Método para obtener una contrasena de un objeto Usuario.
     * @return the contrasena
     */
    public String getRol() {
        return rol_us;
    }

    /**
     * Método para asignar una contraseña de un objeto Usuario.
     * @param rol_us the contrasena to set
     */
    public void setRol(String rol_us) {
        java.lang.String oldRol = this.rol_us;
        this.rol_us = rol_us;
        propertyChangeSupport.firePropertyChange(rol, oldRol, rol_us);
    }
}
