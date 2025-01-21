package db;

import model.Items;
import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBConnection {


    private static Connection connection;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/sprintdjbc?useUnicode=true&serverTimezone=UTC","root", ""

            );
        }
        catch (ClassNotFoundException | java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Items> getItems() {
        List<Items> items = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ITEMS"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Items item = new Items();
                item.setId(resultSet.getLong("ID"));
                item.setName(resultSet.getString("NAME"));
                item.setDescription(resultSet.getString("DESCRIPTION"));
                item.setPrice(resultSet.getDouble("PRICE"));
                items.add(item);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return items;
    }

    public static String login(String email, String password) {
        Users user = getUserByEmail(email);
        if (user == null){
            return "EmailError";
        }
        if (!Objects.equals(user.getPassword(), password)) {
            return "PasswordError";
        }
        return "Success";
    }

    public static Users getUserByEmail(String email) {
        Users user = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM USERS WHERE EMAIL = ?"
            );
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                user = new Users();
                user.setId(resultSet.getLong("ID"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setFullName(resultSet.getString("FULL_NAME"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
