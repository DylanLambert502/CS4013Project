import java.util.Scanner;
import static java.lang.System.exit;

/**
 * @author Dylan Lambert
 */
public class TextMenu {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.printf("Please select menu option:\n" +
                    "1.) Create a reservation\n" +
                    "2.) View reservations\n" +
                    "3.) Test reservation creation\n" +
                    "4.) Exit\n");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    UserReservation.creatRes();
                    break;
                case 2:
                    ReadReservations.displayReservations();
                    break;
                case 3:
                    ReservationTesting.testReservation();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }
    }
}
