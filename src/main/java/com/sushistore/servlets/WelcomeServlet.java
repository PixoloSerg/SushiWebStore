/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.servlets;

import com.sushistore.data.controllers.AddressController;
import com.sushistore.data.controllers.CategoryController;
import com.sushistore.data.controllers.GoodsController;
import com.sushistore.data.controllers.ScheduleController;
import com.sushistore.data.utills.ShoppingCart;
import com.sushistore.data.controllers.ShopInfoController;
import com.sushistore.data.entities.Address;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sveta
 */
public class WelcomeServlet extends HttpServlet {
    
    public static final String REQ_ATTR_SHOPINFO = "shopInfo";
    public static final String REQ_ATTR_VISIBLECATS = "visibleCategories";
    public static final String REQ_ATTR_MENUCATS = "menuCategories";
    public static final String REQ_ATTR_RECOMMEND_GOODS = "recommendGoods";
    public static final String REQ_ATTR_NEW_GOODS = "newGoods";
    public static final String REQ_ATTR_SALE_GOODS = "saleGoods";
    public static final String REQ_ATTR_POPULAR_GOODS = "popularGoods";
    public static final String REQ_ATTR_ADDRESSES = "addresses";
    public static final String REQ_ATTR_LOCATION = "location";
    public static final String REQ_ATTR_SCHEDULE = "schedule";
    public static final String REQ_ATTR_SCHEDULE_LIST = "scheduleList";
    public static final String REQ_ATTR_PAGE_TITLE = "pageTitle";
    public static final String REQ_ATTR_SHOPCART = "shopCart";    
    
    public static final String SESSION_ATTR_SHOPCART = "shopCart";    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(REQ_ATTR_SHOPINFO, 
                ShopInfoController.getShopInfo());        
        request.setAttribute(REQ_ATTR_VISIBLECATS, 
                CategoryController.getCategoriesByVisibility());        
        request.setAttribute(REQ_ATTR_MENUCATS, 
                CategoryController.getCategoriesByMenu());
        request.setAttribute(REQ_ATTR_RECOMMEND_GOODS, 
                GoodsController.getGoodsByRecommendation());
        request.setAttribute(REQ_ATTR_NEW_GOODS, 
                GoodsController.getGoodsByNew());
        request.setAttribute(REQ_ATTR_SALE_GOODS, 
                GoodsController.getGoodsBySale());
        request.setAttribute(REQ_ATTR_POPULAR_GOODS, 
                GoodsController.getGoodsByPopularity());
        request.setAttribute(REQ_ATTR_ADDRESSES, 
                AddressController.getAddresses());
        //TODO: need to retrive client location
        Address location = AddressController.getAddressByCity("New-York");
        request.setAttribute(REQ_ATTR_LOCATION, 
                location);
        request.setAttribute(REQ_ATTR_SCHEDULE, 
                ScheduleController.getFormattedScheduleByAddress(location));    
	request.setAttribute(REQ_ATTR_SCHEDULE_LIST, 
		ScheduleController.getBlockedScheduleByAddress(location));
        
        HttpSession session = request.getSession();
        if(session.getAttribute(SESSION_ATTR_SHOPCART) == null) 
            session.setAttribute(SESSION_ATTR_SHOPCART, new ShoppingCart());
        request.setAttribute(REQ_ATTR_SHOPCART, session.getAttribute(SESSION_ATTR_SHOPCART));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
