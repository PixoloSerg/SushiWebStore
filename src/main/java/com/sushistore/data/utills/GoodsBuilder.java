/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.utills;

import com.sushistore.data.entities.Goods;
import java.math.BigDecimal;

/**
 *
 * @author P5
 */
public class GoodsBuilder {
    
    private final Goods goods;

    public GoodsBuilder() {
        goods = new Goods();
    }
    
    public GoodsBuilder addId(Integer id) {
        goods.setId(id);
        return this;
    }
    
    public GoodsBuilder addGoodsName(String name) {
        goods.setGoodsName(name);
        return this;
    }
    
    public GoodsBuilder addPrice(BigDecimal price) {
        goods.setPrice(price);
        return this;
    }
    
    public GoodsBuilder addPoint(BigDecimal point) {
        goods.setPoint(point);
        return this;
    }
    
    public Goods build() {
        return goods;
    }
    
}
