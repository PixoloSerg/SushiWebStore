/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author P5
 */
public class Invoice implements Serializable {   
    
    public static final String CLIENTID = "CLIENTID";
    public static final String INVOICEDATE = "INVOICEDATE";
    public static final String ADDRESS = "ADDRESS";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String TOTALAMOUNT = "TOTALAMOUNT";
    public static final String TOTALSUM = "TOTALSUM";
    public static final String POINTSSUM = "POINTSSUM";
    
    private static final long serialVersionUID = 1L;
    private Long id;
    private Integer clientId;
    private LocalDateTime invoiceDate;
    private String address;
    private String description;
    private Integer totalAmount;
    private BigDecimal totalSum;
    private BigDecimal pointsSum;
    

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public BigDecimal getPointsSum() {
        return pointsSum;
    }

    public void setPointsSum(BigDecimal pointssum) {
        this.pointsSum = pointssum;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sushistore.data.entities.Invoice[ id="
                + id
                + " clientId="
                + clientId
                + " invoiceDate="
                + invoiceDate
                + " address="
                + address
                + " description="
                + description
                + " totalAmount="
                + totalAmount
                + " totalSum="
                + totalSum
                + " pointsSum="
                + pointsSum
                + " ]";
    }
    
}
