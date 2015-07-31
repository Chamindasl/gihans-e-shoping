/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.City;

/**
 *
 * @author echamam
 */
public class CityVO extends IdNameVO {

    public CityVO() {
        
    }

    public CityVO(City city) {
        this.id = city.getId();
        this.name = city.getName();
    }
}
