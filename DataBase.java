import java.util.HashMap;

public class DataBase {
    //we are using the static keyword so that the values remain same at all times
    //this class is the important class which will store the information about the customers,flights,tickets and airports like we have in the real life system
    //whenever a new object of Customer,Flight,Ticket is created,the information will automatically be stored in the Tickets class
    static HashMap<Integer,Customer> CustomerList = new HashMap<>();
    static HashMap<String,Flight> Flights = new HashMap<>();
    static HashMap<String,String> Tickets = new HashMap<>();
    static HashMap<String,airport> Airports = new HashMap<>();
}
