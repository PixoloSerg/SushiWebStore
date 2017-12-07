/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.servlets;

import com.sushistore.data.controllers.CategoryController;
import com.sushistore.data.controllers.GoodsController;
import com.sushistore.data.entities.Category;
import com.sushistore.data.entities.Goods;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author P5
 */
@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends WelcomeServlet {
    
    private static final String REQ_ATTR_CATEGORY = "category";
    private static final String REQ_ATTR_GOODS_LIST = "goodsList";    
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
        super.doGet(request, response);	
	Category category = CategoryController.getCategoryById(
		Integer.parseInt( request.getParameter("id") ) );
	List<Goods> goodsList = GoodsController.getGoodsByCategoryId(category.getId());	
	request.setAttribute(REQ_ATTR_CATEGORY, category);
	request.setAttribute(REQ_ATTR_GOODS_LIST, goodsList);	
	getServletContext()
		.getRequestDispatcher("/pages/category.jsp")
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "View categories of produtcts. Use 'id' parameter to specify category.";
    }

}
