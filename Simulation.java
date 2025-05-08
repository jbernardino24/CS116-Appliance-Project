public class Simulation {

    private ApplianceSet applianceSet;
    private Random random;
    private static final int WATTAGE_LIMIT = 2000; // Example wattage limit

    public Simulation(ApplianceSet applianceSet) {
        this.applianceSet = applianceSet;
        this.random = new Random();
    }

    public void runSimulation(int intervals) {
        if (applianceSet == null || applianceSet.getCount() == 0) {
            System.out.println("No appliances to simulate.");
            return;
        }

        System.out.println("\nRunning Simulation for " + intervals + " intervals:");
        List<Appliance> allAppliances = new ArrayList<>();
        //Get all appliances.
        for(Appliance appliance: applianceSet.appliances){
            allAppliances.add(appliance);
        }

        for (int i = 0; i < intervals; i++) {
            System.out.println("\n--- Interval " + (i + 1) + " ---");
            int currentWattage = 0;
            List<String> affected = new ArrayList<>();
            List<SmartAppliance> smartAppliancesOn = new ArrayList<>();

             // Determine appliance states and calculate wattage
            for (Appliance appliance : allAppliances) {
                boolean isOn = random.nextDouble() < appliance.getProbOn();
                int wattage = 0;

                if (appliance instanceof SmartAppliance) {
                  SmartAppliance smartAppliance = (SmartAppliance) appliance; // Cast to SmartAppliance
                    wattage = smartAppliance.getReducedWatts(isOn);
                  if (isOn) {
                        smartAppliancesOn.add(smartAppliance);
                    }
                } else {
                    wattage = isOn ? appliance.getOnWatts() : appliance.getOffWatts();
                }

                currentWattage += wattage;
                if (isOn) {
                    affected.add(appliance.getName() + " (ON, " + wattage + "W)");
                } else {
                    affected.add(appliance.getName() + " (OFF, " + wattage + "W)");
                }
            }

            if (currentWattage > WATTAGE_LIMIT) {
                System.out.println("Wattage limit exceeded! Current wattage: " + currentWattage + "W > " + WATTAGE_LIMIT + "W");
                int excessWattage = currentWattage - WATTAGE_LIMIT;
                reduceSmartApplianceUsage(smartAppliancesOn, excessWattage, affected);
            }

             // Print report for this interval
            System.out.println("Affected Appliances/Locations:");
            if (affected.isEmpty()) {
                System.out.println("None");
            } else {
                for (String s : affected) {
                    System.out.println(s);
                }
            }
            System.out.println("Total Wattage: " + currentWattage + "W");
          }
        generateSummaryReport();
    }
     private void reduceSmartApplianceUsage(List<SmartAppliance> smartAppliances, int excessWattage, List<String> affected) {
        if (smartAppliances == null || smartAppliances.isEmpty()) {
            System.out.println("No smart appliances to reduce usage.");
            return;
        }
        // Sort smart appliances by reduction percentage (highest first)
        smartAppliances.sort(Comparator.comparingDouble(SmartAppliance::getReducePercentage).reversed());

        int wattageReduced = 0;
        for (SmartAppliance appliance : smartAppliances) {
            // Calculate how much wattage can be reduced by this appliance
            int reducibleWatts = (int) (appliance.getOnWatts() * appliance.getReducePercentage());

            if (reducibleWatts > 0) {
                // Reduce the appliance's usage
                wattageReduced += reducibleWatts;
                affected.remove(appliance.getName() + " (ON, " + appliance.getOnWatts() + "W)");
                affected.add(appliance.getName() + " (ON, " + appliance.getReducedWatts(true) + "W - Reduced)");

                System.out.println("Reduced " + appliance.getName() + " by " + reducibleWatts + "W");
                if (wattageReduced >= excessWattage) {
                    break; // Stop if enough wattage has been reduced
                }
            }
        }
       if (wattageReduced < excessWattage) {
            System.out.println("Could not reduce wattage enough.  Remaining excess: " + (excessWattage - wattageReduced) + "W");
        }
    }

    private void generateSummaryReport() {
        System.out.println("\n--- Simulation Summary Report ---");
        System.out.println("Total Locations: " + countLocations());
        Map<String, Integer> applianceCounts = countAppliancesByType();
        for (Map.Entry<String, Integer> entry : applianceCounts.entrySet()) {
            System.out.println("Total " + entry.getKey() + ": " + entry.getValue());
        }
    }

     private int countLocations() {
        Set<Long> locations = new HashSet<>();
        for (Appliance appliance : applianceSet.appliances) {
            locations.add(appliance.getLocation());
        }
        return locations.size();
    }

    private Map<String, Integer> countAppliancesByType() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Appliance", 0);
        counts.put("SmartAppliance", 0);

         for (Appliance appliance : applianceSet.appliances) {
            if (appliance instanceof SmartAppliance) {
                counts.put("SmartAppliance", counts.get("SmartAppliance") + 1);
            } else {
                counts.put("Appliance", counts.get("Appliance") + 1);
            }
        }
        return counts;
    }
}
       
            


        
       
       

      
