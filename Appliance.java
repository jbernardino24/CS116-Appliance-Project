
public class Appliance {

    private int applianceID;

    private long location;

    private String name;

    private int onW, offW;

    private double probOn;

    private static int counter = 1;

    private static final long DEFAULT_LOCATION = 99999999;

    private static final String DEFAULT_NAME = "UNKNOWN";

    private static final int DEFAULT_ON_WATTS = 1, DEFAULT_OFF_WATTS = 0;

    private static final double DEFAULT_PROB_ON = 0;

    public Appliance(long l, String n, int w1, int w2, double p) {

        applianceID = counter;
        setLocation(l);

        setName(n);
        setOnWatts(w1);

        setOffWatts(w2);
        setProbOn(p);

        counter++;

    }

    public int getApplianceID() {
        return applianceID;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long newLocation) {

        if (newLocation >= 10000000 && newLocation <= 99999999) {

            location = newLocation;

        } else {

            location = DEFAULT_LOCATION;

        }

    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {

        if (newName != null) {

            name = newName;

        } else {

            name = DEFAULT_NAME;

        }

    }

    public int getOnWatts() {
        return onW;
    }

    public void setOnWatts(int newOnW) {

        if (newOnW > 0) {

            onW = newOnW;

        } else {

            onW = DEFAULT_ON_WATTS;

        }

    }

    public int getOffWatts() {
        return offW;
    }

    public void setOffWatts(int newOffW) {

        if (newOffW >= 0) {

            offW = newOffW;

        } else {

            offW = DEFAULT_OFF_WATTS;

        }

    }

    public double getProbOn() {
        return probOn;
    }

    public void setProbOn(double newProbOn) {

        if (newProbOn > 0 && newProbOn <= 1) {

            probOn = newProbOn;

        } else {

            probOn = DEFAULT_PROB_ON;

        }

    }

    public boolean equals(Appliance a) {

        if (a != null) {

            return (name.equals(a.name) && onW == a.onW && offW == a.offW && Math.abs(probOn - a.probOn) < .000001);

        } else {

            return false;

        }

    }

    public String toString() {

        return getApplianceID() + " Loc=" + getLocation() + " Name=" + getName()
                + " OnW=" + getOnWatts() + " OffW=" + getOffWatts() + " ProbOn=" + getProbOn();

    }

}
