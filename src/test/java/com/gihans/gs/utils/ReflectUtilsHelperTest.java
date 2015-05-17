/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author echamam
 */
public class ReflectUtilsHelperTest {

    public ReflectUtilsHelperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setValue method, of class ReflectUtilsHelper.
     */
    @Test
    public void testSetValue() {
        final String filed = "[].a";
        for (String s : filed.split("\\[].")) {
            System.out.println(" ss -" + s + "-");
        }
        
        System.out.println(filed.substring(filed.indexOf("[].") + 3));
        
    }

}
