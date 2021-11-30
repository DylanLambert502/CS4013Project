import java.util.Scanner;
import static java.lang.System.exit;

/**
 * @author Dylan Lambert
 */
public class TextMenu {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        System.out.printf("Please select menu option:\n" +
                "1.) Create a reservation\n"+
                "2.) View reservations\n"+
                "3.) Test reservation creation\n"+
                "4.) Exit\n");

        int userSelection = input.nextInt();
    do {
        if (userSelection == 1) {
            UserReservation.creatRes();
        } else if (userSelection == 2) {
            ReadReservations.displayReservations();
            break;
        } else if (userSelection == 3) {
            ReservationTesting.testReservation();
        } else if (userSelection == 4) {
            exit(0);
        } else {
            System.out.println("Invalid input");
        }
    } while(true);

    }
}
