/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.District;
import com.gihans.gs.model.Province;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author echamam
 */
public class ProvinceVO extends IdNameVO {

    public List<DistrictVO> districts = new ArrayList<>();

    public ProvinceVO() {
        
    }

    public ProvinceVO(final Province province) {
        this.id = province.getId();
        this.name = province.getName();
        for (final District district : province.getDistrictList()) {
            final DistrictVO districtVO = new DistrictVO(district);
            districts.add(districtVO);
        }
    }
}
