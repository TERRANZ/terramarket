/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * @author terranz
 */
@Entity
@Table(name = "product", catalog = "terramarket", schema = "")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
        @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
        @NamedQuery(name = "Product.findByMincount", query = "SELECT p FROM Product p WHERE p.mincount = :mincount"),
        @NamedQuery(name = "Product.findByBarcode", query = "SELECT p FROM Product p WHERE p.barcode = :barcode"),
        @NamedQuery(name = "Product.findByQtype", query = "SELECT p FROM Product p WHERE p.qtype = :qtype"),
        @NamedQuery(name = "Product.findByPriceIn", query = "SELECT p FROM Product p WHERE p.priceIn = :priceIn"),
        @NamedQuery(name = "Product.findByPriceOut", query = "SELECT p FROM Product p WHERE p.priceOut = :priceOut"),
        @NamedQuery(name = "Product.findByRating", query = "SELECT p FROM Product p WHERE p.rating = :rating")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 512)
    private String name;
    @Basic(optional = false)
    @Column(name = "mincount", nullable = false)
    private int mincount;
    @Column(name = "barcode", length = 256)
    private String barcode;
    @Basic(optional = false)
    @Column(name = "qtype", nullable = false)
    private int qtype;
    @Basic(optional = false)
    @Column(name = "price_in", nullable = false)
    private int priceIn;
    @Basic(optional = false)
    @Column(name = "price_out", nullable = false)
    private int priceOut;
    @Basic(optional = false)
    @Column(name = "rating", nullable = false)
    private int rating;
    @Basic(optional = true)
    @Column(name = "comment", nullable = true, length = 512)
    private String comment;
    @Column(name = "avail")
    private Boolean avail;
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Groups groupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private List<Store> storeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private List<SellsItem> sellsItemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private List<WaybillItem> waybillItemList;
    @OneToMany(mappedBy = "productId")
    private List<Photo> photoList;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, int mincount, int qtype, int priceIn, int priceOut, int rating, String barcode, Groups group,String comment) {
        this.id = id;
        this.name = name;
        this.mincount = mincount;
        this.qtype = qtype;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        this.rating = rating;
        this.barcode = barcode;
        this.groupId = group;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMincount() {
        return mincount;
    }

    public void setMincount(int mincount) {
        this.mincount = mincount;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getQtype() {
        return qtype;
    }

    public void setQtype(int qtype) {
        this.qtype = qtype;
    }

    public int getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(int priceIn) {
        this.priceIn = priceIn;
    }

    public int getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(int priceOut) {
        this.priceOut = priceOut;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Groups getGroup() {
        return groupId;
    }

    public void setGroup(Groups groupId) {
        this.groupId = groupId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    @XmlTransient
    @JsonIgnore
    public List<SellsItem> getSellsItemList() {
        return sellsItemList;
    }

    public void setSellsItemList(List<SellsItem> sellsItemList) {
        this.sellsItemList = sellsItemList;
    }

    @XmlTransient
    @JsonIgnore
    public List<WaybillItem> getWaybillItemList() {
        return waybillItemList;
    }

    public void setWaybillItemList(List<WaybillItem> waybillItemList) {
        this.waybillItemList = waybillItemList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.terra.terramarket.db.entity.Product[ id=" + id + " ]";
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getAvail() {
        return avail;
    }

    public void setAvail(Boolean avail) {
        this.avail = avail;
    }
}
