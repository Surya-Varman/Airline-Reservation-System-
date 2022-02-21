import java.util.ArrayList;
import java.util.Scanner;

public class RegisterCompanion {
    //this class is used to register a companion for the customer
    Scanner scanner = new Scanner(System.in);
    public void AddCompanion(ArrayList<Companion> C){
        Companion companion = new Companion();
        System.out.println("Enter the name of the Companion: ");
        String name = scanner.nextLine();
        companion.setName(name);
        System.out.println("Enter the gender of the companion");
        String gender = scanner.nextLine();
        companion.setGender(gender);
        System.out.println("Enter the age of the companion");
        int age = scanner.nextInt();
        scanner.nextLine();
        companion.setAge(age);
        System.out.println("Enter the passport number of the companion");
        String passportno = scanner.nextLine();
        companion.setPassPortNumber(passportno);
        System.out.println("Enter the aadhar number of the companion");
        String aadharNumber = scanner.nextLine();
        companion.setAadharNumber(aadharNumber);
        C.add(companion);
    }
}
