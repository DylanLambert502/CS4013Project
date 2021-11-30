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
        LocalDate cIn = LocalDate.of(2022, 1, 1);
        LocalDate cOut = LocalDate.of(2022, 1, 3);
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

        int resNum2 = 1002;
        testRes.setReservationNumber(resNum2);
        String resName2 = "Jane Doe";
        testRes.setReservationName(resName2);
        char resT2 = 'S';
        testRes.setReservationType(resT2);
        LocalDate cIn2 = LocalDate.of(2022, 5, 30);
        LocalDate cOut2 = LocalDate.of(2022, 6, 7);
        testRes.setCheckInDate(cIn2);
        testRes.setCheckOutDate(cOut2);
        testRes.setDates();
        testRes.setNumberOfRooms(1);
        ArrayList<String> userRooms2 = new ArrayList<String>();
        userRooms2.add("ES");
        userRooms2.add("2");
        testRes.setRooms(userRooms2);

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
