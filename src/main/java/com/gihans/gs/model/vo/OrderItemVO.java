/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.ClientOrder;
import com.gihans.gs.model.OrderItem;
import java.util.Date;

/**
 *
 * @author echamam
 */
public class OrderItemVO {

    public long id = -1l;
    public double price;
    public int quantity;
    public ItemVO item;

    public OrderItemVO() {
    }

    public OrderItemVO(final OrderItem orderItem) {
        this.id = orderItem.getId();
        this.price = orderItem.getPrice();
        this.quantity = orderItem.getQuantity();
        this.item = new ItemVO(orderItem.getItem());
    }

}
