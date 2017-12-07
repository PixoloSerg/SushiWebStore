/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author P5
 */
public class Goods implements Serializable {

    private static final long serialVersionUID = 1707093247031L;
    private Integer id;
    private Integer groupId;
    private String goodsName;
    private String ingridients;
    private Integer weight;
    private Integer protein;
    private Integer calorie;
    private Integer fat;
    private Integer carbohydrate;
    private String description;
    private String images;
    private Boolean popular;
    private Byte popularity;
    private Boolean recommend;
    private Byte recommendation;
    private Boolean sale;
    private Byte saleWeight;
    private Boolean isNew;
    private Byte newer;
    private Boolean chef;
    private Boolean vegetarian;
    private Boolean spicy;
    private BigDecimal price;
    private BigDecimal point;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getCalorie() {
        return calorie;
    }

    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Integer carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Boolean getPopular() {
        return popular;
    }

    public void setPopular(Boolean popular) {
        this.popular = popular;
    }

    public Byte getPopularity() {
        return popularity;
    }

    public void setPopularity(Byte popularity) {
        this.popularity = popularity;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Byte getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Byte recommendation) {
        this.recommendation = recommendation;
    }

    public Boolean getSale() {
        return sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public Byte getSaleWeight() {
        return saleWeight;
    }

    public void setSaleWeight(Byte saleWeight) {
        this.saleWeight = saleWeight;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Byte getNewer() {
        return newer;
    }

    public void setNewer(Byte newer) {
        this.newer = newer;
    }

    public Boolean getChef() {
        return chef;
    }

    public void setChef(Boolean chef) {
        this.chef = chef;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getSpicy() {
        return spicy;
    }

    public void setSpicy(Boolean spicy) {
        this.spicy = spicy;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goods)) {
            return false;
        }
        Goods other = (Goods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sushistore.data.entities.Goods[ id=" 
                + id 
                + " ]";
    }
    
}
