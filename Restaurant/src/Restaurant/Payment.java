package Restaurant;

import org.junit.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Handles the payment processing and bill calculation for guests' restaurant stays.
 * @author 
 * @version 1.0
 * <p>

 * </p>
 *
 * <p>
 * This class leverages the details of a reservation to compute the total cost for a guest's stay,
 * taking into account factors like table type, number of guests, and the duration of the stay.
 * </p>
 */
public class Payment {

    /**
     * Calculates the total bill for the guest's restuarant  stay based on the details provided in the reservation.
     *
     * @param reservation  the details of the guest's reservation.
     * @return the total bill for the guest's restaurnat stay.
     * @throws ParseException if there's an issue parsing the check-in or check-out dates.
     */
    public String calculateBill(Reservation reservation) throws ParseException {

        // Determine table price based on table type
        double bill, tablePrice = 0;
        if (reservation.tableType.equalsIgnoreCase("Single")){
            tablePrice = 100.00;
        } else if (reservation.tableType.equalsIgnoreCase("Double")){
            tablePrice = 200.00;
        } else if (reservation.tableType.equalsIgnoreCase("Triple")){
            tablePrice = 420.00;
        } else if (reservation.tableType.equalsIgnoreCase("Suite")){
            tablePrice = 6900.00;
        }

        // Calculate nightly cost by considering both adults and children.
        // Note: Children are charged at half the adult rate.
        double costPerNight = (reservation.numAdults * tablePrice) + (reservation.numChildren * (tablePrice/2));

        // Parse check-in and check-out dates
        //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
       
        // Calculate total bill
        bill = costPerNight ;
        return "\ttable Price: "+ fmt.format(bill);
    }
}

