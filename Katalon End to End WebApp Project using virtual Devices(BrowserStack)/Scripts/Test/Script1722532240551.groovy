import java.time.LocalDateTime
import java.time.format.DateTimeFormatter



        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");

        // Format the current date and time
        String formattedDateTime = now.format(formatter);

        // Print the result
        System.out.println("Current DateTime Stamp: " + formattedDateTime);
