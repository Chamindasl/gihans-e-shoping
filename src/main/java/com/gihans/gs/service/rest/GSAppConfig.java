/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author echamam
 */
@ApplicationPath("/rest")
public class GSAppConfig extends Application {

    private static final Set<Class<?>> CLASSES;

    static {
        final HashSet<Class<?>> tmp = new HashSet<>();
        tmp.add(IndexRest.class);
        tmp.add(ItemRest.class);

        CLASSES = Collections.unmodifiableSet(tmp);
    }

    @Override
    public Set<Class<?>> getClasses() {

        return CLASSES;
    }

}
