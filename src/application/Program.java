package application;

import db.DB;

import java.sql.*;

public class Program {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //Shows current table
            statement = conn.prepareStatement("SELECT * FROM department");
            resultSet = statement.executeQuery();

            System.out.println("Current Table from Database:\nID:\tNAME:");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("Id") + "\t" + resultSet.getString("Name"));
            }

            //Inserts a new department
            statement = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)");
            statement.setString(1, "Agapys Tecnologia");
            statement.executeUpdate();

            statement = conn.prepareStatement("SELECT * FROM department");
            resultSet = statement.executeQuery();

            System.out.println("\nUpdated Table from Database:\nID:\tNAME:");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("Id") + "\t" + resultSet.getString("Name"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
