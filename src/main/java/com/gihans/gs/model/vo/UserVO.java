/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

/**
 *
 * @author echamam
 */
public class UserVO {

    public long id = -1l;
    public String email;
    public char type;
    public String displayName;
    public String firstName;
    public String lastName;
    public String password;
    public String phone;
    public AddressVO billingAddress;
    public AddressVO shippingAddress;
    public boolean shipingSameAsBilling;
}
