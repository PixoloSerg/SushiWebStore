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
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer parent_id;
    private String categoryName;
    private String description;
    private String icon;
    private String image;
    private Short weight;
    private Boolean visible;
    private Boolean inmenu;

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Short getWeight() {
        return weight;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getInmenu() {
        return inmenu;
    }

    public void setInmenu(Boolean inmenu) {
        this.inmenu = inmenu;
    }

    public Short getMenuWeight() {
        return menuWeight;
    }

    public void setMenuWeight(Short menuWeight) {
        this.menuWeight = menuWeight;
    }
    private Short menuWeight;
    
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
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sushistore.data.entities.Category[ id=" 
                + id 
                + " ]";
    }
    
}
