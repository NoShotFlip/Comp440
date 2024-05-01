package Restaurant;

/**
 * Represents a Restaurant.Table with a table number, table type, and availability status.
 * @author 
 * @version 1.0
 * <p>
 
 * </p>
 *
 * <p>
 * This class provides a structure for managing and querying information related
 * to individual table in a restaurant or similar establishment.
 * </p>
 */
public class Tables {

    /** The room number. */
    public int tableNum;
    /** The type of the table, e.g., "single", "double", "suite". */
    private String tableType;
    /** Indicates whether the table is currently available. */
    public boolean availability;

    /**
     * Constructs a new Restaurant.Table with the specified table number, table type, and availability.
     *
     * @param tableNum  the table's number.
     * @param tableType    the table's type.
     * @param availability whether the room is available.
     */
    public Tables(int tableNum, String tableType, boolean availability){

        this.tableNum = tableNum;
        this.tableType = tableType;
        this.availability = availability;

    }

    /**
     * Returns the table number.
     *
     * @return the table number.
     */
    public int getTableNumber() {
        return tableNum;
    }

    /**
     * Returns the type of the room.
     *
     * @return the table type.
     */
    public String getTableType() {
        return tableType;
    }

    /**
     * Checks if the table is available.
     *
     * @return true if the table is available, false otherwise.
     */
    public boolean isAvailable(){
        return availability;
    }

}

