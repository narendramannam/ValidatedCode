package com.tesco.retail.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.tesco.retail.dao.implementation.ClearanceSaleDAO;
import com.tesco.retail.domain.entites.ClearanceSale;

/**
 * Servlet implementation class AddSaleServlet
 */
public class AddSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSaleServlet() {
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
		String i=(String)joUser.get("saleid");
		int saleid=Integer.parseInt(i);
		String salename=(String) joUser.get("salename");
		SimpleDateFormat showDateFormat=new SimpleDateFormat("dd-mm-yyyy");
		Date fromdate=null;
		try {
			fromdate=showDateFormat.parse((String)joUser.get("fromDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		Date todate=null;
		try {
			todate=showDateFormat.parse((String) joUser.get("toDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		ClearanceSale clear=new ClearanceSale(saleid, salename, fromdate, todate);
		ClearanceSaleDAO cleardao=new ClearanceSaleDAO();
		cleardao.insertClearancesale(clear);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,HEAD,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-auth-token,Content-Type,Access-Control-Request-Method,Access-Controle-Request-Headers");
		out.println("Sale Addedd Successfully with Id "+saleid+" and Sale Name "+salename);
		out.flush();
		out.close();
	}

}
