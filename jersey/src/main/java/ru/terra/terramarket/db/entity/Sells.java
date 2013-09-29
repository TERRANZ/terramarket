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
@Table(name = "sells", catalog = "terramarket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sells.findAll", query = "SELECT s FROM Sells s"),
    @NamedQuery(name = "Sells.findById", query = "SELECT s FROM Sells s WHERE s.id = :id"),
    @NamedQuery(name = "Sells.findBySelldate", query = "SELECT s FROM Sells s WHERE s.selldate = :selldate")})
public class Sells implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "selldate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date selldate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellId")
    private List<SellsItem> sellsItemList;

    public Sells() {
    }

    public Sells(Integer id) {
        this.id = id;
    }

    public Sells(Integer id, Date selldate) {
        this.id = id;
        this.selldate = selldate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSelldate() {
        return selldate;
    }

    public void setSelldate(Date selldate) {
        this.selldate = selldate;
    }

    @XmlTransient
    @JsonIgnore
    public List<SellsItem> getSellsItemList() {
        return sellsItemList;
    }

    public void setSellsItemList(List<SellsItem> sellsItemList) {
        this.sellsItemList = sellsItemList;
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
        if (!(object instanceof Sells)) {
            return false;
        }
        Sells other = (Sells) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.terra.terramarket.db.entity.Sells[ id=" + id + " ]";
    }
    
}
