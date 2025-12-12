package javabook.chap3.sect6;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Outputs the current date and the elapsed time since the user's birthdate.
 * 
 * @author Drue Coles
 */
public class DaysAlive {

   public static void main(String[] args) {
      // read user's birthdate
      Scanner in = new Scanner(System.in);
      System.out.print("Enter date of birth in MM DD YYYY format: ");
      int month = in.nextInt();
      int day = in.nextInt();
      int year = in.nextInt();
      LocalDate birthday = LocalDate.of(year, month, day);

      // output today's date
      LocalDate today = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
      System.out.printf("Today is %s.%n", today.format(formatter));

      // calculate period since birth
      Period period = Period.between(birthday, today);
      int years = period.getYears();
      int months = period.getMonths();
      int days = period.getDays();
      System.out.printf("You are %d years, %d months, and %d days old.%n", years, months, days);

      // calculate total number of days since birth
      long daysAlive = ChronoUnit.DAYS.between(birthday, today);
      System.out.printf("You have been alive for %,d days.%n", daysAlive);
   }
}
