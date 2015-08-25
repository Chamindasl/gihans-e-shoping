/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.ClientOrder;
import com.gihans.gs.model.OrderItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author echamam
 */
public class ClientOrderVO {

    public long id = -1l;
    public double amount;
    public Date deliveredData;
    public Date orderedDate;
    public Date paymentDate;
    public String orderStatus;
    public String paymentStatus;
    public UserVO user;
    public List<OrderItemVO> orderItems = new ArrayList<>();

    public ClientOrderVO() {
    }

    public ClientOrderVO(final ClientOrder clientOrder) {
        this.id = clientOrder.getId();
        this.amount = clientOrder.getAmount();
        this.deliveredData = clientOrder.getDeliveredData();
        this.orderedDate = clientOrder.getOrderedDate();
        this.paymentDate = clientOrder.getPaymentReceivedDate();
        this.orderStatus =  ClientOrder.OrderStatus.get(clientOrder.getOrderStatus()).name();
        this.paymentStatus = ClientOrder.PaymentStatus.get(clientOrder.getPaymentStatus()).name();
        this.user = new UserVO(clientOrder.getUser());
        for (final OrderItem orderItem : clientOrder.getOrderItemList()) {
            orderItems.add(new OrderItemVO(orderItem));
        }
    }

}
