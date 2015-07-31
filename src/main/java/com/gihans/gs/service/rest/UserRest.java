/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Address;
import com.gihans.gs.model.City;
import com.gihans.gs.model.District;
import com.gihans.gs.model.User;
import com.gihans.gs.model.vo.UserVO;
import java.net.URISyntaxException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("/user")
public class UserRest {

    @PersistenceContext(unitName = "gihans_PU")
    private EntityManager em;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public UserVO saveUser(final UserVO userVo) throws URISyntaxException {
        final User user;
        if (userVo.id == -1l) {
            user = new User(userVo);
            final Address tBill = user.getBillingAddress();
            final Address tShip = user.getShippingAddress();
            user.setBillingAddress(null);
            user.setShippingAddress(null);
            user.setId(null);
            tBill.setId(null);
            tShip.setId(null);
            tBill.setDistrict(em.find(District.class, tBill.getDistrict().getId()));
            tShip.setDistrict(em.find(District.class, tShip.getDistrict().getId()));
            tBill.setCity(em.find(City.class, tBill.getCity().getId()));
            tShip.setCity(em.find(City.class, tShip.getCity().getId()));
            //tBill.
            em.persist(user);
            em.persist(tBill);
            em.persist(tShip);
            em.flush();
            user.setBillingAddress(tBill);
            user.setShippingAddress(tShip);
            em.merge(user);
            userVo.id = user.getId();
            return userVo;
        } else {
            
        }
        
        return null;
    }

}
