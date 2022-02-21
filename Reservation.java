import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Reservation extends DataBase{
    //this class will add reservation and handle payments
    Date d = new Date();
    Scanner scanner = new Scanner(System.in);
    Register register = new Register();
    RegisterCompanion RC = new RegisterCompanion();
    String TicketsGenerated[];
    double TotalFare=0;
    public boolean ShowFlights(){
        System.out.println("Where do want to fly from?");
        String DepartureCity = scanner.nextLine();
        System.out.println("Enter your destination");
        String ArrivalCity = scanner.nextLine();
        Iterator<String> iterator = Flights.keySet().iterator();
        boolean flag = false;

        while(iterator.hasNext()){
            String key = iterator.next();
            if(Flights.get(key).getDepartureCity().equalsIgnoreCase(DepartureCity) && Flights.get(key).getArrivalCity().equalsIgnoreCase(ArrivalCity)){
                flag =true;
                System.out.println("------------------------------------------------------------------------");
                Flights.get(key).ShowDetails();
                System.out.println("------------------------------------------------------------------------");
            }
        }
        if(!flag)
        {
            System.out.println("Sorry no flights are available based on your preferences.");
            return flag;
        }
        else
        {
            System.out.println("Kindly select the flight you want to travel from the list above ");
        }
        return true;

    }


    //this function will make a reservation and will generate tickets
    public void MakeReservation(String FlightNumber){
        int AccountNumber=0;
        System.out.println("Do you already have an account?(y/n)");
        String temp = scanner.nextLine();
        if(temp.equalsIgnoreCase("n"))
        {
            AccountNumber=register.RegisterCustomer(scanner);
        }
        else{
            System.out.println("Enter your account number");
            AccountNumber = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("How many people are you travelling with now?");
        int NoOfPeople = scanner.nextInt();
        scanner.nextLine();
        if(NoOfPeople!=0) {
            System.out.println("How many of these people are NOT registered as your companions");
            int NoOfNotCompanions = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < NoOfNotCompanions; i++) {
                RC.AddCompanion(CustomerList.get(AccountNumber).Companions);
            }
        }
        System.out.println("Do you want to travel in business class or economical class?(b/e)");
        String BorE = scanner.nextLine();
        int TemporaryTicketNumber=-1;
        char TravelClass='N';   //this variable is used to store whether the person is travelling in business class or economical class
        if(BorE.equalsIgnoreCase("b")){
                if(Flights.get(FlightNumber).BusinessSeatsIsFull(NoOfPeople+1))
                    System.out.println("We don't have the capacity to accommodate all of you");
                else
                {
                    TemporaryTicketNumber = Flights.get(FlightNumber).getBusinessSeatsOccupied();
                    Flights.get(FlightNumber).UpdateSeats("b",NoOfPeople+1);
                    TravelClass = 'B';
                }
        }
        else{
            if(Flights.get(FlightNumber).EconomicalSeatsIsFull(NoOfPeople+1))
                System.out.println("We don't have the capacity to accommodate all of you");
            else
            {
                TemporaryTicketNumber = Flights.get(FlightNumber).getEconomicalSeatsOccupied();
                Flights.get(FlightNumber).UpdateSeats("e",NoOfPeople+1);
                TravelClass='E';
            }
        }
         if(NoOfPeople==0){}
         //   System.out.println("Kindle enter your name");
          else
            System.out.println("Kindly enter the name of your companions");
        String AllNames=""; //this will show the tickets generated
        TicketsGenerated = new String[NoOfPeople+1];
        String TicName;
        for(int i=0;i<NoOfPeople+1;i++){
            if(i==0){
                TicName = CustomerList.get(AccountNumber).getName();
            }
            else
                TicName = scanner.nextLine();
            String TempTic = FlightNumber+TravelClass+String.valueOf(TemporaryTicketNumber);
            AllNames = String.valueOf(i+1)+")"+"Name: "+TicName+" "+"TicketNumber: "+TempTic+" Fare: "+String.valueOf(Flights.get(FlightNumber).getFares(TravelClass));//this string is used to display all the names
            TotalFare = TotalFare+Flights.get(FlightNumber).getFares(TravelClass);
            //Tickets.add(TempTic);
            Tickets.put(TempTic,TicName);
            TicketsGenerated[i] = AllNames;
            TemporaryTicketNumber++;
        }
        this.Payments();
        this.GenerateBill(FlightNumber);
        this.TotalFare=0;

        //update the seats after generating the tickets
        /*Thing yet to be done
        * 1)Generate and store the ticket number in the arraylist of the Tickets present in the DataBase class. -->Done<--
        * 2)We should also print the ticket to the user so that he will know his ticket number. -->Done<--
        * 3)Handle the payments method so that the customer will pay for everyone
        * */


    }

    public void GenerateBill(String FlightNumber){
        System.out.println("----------------------Ticket--------------------------");
        System.out.println("--"+d+"--");
        System.out.println("From: "+Flights.get(FlightNumber).getDepartureCity());
        System.out.println("To: "+Flights.get(FlightNumber).getArrivalCity());
        System.out.println("Boarding time " +Flights.get(FlightNumber).getDepartureTime());
        for(int i=0;i<TicketsGenerated.length;i++){
            System.out.println(TicketsGenerated[i]);
        }

        System.out.println("Your total fare is "+TotalFare);
        System.out.println("------------------------------------------------------");
    }
    public void Payments(){
       // System.out.println("Your total fare is: "+TotalFare);
        System.out.println("How do you want to pay for your tickets?");
        System.out.println("1.Credit card");
        System.out.println("2.Debit card");
        System.out.println("3.Netbanking");
        int Case = scanner.nextInt();
        scanner.nextLine();
        switch(Case){
            case 1:
                System.out.println("Enter your Credit Card number: ");
                String CardNumber = scanner.nextLine();
                //we are not collecting the atm pin because we assume that the payments will be taken care by the card reader
                //and we assume that the payment will be successful every time
                System.out.println("Payment successfull!!");
                break;
            case 2:
                System.out.println("Enter your Debit Card number: ");
                String CardNumberDebit = scanner.nextLine();
                //we are not collecting the atm pin because we assume that the payments will be taken care by the card reader
                //and we assume that the payment will be successful every time
                System.out.println("Payment successful!!");
                break;
            case 3:
                System.out.println("Enter your online bank user id");
                String userid = scanner.nextLine();
                System.out.println("enter your online bank password");
                String password = scanner.nextLine();
                //since we do not have any method to check the balance in the user's bank account we make an
                //assumtion that the transaction will always be succesfull.
                System.out.println("Transaction successful");
                break;
        }
    }



}
