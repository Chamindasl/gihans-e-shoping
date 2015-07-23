/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Category;
import com.gihans.gs.model.vo.IndexVO;
import com.gihans.gs.model.vo.ItemVO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author echamam
 */
@Stateless
@Path("index")
public class IndexRest {

    @PersistenceContext(unitName = "gihans_PU")
    private EntityManager em;

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Path("addToCart")
    public IndexVO addToCart(final IndexVO indexVO) {
        final Map<Long, ItemVO> cartItems = new HashMap<>();
        for (final ItemVO itemVO : indexVO.cartItems) {
            if (null == cartItems.get(itemVO.id)) {
                cartItems.put(itemVO.id, itemVO);
            } else {
                cartItems.get(itemVO.id).noOfItems += itemVO.noOfItems; 
            }
        }
        indexVO.cartItems = new ArrayList<>(cartItems.values());
        return indexVO;
    }

}
