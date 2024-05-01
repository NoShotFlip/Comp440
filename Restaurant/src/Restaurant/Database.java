package Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * Provides utilities for interacting with the restaurant reservation database.
 * @author 
 * @version 1.0
 * <p>

 * </p>
 */
public class Database {

    /**
     * Retrieves customer details from the database and constructs a table model with this data.
     *
     * @return the constructed table model with customer details.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    public static DefaultTableModel getCustomerDetailsModel() throws ClassNotFoundException, SQLException {
            String url = "jdbc:mysql://restaurant-database.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation";
            String username = "admin";
            String password = "01NoShotFlip$";
            String query = "select *from Customer_Details";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();

            // Add Columns to Model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Add Rows to Model
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            st.close();
            con.close();

            return model;
        }

    /**
     * Adds a customer to the database with the provided details.
     *
     * @param firstName The first name of the customer.
     * @param lastName The last name of the customer.
     * @param email The email of the customer.
     * @param number The table number of the customer.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void addtoCustomerDetails(String firstName, String lastName ,String email, int number ,String messageString) throws ClassNotFoundException, SQLException{
        
        String url = "jdbc:mysql://restaurant-database.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation";
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
         String query
            = "insert into Customer_Details(TableNum,First_Name,Last_Name,Email,Message) "+"values (?, ?, ?, ?, ?)"; // query to be run
        Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        
        //Statement st = con.createStatement();
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, number);
        preparedStmt.setString (2, firstName);
        preparedStmt.setString (3, lastName);
        preparedStmt.setString (4, email);
        preparedStmt.setString(5, messageString);
        preparedStmt.execute();
        
        //ResultSet rs
          //  = st.executeQuery(query);
        //System.out.println("ADDED");
        //rs.next(); 
        //st.close(); // close statement
        con.close(); // close connection   
    }

    /**
     * Deletes customer details associated with the provided table number.
     *
     * @param tableNum The table number of the customer to be deleted.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void deleteCustomerDetails(int tableNum) throws ClassNotFoundException, SQLException{
        String url = "jdbc:mysql://restaurant-database.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "DELETE FROM Customer_Details WHERE TableNum = ?"; // query to be run
        Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, tableNum);
        preparedStmt.executeUpdate();
        con.close(); // close connection  
    }

    /**
     * Retrieves table availability from the database and constructs a table model with this data.
     *
     * @return the constructed table model with table availability details.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    public static DefaultTableModel getTableAvailabilityModel() throws ClassNotFoundException, SQLException {
            String url = "jdbc:mysql://restaurant-database.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation";
            String username = "admin";
            String password = "01NoShotFlip$";
            String query = "select *from Table_Inventory";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();

            // Add Columns to Model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Add Rows to Model
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            st.close();
            con.close();

            return model;
        }

    /**
     * Updates table availability in the database to 'Not Available' for the specified table number.
     *
     * @param number The table number to be updated.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void updateTableAvailability(int number) throws SQLException, ClassNotFoundException{
        
        String url = "jdbc:mysql://restaurant-database.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation";
        String  username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "update Table_Inventory SET Availability = 'Not Available' where TableNum = ?  ";
         Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        
        //Statement st = con.createStatement();
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, number);
        preparedStmt.executeUpdate();
        con.close(); // close connection  
    }

    /**
     * Updates table availability in the database to 'Available' for the specified table number.
     *
     * @param tableNum The table number to be updated.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void nowAvailable(int tableNum) throws ClassNotFoundException, SQLException{
        String url = "jdbc:mysql://restaurant-database.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "update Table_Inventory SET Availability =  'Available' where TableNum =? ";
         Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        
        //Statement st = con.createStatement();
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, tableNum);
        preparedStmt.executeUpdate();
        con.close(); // close connection  
    }

    /**
     * Retrieves booking details from the database and constructs a table model with this data.
     *
     * @return the constructed table model with booking details.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    public static DefaultTableModel bookingDetails() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://restaurant-database.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation";
        String username = "admin";
        String password = "01NoShotFlip$";
        String query = "select *from Booking";
    
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
    
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
    
        DefaultTableModel model = new DefaultTableModel();
    
        // Add Columns to Model
        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnName(i));
        }
    
        // Add Rows to Model
        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            model.addRow(rowData);
        }
    
        st.close();
        con.close();
    
        return model;
    }

    /**
     * Adds a booking in the database with the provided details.
     *
     * @param number The table number associated with the booking.
     * @param Date The start date of the booking.
     * @param time The end date of the booking.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void addBooking (int number , String Date , String time) throws ClassNotFoundException, SQLException{
       
        String url = "jdbc:mysql://restaurant-database.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
         String query
            = "insert into Booking(TableNum,Date,Time) "+"values (?, ?, ? )"; // query to be run

         Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, number);
        preparedStmt.setString (2, Date);
        preparedStmt.setString (3, time);
        preparedStmt.execute();
        con.close(); // close connection 

    }

    /**
     * Deletes booking details associated with the provided table number.
     *
     * @param tableNum The table number of the booking to be deleted.
     * @throws ClassNotFoundException if the database driver is not found.
     * @throws SQLException if there's any database access error.
     */
    static void deleteBooking(int tableNum) throws SQLException, ClassNotFoundException{
        String url = "jdbc:mysql://restaurant-database.cxhswfveunmf.us-west-1.rds.amazonaws.com:3306/Hotel_Reservation"; // table details
        String username = "admin"; // MySQL credentials
        String password = "01NoShotFlip$";
        String query
            = "DELETE FROM Booking WHERE TableNum = ?"; // query to be run
        Class.forName(
            "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
            url, username, password);
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, tableNum);
        preparedStmt.executeUpdate();
        con.close(); // close connection 
    }
}
