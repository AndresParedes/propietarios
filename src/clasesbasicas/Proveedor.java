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
@Table(name = "proveedor", catalog = "jventas", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedor.findByRazonsocial", query = "SELECT p FROM Proveedor p WHERE p.razonsocial = :razonsocial"),
    @NamedQuery(name = "Proveedor.findByRuc", query = "SELECT p FROM Proveedor p WHERE p.ruc = :ruc"),
    @NamedQuery(name = "Proveedor.findByDireccion1", query = "SELECT p FROM Proveedor p WHERE p.direccion1 = :direccion1"),
    @NamedQuery(name = "Proveedor.findByDireccion2", query = "SELECT p FROM Proveedor p WHERE p.direccion2 = :direccion2"),
    @NamedQuery(name = "Proveedor.findByTelefono1", query = "SELECT p FROM Proveedor p WHERE p.telefono1 = :telefono1"),
    @NamedQuery(name = "Proveedor.findByTelefono2", query = "SELECT p FROM Proveedor p WHERE p.telefono2 = :telefono2"),
    @NamedQuery(name = "Proveedor.findByCelular", query = "SELECT p FROM Proveedor p WHERE p.celular = :celular"),
    @NamedQuery(name = "Proveedor.findByFax", query = "SELECT p FROM Proveedor p WHERE p.fax = :fax"),
    @NamedQuery(name = "Proveedor.findByCorreo", query = "SELECT p FROM Proveedor p WHERE p.correo = :correo"),
    @NamedQuery(name = "Proveedor.findByContacto", query = "SELECT p FROM Proveedor p WHERE p.contacto = :contacto"),
    @NamedQuery(name = "Proveedor.findByExt1", query = "SELECT p FROM Proveedor p WHERE p.ext1 = :ext1"),
    @NamedQuery(name = "Proveedor.findByExt2", query = "SELECT p FROM Proveedor p WHERE p.ext2 = :ext2")})
public class Proveedor implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_proveedor")
    private String idProveedor;
    @Column(name = "razonsocial")
    private String razonsocial;
    @Column(name = "ruc")
    private Integer ruc;
    @Column(name = "direccion1")
    private String direccion1;
    @Column(name = "direccion2")
    private String direccion2;
    @Column(name = "telefono1")
    private String telefono1;
    @Column(name = "telefono2")
    private String telefono2;
    @Column(name = "celular")
    private String celular;
    @Column(name = "fax")
    private String fax;
    @Column(name = "correo")
    private String correo;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "ext1")
    private String ext1;
    @Column(name = "ext2")
    private String ext2;

    public Proveedor() {
    }

    public Proveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        String oldIdProveedor = this.idProveedor;
        this.idProveedor = idProveedor;
        changeSupport.firePropertyChange("idProveedor", oldIdProveedor, idProveedor);
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        String oldRazonsocial = this.razonsocial;
        this.razonsocial = razonsocial;
        changeSupport.firePropertyChange("razonsocial", oldRazonsocial, razonsocial);
    }

    public Integer getRuc() {
        return ruc;
    }

    public void setRuc(Integer ruc) {
        Integer oldRuc = this.ruc;
        this.ruc = ruc;
        changeSupport.firePropertyChange("ruc", oldRuc, ruc);
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        String oldDireccion1 = this.direccion1;
        this.direccion1 = direccion1;
        changeSupport.firePropertyChange("direccion1", oldDireccion1, direccion1);
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        String oldDireccion2 = this.direccion2;
        this.direccion2 = direccion2;
        changeSupport.firePropertyChange("direccion2", oldDireccion2, direccion2);
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        String oldTelefono1 = this.telefono1;
        this.telefono1 = telefono1;
        changeSupport.firePropertyChange("telefono1", oldTelefono1, telefono1);
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        String oldTelefono2 = this.telefono2;
        this.telefono2 = telefono2;
        changeSupport.firePropertyChange("telefono2", oldTelefono2, telefono2);
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        String oldCelular = this.celular;
        this.celular = celular;
        changeSupport.firePropertyChange("celular", oldCelular, celular);
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        String oldFax = this.fax;
        this.fax = fax;
        changeSupport.firePropertyChange("fax", oldFax, fax);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        String oldCorreo = this.correo;
        this.correo = correo;
        changeSupport.firePropertyChange("correo", oldCorreo, correo);
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        String oldContacto = this.contacto;
        this.contacto = contacto;
        changeSupport.firePropertyChange("contacto", oldContacto, contacto);
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        String oldExt1 = this.ext1;
        this.ext1 = ext1;
        changeSupport.firePropertyChange("ext1", oldExt1, ext1);
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        String oldExt2 = this.ext2;
        this.ext2 = ext2;
        changeSupport.firePropertyChange("ext2", oldExt2, ext2);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clasesbasicas.Proveedor[ idProveedor=" + idProveedor + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
