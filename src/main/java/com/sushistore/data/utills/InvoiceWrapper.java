/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.utills;

import com.sushistore.data.controllers.ClientController;
import com.sushistore.data.controllers.LineItemController;
import com.sushistore.data.entities.Client;
import com.sushistore.data.entities.Invoice;
import com.sushistore.data.entities.LineItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author P5
 */
public class InvoiceWrapper {
    
    private final Invoice invoice;
    private List<LineItem> lineItems;
    private Client client;
    
    public InvoiceWrapper(Invoice invoice) {
        this.invoice = invoice;
    }
    
    public Invoice getInvoice() {
        return invoice;
    }

    public List<LineItem> getLineItems() {
        if(lineItems == null)
            setLineItems( LineItemController.getLineItemsByInvoice(invoice) );
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        if(lineItems == null)
            throw new IllegalArgumentException(
                    this.getClass().getName() + ".setLineItems: lineItems is null");
        this.lineItems = lineItems;
    }

    public Client getClient() {
        if(client == null)
            setClient(ClientController.getClientById(invoice.getClientId()));
        return client;
    }

    public void setClient(Client client) {     
        this.client = client;
        invoice.setClientId(client.getId());
    }
    
    public void update() {
        Integer amount = 0;
        BigDecimal sum = BigDecimal.valueOf(0, 2);
        BigDecimal points = BigDecimal.valueOf(0, 2);
        for(LineItem line : lineItems) {
            amount += line.getAmount();
            sum = sum.add(line.getSumm());
            points = points.add(line.getPoint());
        }
        invoice.setTotalAmount(amount);
        invoice.setTotalSum(sum);
        invoice.setPointsSum(points);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(invoice.toString()).append("\n");
        if(client != null) 
            res.append( client.toString() ).append( "\n" );
        lineItems.forEach((item) -> {
            res.append(item.toString()).append("\n");
        } );
        return res.toString();        
    }
    
        
}
