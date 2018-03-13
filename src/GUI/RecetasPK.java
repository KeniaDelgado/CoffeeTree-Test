/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kenia_000
 */
@Embeddable
public class RecetasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PRODUCTO_ID")
    private BigInteger productoId;
    @Basic(optional = false)
    @Column(name = "INGREDIENTE_ID")
    private BigInteger ingredienteId;

    public RecetasPK() {
    }

    public RecetasPK(BigInteger productoId, BigInteger ingredienteId) {
        this.productoId = productoId;
        this.ingredienteId = ingredienteId;
    }

    public BigInteger getProductoId() {
        return productoId;
    }

    public void setProductoId(BigInteger productoId) {
        this.productoId = productoId;
    }

    public BigInteger getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(BigInteger ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoId != null ? productoId.hashCode() : 0);
        hash += (ingredienteId != null ? ingredienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecetasPK)) {
            return false;
        }
        RecetasPK other = (RecetasPK) object;
        if ((this.productoId == null && other.productoId != null) || (this.productoId != null && !this.productoId.equals(other.productoId))) {
            return false;
        }
        if ((this.ingredienteId == null && other.ingredienteId != null) || (this.ingredienteId != null && !this.ingredienteId.equals(other.ingredienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUI.RecetasPK[ productoId=" + productoId + ", ingredienteId=" + ingredienteId + " ]";
    }
    
}
