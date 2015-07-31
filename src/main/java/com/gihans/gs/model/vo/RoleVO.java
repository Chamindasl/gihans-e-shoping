/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.Role;

/**
 *
 * @author echamam
 */
public class RoleVO extends IdNameVO {

    public RoleVO() {

    }

    public RoleVO(final Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }

    public Role toRole() {
        final Role result = new Role();
        result.setId(Integer.parseInt("" + this.id));
        result.setName(name);
        return result;
    }

}
