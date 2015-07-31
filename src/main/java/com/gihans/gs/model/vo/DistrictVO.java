/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.City;
import com.gihans.gs.model.District;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author echamam
 */
public class DistrictVO extends IdNameVO {

    public List<CityVO> cities = new ArrayList<>();

    public DistrictVO() {
        
    }

    public DistrictVO(final District district) {
        this.id = district.getId();
        this.name = district.getName();
        for(final City city : district.getCityList()) {
            final CityVO cityVO = new CityVO(city);
            cities.add(cityVO);
        }
    }

    public District toDistrict() {
        final District result = new District();
        result.setId(Integer.parseInt("" + this.id));
        result.setName(name);
        return result;
    }
}
