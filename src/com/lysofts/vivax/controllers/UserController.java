package com.lysofts.vivax.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lysofts.vivax.dao.UserDAO;
import com.lysofts.vivax.models.User;


@WebServlet("/register")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

    public void init() {
    	userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("auth/register.jsp");
        dispatcher.forward(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
	        try {
	            int result = userDAO.registerUser(user);
	            if (result == 1) {
	            	user = UserDAO.getAuthenticatedUser(email);
	            	HttpSession session = request.getSession();
	                session.setAttribute("user", user);
	                if(user.is_admin()) {
		                response.sendRedirect("list");
		            }else {
		                response.sendRedirect("movies");           	
		            }
	            }else {
	                request.setAttribute("NOTIFICATION", "Registration failed!");            	
	            }
	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
