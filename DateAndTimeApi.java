import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeApi {
    public static void main(String[] args) {
        System.out.println("Welcome to Date and Time API Tutorials!");

        //Creating Date and Time instances
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        System.out.println(today.getYear());
        System.out.println(today.getMonth());
        System.out.println(today.getDayOfMonth());

        System.out.println("==========================");

        LocalDate tomorrow = today.plusDays(1);
        System.out.println("Tomorrow's Date: " + tomorrow);

        LocalDate previousWeek = today.minusWeeks(1);
        System.out.println("Date one week ago: " + previousWeek);


        System.out.println("==========================");

        LocalTime timeNow = LocalTime.now();
        System.out.println("Current Time: " + timeNow);

        LocalTime newTime = timeNow.plusHours(2).plusMinutes(30);
        System.out.println("Time after 2 hours and 30 minutes: " + newTime);

        LocalTime time = LocalTime.of(14, 45, 50);
        System.out.println("Specific Time (14:45:50): " + time);

        System.out.println("==========================");

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        LocalDateTime futureDateTime = currentDateTime.plusDays(5).plusHours(3);
        System.out.println("Date and Time after 5 days and 3 hours: " + futureDateTime);


        System.out.println("==========================");

        ZonedDateTime zonedDateTimeIndia = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date and Time in India: " + zonedDateTimeIndia);


        //used for logging and timestamps
        Instant currentInstant = Instant.now();
        System.out.println("Current Instant (UTC): " + currentInstant);


        System.out.println("==========================");


        //Conversion between Date and Time types
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
        System.out.println("Converted ZonedDateTime: " + zdt);


        // Demonstrating the difference between Period and Duration
        System.out.println("==========================");
        System.out.println("Period vs Duration Difference Example:");

        // Period: date-based (years, months, days)
        LocalDate date1 = LocalDate.of(2022, 5, 10);
        LocalDate date2 = LocalDate.of(2025, 8, 25);
        Period diffPeriod = Period.between(date1, date2);
        System.out.println("Period between " + date1 + " and " + date2 + ": "
            + diffPeriod.getYears() + " years, "
            + diffPeriod.getMonths() + " months, "
            + diffPeriod.getDays() + " days");

        // Duration: time-based (hours, minutes, seconds)
        LocalTime time1 = LocalTime.of(8, 15, 0);
        LocalTime time2 = LocalTime.of(17, 45, 30);
        Duration diffDuration = Duration.between(time1, time2);
        System.out.println("Duration between " + time1 + " and " + time2 + ": "
            + diffDuration.toHours() + " hours, "
            + (diffDuration.toMinutes() % 60) + " minutes, "
            + (diffDuration.getSeconds() % 60) + " seconds");

        // Duration can also be used with LocalDateTime or Instant
        LocalDateTime dt1 = LocalDateTime.of(2024, 1, 1, 10, 0);
        LocalDateTime dt2 = LocalDateTime.of(2024, 1, 2, 12, 30);
        Duration dateTimeDuration = Duration.between(dt1, dt2);
        System.out.println("Duration between " + dt1 + " and " + dt2 + ": "
            + dateTimeDuration.toHours() + " hours, "
            + (dateTimeDuration.toMinutes() % 60) + " minutes");


        //formatter 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currDateTime);
        String formattedDate = today.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);

        //parse
        String dateString = "2024-12-25";
        LocalDate parsedDate = LocalDate.parse(dateString, formatter);
        System.out.println("Parsed Date: " + parsedDate);

        System.out.println("==========================");


        //immutability
        LocalDate immutableDate = LocalDate.now();
        immutableDate.plusDays(3);
        System.out.println(immutableDate);
        System.out.println("Immutable Date after plusDays(3) without assignment: " + immutableDate);
        immutableDate = immutableDate.plusDays(3);
        System.out.println("Immutable Date after plusDays(3) with assignment: " + immutableDate);


        //comparison
        LocalDate dateA = LocalDate.of(2024, 6, 15);
        LocalDate dateB = LocalDate.of(2024, 12, 31);
        if (dateA.isBefore(dateB)) {
            System.out.println(dateA + " is before " + dateB);  
        } else if (dateA.isAfter(dateB)) {
            System.out.println(dateA + " is after " + dateB);
        } else {
            System.out.println(dateA + " is equal to " + dateB);    
        }
    }
}
