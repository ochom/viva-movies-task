package com.lysofts.vivax.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lysofts.vivax.dao.MovieDAO;
import com.lysofts.vivax.models.Movie;
import com.lysofts.vivax.models.User;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the movie.
 * 
 */

@WebServlet("/")
public class MovieController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MovieDAO movieDAO;

    public void init() {
        movieDAO = new MovieDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null && user.is_admin()) {
            try {
    	        switch (action) {
    	            case "/new":
    	            	showNewForm(request, response);	                
    	                break;
    	            case "/insert":
    	                insertMovie(request, response);
    	                break;
    	            case "/delete":
    	                deleteMovie(request, response);
    	                break;
    	            case "/edit":
    	                showEditForm(request, response);
    	                break;
    	            case "/update":
    	                updateMovie(request, response);
    	                break;
    	            case "/list":
    	                listMovie(request, response);
    	                break;
    	            case "/movie":
    	            	detailedMovie(request,response);
    	            	break;
    	            default:
    	            	listMoviePublic(request, response);
    	                break;
                	}
    	        } catch (SQLException ex) {
    	            throw new ServletException(ex);
    	        }
        	
        }else {
            try {
    	        switch (action) {
    	            case "/movie":
    	            	detailedMovie(request,response);
    	            	break;
    	            default :
    	            	listMoviePublic(request, response);
    	            	break;
    	        }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }        	
        }
    }

	private void listMovie(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Movie > listMovie = movieDAO.selectAllMovies();
        request.setAttribute("listMovie", listMovie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movie-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movie-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movie existingMovie = movieDAO.selectMovie(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movie-form.jsp");
        request.setAttribute("movie", existingMovie);
        dispatcher.forward(request, response);

    }

    private void insertMovie(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String title = request.getParameter("title");
        String thumbnail = request.getParameter("thumbnail");
        String description = request.getParameter("description");
        LocalDate released = LocalDate.parse(request.getParameter("released"));
        int episodes = Integer.parseInt(request.getParameter("episodes"));

        Movie newMovie = new Movie(title,thumbnail, description, released, episodes);
        movieDAO.insertMovie(newMovie);
        response.sendRedirect("list");
    }

    private void updateMovie(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id = request.getParameter("id");

        String title = request.getParameter("title");
        String thumbnail = request.getParameter("thumbnail");
        String description = request.getParameter("description");
        LocalDate released = LocalDate.parse(request.getParameter("released"));
        int episodes = Integer.parseInt(request.getParameter("episodes"));

        Movie updateMovie = new Movie(id, title,thumbnail, description, released, episodes);
        movieDAO.updateMovie(updateMovie);
        response.sendRedirect("list");
    }

    private void deleteMovie(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        movieDAO.deleteMovie(id);
        response.sendRedirect("list");
    }
    
    //Public pages


	private void listMoviePublic(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
        List < Movie > listMovie = movieDAO.selectAllMovies();
        request.setAttribute("listMovie", listMovie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie/all-movies.jsp");
        dispatcher.forward(request, response);
    }

    
    private void detailedMovie(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
        Movie existingMovie = movieDAO.selectMovie(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movie-detail.jsp");
        request.setAttribute("movie", existingMovie);
        dispatcher.forward(request, response);
    }
}