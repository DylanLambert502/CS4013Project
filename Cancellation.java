import java.time.LocalDate;
import java.util.Arrays;

/**
 * This class handles cancellations operations of
 * the reservation system and stores the data.
 *@author Niall O'Donohue
 */
public class Cancellation{
  private Reservation reservation;
  private LocalDate cancellationDate;
  private boolean refunded;
  private double refundAmount;
  /**
   * Constructor that creates cancellation object.
   * @param  reservation - the reservation that has been cancelled.
   */
  public Cancellation(Reservation reservation){
    this.reservation = reservation;
    cancellationDate = LocalDate.now();
    refunded = amountMustBeRefunded();
  }

  /**
   * Constructor that creates a cancellation object -(specifically from Cancellations.csv file).
   * @param   reservation - the reservation that has been cancelled.
   * @param   cancellationDate - the date the reservation was cancelled.
   * @param   refunded - defines if the cancellation will result in a refund or not.
   */
  public Cancellation(Reservation reservation, LocalDate cancellationDate, boolean refunded){
    this.reservation = reservation;
    this.cancellationDate = cancellationDate;
    this.refunded = refunded;
  }

  /**
   * Defines if the cancellation will result in a refund or not.
   * @return refunded - returns if the cancellation results in a refund.
   */
  public boolean isRefunded(){
    return refunded;
  }

  /**
   * Returns the date the reservation was cancelled.
   * @return cancellationDate - the date the reservation was cancelled.
   */
  public LocalDate getDate(){
    return cancellationDate;
  }

  /**
   * Method that returns the total cost of the cancelled reservation.
   * @return - returns total cost of cancelled reservation.
   */
  public double getCost(){
    return reservation.totalCost();
  }

  /**
   * defines if passes refund criteria and returns
   * amount to be refunded.
   * @return - amount to be refunded for cancelled reservation.
   */
  public double getRefundAmount() {
    if (amountMustBeRefunded()) {
      refundAmount = getCost();
      return refundAmount;
    } else {
      refundAmount = 0.0;
      return refundAmount;
    }
  }
  /**
   * Method returns reservation that has been cancelled.
   * @return reservation - the reservation that has been cancelled.
   */
  public Reservation getReservation(){
    return reservation;
  }

 @Override
 public String toString(){
   String cancellationToString = "Cancelled reservation number:\t" + reservation.getReservationNumber() + "\n" +
           "Refund amount:\t" + refundAmount + "\n" +
           "Date of cancellation:\t" + cancellationDate.toString() + "\n";
   return cancellationToString;

 }

  /**
   * Checks if cancelled reservation is eligible for refund.
   * @return - true if cancellation can be refunded - false if not.
   */
  private boolean amountMustBeRefunded(){
    if(reservation.getReservationType() == 'S'){
      if(reservation.getCheckInDate().minusDays(2).isAfter(cancellationDate)){
        return true;
      }
    }
    return false;
  }
}
