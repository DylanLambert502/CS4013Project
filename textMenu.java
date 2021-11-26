import java.time.LocalDate;
import java.util.Scanner;
import java.util.Arrays;

public class textMenu {
    public static void main(String args[]) {

        Scanner inOut = new Scanner(System.in);

        reservations newRes = new reservations();

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

        System.out.println("Hotel selection:\t");
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

    String[][] rooms = {{}};
        //Not currently working
    for(int i=0;i<numOfRooms;i++) {
        System.out.println("Enter room to reserve:\t");
        String userRoomIn = inOut.nextLine();

        System.out.println("Number of occupants:\t");
        int numOfOccupants = inOut.nextInt();

        String numOfOccupantsString = Integer.toString(numOfOccupants);
        String[] tempRoom = {userRoomIn, numOfOccupantsString};
        rooms = Arrays.copyOf(rooms, rooms.length + 1);
        rooms[rooms.length - 1] = tempRoom;
    }

    newRes.setRooms(rooms);
    newRes.totalCost();
    newRes.toString();


    }
}
