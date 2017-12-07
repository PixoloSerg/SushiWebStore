/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.utills;

import com.sushistore.data.controllers.GoodsController;
import com.sushistore.data.controllers.InvoiceController;
import com.sushistore.data.entities.Goods;
import com.sushistore.data.entities.Invoice;
import com.sushistore.data.entities.LineItem;
import java.math.BigDecimal;

/**
 *
 * @author P5
 */
public class LineItemWrapper {
    
    private final LineItem lineItem;
    private Goods goods;
    private Invoice invoice;

    /**
     * Get the value of lineItem.amount
     *
     * @return the value of lineItem.amount
     */
    public Integer getAmount() {
        return lineItem.getAmount();
    }

    /**
     * Set the value of lineItem.amount
     *
     * @param amount new value of lineItem.amount
     */
    public void setAmount(Integer amount) {
        if(amount == null || amount <= 0)
            throw new RuntimeException(
                    this.getClass().getName() + ".setAmount: parameter 'amount' must be more than 0");
        this.lineItem.setAmount(amount);
    }
    
    /**
     * Return plain database presentation
     * @return LineItem
     */
    public LineItem getLineItem() {
        return lineItem;
    }
    /**
    * Create wrapper from data retrieved from database directly.
    * 
    * @param lineItem to obtain use LineItemController
    */
    public LineItemWrapper(LineItem lineItem) {
        this.lineItem = lineItem;        
    }

    /**
     * Lazy initialization used.
     * @return 
     */
    public Goods getGoods() {
        if(goods == null) 
            goods = GoodsController.getGoodsById(lineItem.getGoodsId());
        return goods;
    }

    public void setGoods(Goods goods) {
        if(goods == null)
            throw new NullPointerException(
                    this.getClass().getName() + ".setGoods: parameter 'goods' can't be null");        
        this.goods = goods;
        lineItem.setGoodsId( goods.getId() );
        lineItem.setPrice(goods.getPrice());
    }

    /**
     * Lazy initialization used.
     * @return 
     */
    public Invoice getInvoice() {
        if(invoice == null)
            invoice = InvoiceController.getInvoiceById(lineItem.getInvoiceId());
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        if(invoice == null)
            throw new NullPointerException(
                    this.getClass().getName() + ".setInvoice: parameter 'invoice' can't be null");             
        this.invoice = invoice;
        lineItem.setInvoiceId(invoice.getId());        
    }
    
    public void update() {
        BigDecimal amount = BigDecimal.valueOf( lineItem.getAmount().longValue() );
        lineItem.setPoint( goods.getPoint().multiply( amount ) );
        lineItem.setSumm( goods.getPrice().multiply( amount ) );
    }
    
}
