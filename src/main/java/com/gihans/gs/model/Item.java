/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author echamam
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price"),
    @NamedQuery(name = "Item.findByFresh", query = "SELECT i FROM Item i WHERE i.fresh = :fresh"),
    @NamedQuery(name = "Item.findByOnSale", query = "SELECT i FROM Item i WHERE i.onSale = :onSale"),
    @NamedQuery(name = "Item.findByStock", query = "SELECT i FROM Item i WHERE i.stock = :stock"),
    @NamedQuery(name = "Item.findByActive", query = "SELECT i FROM Item i WHERE i.active = :active")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Long price;
    @Column(name = "fresh")
    private Boolean fresh;
    @Column(name = "onSale")
    private Boolean onSale;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "brand", referencedColumnName = "id")
    @ManyToOne
    private Brand brand;
    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "relatedItem")
    private List<RelatedItem> relatedItemList;
    @OneToMany(mappedBy = "item")
    private List<RelatedItem> relatedItemList1;

    public Item() {
    }

    public Item(Long id) {
        this.id = id;
    }

    public Item(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getFresh() {
        return fresh;
    }

    public void setFresh(Boolean fresh) {
        this.fresh = fresh;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @XmlTransient
    @JsonIgnore
    public List<RelatedItem> getRelatedItemList() {
        return relatedItemList;
    }

    public void setRelatedItemList(List<RelatedItem> relatedItemList) {
        this.relatedItemList = relatedItemList;
    }

    @XmlTransient
    @JsonIgnore
    public List<RelatedItem> getRelatedItemList1() {
        return relatedItemList1;
    }

    public void setRelatedItemList1(List<RelatedItem> relatedItemList1) {
        this.relatedItemList1 = relatedItemList1;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gihans.gs.model.Item[ id=" + id + " ]";
    }
    
}