import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

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
    private List<LocalDate> stayedDates;
    private int numberOfRooms;
    private String[][] rooms;
    private double cost;

    public reservations(){

    }

    public reservations(int reservationNumber,
                        String reservationName,
                        char reservationType,
                        LocalDate checkInDate, LocalDate checkOutDate,
                        int numberOfRooms,
                        String[][] rooms) {
        this.reservationNumber = reservationNumber;
        this.reservationName = reservationName;
        this.reservationType = reservationType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfRooms = numberOfRooms;
        this.rooms = rooms;
    }

    /**
     * Constructor to creat a reservation
     *
     * @param reservationNumber an integer to identify a reservation
     * @param reservationName   the name of the reserver
     * @param reservationType   what type of purcase was the reservation (S or A0
     * @param checkInDate       date booked for check in
     * @param checkOutDate      date of departure from hotel
     * @param numberOfRooms     number of rooms booked
     * @param rooms             type of rooms booked
     * @param cost              cost of the stay
     */
    public reservations(int reservationNumber,
                        String reservationName,
                        char reservationType,
                        LocalDate checkInDate, LocalDate checkOutDate, List<LocalDate> stayedDates,
                        int numberOfRooms,
                        String[][] rooms,
                        double cost) {
        this.reservationNumber = reservationNumber;
        this.reservationName = reservationName;
        this.reservationType = reservationType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.stayedDates = stayedDates;
        this.numberOfRooms = numberOfRooms;
        this.rooms = rooms;
        this.cost = cost;
    }

    //GET METHODS

    /**
     * method return reservation number
     *
     * @return number that identifies the reservation
     */
    public int getReservationNumber() {
        return reservationNumber;
    }

    /**
     * Method returns reservation name
     *
     * @return name on the reservation
     */
    public String getReservationName() {
        return reservationName;
    }

    /**
     * Method returns the reservation purchase type
     *
     * @return reservation type
     */
    public char getReservationType() {
        return reservationType;
    }

    /**
     * Method returns the date of check in for the reservation
     *
     * @return date of check in
     */
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    /**
     * Method returns the date of departure from the reserved rooms
     *
     * @return date of check out
     */
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public List<LocalDate> getStayedDates() {
        return stayedDates;
    }

    /**
     * Method returns the number of rooms booked
     *
     * @return the number of rooms reserved
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * Method returns the type of rooms reserved
     *
     * @return room types of reservation
     */
    public String getRoomTypes() {
        ArrayList<String> roomT = new ArrayList<String>();
        for(int i=0;i<rooms.length;i++){
            String rT= rooms[i][0];
            roomT.add(rT);
        }
        return roomT.toString();
    }


    //SET METHODS
    /**
     * @return
     */
    public void setRooms(String[][] rooms) {
        this.rooms = rooms;
    }
    /**
     * Sets the cost of the room(s)
     *
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setReservationName(String name){
        this.reservationName=name;
    }
    public void setCheckInDate(LocalDate cIn){
        this.checkInDate=cIn;
    }
    public void setCheckOutDate(LocalDate cOut){
        this.checkOutDate=cOut;
    }
    public void setDates() {
        this.stayedDates = checkInDate.datesUntil(checkOutDate).collect(Collectors.toList());
    }
    public void setNumberOfRooms(int numberOfRooms){
        this.numberOfRooms=numberOfRooms;
    }


    //METHOD to calculate total cost of the stay
    /**
     * METHOD to calculate total cost of the stay
     * @return the total cost of the booked stay
     */
    public double totalCost() {
        double totalCost = 0;
        room obj = new room();

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i][0] == "DD" || rooms[i][0] == "DT") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.DD[3] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.DD[4] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.DD[5] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.DD[6] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.DD[7] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.DD[8] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.DD[9] * Integer.parseInt(rooms[i][1]);
                    }
                }
            }
            if (rooms[i][0] == "DS") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.DS[3] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.DS[4] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.DS[5] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.DS[6] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.DS[7] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.DS[8] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.DS[9] * Integer.parseInt(rooms[i][1]);
                    }
                }
            }
            if (rooms[i][0] == "DF") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.DF[3] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.DF[4] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.DF[5] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.DF[6] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.DF[7] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.DF[8] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.DF[9] * Integer.parseInt(rooms[i][1]);
                    }
                }
            }
            if (rooms[i][0] == "ED" || rooms[i][0] == "ET") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.ED[3] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.ED[4] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.ED[5] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.ED[6] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.ED[7] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.ED[8] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.ED[9] * Integer.parseInt(rooms[i][1]);
                    }
                }
            }
            if (rooms[i][0] == "ES") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.ES[3] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.ES[4] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.ES[5] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.ES[6] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.ES[7] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.ES[8] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.ES[9] * Integer.parseInt(rooms[i][1]);
                    }
                }
            }
            if (rooms[i][0] == "CD") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.CD[3] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.CD[4] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.CD[5] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.CD[6] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.CD[7] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.CD[8] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.CD[9] * Integer.parseInt(rooms[i][1]);
                    }
                }
            }
            if (rooms[i][0] == "CT") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.CT[3] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.CT[4] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.CT[5] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.CT[6] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.CT[7] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.CT[8] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.CT[9] * Integer.parseInt(rooms[i][1]);
                    }
                }
            }
            if (rooms[i][0] == "CS") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.CS[3] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.CS[4] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.CS[5] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.CS[6] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.CS[7] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.CS[8] * Integer.parseInt(rooms[i][1]);
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.CS[9] * Integer.parseInt(rooms[i][1]);
                    }
                }
            }
        }
        if(reservationType=='A'||reservationType=='a') {
            double discount = totalCost-((totalCost/100)*5);
            this.cost = discount;
        }
        else{
            this.cost = totalCost;
        }
        return totalCost;
    }


    /**
     * Prints the parameters of the reservation to string
     * @return reservation details in a string format
     */
    public String toString() {
        String reservationToString = "Reservation number:\t" + reservationNumber + "\n" +
                "Reservation name:\t" + reservationName + "\n" +
                "Reservation type:\t" + reservationType + "\n" +
                "Check in date\t:\t" + checkInDate + "\n" +
                "Check out date\t:\t" + checkOutDate + "\n" +
                "Number of rooms\t:\t" + numberOfRooms + "\n" +
                "Rooms booked\t:\t" + Arrays.deepToString(rooms) + "\n" +
                "Total cost\t\t:\t" + cost + "\n";
        return reservationToString;
    }
}


