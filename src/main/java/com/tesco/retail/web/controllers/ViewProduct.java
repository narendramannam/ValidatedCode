package com.tesco.retail.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tesco.retail.dao.implementation.ProductDiscountDAO;
import com.tesco.retail.domain.entites.ProductDiscount;

/**
 * Servlet implementation class ViewProduct
 */
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ProductDiscount> productDiscountList=new ArrayList<ProductDiscount>();
		ProductDiscountDAO pdao=new ProductDiscountDAO();
		productDiscountList=pdao.getProduct();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,HEAD,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-auth-token,Content-Type,Access-Control-Request-Method,Access-Controle-Request-Headers");
		Gson gson =new Gson();
		String jsonCategoryList = gson.toJson(productDiscountList); 
		out.println(jsonCategoryList);
	}

}
