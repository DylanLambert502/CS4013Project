import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Dylan Lambert
 */

public class ReservationTesting {
    /**
     * Method to test the creation and display of reservations
     */
    public static void testReservation() {
        Reservation testRes = new Reservation();
        int resNum = 1001;
        testRes.setReservationNumber(resNum);
        String resName = "Dylan Lambert";
        testRes.setReservationName(resName);
        char resT = 'S';
        testRes.setReservationType(resT);
        LocalDate cIn = LocalDate.of(2021, 1, 1);
        LocalDate cOut = LocalDate.of(2021, 1, 3);
        testRes.setCheckInDate(cIn);
        testRes.setCheckOutDate(cOut);
        testRes.setDates();
        testRes.setNumberOfRooms(2);
        ArrayList<String> userRooms = new ArrayList<String>();
        userRooms.add("DD");
        userRooms.add("2");
        userRooms.add("CT");
        userRooms.add("1");
        testRes.setRooms(userRooms);

        testRes.totalCost();
        System.out.println(testRes.toString());
        WriteReservations.writeReservations(testRes);
        
        Cancellation cancel = new Cancellation(testRes);
        cancel.getReservation();
        cancel.getRefundAmount();
        System.out.println(cancel.toString());
        System.out.println("End of Test");
    }
}
