/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author terranz
 */
@Entity
@Table(name = "waybill_items", catalog = "terramarket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WaybillItem.findAll", query = "SELECT w FROM WaybillItem w"),
    @NamedQuery(name = "WaybillItem.findById", query = "SELECT w FROM WaybillItem w WHERE w.id = :id"),
    @NamedQuery(name = "WaybillItem.findByCount", query = "SELECT w FROM WaybillItem w WHERE w.count = :count")})
public class WaybillItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "count", nullable = false)
    private int count;
    @JoinColumn(name = "waybill_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Waybill waybillId;
    @JoinColumn(name = "prod_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Product prodId;

    public WaybillItem() {
    }

    public WaybillItem(Integer id) {
        this.id = id;
    }

    public WaybillItem(Integer id, int count) {
        this.id = id;
        this.count = count;
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

    public Waybill getWaybill() {
        return waybillId;
    }

    public void setWaybill(Waybill waybillId) {
        this.waybillId = waybillId;
    }

    public Product getProduct() {
        return prodId;
    }

    public void setProduct(Product prodId) {
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
        if (!(object instanceof WaybillItem)) {
            return false;
        }
        WaybillItem other = (WaybillItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.terra.terramarket.db.entity.WaybillItem[ id=" + id + " ]";
    }
    
}
