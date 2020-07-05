package com.lysofts.vivax.dao;

import com.lysofts.vivax.models.User;
import com.lysofts.vivax.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
    public int registerUser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (username, email, password) VALUES " +
            " (?, ?, ?);";

        int result = 0;
        try (Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return result;
    }
    
    public static User getAuthenticatedUser(String email) {
    	User user = null;
    	String INSERT_USERS_SQL = "SELECT id, username, email, is_admin FROM users where email=?";

            try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
                preparedStatement.setString(1, email);
                
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                	user = new User(
                			resultSet.getString("username"),
                			resultSet.getString("email"),
                			resultSet.getInt("is_admin")==1
                			);                		
            	}
            } catch (SQLException e) {
                JDBCUtils.printSQLException(e);
            }
    	return user;
    }
}
