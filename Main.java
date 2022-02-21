import java.util.Scanner;

public class Main extends DataBase {
    public static void main(String[] args){
        //this is the main class with the main function.
        Scanner scanner = new Scanner(System.in);
        Register register = new Register();
        Reservation reservation = new Reservation();
        Admin admin = new Admin();
        //we are adding 2 flights initially for the sake of convenience
        Flight sampleflight = new Flight("sample1");
        Flight sampleflight2 = new Flight("sample2");
        admin.Flights.put("MH1234",sampleflight);
        admin.Flights.put("TN1204",sampleflight2);
        airport a = new airport();
        Airports.put("Mumbai",a);
        airport b = new airport();
        Airports.put("Chennai",a);
        //
        boolean isrunning = true;
        while(isrunning){
            System.out.println("Choose the operation that you want to perform: ");
            System.out.println("1.Register Customer");
            System.out.println("2.Book a Flight Ticket");
            System.out.println("3.Cancel Flight Ticket");
            System.out.println("4.Admin settings");
            System.out.println("5.Exit");
            int option  = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    int no =register.RegisterCustomer(scanner);
                    break;
                case 2:
                    boolean temp =reservation.ShowFlights();
                    if(!temp)
                        break;
                    System.out.println("Enter the flight number of the flight which you want to travel. Enter skip if you want to exit this window");
                    String flightnumber = scanner.nextLine();
                    if(flightnumber.equalsIgnoreCase("skip"))
                        break;
                    else{
                    reservation.MakeReservation(flightnumber);
                    }
                    break;
                case 3:
                    admin.CancelReservation();
                    break;
                case 4:
                    System.out.println("Enter the admin password");
                    String password = scanner.nextLine();
                    if(password.equals(admin.getPassword())){
                        System.out.println("Admin Settings");
                        System.out.println("1.Add Flight");
                        System.out.println("2.Remove Flight");
                        System.out.println("3.Change Fares");
                        System.out.println("4.Change Departure Time");
                        System.out.println("5.Change Arrival Time");
                        int option1 = scanner.nextInt();
                        scanner.nextLine();
                        switch (option1){
                            case 1:
                                admin.AddFlight();
                                break;
                            case 2:
                                admin.RemoveFlight();
                                break;
                            case 3:
                                System.out.println("Enter the flight number to which you want the change the fares for");
                                String FlightNumber = scanner.nextLine();
                                System.out.println("Do you want to change the business class fares or economical class fares");
                                String WhichClass = scanner.nextLine();
                                System.out.println("Enter the new fares value ");
                                int NewFares = scanner.nextInt();
                                scanner.nextLine();
                                admin.ChangeFares(FlightNumber,NewFares,WhichClass);
                                break;
                            case 4:
                                System.out.println("Enter the flight number to which you want the change the Departure Time for");
                                String FlightNumber1 = scanner.nextLine();
                                System.out.println("Enter the new departure time for the flight");
                                String NewDepartureTime = scanner.nextLine();
                                admin.ChangeDepartureTime(FlightNumber1,NewDepartureTime);
                                break;
                            case 5:
                                System.out.println("Enter the flight number to which you want the change the arrival Time for");
                                String FlightNumber2 = scanner.nextLine();
                                System.out.println("Enter the new arrival time for the flight");
                                String NewArrivalTime = scanner.nextLine();
                                admin.ChangeArrivalTime(FlightNumber2,NewArrivalTime);
                                break;
                        }
                    }
                    else{
                        System.out.println("The password entered is wrong");
                    }
                    break;
                case 5:
                    isrunning=false;
                    break;
            }





        }

    }
}
