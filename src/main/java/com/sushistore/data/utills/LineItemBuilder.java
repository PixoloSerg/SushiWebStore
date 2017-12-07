/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.utills;

import com.sushistore.data.entities.*;
import java.math.BigDecimal;

/**
 *
 * @author Sveta
 */
public class LineItemBuilder {
    
    private LineItemWrapper item;
    
    public LineItemWrapper build() {
        item.update();
	return item;
    }

    private LineItemWrapper createItem() {
	if(item == null) {
	    item = new LineItemWrapper(new LineItem());
            
	    item.getLineItem().setAmount(1);
	    item.getLineItem().setPoint(BigDecimal.valueOf(0, 2));
	    item.getLineItem().setPrice(BigDecimal.valueOf(0, 2));
	    item.getLineItem().setSumm(BigDecimal.valueOf(0, 2));
	}
	return item;
    }   
    
    public LineItemBuilder() {
	createItem();
    }
    
    public LineItemBuilder addId(Long id) {
	item.getLineItem().setId(id);
	return this;
    }
    
    public LineItemBuilder addInvoice(Invoice invoice) {
	item.setInvoice(invoice);
	return this;
    }
    
    public LineItemBuilder addGoods(Goods goods) {
	item.setGoods(goods);	
	return this;
    }
    
    public LineItemBuilder addAmount(Integer amount) {
	item.setAmount(amount);
	return this;
    }

}