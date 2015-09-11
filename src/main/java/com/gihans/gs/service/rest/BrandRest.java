/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Brand;
import com.gihans.gs.model.vo.BrandVO;
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
@Path("/brand")
public class BrandRest {

    @PersistenceContext(unitName = "gihans_PU")
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<BrandVO> findAll() {
        final List<Brand> findAll = em.createQuery("select b from Brand b where b.active=TRUE", Brand.class).getResultList();
        final List<BrandVO> brands = new ArrayList<>();
        for (final Brand b : findAll) {
            brands.add(new BrandVO(b));
        }
        return brands;
    }

    @GET
    @Path("withInactive")
    @Produces("application/json")
    public List<BrandVO> findAllWithInactive() {
        final List<Brand> findAll = em.createQuery("select b from Brand b", Brand.class).getResultList();
        final List<BrandVO> brands = new ArrayList<>();
        for (final Brand b : findAll) {
            brands.add(new BrandVO(b));
        }
        return brands;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public BrandVO save(final BrandVO brandVO) {
        final Brand toBrand = brandVO.toBrand();
        if (brandVO.id == -1l) {
            toBrand.setId(null);
            toBrand.setActive(Boolean.TRUE);
            em.persist(toBrand);
        } else {
            em.merge(toBrand);
        }
        return brandVO;
    }

}
