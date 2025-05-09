
import java.util.*;

public class ApplianceSortTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Appliance[] list = new Appliance[5];
        for (int i = 0; i < list.length; i++) {
            String stringRead = in.nextLine();
            StringTokenizer st = new StringTokenizer(stringRead, ",");
            long location = Long.parseLong(st.nextToken());
            String name = st.nextToken();
            int onW = Integer.parseInt(st.nextToken());
            int offW = Integer.parseInt(st.nextToken());
            double probOn = Double.parseDouble(st.nextToken());
            if (st.hasMoreTokens()) {
                double reducePercent = Double.parseDouble(st.nextToken());
                list[i] = new SmartAppliance(location, name, onW, offW, probOn, reducePercent);
            } else {
                list[i] = new Appliance(location, name, onW, offW, probOn);
            }
        }
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
