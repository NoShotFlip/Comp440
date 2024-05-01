package Restaurant;

import java.sql.SQLException;

import javax.swing.JTextField;

/**
 * Represents a restaurant  entity with functionalities encompassing table reservations and cancellations.
 * @author 
 * @version 1.0
 * <p>
 * Date of Creation: 28 July 2023
 * </p>
 *
 * <p>
 * This class not only manages the in-memory representation of the restaurant but also interfaces with a database
 * for persistent storage of reservation details.
 * </p>
 */
public class Restaurant {

    /** An array representing all the table in the restaurant. */
    public static Tables[] tables;

    /**
     * Constructs a new restaurant with the given tables.
     *
     * @param tables the array of tables that belong to this restaurant.
     */
    public Restaurant(Tables[] tables){
        this.tables = tables;
    }

    /**
     * Processes a tables reservation request for a guest. If successful, details of the reservation are returned.
     * Otherwise, a null value indicates the absence of available tables of the desired type.
     *
     * @param guest    the guest making the reservation.
     * @param tableType the type of tables desired by the guest.
     * @param checkIn  the check-in date.
     * @param checkOut1String the check-out date.
     * @param email    the email of the guest.
     * @param bill     total billing details.
     *
     * @return details of the reserved tables or null if the desired tables type is unavailable.
     *
     * @throws ClassNotFoundException if there's an issue loading a database class.
     * @throws SQLException if there's a database access error.
     */
    public static String reserveTable(Guest guest, String tableType, String checkIn, String checkOut1String, String email, String bill) throws ClassNotFoundException, SQLException{
        for (int i = 0; i < tables.length; i++){
            if (tables[i].getTableType().equalsIgnoreCase(tableType) && tables[i].isAvailable()){
               
                return "Table Reservation Successful!" +
                        "\nGuest Name: " + guest.getFirstName() + " " + guest.getLastName() + " "
                        + "\nGuest Email: " + guest.getEmail()  +"\nTable Type: " + tableType + "\tTable number: "
                        + tables[i].getTableNumber() + "\nDate: " + checkIn + "\nTime: " + checkOut1String 
                        + "\nDon't forget your table number if you want to cancel your reservation!";
            }
        }
        return null;
    }

    /**
     * Handles table reservation and simultaneously updates the database to reflect these changes.
     *
     * @param guest    details of the guest requesting the reservation.
     * @param tableType the kind of table the guest desires.
     * @param checkIn  intended check-in date.
     * @param checkOut1String intended check-out date.
     * @param email    contact email of the guest.
     * @param message1String 
     *
     * @throws ClassNotFoundException if there's an issue connecting with the database driver.
     * @throws SQLException if there's an issue accessing the database.
     */
    public static void reserveTable1(Guest guest, String tableType, String checkIn, String checkOut1String, String email, String message1String) throws ClassNotFoundException, SQLException{
        for (int i = 0; i < tables.length; i++){
            if (tables[i].getTableType().equalsIgnoreCase(tableType) && tables[i].isAvailable()){
                tables[i].availability = false;
                
                int tableNumber = tables[i].getTableNumber();
                //Calls addtoCustomerDetails from DataBase class to store the information
                Database.addtoCustomerDetails(guest.getFirstName(), guest.getLastName(), email, tableNumber,message1String);
                //Calls addBooking from DataBase class to store the information
                Database.addBooking(tableNumber,checkIn,checkOut1String);
                //Calls updateRoomAvailability from DataBase class to store the information
                Database.updateTableAvailability(tableNumber);
                return;
            }
        }
        
    }

    /**
     * Cancels an existing table reservation and updates the database to reflect the table's availability.
     *
     * @param tableNumber the specific number of the table whose reservation needs cancellation.
     *
     * @return a message indicating whether the cancellation was successful or not.
     *
     * @throws ClassNotFoundException if there's an issue connecting with the database driver.
     * @throws SQLException if there's an issue accessing the database.
     */
    public static String cancelTable(int tableNumber) throws ClassNotFoundException, SQLException{
        String message;
        for (int i = 0; i < tables.length; i++){
            if (tables[i].getTableNumber() == tableNumber && !tables[i].isAvailable()) {
                // Mark table as available;
                tables[i].availability = true;

                // Update database to reflect cancellation
                //Calls deleteCustomerDetails from DataBase class to delete in the Database
                Database.deleteCustomerDetails(tableNumber);
                //Calls nowAvailabe from DataBase class to Updates in the Database
                Database.nowAvailable(tableNumber);
                //Calls deleteBooking from DataBase class to delete in the Database
                Database.deleteBooking(tableNumber);
                message = "Reservation Canceled!";
                return message;
            }
        }
        message = "Error: No Matching Reservation Found.";
        return message;
    }

}
