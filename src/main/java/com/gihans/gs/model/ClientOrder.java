/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model;

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

/**
 *
 * @author echamam
 */
@Entity
@Table(name = "client_order")
@NamedQueries({
    @NamedQuery(name = "ClientOrder.findAll", query = "SELECT c FROM ClientOrder c")})
public class ClientOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "ordered_date")
    @Temporal(TemporalType.DATE)
    private Date orderedDate;
    @Column(name = "payment_status")
    private Integer paymentStatus;
    @Column(name = "order_status")
    private Integer orderStatus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @OneToMany(mappedBy = "clientOrder", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;
    @JoinColumn(name = "shipping_address", referencedColumnName = "id")
    @ManyToOne
    private Address shippingAddress;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private User user;

    public enum PaymentStatus {

        PENDING(1),
        BANK_CONFIRMED(2),
        RECEIVED(3);

        private final int id;

        PaymentStatus(int id) {
            this.id = id;
            
        }

        public int getId() {
            return id;
        }
       
    }

    public enum OrderStatus {

        PENDING(1),
        BANK_CONFIRMED(2),
        RECEIVED(3);

        private final int id;

        OrderStatus(int id) {
            this.id = id;
            
        }

        public int getId() {
            return id;
        }
       
    }

    public ClientOrder() {
    }

    public ClientOrder(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
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
        if (!(object instanceof ClientOrder)) {
            return false;
        }
        ClientOrder other = (ClientOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gihans.gs.model.ClientOrder[ id=" + id + " ]";
    }

}
