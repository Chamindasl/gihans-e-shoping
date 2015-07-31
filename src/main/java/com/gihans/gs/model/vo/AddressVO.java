/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.Address;

/**
 *
 * @author echamam
 */
public class AddressVO {

    public long id;
    public String email;
    public String contactPerson;
    public String address1;
    public String address2;
    public ProvinceVO province;
    public DistrictVO district;
    public CityVO city;
    public String phone;
    public boolean business;

    public AddressVO () {
        
    }

    public AddressVO(final Address address) {

    }

    public Address toAddress() {
        final Address result = new Address();
        result.setId(this.id);
        result.setEmail(this.email);
        result.setContactPerson(this.contactPerson);
        result.setAddress1(this.address1);
        result.setAddress2(this.address2);
        result.setCompanyAddress(this.business);
        result.setPhone(phone);
        result.setDistrict(this.district.toDistrict());
        result.setCity(this.city.toCity());
        return result;
    }
}
