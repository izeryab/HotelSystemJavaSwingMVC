package Model;

public class Customer {
    private String NameSurName;
    private int phoneNo;
    private int IDNo;
    private int Duration;
    private int NoOfPeople;
    private double total;

    public Customer(String nameSurName, int phoneNo, int iDNo, int duration, int noOfPeople) {
        NameSurName = nameSurName;
        this.phoneNo = phoneNo;
        IDNo = iDNo;
        Duration = duration;
        NoOfPeople = noOfPeople;
    }

    public String getNameSurName() {
        return NameSurName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public int getIDNo() {
        return IDNo;
    }

    public int getDuration() {
        return Duration;
    }

    public int getNoOfPeople() {
        return NoOfPeople;
    }

    public void setNameSurName(String nameSurName) {
        NameSurName = nameSurName;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setIDNo(int iDNo) {
        IDNo = iDNo;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public void setNoOfPeople(int noOfPeople) {
        NoOfPeople = noOfPeople;
    }

    @Override
    public String toString() {
        return "CustomerInfo [NameSurName=" + NameSurName + ", phoneNo=" + phoneNo + ", IDNo=" + IDNo + ", Duration="
                + Duration + ", NoOfPeople=" + NoOfPeople + "]";
    }

    public void getInput(double n) {
        this.total = n;
    }

    public double total() {
        return total;
    }

    public double calculate() {
        return total() * Duration;
    }
}
