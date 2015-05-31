
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0654437
 */
public class Inventory {


    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("JDBC Driver Not Found: " + ex.getMessage());
        }

        try {
            String jdbc = "jdbc:mysql://ipro.lambton.on.ca/inventory";
            conn = DriverManager.getConnection(jdbc, "products", "products");
        } catch (SQLException ex) {
            System.err.println("Failed to Connect: " + ex.getMessage());
        }
        return conn;
    }

   
    public static int getQuantityForId(int id) {
        int quantity = -1;
        try {
            Connection conn = getConnection();        
            String query = "SELECT quantity FROM inventory WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);            
            ResultSet rs = pstmt.executeQuery();            
            rs.first();
            quantity = rs.getInt("quantity");
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Failed to Get Quantity for ID " + id + ": " + ex.getMessage());
        }
        return quantity;
    }
}

    

