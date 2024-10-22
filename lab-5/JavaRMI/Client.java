import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null, 1099);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("Response: " + response);

            // modified code

            Scanner input = new Scanner(System.in);
            // user input
            System.out.println(
                    "Choose an operation:\n"
                +   "(1) Addition"
                +   "(2) Subtraction"
                +   "(3) Multiplication"
                +   "(4) Division"
            );
            int selection = 0;
            do {
                selection = input.nextInt();
            } while (selection < 1 && selection > 4);

            System.out.println("Enter first number");
            int a = input.nextInt();
            System.out.println("Enter second number");
            int b = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 1:
                    // addition
                    response = String.valueOf(stub.addition(a, b));
                    System.out.println("Response (addition): " + response);
                    break;
                case 2:
                    // subtraction
                    response = String.valueOf(stub.subtraction(a, b));
                    System.out.println("Response (subtraction): " + response);
                    break;
                case 3:
                    // multiplication 
                    response = String.valueOf(stub.multiplication(a, b));
                    System.out.println("Response (multiplication): " + response);
                    break;
                case 4:
                    // division
                    response = String.valueOf(stub.division(a, b));
                    System.out.println("Response (division): " + response);
                    break;
                default:
                    break;
            }

            input.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
