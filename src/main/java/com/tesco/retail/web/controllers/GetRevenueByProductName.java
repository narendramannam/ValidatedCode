package com.tesco.retail.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.tesco.retail.dao.implementation.OrderDAO;
import com.tesco.retail.domain.entites.Invoice;
import com.tesco.retail.domain.entites.Order;

/**
 * Servlet implementation class GetRevenueByProductName
 */
public class GetRevenueByProductName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRevenueByProductName() {
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
		StringBuffer stringBuffer=new StringBuffer();
		
		try
		{
			BufferedReader reader=request.getReader();
			String line=null;
			while((line=reader.readLine())!=null)
			{
				stringBuffer.append(line);
			}
		}
		catch (Exception e) 
		{
			e.getMessage();
		}
		JSONParser parser=new JSONParser();
		JSONObject object=null;
		try
		{
			object=(JSONObject) parser.parse(stringBuffer.toString());
		}
		catch (Exception e) 
		{
			e.getMessage();
		}
		String frmDate=(String) object.get("fDate");
		String tDate=(String) object.get("tDate");
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate=null;
		Date toDate=null;
		try {
			fromDate=dateFormat.parse(frmDate);
			toDate=dateFormat.parse(tDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		OrderDAO orderDao=new OrderDAO();
		long x=toDate.getTime()-fromDate.getTime();
    	int days=(int) (x/(24*60*60*1000));
    	double finalAmount=0;
    	double cost=0;
    	Invoice invoice=null;
		while(days>=0)
		{
			List<Order> orders=orderDao.getListOfOrdersByDate(fromDate);
			if(orders!=null)
			{
				for(Order o: orders)
				{
					invoice=o.getInvoice();
					cost=invoice.getFinalAmount();
					finalAmount+=cost;
				}
			}
			fromDate=new Date(fromDate.getTime()+ (1000*60*60*24));
			days--;
		}
		
		
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin","http://localhost:63342" );
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,HEAD,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, x-auth-token, Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers ");
		
		Gson gson =new Gson();
		String jsonCategoryList = gson.toJson(finalAmount); 
		
		out.println(jsonCategoryList);
		
	}

}
