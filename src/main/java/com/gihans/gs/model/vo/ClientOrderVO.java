/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.ClientOrder;
import java.util.Date;

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
    public UserVO userVO;

    public ClientOrderVO() {
    }

    public ClientOrderVO(final ClientOrder clientOrder) {
        this.id = clientOrder.getId();
        this.amount = clientOrder.getAmount();
        this.deliveredData = clientOrder.getDeliveredData();
        this.orderedDate = clientOrder.getOrderedDate();
        this.paymentDate = clientOrder.getPaymentReceivedDate();
        this.orderStatus = "" + clientOrder.getOrderStatus();
        this.paymentStatus = "" + clientOrder.getPaymentStatus();
    }

}
