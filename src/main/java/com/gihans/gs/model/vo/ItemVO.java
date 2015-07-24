/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.Category;
import com.gihans.gs.model.Item;

/**
 *
 * @author echamam
 */
public class ItemVO {

    public long id;
    public String name;
    public String mainImage;
    public String indexImage;
    public String cartImage;
    public boolean fresh;
    public boolean sale;
    public double price;
    public int noOfItems;
    public CategoryVO categoryVO;

    public ItemVO() {

    }

    public ItemVO(final Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.cartImage = item.getCartImage();
        this.categoryVO = new CategoryVO();
        this.fresh = item.getFresh();
        this.indexImage = item.getIndexImage();
        this.mainImage = item.getMainImage();
        this.noOfItems = item.getStock();
        this.price = item.getPrice();
        final Category category = item.getCategory();
        if (null != category) {
            this.categoryVO.id = category.getId();
            this.categoryVO.name = category.getName();
        }
    }
}
