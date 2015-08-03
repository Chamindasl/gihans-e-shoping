/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.model.vo;

import com.gihans.gs.model.Category;
import com.gihans.gs.model.Item;
import java.text.SimpleDateFormat;

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
    public String freshTxt;
    public String saleTxt;
    public double price;
    public int noOfItems;
    public boolean inCart;
    public boolean featured;
    public int stock;
    public String startFrom;
    public String featuredTxt;
    public CategoryVO categoryVO;
    public BrandVO brandVO;

    public ItemVO() {

    }

    public ItemVO(final Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.cartImage = item.getCartImage();
        this.categoryVO = new CategoryVO();
        this.brandVO = new BrandVO();
        this.fresh = item.getFresh();
        this.sale = item.getOnSale();
        this.featured = item.getFeatured();
        this.indexImage = item.getIndexImage();
        this.mainImage = item.getMainImage();
        this.noOfItems = item.getStock();
        this.price = item.getPrice();
        this.stock = item.getStock();
        this.featuredTxt = this.featured ? "Featured" : "";
        this.freshTxt = this.fresh ? "New" : "";
        this.saleTxt = this.sale ? "Sale" : "";
        final Category category = item.getCategory();
        if (null != category) {
            this.categoryVO.id = category.getId();
            this.categoryVO.name = category.getName();
        }
        if (null != item.getBrand()) {
            this.brandVO = new BrandVO(item.getBrand());
        }
        if (null != item.getStartFrom()) {
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.startFrom = sdf.format(item.getStartFrom());
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVO other = (ItemVO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
