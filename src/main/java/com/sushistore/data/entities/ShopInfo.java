/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.entities;

import java.io.Serializable;

/**
 *
 * @author P5
 */
public class ShopInfo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Offer offer;
    private SaleBlock saleBlock;
    private RecommendBlock recommendBlock;
    private String popularBandTitle;
    private String newBandTitle;
    private String shopSlogan;

    public String getShopSlogan() {
        return shopSlogan;
    }

    public void setShopSlogan(String shopSlogan) {
        this.shopSlogan = shopSlogan;
    }

    public String getPopularBandTitle() {
        return popularBandTitle;
    }

    public void setPopularBandTitle(String popularBandTitle) {
        this.popularBandTitle = popularBandTitle;
    }

    public String getNewBandTitle() {
        return newBandTitle;
    }

    public void setNewBandTitle(String newBandTitle) {
        this.newBandTitle = newBandTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public SaleBlock getSaleBlock() {
        return saleBlock;
    }

    public void setSaleBlock(SaleBlock saleBlock) {
        this.saleBlock = saleBlock;
    }

    public RecommendBlock getRecommendBlock() {
        return recommendBlock;
    }

    public void setRecommendBlock(RecommendBlock recommendBlock) {
        this.recommendBlock = recommendBlock;
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
    }
    private About about;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopInfo)) {
            return false;
        }
        ShopInfo other = (ShopInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sushistore.data.entities.ShopInfo[ id=" 
                + id 
                + " ]";
    }
    
}
