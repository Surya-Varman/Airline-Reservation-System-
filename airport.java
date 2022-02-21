import java.util.ArrayList;
import java.util.HashMap;

public class airport extends DataBase {
    //this is the airport class this class will store information about the airports and the flights from the airports
    private String City;
    ArrayList<String> FlightNumber = new ArrayList<>();
    HashMap<String,String> FlightTimings = new HashMap<>(); //this hashmap will contain the fight's departure time
     //this class will contain the name of the city the airport is located in and the flights which leave the city
    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
