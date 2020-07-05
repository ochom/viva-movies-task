package com.lysofts.vivax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lysofts.vivax.models.Movie;
import com.lysofts.vivax.utils.JDBCUtils;

public class MovieDAO {

    private static final String INSERT_MOVIES_SQL = "INSERT INTO movies" +
        "  (title, thumbnail, description, released,  episodes) VALUES " + " (?, ?, ?, ?, ?);";

    private static final String SELECT_MOVIE_BY_ID = "select id,title,thumbnail, description,released,episodes from movies where id =?";
    private static final String SELECT_ALL_MOVIES = "select * from movies";
    private static final String DELETE_MOVIE_BY_ID = "delete from movies where id = ?;";
    private static final String UPDATE_MOVIE = "update movies set title = ?, thumbnail=?, description= ?, released =?, episodes =? where id = ?;";

    public MovieDAO() {}

    public void insertMovie(Movie movie) throws SQLException {
        System.out.println(INSERT_MOVIES_SQL);
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIES_SQL)) {
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getThumbnail());
            preparedStatement.setString(3, movie.getDescription());
            preparedStatement.setDate(4, JDBCUtils.getSQLDate(movie.getReleased()));
            preparedStatement.setInt(5, movie.getEpisodes());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
    }

    
    public Movie selectMovie(long movieId) {
        Movie movie = null;
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIE_BY_ID);) {
            preparedStatement.setLong(1, movieId);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String thumbnail = rs.getString("thumbnail");
                String description = rs.getString("description");
                LocalDate released = rs.getDate("released").toLocalDate();
                int episodes = rs.getInt("episodes");
                movie = new Movie(id, title,thumbnail, description, released, episodes);
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return movie;
    }
    

    public List<Movie> selectAllMovies() {
        List <Movie> movies = new ArrayList < > ();
        try (Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String thumbnail = rs.getString("thumbnail");
                String description = rs.getString("description");
                LocalDate released = rs.getDate("released").toLocalDate();
                int episodes = rs.getInt("episodes");
                movies.add(new Movie(id, title,thumbnail, description, released, episodes));
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return movies;
    }

    public boolean deleteMovie(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_MOVIE_BY_ID);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    
    public boolean updateMovie(Movie movie) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = JDBCUtils.getConnection(); 
    		PreparedStatement pst = connection.prepareStatement(UPDATE_MOVIE);) {
        	pst.setString(1, movie.getTitle());
        	pst.setString(2, movie.getThumbnail());
        	pst.setString(3, movie.getDescription());
            pst.setDate(4, JDBCUtils.getSQLDate(movie.getReleased()));
            pst.setInt(5, movie.getEpisodes());
            pst.setString(6, movie.getId());
            rowUpdated = pst.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
