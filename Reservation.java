import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is to define reservations
 *
 * @author Dylan Lambert
 */

public class Reservation {

    private int reservationNumber;
    private String reservationName;
    private char reservationType; // S: Standard purchase , A: Advanced purchase
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private List<LocalDate> stayedDates;
    private int numberOfRooms;
    private ArrayList<String> rooms;
    private double cost;

    public Reservation(){

    }

    public Reservation(int reservationNumber,
                       String reservationName,
                       char reservationType,
                       LocalDate checkInDate, LocalDate checkOutDate,
                       int numberOfRooms,
                       ArrayList<String> rooms) {
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
    public Reservation(int reservationNumber,
                       String reservationName,
                       char reservationType,
                       LocalDate checkInDate, LocalDate checkOutDate, List<LocalDate> stayedDates,
                       int numberOfRooms,
                       ArrayList<String> rooms,
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
       return null;
    }
    public ArrayList<String> getRooms(){
        return rooms;
    }


    //SET METHODS

    public void setRooms(ArrayList<String> rooms){
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
    public void setReservationNumber(int resNum){
        this.reservationNumber=resNum;
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
    public void setReservationType(char resType){
        this.reservationType = resType;
    }


    //METHOD to calculate total cost of the stay
    /**
     * METHOD to calculate total cost of the stay
     * @return the total cost of the booked stay
     */
    public double totalCost() {
        double totalCost = 0;
        Room obj = new Room();

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) == "DD"|| rooms.get(i) == "DT") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.DD[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.DD[4] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.DD[5] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.DD[6] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.DD[7] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.DD[8] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.DD[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                }
            }
            if (rooms.get(i) == "DS") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.DS[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.DS[4] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.DS[5] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.DS[6] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.DS[7] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.DS[8] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.DS[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                }
            }
            if (rooms.get(i) == "DF") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.DF[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.DF[4] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.DF[5] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.DF[6] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.DF[7] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.DF[8] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.DF[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                }
            }
            if (rooms.get(i) == "ED"||rooms.get(i)=="ET") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.ED[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.ED[4] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.ED[5] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.ED[6] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.ED[7] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.ED[8] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.ED[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                }
            }
            if (rooms.get(i) == "ES") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.ES[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.ES[4] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.ES[5] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.ES[6] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.ES[7] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.ES[8] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.ES[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                }
            }
            if (rooms.get(i) == "CD") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.CD[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.CD[4] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.CD[5] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.CD[6] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.CD[7] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.CD[8] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.CD[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                }
            }
            if (rooms.get(i) == "CT") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.CT[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.CT[4] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.CT[5] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.CT[6] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.CT[7] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.CT[8] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.CT[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                }
            }
            if (rooms.get(i) == "CS") {
                for (int j = 0; j < stayedDates.toArray().length; j++) {
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.MONDAY) {
                        totalCost += obj.CS[3] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.TUESDAY) {
                        totalCost += obj.CS[4] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        totalCost += obj.CS[5] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.THURSDAY) {
                        totalCost += obj.CS[6] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.FRIDAY) {
                        totalCost += obj.CS[7] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SATURDAY) {
                        totalCost += obj.CS[8] * Integer.parseInt(rooms.get(i + 1));
                    }
                    if (stayedDates.get(j).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        totalCost += obj.CS[3] * Integer.parseInt(rooms.get(i + 1));
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
                "Rooms booked\t:\t" + rooms + "\n" +
                "Total cost\t\t:\t" + cost + "\n";
        return reservationToString;
    }
}

