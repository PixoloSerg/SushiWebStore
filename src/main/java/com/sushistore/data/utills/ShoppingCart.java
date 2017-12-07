/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.utills;

import com.sushistore.data.controllers.GoodsController;
import com.sushistore.data.entities.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author P5
 */
public class ShoppingCart {
    /**
     * Temprorary id for lineitem
     */
    private Long id = 0L;
    private Client client;
    /**
     * Only read access
     */
    private final InvoiceWrapper invoice;
    /**
     * Only read access
     */
    private List<LineItemWrapper> lineItems;
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if(client == null)
            throw new NullPointerException(
                    this.getClass().getName() + ".setClient: param 'client' is null");
        this.client = client;
        invoice.setClient(client);
    }

    public InvoiceWrapper getInvoice() {
        return invoice;    
    }

    public ShoppingCart() {
        Invoice i = new Invoice();
        i.setInvoiceDate(LocalDateTime.now());
        i.setPointsSum(BigDecimal.valueOf(0, 2));
        i.setTotalAmount(0);
        i.setTotalSum(BigDecimal.valueOf(0, 2));
        invoice = new InvoiceWrapper(i);        
        lineItems = new ArrayList<>();        
    }

    public List<LineItemWrapper> getLineItems() {
        return lineItems;
    }
        
    public void deleteLineItemById(long id) {
        for(int i=0; i<lineItems.size(); i++) {
            if(lineItems.get(i).getLineItem().getId() == id ) {
                lineItems.remove(i);
                break;
            }
        }
        updateInvoice();
    }
    
    public void deleteLineItemByGoods(Goods goods) {
        lineItems = getLineItems().stream().filter( 
                    (item) -> {
                        return !Objects.equals(item.getGoods(), goods);
                    }).collect( Collectors.toList() );
        updateInvoice();
    }
    
    public void updateLineItem(LineItemWrapper item, Integer qnt) {        
        item.setAmount(qnt);
        item.update();
    }
    
    public Long addGoods(Goods goods, Integer qnt) {
	LineItemWrapper lineItem;        
	for(int i=0; i<getLineItems().size(); i++) {
	    lineItem = getLineItems().get(i);
	    if( lineItem.getGoods().equals( goods ) ) {
                updateLineItem(lineItem, lineItem.getAmount() + qnt);
                updateInvoice();
                return lineItem.getLineItem().getId();
	    }
	}
	lineItem = new LineItemBuilder()
                .addId(++id).addInvoice(invoice.getInvoice())
                .addGoods(goods).addAmount(qnt).build();
	lineItems.add(lineItem);
        updateInvoice();
        return lineItem.getLineItem().getId();
    }
    
    public Long addGoods(Integer goodsId, Integer qnt) {
	Goods goods = GoodsController.getGoodsById(goodsId);
	return addGoods(goods, qnt);
    }
    
    public void updateLineItem(long id, Integer qnt) {
        if(qnt <= 0 ) 
            throw new IllegalArgumentException(
                    this.getClass() + ".setLineItemQnt: param 'qnt' must be more than zero");
        LineItemWrapper line = lineItems.stream().filter( (item) -> (item.getLineItem().getId() == id) )
                .findFirst().orElse(null);
        line.setAmount(qnt);
        line.update();
        updateInvoice();
    }
    

    private void updateInvoice() {        
        List<LineItem> list = new ArrayList<>(lineItems.size());
        //Retrieve LineItem list from LineItemWrapper list
        lineItems.forEach((item) -> {
            list.add(item.getLineItem());
        });
        invoice.setLineItems(list);
        invoice.update();
    }
    
}
