/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Hector
 */
@Entity
@Table(name = "INGREDIENTES", catalog = "", schema = "COFFEETREEPT1")
@NamedQueries({
    @NamedQuery(name = "Ingredientes.findAll", query = "SELECT i FROM Ingredientes i")
    , @NamedQuery(name = "Ingredientes.findByIngredienteId", query = "SELECT i FROM Ingredientes i WHERE i.ingredienteId = :ingredienteId")
    , @NamedQuery(name = "Ingredientes.findByNombre", query = "SELECT i FROM Ingredientes i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Ingredientes.findByCantDisp", query = "SELECT i FROM Ingredientes i WHERE i.cantDisp = :cantDisp")
    , @NamedQuery(name = "Ingredientes.findByFechaPed", query = "SELECT i FROM Ingredientes i WHERE i.fechaPed = :fechaPed")
    , @NamedQuery(name = "Ingredientes.findByMedida", query = "SELECT i FROM Ingredientes i WHERE i.medida = :medida")})
public class Ingredientes implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "INGREDIENTE_ID")
    private BigDecimal ingredienteId;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CANT_DISP")
    private Double cantDisp;
    @Column(name = "FECHA_PED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPed;
    @Column(name = "MEDIDA")
    private String medida;

    public Ingredientes() {
    }

    public Ingredientes(BigDecimal ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public BigDecimal getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(BigDecimal ingredienteId) {
        BigDecimal oldIngredienteId = this.ingredienteId;
        this.ingredienteId = ingredienteId;
        changeSupport.firePropertyChange("ingredienteId", oldIngredienteId, ingredienteId);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public Double getCantDisp() {
        return cantDisp;
    }

    public void setCantDisp(Double cantDisp) {
        Double oldCantDisp = this.cantDisp;
        this.cantDisp = cantDisp;
        changeSupport.firePropertyChange("cantDisp", oldCantDisp, cantDisp);
    }

    public Date getFechaPed() {
        return fechaPed;
    }

    public void setFechaPed(Date fechaPed) {
        Date oldFechaPed = this.fechaPed;
        this.fechaPed = fechaPed;
        changeSupport.firePropertyChange("fechaPed", oldFechaPed, fechaPed);
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        String oldMedida = this.medida;
        this.medida = medida;
        changeSupport.firePropertyChange("medida", oldMedida, medida);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingredienteId != null ? ingredienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredientes)) {
            return false;
        }
        Ingredientes other = (Ingredientes) object;
        if ((this.ingredienteId == null && other.ingredienteId != null) || (this.ingredienteId != null && !this.ingredienteId.equals(other.ingredienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUI.Ingredientes[ ingredienteId=" + ingredienteId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
