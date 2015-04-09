

package com.tesco.retail.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.tesco.retail.dao.implementation.ProductDAO;
import com.tesco.retail.dao.implementation.ProductDiscountDAO;
import com.tesco.retail.domain.entites.Product;
import com.tesco.retail.domain.entites.ProductDiscount;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
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
		int id=Integer.parseInt((String)joUser.get("pid"));
		int discount=Integer.parseInt((String)joUser.get("discount"));
		
		ProductDAO productDAO=new ProductDAO();
		Product product=productDAO.getProductById(id);
		ProductDiscount productDiscount=new ProductDiscount(discount, product);
		ProductDiscountDAO productDiscountDAO=new ProductDiscountDAO();
		productDiscountDAO.insertProductDiscount(productDiscount);
		String result="Product with id "+id+" Added successfully";
		PrintWriter out=response.getWriter();
		response.setContentType("application/json; charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,HEAD,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-auth-token,Content-Type,Access-Control-Request-Method,Access-Controle-Request-Headers");
		Gson gson =new Gson();
		String jsonCategoryList = gson.toJson(result); 
		out.println(jsonCategoryList);
	}

}
