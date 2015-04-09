package com.tesco.retail.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.tesco.retail.dao.implementation.ClearanceSaleDAO;
import com.tesco.retail.dao.implementation.InventoryDAO;
import com.tesco.retail.domain.entites.ClearanceSale;
import com.tesco.retail.domain.entites.Inventory;
import com.tesco.retail.domain.entites.Product;
import com.tesco.retail.domain.entites.ProductDiscount;

/**
 * Servlet implementation class AddProductDetails
 */
public class AddProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClearanceSaleDAO clearanceSaleDAO=new ClearanceSaleDAO();
		List<ClearanceSale> clearanceSales=clearanceSaleDAO.getsale();
		List<Integer> ids=new ArrayList<Integer>();
		for(ClearanceSale sale:clearanceSales)
		{
			int id=sale.getClearanceSaleId();
			ids.add(id);
		}
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,HEAD,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-auth-token,Content-Type,Access-Control-Request-Method,Access-Controle-Request-Headers");
		
		Gson gson =new Gson();
		String jsonCategoryList = gson.toJson(ids); 
		out.println(jsonCategoryList);
		
			}
	

}
