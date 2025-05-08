import java.io.*;
import java.util.*;

// Custom Exception class for Appliance Management
class ApplianceException extends Exception {
    public ApplianceException(String message) {
        super(message);
        logException(message); // Log the exception
    }

     private void logException(String message) {
        try (FileWriter fw = new FileWriter("log.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(new Date() + ": " + message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
