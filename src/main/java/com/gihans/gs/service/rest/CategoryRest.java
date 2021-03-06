/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Category;
import com.gihans.gs.model.vo.CategoryVO;
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
@Path("/category")
public class CategoryRest {

    @PersistenceContext(unitName = "gihans_PU")
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<CategoryVO> findAll() {
        final List<Category> findAll = em.createQuery("select c from Category c where c.parent IS NULL and c.active=TRUE", Category.class).getResultList();
        final List<CategoryVO> catVos = new ArrayList<>();
        for (Category c : findAll) {
            catVos.add(toCategoryVO(c, true));
        }
        return catVos;
    }

    @GET
    @Path("withInactive")
    @Produces("application/json")
    public List<CategoryVO> findAllWithInactive() {
        final List<Category> findAll = em.createQuery("select c from Category c where c.parent IS NULL", Category.class).getResultList();
        final List<CategoryVO> catVos = new ArrayList<>();
        for (Category c : findAll) {
            catVos.add(toCategoryVO(c, false));
        }
        return catVos;
    }

    @POST
    @Path("edit")
    @Produces("application/json")
    @Consumes("application/json")
    public CategoryVO edit(final CategoryVO categoryVO) {
        final Category c = em.find(Category.class, Integer.parseInt("" + categoryVO.id));
        c.setActive(categoryVO.active);
        return categoryVO;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public CategoryVO save(final CategoryVO categoryVO) {
        final Category category = new Category();
        category.setName(categoryVO.name);
        category.setActive(categoryVO.active);
        if (null != categoryVO.parentCategory && categoryVO.parentCategory.id != -1l) {
            category.setParent(em.find(Category.class, Integer.parseInt("" + categoryVO.parentCategory.id)));
        }
        if (categoryVO.id == -1l) {
            category.setActive(Boolean.TRUE);
            em.persist(category);
        } else {
            category.setId(Integer.parseInt("" + categoryVO.id));
            em.merge(category);
        }
        return categoryVO;
    }

    private static CategoryVO toCategoryVO(final Category category, final boolean active) {
        final CategoryVO categoryVO = new CategoryVO();
        categoryVO.id = category.getId();
        categoryVO.name = category.getName();
        categoryVO.active = category.getActive();
        final CategoryVO categoryVOP = new CategoryVO();
        categoryVOP.id = category.getId();
        categoryVOP.name = category.getName();
        categoryVOP.active = category.getActive();
        for (final Category subCat : category.getSubCategories()) {
            if (null == categoryVO.subCategories) {
                categoryVO.subCategories = new ArrayList<>();
            }
            final CategoryVO subCatVo = new CategoryVO();
            subCatVo.id = subCat.getId();
            subCatVo.name = subCat.getName();
            subCatVo.active = subCat.getActive();
            subCatVo.parentCategory = categoryVOP;
            if (!active) {
                categoryVO.subCategories.add(subCatVo);
            } else if (active && subCat.getActive()) {
                categoryVO.subCategories.add(subCatVo);
            }
        }
        return categoryVO;
    }

}
