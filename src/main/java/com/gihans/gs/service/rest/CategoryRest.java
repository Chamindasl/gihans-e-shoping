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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("/categoryVo")
public class CategoryRest {

    @PersistenceContext(unitName = "gihans_PU")
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<CategoryVO> findAll() {
        final List<Category> findAll = em.createQuery("select c from Category c where c.parent IS NULL", Category.class).getResultList();
        final List<CategoryVO> catVos = new ArrayList<>();
        for (Category c : findAll) {
            catVos.add(toCategoryVO(c));
        }
        return catVos;
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
