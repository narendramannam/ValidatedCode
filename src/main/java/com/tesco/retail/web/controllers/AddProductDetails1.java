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
import com.tesco.retail.dao.implementation.InventoryDAO;
import com.tesco.retail.domain.entites.Inventory;
import com.tesco.retail.domain.entites.Product;
import com.tesco.retail.domain.entites.ProductDiscount;

/**
 * Servlet implementation class AddProductDetails1
 */
public class AddProductDetails1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductDetails1() {
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
		
		StringBuffer sb=new StringBuffer();
		try{
			BufferedReader reader=request.getReader();
			String line=null;
			while((line=reader.readLine())!=null){
				sb.append(line);
			}
		}
		catch(Exception e){
			e.getMessage();
		}
		JSONParser parser= new JSONParser();
		JSONObject joUser=null;
		
		try{
			joUser=(JSONObject) parser.parse(sb.toString());
		}
		catch(Exception e){
			e.getMessage();
		}
		/* add product*/
		InventoryDAO inventoryDAO=new InventoryDAO();
	    List<Inventory> inventory=inventoryDAO.getInventory();   
	    Product product;
	    ProductDiscount discount;
	    int quantity;
	    List<Product> products=new ArrayList<Product>();
	    for(Inventory p:inventory)
	    {
	    	product=p.getProduct();
	    	quantity=p.getQuantity();
	    	Date expiryDate=product.getExpiryDate();
	    	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	    	Date date=new Date();
	    	String curntDate=dateFormat.format(date);
	    	Date currentDate=null;
			try {
				currentDate = dateFormat.parse(curntDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
	    	long x=expiryDate.getTime()-currentDate.getTime();
	    	int days=(int) (x/(24*60*60*1000));
	    	int qty=0;
	    	
	    	if( (days<=60) || (qty>=(quantity/2)) )
	    	{
	    		products.add(product);
	    	}
	    	
	    }
		/*end*/
	    PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,HEAD,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-auth-token,Content-Type,Access-Control-Request-Method,Access-Controle-Request-Headers");
		
		Gson gson =new Gson();
		String jsonCategoryList = gson.toJson(products); 
		
		out.println(jsonCategoryList);
		
		
	}

}
