/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Category;
import com.gihans.gs.model.vo.IndexVO;
import com.gihans.gs.model.vo.ItemVO;
import com.gihans.gs.model.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
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

    @EJB
    private CategoryRest categoryRest;

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

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Path("loadIndexVO")
    public IndexVO loadIndexVO(final IndexVO indexVO) {
        loadCategories(indexVO);
        loadFeaturedItems(indexVO);
        return indexVO;
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Path("loadRelatedItems")
    public IndexVO loadRelatedItems(final IndexVO indexVO) {
        final Set<Item> relatedItemSet = new HashSet<>();
        final List<ItemVO> currentRelated = new ArrayList(indexVO.recommendedItems);
        final List<ItemVO> result = new ArrayList<>();
        if (null != indexVO.addedItemVO) {
            final List<Item> relatedItems = em.find(Item.class, Long.valueOf("" + indexVO.addedItemVO.id)).getRelatedItems();
            relatedItemSet.addAll(relatedItems);
        }
        if (null != indexVO.selectedCategory) {
            final List<Item> relatedItems = em.find(Category.class, Integer.valueOf("" + indexVO.selectedCategory.id)).getItemList();
            relatedItemSet.addAll(relatedItems);
        }
        for (final Item i : relatedItemSet) {
            result.add(new ItemVO(i));
        }
        result.addAll(currentRelated);
        indexVO.recommendedItems = result;
        return indexVO;
    }

    private void loadCategories(final IndexVO indexVO) {
        indexVO.categories = categoryRest.findAll();
    }

    private void loadFeaturedItems(final IndexVO indexVO) {
        final List<Item> items = em.createQuery("select i from Item i where i.active=TRUE and i.featured=TRUE", Item.class).getResultList();
        final List<ItemVO> itemVOs = new ArrayList<>();
        final List<ItemVO> relatedItems = new ArrayList<>();
        for (final Item i : items) {
            itemVOs.add(new ItemVO(i));
            for (final Item ri : i.getRelatedItems()) {
                relatedItems.add(new ItemVO(ri));
            }
        }
        indexVO.recommendedItems = relatedItems;
        indexVO.featuredItems = itemVOs;
    }

}
