public class SmartAppliance extends Appliance {

    private double reducePercent;

    private static final double DEFAULT_REDUCE_PERCENT = 1;

    public SmartAppliance(long l, String n, int w1, int w2, double p1, double p2) {

        super(l, n, w1, w2, p1);

        setReducePercentage(p2);

    }

    public double getReducePercentage() {
        return reducePercent;
    }

    public void setReducePercentage(double newReducePercent) {

        if (newReducePercent > 0 && newReducePercent <= 1) {

            reducePercent = newReducePercent;

        } else {

            reducePercent = DEFAULT_REDUCE_PERCENT;

        }

    }

    public boolean equals(SmartAppliance a) {

        if (a != null) {

            return (super.equals(a) && Math.abs(reducePercent - a.reducePercent) < .000001);

        } else {

            return false;

        }

    }

    public boolean equals(Appliance a) {

        return false;

    }

    public String toString() {

        return getApplianceID() + " Loc=" + getLocation() + " Name=" + getName()
                + " OnW=" + getOnWatts() + " OffW=" + getOffWatts() + " ProbOn=" + getProbOn() + " Reduce%=" + getReducePercentage();

    }

}

