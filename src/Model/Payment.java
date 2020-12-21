package Model;

import java.util.Random;

public class Payment {
    private Room room;
    private Customer cust;
    private double amount;
    private int bill_No;
    private Extra extra;

    public Payment(Room r, Customer cu, Extra ex) {
        this.room = r;
        this.extra = ex;
        this.cust = cu;
        if (room.status().equals("Suit")) {
            cust.getInput(100);
            amount = cust.calculate();

        } else if (room.status().equals("Normal")) {
            cust.getInput(50);
            amount = cust.calculate();
        } else {
            cust.getInput(80);
            amount = cust.calculate();
        }
        Random rand = new Random();
        this.bill_No = rand.nextInt(100);
    }

    public void delete() {
        room = null;
        amount = -1;
        extra = null;
        bill_No = -1;
    }

    public double calculate() {
        double pay = amount;
        if (extra != null)
            pay += extra.getMassage() + extra.getSpa() + extra.getRoomService();
        return pay;
    }

    @Override
    public String toString() {
        return "Payment [room=" + room + ", amount=" + amount + ", bill_No=" + bill_No + ", extra=" + extra + "]";
    }

    public Extra getExtra() {
        return extra;
    }

    public Customer getCust() {
        return cust;
    }

    public Room getRoom() {
        return room;
    }
}
