
import java.util.ArrayList;
import java.util.List;

public class ApplianceSet extends Appliance {

    private Appliance[] appliances;
    private int count;

    public ApplianceSet() {
        super(0L, "Default Appliance Set", 0, 0, 0.0); // Provide default values
        this.appliances = new Appliance[10];
        this.count = 0;
    }

    public ApplianceSet(int initialCapacity) {
        super(0L, "User Defined Set", 0, 0, 0.0); // Provide default values
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.appliances = new Appliance[initialCapacity];
        this.count = 0;
    }

    public int getCount() {
        count = 0;

        for (int i = 0; i < appliances.length; i++) {
            if (appliances[i] != null) {
                count++;
            }
        }

        return count;
    }

    public boolean addAppliance(Appliance newA) {
        if (newA == null) {
            return false; // Do not add if the appliance is null
        }

        // Check if the collection is full
        if (getCount() == appliances.length) {
            // Double the size of the collection
            int newCapacity = appliances.length * 2;
            Appliance[] newAppliances = new Appliance[newCapacity];
            System.arraycopy(appliances, 0, newAppliances, 0, appliances.length);
            appliances = newAppliances;
        }

        // Add the new Appliance to the collection
        for (int i = 0; i < appliances.length; i++) {
            if (appliances[i] == null) {
                appliances[i] = newA;
                return true;
            }
        }

        return false;
    }

    public String getCustomerAppliances(long keyLocation) {
        return "";
    }

    public String toString() {
        return "";
    }

    public boolean deleteAppliance(int idToDelete) {
        for (int i = 0; i < count; i++) {
            if (appliances[i] != null && appliances[i].getApplianceID() == idToDelete) {
                // Found the appliance to delete
                // Shift subsequent elements to fill the gap
                for (int j = i; j < count - 1; j++) {
                    appliances[j] = appliances[j + 1];
                }
                appliances[count - 1] = null; // Clear the last element
                count--;
                return true; // Deletion successful
            }
        }
        return false; // Appliance with the given ID not found
    }

    public Appliance findAppliance(int idToFind) {
        for (int i = 0; i < count; i++) {
            if (appliances[i] != null && appliances[i].getApplianceID() == idToFind) {
                return appliances[i]; // Found the appliance
            }
        }
        return null; // Appliance with the given ID not found

    }

    public List<Appliance> getAppliancesByLocation(long location) {
        List<Appliance> foundAppliances = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (appliances[i] != null && appliances[i].getLocation() == location) {
                foundAppliances.add(appliances[i]);
            }
        }
        return foundAppliances;
    }

    public List<Appliance> getAppliancesByType(String type) {
        List<Appliance> foundAppliances = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (appliances[i] != null) {
                // Check if the appliance's class name matches the requested type
                if (appliances[i].getClass().getSimpleName().equalsIgnoreCase(type)) {
                    foundAppliances.add(appliances[i]);
                }
            }
        }
        return foundAppliances;
    }
}
