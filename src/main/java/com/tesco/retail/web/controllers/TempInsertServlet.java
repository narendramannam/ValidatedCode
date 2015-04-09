package com.tesco.retail.web.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tesco.retail.dao.implementation.InventoryDAO;
import com.tesco.retail.dao.implementation.ProductDAO;
import com.tesco.retail.domain.entites.Inventory;
import com.tesco.retail.domain.entites.Product;

/**
 * Servlet implementation class TempInsertServlet
 */
public class TempInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TempInsertServlet() {
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
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-mm-yyyy");
		String d="01-12-2014";
		String di="01-04-2015";
		Date d1 = null;
		Date d2= null;
		try {
			d1 = dateformat.parse(d);
			d2=dateformat.parse(di);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		Product product=new Product(2, "Nokia", "good product", 20000.00,d1, 10,null, null);
		Inventory inventory=new Inventory(2, product, d2, 20);
		ProductDAO pdao=new ProductDAO();
		pdao.insertProduct(product);
		InventoryDAO idao=new InventoryDAO();
		idao.insertIntventory(inventory);
		
	}

}
