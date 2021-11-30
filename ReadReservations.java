import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReadReservations {

    public static void readReservations() {
        String path = "reservations.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                int DD = 0;
                if (values[6].contains("DD")) {
                    DD = DD + 1;
                }
                int DT = 0;
                if (values[6].contains("DT")) {
                    DT = DT + 1;
                }
                int DS = 0;
                if (values[6].contains("DS")) {
                    DS = DS + 1;
                }
                int DF = 0;
                if (values[6].contains("DF")) {
                    DF = DF + 1;
                }
                int ED = 0;
                if (values[6].contains("ED")) {
                    ED = ED + 1;
                }
                int ET = 0;
                if (values[6].contains("ET")) {
                    ET = ET + 1;
                }
                int ES = 0;
                if (values[6].contains("ES")) {
                    ES = ES + 1;
                }
                int CD = 0;
                if (values[6].contains("CD")) {
                    CD = CD + 1;
                }
                int CT = 0;
                if (values[6].contains("DD")) {
                    CT = CT + 1;
                }
                int CS = 0;
                if (values[6].contains("CS")) {
                    CS = CS + 1;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * @author Dylan Lambert
     */
    public static void displayReservations(){
        List<List<String>> records = new ArrayList<>();
        try(BufferedReader dbr = new BufferedReader(new FileReader("reservations.csv"))){
            String line = "";
            while((line = dbr.readLine()) != null){
                String[] values = line.split("\n");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<records.size();i++){
        System.out.println(records.get(i)+"\n");
        }
    }
    /**
    *@author Dylan Lambert
    */
    public static int numberOfReservation(){
        List<List<String>> records = new ArrayList<>();
        try(BufferedReader dbr = new BufferedReader(new FileReader("reservations.csv"))){
            String line = "";
            while((line = dbr.readLine()) != null){
                String[] values = line.split("\n");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records.size();
    }
}

// System.out.println("The list of names are: " + values[0]);
//         System.out.println("The list of Number are: " + values[1]);
//         System.out.println("The list of Type are: " + values[2]);
//         System.out.println("The list of CheckIn are: " + values[3]);
//         System.out.println("The list of CheckOut are: " + values[4]);
//         System.out.println("The list of AmtOFRooms are: " + values[5]);
//         System.out.println("The list of Roomtype are: " + values[6]);
//         System.out.println("The list of Occupancy are: " + values[7]);
//         System.out.println("The list of Total are: " + values[8]);
