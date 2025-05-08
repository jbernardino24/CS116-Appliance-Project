public class ApplianceSet extends Appliance {

    private Appliance[] appliances;
    private static int counter;

    public ApplianceSet() {
        ApplianceSet[] List = new ApplianceSet[10000];
    }

    public ApplianceSet(int range) {
        ApplianceSet[] UserList = new ApplianceSet[range];
    }

    public int getCount() {
        counter = 0;

        for (int i = 0; i < appliances.length; i++) {
            if (appliances[i] != null) {
                counter++;
            }
        }

        return counter;
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
}
