/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.User;

/**
 *
 * @author echamam
 */
public class UserVO {

    public long id = -1l;
    public String email;
    public String displayName;
    public String firstName;
    public String lastName;
    public String password;
    public String phone;
    public AddressVO billingAddress;
    public AddressVO shippingAddress;
    public boolean shipingSameAsBilling;
    public RoleVO role;

    public UserVO() {
    }

    public UserVO(final User user) {
        this.email = user.getEmail();
        this.displayName = user.getDisplayName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phone = user.getPhone();
        this.billingAddress = new AddressVO(user.getBillingAddress());
        this.shippingAddress = new AddressVO(user.getShippingAddress());
        this.role = new RoleVO(user.getRole());
    }

    public User toUser(UserVO userVo) {
        final User user = new User();
        user.setId(userVo.id);
        user.setDisplayName(userVo.displayName);
        user.setEmail(userVo.email);
        user.setFirstName(userVo.firstName);
        user.setLastName(userVo.lastName);
        user.setPhone(userVo.phone);
        user.setShippingAddress(userVo.shippingAddress.toAddress());
        user.setBillingAddress(userVo.billingAddress.toAddress());
        user.setPassword(userVo.password);
        user.setRole(userVo.role.toRole());
        return user;
    }

}
