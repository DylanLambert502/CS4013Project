import java.time.LocalDate;
import java.util.*;

/**
 * This class is to define reservations
 *
 * @author Dylan Lambert
 */

public class reservations {
    private int reservationNumber;
    private String reservationName;
    private char reservationType; // S: Standard purchase , A: Advanced purchase
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfRooms;
    private String[][] rooms;
    private double cost;

    public reservations(int reservationNumber,
                        String reservationName,
                        char reservationType,
                        LocalDate checkInDate, LocalDate checkOutDate,
                        int numberOfRooms,
                        String[][] rooms){
        this.reservationNumber=reservationNumber;
        this.reservationName=reservationName;
        this.reservationType=reservationType;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.numberOfRooms=numberOfRooms;
        this.rooms=rooms;
    }
    /**
     * Constructor to creat a reservation
     * @param reservationNumber an integer to identify a reservation
     * @param reservationName the name of the reserver
     * @param reservationType what type of purcase was the reservation (S or A0
     * @param checkInDate date booked for check in
     * @param checkOutDate date of departure from hotel
     * @param numberOfRooms number of rooms booked
     * @param rooms type of rooms booked
     * @param cost cost of the stay
     */
    public reservations(int reservationNumber,
                        String reservationName,
                        char reservationType,
                        LocalDate checkInDate, LocalDate checkOutDate,
                        int numberOfRooms,
                        String[][] rooms,
                        double cost){
        this.reservationNumber=reservationNumber;
        this.reservationName=reservationName;
        this.reservationType=reservationType;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.numberOfRooms=numberOfRooms;
        this.rooms=rooms;
        this.cost=cost;
    }

    //GET METHODS
    /**
     * method return reservation number
     * @return number that identifies the reservation
     */
    public int getReservationNumber(){
        return reservationNumber;
    }

    /**
     * Method returns reservation name
     * @return name on the reservation
     */
    public String getReservationName(){
        return reservationName;
    }

    /**
     * Method returns the reservation purchase type
     * @return reservation type
     */
    public char getReservationType(){
        return reservationType;
    }

    /**
     * Method returns the date of check in for the reservation
     * @return date of check in
     */
    public LocalDate getCheckInDate(){
        return checkInDate;
    }

    /**
     * Method returns the date of departure from the reserved rooms
     * @return date of check out
     */
    public LocalDate getCheckOutDate(){
        return checkOutDate;
    }

    /**
     * Method returns the number of rooms booked
     * @return the number of rooms reserved
     */
    public int getNumberOfRooms(){
        return numberOfRooms;
    }

    /**
     * Method returns the type of rooms reserved
     * @return room types of reservation
     */
    public String getRoomTypes(){
        return null; // finish this method for getting the types of room reserved
    }

    //SET METHODS
    /**
     *
     * @return
     */
    public void setRooms(String[][] rooms){
        this.rooms=rooms;
    }

    /**
     * Sets the cost of the room(s)
     * @param cost
     */
    public void setCost(double cost){
        this.cost=cost;
    }

    //METHOD to calculate total cost of the stay
    public double totalCost(){
        double totalCost=0;
        room obj=new room();

        for(int i=0;i<rooms.length;i++){
            if(rooms[i][0] =="DD"||rooms[i][0]=="DF"){
                totalCost+=obj.DD[3]*Integer.parseInt(rooms[i][1]);
            }
        }
        //NOT fully finished more work on rooms types and rates for specific days needs to be done
        //Currently calculates cost based on occupants for 1 day (Monday)
        this.cost=totalCost;
        return totalCost;
    }


    public String toString(){
        String reservationToString = "Reservation number:\t"+reservationNumber + "\n"+
                "Reservation name:\t"+reservationName + "\n"+
                "Reservation type:\t"+reservationType + "\n"+
                "Check in date\t:\t"+checkInDate + "\n"+
                "Check out date\t:\t"+checkOutDate + "\n"+
                "Number of rooms\t:\t"+numberOfRooms + "\n"+
                "Rooms booked\t:\t"+Arrays.deepToString(rooms)+"\n"+
                "Total cost\t\t:\t"+cost + "\n";
        return reservationToString;
    }
}
