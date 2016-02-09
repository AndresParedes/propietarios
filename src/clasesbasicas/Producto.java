/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesbasicas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Ging
 */
@Entity
@Table(name = "producto", catalog = "jventas", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Producto.findByProveedor", query = "SELECT p FROM Producto p WHERE p.proveedor = :proveedor"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock"),
    @NamedQuery(name = "Producto.findByStockmedio", query = "SELECT p FROM Producto p WHERE p.stockmedio = :stockmedio"),
    @NamedQuery(name = "Producto.findByStockminimo", query = "SELECT p FROM Producto p WHERE p.stockminimo = :stockminimo"),
    @NamedQuery(name = "Producto.findByIva", query = "SELECT p FROM Producto p WHERE p.iva = :iva"),
    @NamedQuery(name = "Producto.findByIce", query = "SELECT p FROM Producto p WHERE p.ice = :ice"),
    @NamedQuery(name = "Producto.findByPrecioventa", query = "SELECT p FROM Producto p WHERE p.precioventa = :precioventa"),
    @NamedQuery(name = "Producto.findByPreciocompra", query = "SELECT p FROM Producto p WHERE p.preciocompra = :preciocompra")})
public class Producto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "proveedor")
    private String proveedor;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "stockmedio")
    private Integer stockmedio;
    @Column(name = "stockminimo")
    private Integer stockminimo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "iva")
    private Double iva;
    @Column(name = "ice")
    private Double ice;
    @Column(name = "precioventa")
    private Double precioventa;
    @Column(name = "preciocompra")
    private Double preciocompra;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        Integer oldIdProducto = this.idProducto;
        this.idProducto = idProducto;
        changeSupport.firePropertyChange("idProducto", oldIdProducto, idProducto);
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        String oldNombreProducto = this.nombreProducto;
        this.nombreProducto = nombreProducto;
        changeSupport.firePropertyChange("nombreProducto", oldNombreProducto, nombreProducto);
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        String oldProveedor = this.proveedor;
        this.proveedor = proveedor;
        changeSupport.firePropertyChange("proveedor", oldProveedor, proveedor);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        Integer oldStock = this.stock;
        this.stock = stock;
        changeSupport.firePropertyChange("stock", oldStock, stock);
    }

    public Integer getStockmedio() {
        return stockmedio;
    }

    public void setStockmedio(Integer stockmedio) {
        Integer oldStockmedio = this.stockmedio;
        this.stockmedio = stockmedio;
        changeSupport.firePropertyChange("stockmedio", oldStockmedio, stockmedio);
    }

    public Integer getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(Integer stockminimo) {
        Integer oldStockminimo = this.stockminimo;
        this.stockminimo = stockminimo;
        changeSupport.firePropertyChange("stockminimo", oldStockminimo, stockminimo);
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        Double oldIva = this.iva;
        this.iva = iva;
        changeSupport.firePropertyChange("iva", oldIva, iva);
    }

    public Double getIce() {
        return ice;
    }

    public void setIce(Double ice) {
        Double oldIce = this.ice;
        this.ice = ice;
        changeSupport.firePropertyChange("ice", oldIce, ice);
    }

    public Double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Double precioventa) {
        Double oldPrecioventa = this.precioventa;
        this.precioventa = precioventa;
        changeSupport.firePropertyChange("precioventa", oldPrecioventa, precioventa);
    }

    public Double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(Double preciocompra) {
        Double oldPreciocompra = this.preciocompra;
        this.preciocompra = preciocompra;
        changeSupport.firePropertyChange("preciocompra", oldPreciocompra, preciocompra);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clasesbasicas.Producto[ idProducto=" + idProducto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
