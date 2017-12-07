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
public class LineItem implements Serializable {
    
    public static final String INVOICEID = "INVOICEID";
    public static final String GOODSID = "GOODSID";
    public static final String PRICE = "PRICE";
    public static final String SUMM = "SUMM";
    public static final String AMOUNT = "AMOUNT";
    public static final String POINT = "POINT";

    private static final long serialVersionUID = 123274801102L;
    private Long id;
    private Long invoiceId;
    private Integer goodsId;
    private BigDecimal price;
    private BigDecimal summ;
    private Integer amount;
    private BigDecimal point;
    
    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public Long getInvoiceId() {
	return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
	this.invoiceId = invoiceId;
    }

    public Integer getGoodsId() {
	return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
	this.goodsId = goodsId;
    }
    
    

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSumm() {
        return summ;
    }

    public void setSumm(BigDecimal summ) {
        this.summ = summ;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (!(object instanceof LineItem)) {
            return false;
        }
        LineItem other = (LineItem) object;
        if (
                (this.id == null && other.id != null) || 
                (this.id != null && !this.id.equals(other.id)) ||
                ( this.id == null && other.id == null && 
                    (this.invoiceId != other.invoiceId || this.goodsId != other.goodsId ) )
                ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sushistore.data.entities.LineItem[ id="
                + id
                + " invoiceId="
                + invoiceId
                + " goodsId=" 
                + goodsId
                + " price="
                + price
                + " summ="
                + summ
                + " amount="
                + amount
                + " point="
                + point
                + " ]";
    }
    
}
