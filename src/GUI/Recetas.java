/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author kenia_000
 */
@Entity
@Table(name = "RECETAS", catalog = "", schema = "COFFEETREEPT1")
@NamedQueries({
    @NamedQuery(name = "Recetas.findAll", query = "SELECT r FROM Recetas r"),
    @NamedQuery(name = "Recetas.findByProductoId", query = "SELECT r FROM Recetas r WHERE r.recetasPK.productoId = :productoId"),
    @NamedQuery(name = "Recetas.findByIngredienteId", query = "SELECT r FROM Recetas r WHERE r.recetasPK.ingredienteId = :ingredienteId"),
    @NamedQuery(name = "Recetas.findByCant", query = "SELECT r FROM Recetas r WHERE r.cant = :cant")})
public class Recetas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecetasPK recetasPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANT")
    private Double cant;

    public Recetas() {
    }

    public Recetas(RecetasPK recetasPK) {
        this.recetasPK = recetasPK;
    }

    public Recetas(BigInteger productoId, BigInteger ingredienteId) {
        this.recetasPK = new RecetasPK(productoId, ingredienteId);
    }

    public RecetasPK getRecetasPK() {
        return recetasPK;
    }

    public void setRecetasPK(RecetasPK recetasPK) {
        this.recetasPK = recetasPK;
    }

    public Double getCant() {
        return cant;
    }

    public void setCant(Double cant) {
        Double oldCant = this.cant;
        this.cant = cant;
        changeSupport.firePropertyChange("cant", oldCant, cant);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recetasPK != null ? recetasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recetas)) {
            return false;
        }
        Recetas other = (Recetas) object;
        if ((this.recetasPK == null && other.recetasPK != null) || (this.recetasPK != null && !this.recetasPK.equals(other.recetasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUI.Recetas[ recetasPK=" + recetasPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
