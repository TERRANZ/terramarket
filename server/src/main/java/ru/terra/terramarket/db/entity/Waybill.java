/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author terranz
 */
@Entity
@Table(name = "waybills", catalog = "terramarket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Waybill.findAll", query = "SELECT w FROM Waybill w"),
    @NamedQuery(name = "Waybill.findById", query = "SELECT w FROM Waybill w WHERE w.id = :id"),
    @NamedQuery(name = "Waybill.findByCount", query = "SELECT w FROM Waybill w WHERE w.count = :count"),
    @NamedQuery(name = "Waybill.findBySelldate", query = "SELECT w FROM Waybill w WHERE w.selldate = :selldate"),
    @NamedQuery(name = "Waybill.findBySupplier", query = "SELECT w FROM Waybill w WHERE w.supplier = :supplier"),
    @NamedQuery(name = "Waybill.findByTitle", query = "SELECT w FROM Waybill w WHERE w.title = :title")})
public class Waybill implements Serializable {
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
    @Column(name = "selldate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date selldate;
    @Basic(optional = false)
    @Column(name = "supplier", nullable = false, length = 512)
    private String supplier;
    @Basic(optional = false)
    @Column(name = "title", nullable = false, length = 512)
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "waybillId")
    private List<WaybillItem> waybillItemList;
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User user;

    public Waybill() {
    }

    public Waybill(Integer id) {
        this.id = id;
    }

    public Waybill(Integer id, int count, Date selldate, String supplier, String title) {
        this.id = id;
        this.count = count;
        this.selldate = selldate;
        this.supplier = supplier;
        this.title = title;
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

    public Date getSelldate() {
        return selldate;
    }

    public void setSelldate(Date selldate) {
        this.selldate = selldate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    @JsonIgnore
    public List<WaybillItem> getWaybillItemList() {
        return waybillItemList;
    }

    public void setWaybillItemList(List<WaybillItem> waybillItemList) {
        this.waybillItemList = waybillItemList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof Waybill)) {
            return false;
        }
        Waybill other = (Waybill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.terra.terramarket.db.entity.Waybill[ id=" + id + " ]";
    }
    
}
