/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author echamam
 */
public class IndexVO {

    public CategoryVO selectedCategory;
    public List<ItemVO> featuredItems = new ArrayList<>();
    public List<ItemVO> recommendedItems = new ArrayList<>();
    public List<ItemVO> cartItems = new ArrayList<>();
    public List<CategoryVO> categories = new ArrayList<>();
    public List<BrandVO> brands = new ArrayList<>();
    public ItemVO addedItemVO;
    public BrandVO selectedBrand;
}
