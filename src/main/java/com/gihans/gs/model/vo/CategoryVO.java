/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import java.util.List;

/**
 *
 * @author echamam
 */
public class CategoryVO extends IdNameVO {

    public boolean selected;
    public List<CategoryVO> subCategories;
    public CategoryVO parentCategory;
    public boolean active;

    public CategoryVO() {
        id = -1l;
    }

}
