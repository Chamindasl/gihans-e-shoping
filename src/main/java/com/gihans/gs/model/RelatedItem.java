/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author echamam
 */
@Entity
@Table(name = "related_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatedItem.findAll", query = "SELECT r FROM RelatedItem r"),
    @NamedQuery(name = "RelatedItem.findById", query = "SELECT r FROM RelatedItem r WHERE r.id = :id"),
    @NamedQuery(name = "RelatedItem.findByHits", query = "SELECT r FROM RelatedItem r WHERE r.hits = :hits")})
public class RelatedItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "hits")
    private BigInteger hits;
    @JoinColumn(name = "relation", referencedColumnName = "id")
    @ManyToOne
    private Relation relation;
    @JoinColumn(name = "related_item", referencedColumnName = "id")
    @ManyToOne
    private Item relatedItem;
    @JoinColumn(name = "item", referencedColumnName = "id")
    @ManyToOne
    private Item item;

    public RelatedItem() {
    }

    public RelatedItem(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getHits() {
        return hits;
    }

    public void setHits(BigInteger hits) {
        this.hits = hits;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public Item getRelatedItem() {
        return relatedItem;
    }

    public void setRelatedItem(Item relatedItem) {
        this.relatedItem = relatedItem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        if (!(object instanceof RelatedItem)) {
            return false;
        }
        RelatedItem other = (RelatedItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gihans.gs.model.RelatedItem[ id=" + id + " ]";
    }
    
}
