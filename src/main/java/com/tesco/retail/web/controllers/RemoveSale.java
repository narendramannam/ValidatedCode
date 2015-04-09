package com.tesco.retail.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.tesco.retail.dao.implementation.ClearanceSaleDAO;
import com.tesco.retail.domain.entites.ClearanceSale;

/**
 * Servlet implementation class RemoveSale
 */
public class RemoveSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveSale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		ClearanceSaleDAO dao=new ClearanceSaleDAO();
		List<ClearanceSale> listc=dao.getsale();
		Gson gson=new Gson();
		String salelist=gson.toJson(listc);
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,HEAD,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-auth-token,Content-Type,Access-Control-Request-Method,Access-Controle-Request-Headers");
		out.println(salelist);
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
