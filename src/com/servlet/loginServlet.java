package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operation.operClass;
import bean.demoBean;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		RequestDispatcher rd = null;
		
		if(request.getParameter("key")!=null){
		
			if(request.getParameter("key").equals("login")){
				
				if(request.getParameter("txtUserName").equals("abc") && request.getParameter("txtPsw").equals("abc")){
					rd=request.getRequestDispatcher("/home.jsp");  
					rd.forward(request, response); 
					
				}
			}
			
			if(request.getParameter("key").equals("add")){
				demoBean bean = new demoBean();
				bean.setName( request.getParameter("txtName") );
				bean.setAdd(request.getParameter("txtAdd"));
				
				
				operClass obj = new operClass();
				boolean flag = obj.insert(bean);
				
				
				if(flag){
					ArrayList<demoBean> list = obj.getDemo();
					request.setAttribute("listSession", list);
					//request.getSession().setAttribute("listSession", list);
					
					
				}
				
				rd=request.getRequestDispatcher("/list.jsp");  
				rd.forward(request, response); 
				
				
				
				
				System.out.println("Inside servlet add key");
				
			}
			
			
			
		}
		
	}

}
