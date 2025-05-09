
import java.util.*;

public class TestExceptions {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int i = 0;  // declare an initialize variables BEFORE the try block
        boolean inputNotOK = true;

        while (inputNotOK) {
            try {
                // code that might generate an exception
                i = s.nextInt();  // if exception, skip the rest of this block
                // if no exception, continue the code in the block
                if (i < 0) {   // negaitve integer goes TRUE here not the catch
                    System.out.println("zero or greater integer please");
                } else {

                    double x = 8 / i;
                    System.out.println(x);
                    inputNotOK = false;
                }
            } catch (InputMismatchException ime) {
                // code to recover from the exception
                System.out.println("I said an integer");
                String garbage = s.next();   // clears the Scanner buffer of non-int data
            } catch (ArithmeticException ae) {
                // code to recover from the exception
                System.out.println("no divide by zero allowed");
            }

        }    // end of while loop, executed after a catch, or the try sucessful

        System.out.println(i);
    }
}
