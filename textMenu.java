import java.time.LocalDate;


public class textMenu {
    public static void main(String args[]){

        LocalDate cIn = LocalDate.of(2021,01,01);
        LocalDate cOut= LocalDate.of(2021,01,02);
        String[][] testRooms = {{"DD","2"}, {"DF","2"}};//Int 2 represent the number of occupants


        reservations TestRev = new reservations(1001,
                "Jane Doe",
                's',
                cIn,
                cOut,
                2,
                testRooms);
        TestRev.totalCost();
        System.out.println(TestRev.toString());


    }
}
