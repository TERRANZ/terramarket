/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author terranz
 */
@Entity
@Table(name = "store", catalog = "terramarket", schema = "")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s"),
        @NamedQuery(name = "Store.findById", query = "SELECT s FROM Store s WHERE s.id = :id"),
        @NamedQuery(name = "Store.findByCount", query = "SELECT s FROM Store s WHERE s.count = :count"),
        @NamedQuery(name = "Store.findByProduct", query = "SELECT s FROM Store s WHERE s.prodId = :prod"),
        @NamedQuery(name = "Store.findByUpdated", query = "SELECT s FROM Store s WHERE s.updated = :updated")})
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "count", nullable = false)
    private int count;
    @Basic(optional = false)
    @Column(name = "updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "prod_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Product prodId;

    public Store() {
    }

    public Store(Integer id) {
        this.id = id;
    }

    public Store(Integer id, Product product, int count, Date updated) {
        this.id = id;
        this.count = count;
        this.updated = updated;
        this.prodId = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Product getProduct() {
        return prodId;
    }

    public void setProdId(Product prodId) {
        this.prodId = prodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.terra.terramarket.db.entity.Store[ id=" + id + " ]";
    }

}
