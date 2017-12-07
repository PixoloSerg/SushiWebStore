/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.servlets;

import com.sushistore.data.utills.ShoppingCart;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sveta
 */
@WebServlet(name = "ShopCart", urlPatterns = {"/shopcart"})
public class ShoppingCartServlet extends HttpServlet {
    
    public static final String REQ_PRM_GOODS_ID = "goodsId";
    public static final String REQ_PRM_GOODS_QNT = "goodsQnt";
    public static final String REQ_PRM_ITEM_ID = "itemId";
    public static final String REQ_PRM_ITEM_QNT = "itemQnt";
    public static final String REQ_PRM_ADD_GOODS = "addGoods";
    public static final String REQ_PRM_SET_ITEM = "setItem";
    public static final String REQ_PRM_DEL_ITEM = "delItem";

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	getServletContext()
		.getRequestDispatcher("/pages/shoppingCartPage.jsp")
		.forward(request, response);	
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ShoppingCart cart = (ShoppingCart) request.getSession()
                .getAttribute(WelcomeServlet.SESSION_ATTR_SHOPCART );	
	try {            
	    if(request.getParameter(REQ_PRM_ADD_GOODS) != null) {	
		Integer goodsId = Integer.parseInt( request.getParameter(REQ_PRM_GOODS_ID) );
		Integer goodsQnt = Integer.parseInt( request.getParameter(REQ_PRM_GOODS_QNT) );
		cart.addGoods(goodsId, goodsQnt);	    
	    } else {
		Long itemId = Long.parseLong(request.getParameter(REQ_PRM_ITEM_ID) );		
		if(request.getParameter(REQ_PRM_SET_ITEM) != null) {
		    Integer itemQnt = Integer.parseInt(request.getParameter(REQ_PRM_ITEM_QNT) );
		    cart.updateLineItem(itemId, itemQnt);
		} else if(request.getParameter(REQ_PRM_DEL_ITEM) != null) {
		    cart.deleteLineItemById(itemId);
		}
	    }
	} catch(Exception e) {
	    throw new ServletException(e);
	}
	response.sendRedirect(request.getServletPath());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Shopping cart servlet.";
    }

}
