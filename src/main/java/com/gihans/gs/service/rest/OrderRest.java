/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Category;
import com.gihans.gs.model.ClientOrder;
import com.gihans.gs.model.OrderItem;
import com.gihans.gs.model.vo.CategoryVO;
import com.gihans.gs.model.vo.IndexVO;
import com.gihans.gs.model.vo.ItemVO;
import com.gihans.gs.model.Item;
import com.gihans.gs.model.User;
import com.gihans.gs.model.vo.ClientOrderVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Stateless
@Path("/order")
public class OrderRest {

    @PersistenceContext(unitName = "gihans_PU")
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<ClientOrderVO> findAll(@Context final HttpServletRequest request) {
        final List<ClientOrder> orders;
        final List<ClientOrderVO> result = new ArrayList<>();
        final User user = (User) request.getSession().getAttribute("loggedInUser");

        if (user.getRole().getName().equals("Customer")) {
            orders = em.createQuery("select o from ClientOrder o where o.user.id=:user", ClientOrder.class)
                    .setParameter("user", user.getId())
                    .getResultList();
        } else {
            orders = em.createQuery("select o from ClientOrder o", ClientOrder.class).getResultList();
        }
        for (final ClientOrder co : orders) {
            result.add(new ClientOrderVO(co));
        }
        return result;
    }

    @POST
    @Path("place")
    @Produces("application/json")
    @Consumes("application/json")
    public IndexVO save(final IndexVO indexVO, @Context final HttpServletRequest request) {
        final ClientOrder co = new ClientOrder();
        final ArrayList<OrderItem> orderItems = new ArrayList<>();
        co.setOrderItemList(orderItems);
        co.setOrderedDate(new Date());
        co.setPaymentStatus(ClientOrder.PaymentStatus.PENDING.getId());
        co.setOrderStatus(ClientOrder.OrderStatus.NEW.getId());
        co.setUser((User) request.getSession().getAttribute("loggedInUser"));
        em.persist(co);
        double total = 0d;
        for (ItemVO cartItem : indexVO.cartItems) {
            final OrderItem oi = new OrderItem();
            oi.setClientOrder(co);
            final Item item = em.find(Item.class, cartItem.id);
            oi.setItem(item);
            oi.setPrice(item.getPrice());
            oi.setQuantity(cartItem.noOfItems);
            total += oi.getPrice() * oi.getQuantity();
            em.persist(oi);
        }
        co.setAmount(total);
        return indexVO;
    }

    private static CategoryVO toCategoryVO(final Category category) {
        final CategoryVO categoryVO = new CategoryVO();
        categoryVO.id = category.getId();
        categoryVO.name = category.getName();
        for (final Category subCat : category.getSubCategories()) {
            if (null == categoryVO.subCategories) {
                categoryVO.subCategories = new ArrayList<>();
            }
            final CategoryVO subCatVo = new CategoryVO();
            subCatVo.id = subCat.getId();
            subCatVo.name = subCat.getName();
            categoryVO.subCategories.add(subCatVo);
        }
        return categoryVO;
    }

}
