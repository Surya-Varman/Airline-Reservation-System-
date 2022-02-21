import java.util.Scanner;
/*
private String Name,PermanentAddress,CurrentAddress,PhoneNo,Occupation;
    private String PassportNo,AadharNo;
    private int Age;
 */
public class Register extends DataBase{
    private int GenerateAccountNumber(){
        int account_number;
        account_number = (int)(100000*Math.random());
        if(CustomerList.containsKey(account_number)){
            account_number = GenerateAccountNumber();
        }
        return account_number;
    }

    public int RegisterCustomer(Scanner scanner){
        String Name,PermanentAddress,CurrentAddress,PhoneNo,Occupation,PassportNo,AadharNo;
        int Age;
        Customer customer = new Customer();
        System.out.println("Welcome To XYZ Airlines.\nPlease enter the following details to register.");
        System.out.println("Enter your name:");
        Name = scanner.nextLine();
        customer.setName(Name);
        System.out.println("Enter your age:");
        Age = scanner.nextInt();
        scanner.nextLine();
        customer.setAge(Age);
        System.out.println("Enter your Permanent Address");
        PermanentAddress = scanner.nextLine();
        customer.setPermanentAddress(PermanentAddress);
        System.out.println("Is your current address same as your permanent address Y/N?");
        String res = scanner.nextLine();
        if(res.equalsIgnoreCase("Y")){
            customer.setCurrentAddress(PermanentAddress);
        }
        else{
            System.out.println("Enter your current address ");
            CurrentAddress = scanner.nextLine();
            customer.setCurrentAddress(CurrentAddress);
        }
        System.out.println("Enter your phone number ");
        PhoneNo= scanner.nextLine();
        customer.setPhoneNo(PhoneNo);
        System.out.println("Enter your occupation ");
        Occupation = scanner.nextLine();
        customer.setOccupation(Occupation);
        System.out.println("Enter your passport number ");
        customer.setPassportNo(scanner.nextLine());
        System.out.println("Enter your aadhar number ");
        customer.setAadharNo(scanner.nextLine());
        System.out.println("Do you have anyone with whom you frequently travel with? y/n?");
        if(scanner.nextLine().equals("y")){
            int NoOfPeople;
            System.out.println("How many people do you travel with frequently?");
            NoOfPeople = scanner.nextInt();
            scanner.nextLine();
            RegisterCompanion registerCompanion = new RegisterCompanion();
            for(int i=0;i<NoOfPeople;i++){
                registerCompanion.AddCompanion(customer.Companions);
            }
        }
        int account_number = GenerateAccountNumber();
        System.out.println("Your account number is "+account_number);
        CustomerList.put(account_number,customer);
        return account_number;
    }
}
