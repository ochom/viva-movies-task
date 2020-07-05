package com.lysofts.vivax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lysofts.vivax.models.LoginModel;
import com.lysofts.vivax.utils.JDBCUtils;

public class LoginDAO {
	public boolean validate(LoginModel loginModel) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from users where email = ? and password = ? ")) {
            preparedStatement.setString(1, loginModel.getEmail());
            preparedStatement.setString(2, loginModel.getPassword());
            
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return status;
    }
}
