import java.util.ArrayList;

public class Customer {
    //This class stores all the information of the customer
    private String Name,PermanentAddress,CurrentAddress,PhoneNo,Occupation;
    private String PassportNo,AadharNo;
    private int Age;
    public ArrayList<Companion> Companions;
    Customer(){
        Companions =new ArrayList<>();
    }
    public String getName() {
        return Name;
    }

    public void setName(String  name) {
        Name = name;
    }
    public int getAge(){
        return this.Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }


    public String getPermanentAddress() {
        return PermanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        PermanentAddress = permanentAddress;
    }

    public String getCurrentAddress() {
        return CurrentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        CurrentAddress = currentAddress;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getPassportNo() {
        return PassportNo;
    }

    public void setPassportNo(String passportNo) {
        PassportNo = passportNo;
    }

    public String getAadharNo() {
        return AadharNo;
    }

    public void setAadharNo(String aadharNo) {
        AadharNo = aadharNo;
    }
}
