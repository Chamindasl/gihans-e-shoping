/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Province;
import com.gihans.gs.model.vo.ProvinceVO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("/provinceVO")
public class ProvinceRest {

    @PersistenceContext(unitName = "gihans_PU")
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<ProvinceVO> findAll() {
        final List<Province> findAll = em.createQuery("select p from Province p", Province.class).getResultList();
        final List<ProvinceVO> proviceVos = new ArrayList<>();
        for (final Province p : findAll) {
            proviceVos.add(new ProvinceVO(p));
        }
        return proviceVos;
    }

}
