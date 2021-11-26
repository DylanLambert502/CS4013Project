import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class readReservations {
    public static void main(String[] args){
        String path = "C:\\Users\\conor\\IdeaProjects\\CS4013Project-main\\CS4013Project-main\\reservations.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) !=null) {
                String[] values = line.split(",");
                System.out.println("The list of names are: " +values[0]);
                System.out.println("The list of Number are: " +values[1]);
                System.out.println("The list of Type are: " +values[2]);
                System.out.println("The list of CheckIn are: " +values[3]);
                System.out.println("The list of CheckOut are: " +values[4]);
                System.out.println("The list of AmtOFRooms are: " +values[5]);
                System.out.println("The list of Roomtype are: " +values[6]);
                System.out.println("The list of Occupancy are: " +values[7]);
                System.out.println("The list of Total are: " +values[8]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
/*
Name,       values[0]
Number,     values[1]
Type,       values[2]
CheckIn,    values[3]
CheckOut,	values[4]
AmtOFRooms,	values[5]
Roomtype,	values[6]
Occupancy,	values[7]
TotalCost,      values[8]


    for( int i=0 , i < valueOf.values[6] , i++ ){
    if (values[6].equalTo(DD)) {
    -called room class -
    DD[0] = DD [0]-1
    } else if (values[6].equalTo(DT)) {
    -called room class -
    DT[0] = DT [0]-1
    }
    }
 */

