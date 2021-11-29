

public class DaysOfWeek {
//Need to implement a way of checking the days booked and convert to days of the week
//Was thinking of using Zellers congruence algorithm form the revision exercise at beginning of the year
}

/**
import java.util.Scanner;

public class Exercise3_21 {
    public static void main(String[] arguments) {

        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Scanner inout = new Scanner(System.in);

        System.out.println("Enter Year: ");
        int kUserYear = inout.nextInt();
        System.out.println("Enter Month: ");
        int mUserMonth = inout.nextInt();
        //Convert user months for Jan and Feb and subtract year as months is from previous year
        if(mUserMonth == 1){
            mUserMonth = 13;
            kUserYear--;
        }
        else if(mUserMonth == 2){
            mUserMonth = 14;
            kUserYear--;
        }
        System.out.println("Enter Day of Month: ");
        int qUserDay = inout.nextInt();

        int jCentury = kUserYear/100;
        int kNewYear = kUserYear%100;

        int hDayOfWeek = (qUserDay + 26*(mUserMonth+1)/10 + kNewYear + kNewYear/4 +jCentury/4 + 5*(jCentury))%7;
        System.out.print(daysOfWeek[hDayOfWeek]);


    }
}
*/
