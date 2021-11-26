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
                System.out.println(values[0]);
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
Total,      values[9]

 */

