package com.lysofts.vivax.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lysofts.vivax.dao.LoginDAO;
import com.lysofts.vivax.dao.UserDAO;
import com.lysofts.vivax.models.LoginModel;
import com.lysofts.vivax.models.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDAO loginDAO;		

    public void init() {
    	loginDAO = new LoginDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("auth/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        authenticate(request, response);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginModel loginModel = new LoginModel();
        loginModel.setEmail(email);
        loginModel.setPassword(password);

        
        //HttpSession session = request.getSession();
        try {
            if (loginDAO.validate(loginModel)) {            	
            	User user = UserDAO.getAuthenticatedUser(email);
	        	HttpSession session = request.getSession();
	            session.setAttribute("user", user);
	            if(user.is_admin()) {
	                response.sendRedirect("list");
	            }else {
	                response.sendRedirect(request.getContextPath());           	
	            }
            } else {
                request.setAttribute("NOTIFICATION", "Login failed!");    
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
