
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List; // You're using List
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Menu {

    private static ApplianceSet applianceSet = new ApplianceSet();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Main method to run the menu-driven system.
            while (true) {
                displayMenu();
                int choice = getUserChoice();
                processChoice(choice);
                if (choice == 0) {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); //clear buffer
        }
    }

    private static void displayMenu() {
        System.out.println("\nAppliance Management System Menu:");
        System.out.println("1. Add Appliance");
        System.out.println("2. Delete Appliance");
        System.out.println("3. Find Appliance");
        System.out.println("4. View Appliances by Location");
        System.out.println("5. View Appliances by Type");
        System.out.println("6. Load Appliances from File");
        System.out.println("7. Run Simulation");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    private static void processChoice(int choice) {
        try {
            switch (choice) {
                case 1:
                    addAppliance();
                    break;
                case 2:
                    deleteAppliance();
                    break;
                case 3:
                    findAppliance();
                    break;
                case 4:
                    viewAppliancesByLocation();
                    break;
                case 5:
                    viewAppliancesByType();
                    break;
                case 6:
                    loadAppliancesFromFile();
                    break;
                case 7:
                    runSimulation();
                    break;
                case 0:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (ApplianceException e) {
            System.err.println("Error: " + e.getMessage()); // Use cerr for error messages
        }
    }

    private static void addAppliance() {
        System.out.println("\nAdd Appliance:");
        System.out.print("Location (8-digit number): ");
        long location = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("On Watts: ");
        int onWatts = scanner.nextInt();
        System.out.print("Off Watts: ");
        int offWatts = scanner.nextInt();
        System.out.print("Probability of Being On (0 to 1): ");
        double probOn = scanner.nextDouble();

        System.out.print("Is it a Smart Appliance? (yes/no): ");
        String isSmart = scanner.next();
        scanner.nextLine(); // Consume the newline

        Appliance newAppliance;
        if (isSmart.equalsIgnoreCase("yes")) {
            System.out.print("Reduction Percentage (0 to 1): ");
            double reductionPercentage = scanner.nextDouble();
            newAppliance = new SmartAppliance(location, name, onWatts, offWatts, probOn, reductionPercentage);
        } else {
            newAppliance = new Appliance(location, name, onWatts, offWatts, probOn);
        }
        if (applianceSet.addAppliance(newAppliance)) {
            System.out.println("Appliance added successfully.");
        } else {
            System.out.println("Failed to add appliance."); //Should not happen, but good to have.
        }
    }

    private static void deleteAppliance() throws ApplianceException {
        System.out.println("\nDelete Appliance:");
        System.out.print("Enter Appliance ID to delete: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline

        if (applianceSet.deleteAppliance(idToDelete)) {
            System.out.println("Appliance deleted successfully.");
        }
    }

    private static void findAppliance() {
        System.out.println("\nFind Appliance:");
        System.out.print("Enter Appliance ID to find: ");
        int idToFind = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline.

        Appliance foundAppliance = applianceSet.findAppliance(idToFind);
        if (foundAppliance != null) {
            System.out.println("Appliance found: " + foundAppliance);
        } else {
            System.out.println("Appliance not found.");
        }
    }

    private static void viewAppliancesByLocation() {
        System.out.println("\nView Appliances by Location:");
        System.out.print("Enter Location: ");
        long location = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        List<Appliance> appliances = applianceSet.getAppliancesByLocation(location);
        if (appliances.isEmpty()) {
            System.out.println("No appliances found at location " + location);
        } else {
            System.out.println("Appliances at Location " + location + ":");
            for (Appliance appliance : appliances) {
                System.out.println(appliance);
            }
        }
    }

    private static void viewAppliancesByType() {
        System.out.println("\nView Appliances by Type:");
        System.out.print("Enter Appliance Type (Appliance or SmartAppliance): ");
        String type = scanner.next();
        scanner.nextLine(); // Consume newline

        List<Appliance> appliances = applianceSet.getAppliancesByType(type);
        if (appliances.isEmpty()) {
            System.out.println("No appliances of type '" + type + "' found.");
        } else {
            System.out.println("Appliances of type '" + type + "':");
            for (Appliance appliance : appliances) {
                System.out.println(appliance);
            }
        }
    }

    private static void loadAppliancesFromFile() {
        System.out.println("\nLoad Appliances from File:");
        System.out.print("Enter filename: ");
        String filename = scanner.next();
        scanner.nextLine(); // Consume newline.

        File file = new File(filename);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int appliancesLoaded = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    try {
                        long location = Long.parseLong(parts[0].trim());
                        String name = parts[1].trim();
                        int onWatts = Integer.parseInt(parts[2].trim());
                        int offWatts = Integer.parseInt(parts[3].trim());
                        double probOn = Double.parseDouble(parts[4].trim());
                        String type = parts[5].trim();

                        Appliance newAppliance;
                        if (type.equalsIgnoreCase("SmartAppliance") && parts.length == 7) {
                            double reductionPercentage = Double.parseDouble(parts[6].trim());
                            newAppliance = new SmartAppliance(location, name, onWatts, offWatts, probOn, reductionPercentage);
                        } else if (type.equalsIgnoreCase("Appliance")) {
                            newAppliance = new Appliance(location, name, onWatts, offWatts, probOn);
                        } else {
                            System.out.println("Skipping invalid appliance type or format: " + line);
                            continue;
                        }

                        if (applianceSet.addAppliance(newAppliance)) {
                            appliancesLoaded++;
                        } else {
                            System.out.println("Failed to add appliance: " + line);
                        }

                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing line: " + line + ". Skipping.");
                    }
                } else {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
            System.out.println(appliancesLoaded + " appliances loaded from file.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void runSimulation() {
        if (applianceSet.getCount() == 0) {
            System.out.println("No appliances to simulate.");
            return;
        }
        System.out.println("\nRun Simulation:");
        System.out.print("Enter number of intervals: ");
        int intervals = scanner.nextInt();
        scanner.nextLine(); // Consume newline.
        Simulation simulation = new Simulation(applianceSet);
        simulation.runSimulation(intervals);
    }
}
