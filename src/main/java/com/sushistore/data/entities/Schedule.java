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
public class Schedule implements Serializable {
            
    public static final String BEGIN = "WORKBEGIN";
    public static final String END = "WORKEND";

    private static final long serialVersionUID = 1L;
    private Integer id;
    private BigDecimal begin;
    private BigDecimal end;

    public BigDecimal getBegin() {
        return begin;
    }

    public void setBegin(BigDecimal begin) {
        this.begin = begin;
    }

    public BigDecimal getEnd() {
        return end;
    }

    public void setEnd(BigDecimal end) {
        this.end = end;
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
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sushistore.data.entities.Schedule[ id=" + id + " ]";
    }
    
}
