import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dylan lambert
 */
public class UserReservation {
    /**
     * Method to create a reservation
     */
    public static Reservation creatRes(boolean cancelation) {

        Scanner inOut = new Scanner(System.in);
        Reservation newRes = new Reservation();

        System.out.println("Please enter name for reservation:\t");
        String resName = inOut.nextLine();
        newRes.setReservationName(resName);

        System.out.println("Check in date:\t");
        int cInYear = inOut.nextInt();
        int cInMonth = inOut.nextInt();
        int cInDay = inOut.nextInt();
        LocalDate cIn = LocalDate.of(cInYear, cInMonth, cInDay);
        newRes.setCheckInDate(cIn);

        System.out.println("Check out date:\t");
        int cOutYear = inOut.nextInt();
        int cOutMonth = inOut.nextInt();
        int cOutDay = inOut.nextInt();
        LocalDate cOut = LocalDate.of(cOutYear, cOutMonth, cOutDay);
        newRes.setCheckOutDate(cOut);

        LocalDate nowDate = LocalDate.now();
        char resT;
        if(ChronoUnit.DAYS.between(nowDate,cIn)>29){
            resT = 'A';
        }
        else{
            resT = 'S';
        }
        newRes.setReservationType(resT);

        System.out.println("Hotel selection:\t5*\t4*\t3*");
        int hotelStar = inOut.nextInt();

        System.out.println("Number of rooms to reserve:\t");
        int numOfRooms = inOut.nextInt();
        newRes.setNumberOfRooms(numOfRooms);

        //Will have to check what rooms are available before displaying here
        if (hotelStar == 5) {
            System.out.println("Available rooms:\nDeluxe Double (DD)\nDeluxe Twin (DT)\nDeluxe Family (DF)\n");
        } else if (hotelStar == 4) {
            System.out.println("Available rooms:\nExecutive Double (ED)\nExecutive Twin (ET)\nExecutive Single (ES)\n");
        } else if (hotelStar == 3) {
            System.out.println("Available rooms:\nClassic Double (CD)\nClassic Twin (CT)\nClassic Single (CT)\n");
        }

        ArrayList<String> userRooms = new ArrayList<String>();

        for(int i=0;i<numOfRooms;i++){
            System.out.println("Enter room type:\t");
            String userRoomIn = inOut.next().toUpperCase();
            userRooms.add(userRoomIn);


            System.out.println("Number of occupants:\t");
            String numOfOccupants = inOut.next();
            userRooms.add(numOfOccupants);
        }

        newRes.setRooms(userRooms);
        newRes.setDates();
        if(cancelation && resT == 'S'){
            newRes.setCost(0.0);
        } else {
            newRes.totalCost();
        }
        newRes.setReservationNumber(ReadReservations.numberOfReservation());
        System.out.println(newRes.toString());
        WriteReservations.writeReservations(newRes);
        return newRes;
    }

}