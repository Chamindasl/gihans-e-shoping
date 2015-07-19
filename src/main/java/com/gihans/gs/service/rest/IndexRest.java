/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Category;
import com.gihans.gs.model.vo.IndexVO;
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

    @PersistenceContext(unitName = "com.gihans_gs_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public IndexVO create(IndexVO indexVO) {
        return indexVO;
    }

}
