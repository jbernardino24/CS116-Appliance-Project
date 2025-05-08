
import java.util.Scanner;

public class ApplianceSmartApplianceTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testNumber = input.nextInt();
        boolean pass = true;
        if (testNumber == 1) { // Test Case 1 - Appliance constructor (args OK), toString()
            Appliance o1 = new Appliance(10000001, "Video Game", 50, 0, 0.167);
            boolean a1 = o1.toString().equals("1 Loc=10000001 Name=Video Game OnW=50 OffW=0 ProbOn=0.167");
            if (!a1) {
                System.out.println("Appliance constructor all args OK");
                System.out.println("Expected Output:" + "1 Loc=10000001 Name=Video Game OnW=50 OffW=0 ProbOn=0.167");
                System.out.println("Your Output    :" + o1.toString());
                pass = false;
            }
            Appliance o2 = new Appliance(10000001, "Dishwasher", 200, 0, 0.05);
            boolean a2 = o2.toString().equals("2 Loc=10000001 Name=Dishwasher OnW=200 OffW=0 ProbOn=0.05");
            if (!a2) {
                System.out.println("Appliance constructor all args OK");
                System.out.println("Expected Output:" + "2 Loc=10000001 Name=Dishwasher OnW=200 OffW=0 ProbOn=0.05");
                System.out.println("Your Output    :" + o2.toString());
                pass = false;
            }
            Appliance o3 = new Appliance(12345678, "Video Game", 50, 0, 0.1);
            boolean a3 = o3.toString().equals("3 Loc=12345678 Name=Video Game OnW=50 OffW=0 ProbOn=0.1");
            if (!a3) {
                System.out.println("Appliance constructor all args OK");
                System.out.println("Expected Output:" + "3 Loc=12345678 Name=Video Game OnW=50 OffW=0 ProbOn=0.1");
                System.out.println("Your Output    :" + o3.toString());
                pass = false;
            }
        }
        if (testNumber == 2) { // Test Case 2 - Appliance constructor (args not OK)
            Appliance o1 = new Appliance(1001, "Video Game", 50, 0, 0.167);
            boolean a1 = o1.toString().equals("1 Loc=99999999 Name=Video Game OnW=50 OffW=0 ProbOn=0.167");
            if (!a1) {
                System.out.println("Appliance constructor - location invalid");
                System.out.println("Expected Output:" + "1 Loc=99999999 Name=Video Game OnW=50 OffW=0 ProbOn=0.167");
                System.out.println("Your Output    :" + o1.toString());
                pass = false;
            }
            Appliance o2 = new Appliance(10000001, null, 200, 0, 0.05);
            boolean a2 = o2.toString().equals("2 Loc=10000001 Name=UNKNOWN OnW=200 OffW=0 ProbOn=0.05");
            if (!a2) {
                System.out.println("Appliance constructor - name invalid");
                System.out.println("Expected Output:" + "2 Loc=10000001 Name=UNKNOWN OnW=200 OffW=0 ProbOn=0.05");
                System.out.println("Your Output    :" + o2.toString());
                pass = false;
            }
            Appliance o3 = new Appliance(12345678, "Video Game", 1, 0, 0.1);
            boolean a3 = o3.toString().equals("3 Loc=12345678 Name=Video Game OnW=1 OffW=0 ProbOn=0.1");
            if (!a3) {
                System.out.println("Appliance constructor - on watts invalid");
                System.out.println("Expected Output:" + "3 Loc=12345678 Name=Video Game OnW=1 OffW=0 ProbOn=0.1");
                System.out.println("Your Output    :" + o3.toString());
                pass = false;
            }
            Appliance o4 = new Appliance(22222222, "Video Game", 50, -1, 0.167);
            boolean a4 = o4.toString().equals("4 Loc=22222222 Name=Video Game OnW=50 OffW=0 ProbOn=0.167");
            if (!a4) {
                System.out.println("Appliance constructor - off watts invalid");
                System.out.println("Expected Output:" + "4 Loc=22222222 Name=Video Game OnW=50 OffW=0 ProbOn=0.167");
                System.out.println("Your Output    :" + o4.toString());
                pass = false;
            }
            Appliance o5 = new Appliance(10000001, "hair dryer", 200, 0, 1.1);
            boolean a5 = o5.toString().equals("5 Loc=10000001 Name=hair dryer OnW=200 OffW=0 ProbOn=0.0");
            if (!a5) {
                System.out.println("Appliance constructor - prob on invalid");
                System.out.println("Expected Output:" + "5 Loc=10000001 Name=hair dryer OnW=200 OffW=0 ProbOn=0.0");
                System.out.println("Your Output    :" + o5.toString());
                pass = false;
            }
        }
        if (testNumber == 3) { // Test Case 3 - Appliance equals
            Appliance o1 = new Appliance(123456781, "Video Game", 50, 0, 0.167);
            Appliance o2 = new Appliance(22222222, "Video Game", 50, 0, 0.167);
            boolean a12 = o1.equals(o2);
            if (!a12) {
                System.out.println("Appliance - equals TRUE");
                System.out.println("Expected Output:" + "true");
                System.out.println("Your Output    :" + a12);
                pass = false;
            }
            boolean a21 = o2.equals(o1);
            if (!a21) {
                System.out.println("Appliance - reverse equals TRUE");
                System.out.println("Expected Output:" + "true");
                System.out.println("Your Output    :" + a21);
                pass = false;
            }
            Appliance o3 = new Appliance(22222222, "Video", 50, 0, 0.167);
            boolean a13 = o1.equals(o3);
            if (a13) {
                System.out.println("Appliance - equals FALSE name");
                System.out.println("Expected Output:" + "false");
                System.out.println("Your Output    :" + a13);
                pass = false;
            }
            Appliance o4 = new Appliance(22222222, "Video Game", 51, 0, 0.167);
            boolean a14 = o1.equals(o4);
            if (a14) {
                System.out.println("Appliance - equals FALSE on watt");
                System.out.println("Expected Output:" + "false");
                System.out.println("Your Output    :" + a14);
                pass = false;
            }
            Appliance o5 = new Appliance(22222222, "Video Game", 50, 1, 0.167);
            boolean a15 = o1.equals(o5);
            if (a15) {
                System.out.println("Appliance - equals FALSE off watt");
                System.out.println("Expected Output:" + "false");
                System.out.println("Your Output    :" + a15);
                pass = false;
            }
            Appliance o6 = new Appliance(123456781, "Video Game", 50, 0, 0.166);
            boolean a16 = o1.equals(o6);
            if (a16) {
                System.out.println("Appliance - equals FALSE prob on");
                System.out.println("Expected Output:" + "false");
                System.out.println("Your Output    :" + a16);
                pass = false;
            }
        }
        
		if (testNumber==4) { // Test Case 4 - SmartAppliance constructor (args OK), toString()
			SmartAppliance o1 = new SmartAppliance(10000001,"Video Game",50,0,0.167,.25);
			boolean a1=o1.toString().equals("1 Loc=10000001 Name=Video Game OnW=50 OffW=0 ProbOn=0.167 Reduce%=0.25");
			if (!a1) {
				System.out.println("SmartAppliance constructor all args OK");
				System.out.println("Expected Output:"+"1 Loc=10000001 Name=Video Game OnW=50 OffW=0 ProbOn=0.167 Reduce%=0.25");
				System.out.println("Your Output    :"+o1.toString());
				pass=false;
			}
			SmartAppliance o2 = new SmartAppliance(10000001,"Dishwasher",200,0,0.05,.5);
			boolean a2=o2.toString().equals("2 Loc=10000001 Name=Dishwasher OnW=200 OffW=0 ProbOn=0.05 Reduce%=0.5");
			if (!a2) {
				System.out.println("SmartAppliance constructor all args OK");
				System.out.println("Expected Output:"+"2 Loc=10000001 Name=Dishwasher OnW=200 OffW=0 ProbOn=0.05 Reduce%=0.5");
				System.out.println("Your Output    :"+o2.toString());
				pass=false;
			}	
			SmartAppliance o3 = new SmartAppliance(12345678,"Video Game",50,0,0.1,1);
			boolean a3=o3.toString().equals("3 Loc=12345678 Name=Video Game OnW=50 OffW=0 ProbOn=0.1 Reduce%=1.0");
			if (!a3) {
				System.out.println("SmartAppliance constructor all args OK");
				System.out.println("Expected Output:"+"3 Loc=12345678 Name=Video Game OnW=50 OffW=0 ProbOn=0.1 Reduce%=1.0");
				System.out.println("Your Output    :"+o3.toString());				
				pass=false;
			}
		}	
		if (testNumber==5) { // Test Case 5 - SmartAppliance constructor (args not OK)
			SmartAppliance o1 = new SmartAppliance(10011001,"Video Game",50,0,0.167, -.1);
			boolean a1=o1.toString().equals("1 Loc=10011001 Name=Video Game OnW=50 OffW=0 ProbOn=0.167 Reduce%=1.0");
			if (!a1) {
				System.out.println("SmartAppliance constructor - reduce percentage negative");
				System.out.println("Expected Output:"+"1 Loc=10011001 Name=Video Game OnW=50 OffW=0 ProbOn=0.167 Reduce%=1.0");
				System.out.println("Your Output    :"+o1.toString());
				pass=false;
			}
			SmartAppliance o2 = new SmartAppliance(10000001,"Washer",200,0,0.05, 1.1);
			boolean a2=o2.toString().equals("2 Loc=10000001 Name=Washer OnW=200 OffW=0 ProbOn=0.05 Reduce%=1.0");
			if (!a2) {
				System.out.println("SmartAppliance constructor - reduce percentage >1");
				System.out.println("Expected Output:"+"2 Loc=10000001 Name=Washer OnW=200 OffW=0 ProbOn=0.05 Reduce%=1.0");
				System.out.println("Your Output    :"+o2.toString());
				pass=false;
			}			
		}			
		if (testNumber==6) { // Test Case 6 - SmartAppliance equals
			SmartAppliance o1 = new SmartAppliance(123456781,"Video Game",50,0,0.167,.5);
			SmartAppliance o2 = new SmartAppliance(22222222,"Video Game",50,0,0.167,.5);
			boolean a12=o1.equals(o2);
			if (!a12) {
				System.out.println("SmartAppliance - equals TRUE");
				System.out.println("Expected Output:"+"true");
				System.out.println("Your Output    :"+a12);
				pass=false;
			}
			boolean a21=o2.equals(o1);
			if (!a21) {
				System.out.println("SmartAppliance - reverse equals TRUE");
				System.out.println("Expected Output:"+"true");
				System.out.println("Your Output    :"+a21);
				pass=false;
			}		
			SmartAppliance o3 = new SmartAppliance(22222222,"Video Game",50,0,0.167,.51);
			boolean a13=o1.equals(o3);
			if (a13) {
				System.out.println("SmartAppliance - equals FALSE reducePercent");
				System.out.println("Expected Output:"+"false");
				System.out.println("Your Output    :"+a13);
				pass=false;
			}			
			Appliance o4 = new Appliance(22222222,"Video Game",50,0,0.167);
			boolean a34=o3.equals(o4);
			if (a34) {
				System.out.println("SmartAppliance to Appliance - equals FALSE");
				System.out.println("Expected Output:"+"false");
				System.out.println("Your Output    :"+a34);
				pass=false;
			}
			boolean a43=o4.equals(o3);
			if (!a43) {
				System.out.println("Appliance to SmartAppliance - equals TRUE");
				System.out.println("Expected Output:"+"true");
				System.out.println("Your Output    :"+a43);	
				pass=false;
			}			
		}	
         
        System.out.println(pass);
    }
}
