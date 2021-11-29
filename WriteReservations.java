import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;


public class WriteReservations {
    public static void writeReseravations(Reservation reservations) {
        int reservationNumber = 0;
        String reservationName = null;
        char reservationType = 0; // S: Standard purchase , A: Advanced purchase
        LocalDate checkInDate = null;
        LocalDate checkOutDate = null;
        List<LocalDate> stayedDates;
        int numberOfRooms = 0;
        String[][] rooms = new String[0][]; // type of room
        int Occupany = 0;
        double totalCost = 0;
        String filepath = "reservations.csv";


        try {
            FileWriter writer = new FileWriter(filepath, true);
            BufferedWriter buff = new BufferedWriter(writer);
            PrintWriter pw = new PrintWriter(buff);

            reservationName = reservations.getReservationName();
            reservationNumber   = reservations.getReservationNumber();
            reservationType = reservations.getReservationType();
            checkInDate  = reservations.getCheckInDate();
            checkOutDate  = reservations.getCheckOutDate();
            numberOfRooms  = reservations.getNumberOfRooms();
            rooms  = reservations.getRooms();
            Occupany  = 1;
            totalCost  = reservations.totalCost();


            pw.println(reservationName + "," + reservationNumber + "," + reservationType + "," + checkInDate + ","
                    + checkOutDate + "," + numberOfRooms + "," + rooms + "," + Occupany + "," + totalCost);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "reservation saved");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "reservation not saved");
        }
    }
}
    

