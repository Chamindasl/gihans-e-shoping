/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.utils;

import java.util.Collection;
import org.azeckoski.reflectutils.ReflectUtils;

/**
 *
 * @author echamam
 */
public class ReflectUtilsHelper {

    private static final ReflectUtils RU = ReflectUtils.getInstance();

    public static void setFieldValue(final Object object, final String field, final Object value) {
        if (field.contains("[]")) {
            final String[] singleFileds = field.split("\\[].");
            if (singleFileds[0].isEmpty()) {
                for(final Object o2 : (Collection)object) {
                    setFieldValue(o2, field.substring(field.indexOf("[].") + 3), value);
                }
            } else {
                for (final Object o2 : (Collection) RU.getFieldValue(object, singleFileds[0])) {
                    setFieldValue(o2, field.substring(field.indexOf("[].") + 3), value);
                }
            }

        } else {
            System.out.println(" set for " + object + " - " + field);
            RU.setFieldValue(object, field, value);
        }
    }

}
