package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM department");
            while (resultSet.next()){
                System.out.println("Department ID: " + resultSet.getInt("Id") + "; Department Name: " + resultSet.getString("Name"));
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
