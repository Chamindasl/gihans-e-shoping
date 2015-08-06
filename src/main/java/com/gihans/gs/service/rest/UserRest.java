/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Address;
import com.gihans.gs.model.City;
import com.gihans.gs.model.District;
import com.gihans.gs.model.Role;
import com.gihans.gs.model.User;
import com.gihans.gs.model.vo.RoleVO;
import com.gihans.gs.model.vo.UserVO;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Stateless
@Path("/user")
public class UserRest {

    @PersistenceContext(unitName = "gihans_PU")
    private EntityManager em;

    @EJB
    private MailService mailService;

    @Context
    private ServletContext context;

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
            user.setActive(false);
            user.setUuid(UUID.randomUUID().toString());
            //tBill.
            em.persist(user);
            em.persist(tBill);
            em.persist(tShip);
            em.flush();
            user.setBillingAddress(tBill);
            user.setShippingAddress(tShip);
            em.merge(user);
            userVo.id = user.getId();
            mailService.sendMail(user, context.getRealPath("/"));
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

    @GET
    @Path("sessionUser")
    @Produces("application/json")
    public UserVO findAllUsers(@Context final HttpServletRequest request) {
        final Object u = request.getSession().getAttribute("loggedInUser");
        if (null == u) {
            return null;
        } else {
            return new UserVO((User) u);
        }
    }

    @POST
    @Path("login")
    @Produces("application/json")
    @Consumes("application/json")
    public Response loginUser(final UserVO userVo, @Context final HttpServletRequest request) {
        final TypedQuery<User> query = em.createQuery("select u from User u where u.email=:email and u.password=:password", User.class);
        query.setParameter("email", userVo.email);
        query.setParameter("password", userVo.password);
        final List<User> users = query.getResultList();
        if (users.size() > 0) {
            final User user = users.get(0);
            request.getSession().setAttribute("loggedInUser", user);
            return Response.ok().entity(new UserVO(user)).build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

}
