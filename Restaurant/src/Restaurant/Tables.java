package Hotel_Toad;

/**
 * Represents a Hotel_Toad.Room with a room number, room type, and availability status.
 * @author Toad's Taskforce
 * @version 1.0
 * <p>
 * Date of Creation: 28 July 2023
 * </p>
 *
 * <p>
 * This class provides a structure for managing and querying information related
 * to individual rooms in a hotel or similar establishment.
 * </p>
 */
public class Tables {

    /** The room number. */
    public int tableNum;
    /** The type of the room, e.g., "single", "double", "suite". */
    private String tableType;
    /** Indicates whether the room is currently available. */
    public boolean availability;

    /**
     * Constructs a new Hotel_Toad.Room with the specified room number, room type, and availability.
     *
     * @param tableNum  the room's number.
     * @param tableType    the room's type.
     * @param availability whether the room is available.
     */
    public Tables(int tableNum, String tableType, boolean availability){

        this.tableNum = tableNum;
        this.tableType = tableType;
        this.availability = availability;

    }

    /**
     * Returns the room number.
     *
     * @return the room number.
     */
    public int getTableNumber() {
        return tableNum;
    }

    /**
     * Returns the type of the room.
     *
     * @return the room type.
     */
    public String getTableType() {
        return tableType;
    }

    /**
     * Checks if the room is available.
     *
     * @return true if the room is available, false otherwise.
     */
    public boolean isAvailable(){
        return availability;
    }

}

