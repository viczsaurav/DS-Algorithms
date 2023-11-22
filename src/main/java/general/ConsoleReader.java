package general;

import java.util.*;
public class ConsoleReader {

    // This will not work in IDE This is because IDEs provide their own console environment,
    // and the System.console() method returns null when the program is run from an IDE.
//    public static void main(String[] args) {
//        while(true){
//            String name = System.console().readLine();
//            System.out.println("My Name is " + name);
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter Name: ");
            String name =  scanner.nextLine();
            System.out.println("My Name is " + name);
        }
    }
}
