/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.Brand;

/**
 *
 * @author echamam
 */
public class BrandVO extends IdNameVO {

    public int noOfItems;
    public boolean selected;
    public boolean active;

    public BrandVO() {
        this.id = -1;
    }

    public BrandVO(final Brand b) {
        this.id = b.getId();
        this.name = b.getName();
        this.active = b.getActive();
        this.noOfItems = b.getItemList().size();
    }
    
    public Brand toBrand() {
        final Brand result = new Brand();
        result.setId(Integer.parseInt("" + this.id));
        result.setName(name);
        result.setActive(active);
        return result;
    }
}
