/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Address;
import com.gihans.gs.model.City;
import com.gihans.gs.model.District;
import com.gihans.gs.model.Province;
import com.gihans.gs.model.Role;
import com.gihans.gs.model.User;
import com.gihans.gs.model.vo.ProvinceVO;
import com.gihans.gs.model.vo.RoleVO;
import com.gihans.gs.model.vo.UserVO;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
            user = userVo.toUser(userVo);
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

    @GET
    @Path("roles")
    @Produces("application/json")
    public List<RoleVO> findAllRoles() {
        final List<Role> roles = em.createQuery("select p from Role p", Role.class).getResultList();
        final List<RoleVO> roleVos = new ArrayList<>();
        for (final Role p : roles) {
            roleVos.add(new RoleVO(p));
        }
        return roleVos;
    }

    @GET
    @Path("users")
    @Produces("application/json")
    public List<UserVO> findAllUsers() {
        final List<User> users = em.createQuery("select p from User p", User.class).getResultList();
        final List<UserVO> userVos = new ArrayList<>();
        for (final User u : users) {
            userVos.add(new UserVO(u));
        }
        return userVos;
    }

}
