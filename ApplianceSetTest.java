
import java.util.Scanner;

public class ApplianceSetTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testNumber = input.nextInt();
        boolean pass = true;
        if (testNumber == 1) { // Test Case 1 - addAppliance (basic)
            ApplianceSet list = new ApplianceSet(2);
            Appliance o1 = new Appliance(10000001, "Video Game", 200, 0, 0.167);
            SmartAppliance r1 = new SmartAppliance(10000001, "Clothes Washer", 1200, 0, 0.025, 0.25);
            list.addAppliance(o1);
            list.addAppliance(r1);
            boolean a1 = list.toString().equals("Count=2\n1 Loc=10000001 Name=Video Game OnW=200 OffW=0 ProbOn=0.167\n2 Loc=10000001 Name=Clothes Washer OnW=1200 OffW=0 ProbOn=0.025 Reduce%=0.25\n");
            if (!a1) {
                System.out.println("add 1 appliance and 1 smart appliance");
                System.out.println("Expected Output:" + "Count=2\n1 Loc=10000001 Name=Video Game OnW=200 OffW=0 ProbOn=0.167\n2 Loc=10000001 Name=Clothes Washer OnW=1200 OffW=0 ProbOn=0.025 Reduce%=0.25\n");
                System.out.println("Your Output    :" + list.toString());
                pass = false;
            }
        }
        if (testNumber == 2) { // Test Case 2 - addAppliance (advanced)
            ApplianceSet list = new ApplianceSet(2);
            Appliance o1 = new Appliance(10000001, "Video Game", 200, 0, 0.167);
            SmartAppliance r1 = new SmartAppliance(10000001, "Clothes Washer", 1200, 0, 0.025, 0.25);
            list.addAppliance(o1);
            list.addAppliance(r1);
            Appliance o2 = new Appliance(10000002, "Lighting - 100 Watt", 100, 0, 0.33);
            list.addAppliance(o2);
            boolean a2 = list.toString().equals("Count=3\n1 Loc=10000001 Name=Video Game OnW=200 OffW=0 ProbOn=0.167\n2 Loc=10000001 Name=Clothes Washer OnW=1200 OffW=0 ProbOn=0.025 Reduce%=0.25\n3 Loc=10000002 Name=Lighting - 100 Watt OnW=100 OffW=0 ProbOn=0.33\n");
            if (!a2) {
                System.out.println("add 3 object, force ApplianceSet growth");
                System.out.println("Expected Output:" + "Count=3\n1 Loc=10000001 Name=Video Game OnW=200 OffW=0 ProbOn=0.167\n2 Loc=10000001 Name=Clothes Washer OnW=1200 OffW=0 ProbOn=0.025 Reduce%=0.25\n3 Loc=10000002 Name=Lighting - 100 Watt OnW=100 OffW=0 ProbOn=0.33\n");
                System.out.println("Your Output    :" + list.toString());
                pass = false;
            }
            list.addAppliance(null);
            boolean a3 = list.toString().equals("Count=3\n1 Loc=10000001 Name=Video Game OnW=200 OffW=0 ProbOn=0.167\n2 Loc=10000001 Name=Clothes Washer OnW=1200 OffW=0 ProbOn=0.025 Reduce%=0.25\n3 Loc=10000002 Name=Lighting - 100 Watt OnW=100 OffW=0 ProbOn=0.33\n");
            if (!a3) {
                System.out.println("add null object, no change");
                System.out.println("Expected Output:" + "Count=3\n1 Loc=10000001 Name=Video Game OnW=200 OffW=0 ProbOn=0.167\n2 Loc=10000001 Name=Clothes Washer OnW=1200 OffW=0 ProbOn=0.025 Reduce%=0.25\n3 Loc=10000002 Name=Lighting - 100 Watt OnW=100 OffW=0 ProbOn=0.33\n");
                System.out.println("Your Output    :" + list.toString());
                pass = false;
            }
            o2.setName("computer");
            boolean a4 = list.toString().equals("Count=3\n1 Loc=10000001 Name=Video Game OnW=200 OffW=0 ProbOn=0.167\n2 Loc=10000001 Name=Clothes Washer OnW=1200 OffW=0 ProbOn=0.025 Reduce%=0.25\n3 Loc=10000002 Name=Lighting - 100 Watt OnW=100 OffW=0 ProbOn=0.33\n");
            if (!a4) {
                System.out.println("verify deep copy on last appliance added, no change");
                System.out.println("Expected Output:" + "Count=3\n1 Loc=10000001 Name=Video Game OnW=200 OffW=0 ProbOn=0.167\n2 Loc=10000001 Name=Clothes Washer OnW=1200 OffW=0 ProbOn=0.025 Reduce%=0.25\n3 Loc=10000002 Name=Lighting - 100 Watt OnW=100 OffW=0 ProbOn=0.33\n");
                System.out.println("Your Output    :" + list.toString());
                pass = false;
            }
        }
        if (testNumber == 3) { // Test Case 3 - getCustomerAppliances
            ApplianceSet list = new ApplianceSet(2);
            Appliance o1 = new Appliance(10000001, "Video Game", 200, 0, 0.167);
            Appliance o2 = new Appliance(10000002, "Lighting - 100 Watt", 100, 0, 0.33);
            SmartAppliance r1 = new SmartAppliance(10000001, "Clothes Washer", 1200, 0, 0.025, 0.25);
            list.addAppliance(o1);
            list.addAppliance(o2);
            list.addAppliance(r1);
            boolean a3 = list.getCustomerAppliances(10000001).equals("1 Loc=10000001 Name=Video Game OnW=200 OffW=0 ProbOn=0.167\n3 Loc=10000001 Name=Clothes Washer OnW=1200 OffW=0 ProbOn=0.025 Reduce%=0.25\n");
            if (!a3) {
                System.out.println("get customer appliances - location OK");
                System.out.println("Expected Output:" + "1 Loc=10000001 Name=Video Game OnW=200 OffW=0 ProbOn=0.167\n3 Loc=10000001 Name=Clothes Washer OnW=1200 OffW=0 ProbOn=0.025 Reduce%=0.25\n");
                System.out.println("Your Output    :" + list.getCustomerAppliances(10000001));
                pass = false;
            }
            boolean a4 = list.getCustomerAppliances(11111111).equals("");
            if (!a4) {
                System.out.println("get customer appliances - location not OK");
                System.out.println("Expected Output:" + "");
                System.out.println("Your Output    :" + list.getCustomerAppliances(11111111));
                pass = false;
            }
        }
        System.out.println(pass);
    }
}
