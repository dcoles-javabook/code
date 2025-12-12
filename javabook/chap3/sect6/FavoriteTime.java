package javabook.chap3.sect6;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Prompts the user for a favorite time of day and calculates how long the user must wait until it
 * arrives.
 *
 * @author Drue Coles
 */
public class FavoriteTime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your favorite time of day (HH:MM) in 24-hour format: ");
        String input = scanner.next();

        // parse user input
        LocalTime futureTime = LocalTime.parse(input);
        LocalTime now = LocalTime.now();

        // compute forward interval
        int secondsInDay = 24 * 60 * 60;
        int nowSecs = now.toSecondOfDay();
        int futureSecs = futureTime.toSecondOfDay();
        int deltaSeconds = Math.floorMod(futureSecs - nowSecs, secondsInDay); // for wrap-around
        Duration duration = Duration.ofSeconds(deltaSeconds);

        // display current and future times in hh:mm:ss (24-hour format)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.printf("%13s %s%n", "Current time:", now.format(formatter));
        System.out.printf("%13s %s%n", "Future time:", futureTime.format(formatter));

        // display waiting time in HH:MM:SS format
        long totalSeconds = duration.getSeconds();
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;
        System.out.printf("%13s %02d:%02d:%02d%n", "Waiting time:", hours, minutes, seconds);
    }
}
