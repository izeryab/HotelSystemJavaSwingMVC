package Model;

public class Reservation {
    private Customer cust;
    private Room room;
    private Payment pay;

    public Reservation() {
    }

    public Reservation(Customer cust, Room room, Payment pay) {
        this.cust = cust;
        this.room = room;
        this.pay = pay;
    }

    public Customer getCust() {
        return cust;
    }

    public Room getRoom() {
        return room;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Payment getPay() {
        return pay;
    }

    public void setPay(Payment pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
