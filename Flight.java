import java.util.HashMap;

public class Flight {
    private String FlightNumber,DepartureCity,ArrivalCity;
    private double Duration,fares,BusinessClassFares,EconomicalClassFares;
    private int BusinessSeats,EconomicalSeats,NoOfStops,BusinessSeatsOccupied,EconomicalSeatsOccupied;
    private boolean InternationalFlight,OneWayTrip;
    private String DepartureTime,ArrivalTime;
    Flight(String sample1){
        if(sample1.equalsIgnoreCase("sample1"))
        {
            this.FlightNumber ="MH1234";
            this.DepartureCity = "Mumbai";
            this.ArrivalCity ="Chennai";
            this.Duration =2.5;
            this.BusinessClassFares = 2500;
            this.EconomicalClassFares=1750;
            this.EconomicalSeats=5;
            this.BusinessSeats=5;
            this.NoOfStops =2;
            this.InternationalFlight=false;
            this.OneWayTrip=true;
            this.LayOvers.put("Kolkata",2.5);
            this.LayOvers.put("Delhi",4d);
            this.DepartureTime="9AM";
            this.ArrivalTime="11AM";
            this.BusinessSeatsOccupied=0;
            this.EconomicalSeatsOccupied=0;
        }
        else if(sample1.equalsIgnoreCase(("sample2"))){
            this.FlightNumber ="TN1204";
            this.DepartureCity = "Chennai";
            this.ArrivalCity ="Bangalore";
            this.Duration =3;
            this.BusinessClassFares = 3000;
            this.EconomicalClassFares=2200;
            this.EconomicalSeats=10;
            this.BusinessSeats=10;
            this.NoOfStops =0;
            this.InternationalFlight=false;
            this.OneWayTrip=true;
            this.DepartureTime="4PM";
            this.ArrivalTime="6PM";
            this.BusinessSeatsOccupied=0;
            this.EconomicalSeatsOccupied=0;
        }
    }
    public void ShowDetails(){
        System.out.println("Flight Number: "+this.FlightNumber+" Duration: "+this.Duration);
        System.out.println("Number of business class seats available: "+NoOfEmptyBusinessSeats());
        System.out.println("Number of economical class seats available: "+NoOfEmptyEconomicalSeats());
        System.out.println("Business Class Fares: "+this.BusinessClassFares+" Economical Class Fares: "+this.EconomicalClassFares);
        if(this.NoOfStops==0)
        System.out.println("No of stops: "+this.NoOfStops);
        else{
            System.out.println("Layovers and their durations(in hours) are: ");
            System.out.println(LayOvers);
        }
        if(this.OneWayTrip)
        System.out.println("Trip type: One Way trip");
        else
            System.out.println("Trip type: Two Way trip");
        System.out.println("Departure Time: "+this.DepartureTime+"  Arrival Time: "+this.ArrivalTime);
    }

    public double getBusinessClassFares() {
        return BusinessClassFares;
    }

    public void setBusinessClassFares(double businessClassFares) {
        BusinessClassFares = businessClassFares;
    }

    public double getEconomicalClassFares() {
        return EconomicalClassFares;
    }

    public void setEconomicalClassFares(double economicalClassFares) {
        EconomicalClassFares = economicalClassFares;
    }

    public void UpdateSeats(String s, int n){
        if(s.equalsIgnoreCase("b")){
            this.BusinessSeatsOccupied+=n;
        }
        else
            this.EconomicalSeatsOccupied+=n;
    }
    public int getBusinessSeatsOccupied() {
        return BusinessSeatsOccupied;
    }

    public void setBusinessSeatsOccupied(int businessSeatsOccupied) {
        BusinessSeatsOccupied = businessSeatsOccupied;
    }

    public int getEconomicalSeatsOccupied() {
        return EconomicalSeatsOccupied;
    }

    public void setEconomicalSeatsOccupied(int economicalSeatsOccupied) {
        EconomicalSeatsOccupied = economicalSeatsOccupied;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public HashMap<String,Double>LayOvers = new HashMap<>();
    Flight(){
        this.BusinessSeatsOccupied=0;
        this.EconomicalSeatsOccupied=0;
    }
    public boolean BusinessSeatsIsFull(int n){
            if(BusinessSeats<((BusinessSeatsOccupied)+n))
                return true;
            else
                return false;
    }
    public boolean EconomicalSeatsIsFull(int n){
        if(EconomicalSeats<((EconomicalSeatsOccupied)+n))
            return true;
        else
            return false;
    }
    public int NoOfEmptyBusinessSeats(){
        return (this.BusinessSeats-this.BusinessSeatsOccupied);
    }
    public int NoOfEmptyEconomicalSeats(){
        return (this.EconomicalSeats-this.EconomicalSeatsOccupied);
    }

    public String getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return DepartureCity;
    }

    public void setDepartureCity(String departureCity) {
        DepartureCity = departureCity;
    }

    public String getArrivalCity() {
        return ArrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        ArrivalCity = arrivalCity;
    }

    public double getDuration() {
        return Duration;
    }

    public void setDuration(double duration) {
        Duration = duration;
    }

    public double getFares(char n) {
        if(n=='B' || n=='b')
            return this.BusinessClassFares;
        else
            return this.EconomicalClassFares;
    }

    public void setFares(double fares) {
        this.fares = fares;
    }

    public int getBusinessSeats() {
        return BusinessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        BusinessSeats = businessSeats;
    }

    public int getEconomicalSeats() {
        return EconomicalSeats;
    }

    public void setEconomicalSeats(int economicalSeats) {
        EconomicalSeats = economicalSeats;
    }

    public int getNoOfStops() {
        return NoOfStops;
    }

    public void setNoOfStops(int noOfStops) {
        NoOfStops = noOfStops;
    }

    public boolean isInternationalFlight() {
        return InternationalFlight;
    }

    public void setInternationalFlight(boolean internationalFlight) {
        InternationalFlight = internationalFlight;
    }

    public boolean isOneWayTrip() {
        return OneWayTrip;
    }

    public void setOneWayTrip(boolean oneWayTrip) {
        OneWayTrip = oneWayTrip;
    }
}
