/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author terranz
 */
@Entity
@Table(name = "sells_items", catalog = "terramarket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SellsItem.findAll", query = "SELECT s FROM SellsItem s"),
    @NamedQuery(name = "SellsItem.findById", query = "SELECT s FROM SellsItem s WHERE s.id = :id"),
    @NamedQuery(name = "SellsItem.findByCount", query = "SELECT s FROM SellsItem s WHERE s.count = :count")})
public class SellsItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "count", nullable = false)
    private int count;
    @JoinColumn(name = "sell_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Sells sellId;
    @JoinColumn(name = "prod_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Product prodId;

    public SellsItem() {
    }

    public SellsItem(Integer id) {
        this.id = id;
    }

    public SellsItem(Integer id, int count) {
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

    public Sells getSellId() {
        return sellId;
    }

    public void setSellId(Sells sellId) {
        this.sellId = sellId;
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
        if (!(object instanceof SellsItem)) {
            return false;
        }
        SellsItem other = (SellsItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.terra.terramarket.db.entity.SellsItem[ id=" + id + " ]";
    }
    
}
