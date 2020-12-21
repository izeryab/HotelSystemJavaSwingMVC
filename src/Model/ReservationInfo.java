package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReservationInfo {
    private ArrayList<Reservation> reservation;

    public ReservationInfo() {
        reservation = ReservationInfo.getReservation();
    }

    public void newReservation(Reservation res) {
        for (var x : reservation) {
            if (x.equals(res))
                return;
        }
        reservation.add(res);
    }

    public boolean deleteReservation(Reservation re) {
        return reservation.remove(re);
    }

    public void modify(String cusName) {
        for (var re : reservation) {
            Customer cu = re.getCust();
            if (cusName.equals(cu.getNameSurName())) {

            }
        }
    }

    public void save() {
        try {
            File file = new File(".//TxtFiles//reservation.txt");
            PrintWriter writer = new PrintWriter(file);
            for (Reservation r : reservation) {
                String str = "";
                Room ro = r.getRoom();
                str += ro.getRoomNo() + "#" + ro.status() + "#";
                Customer cus = r.getCust();
                str += cus.getNameSurName() + "#" + cus.getPhoneNo() + "#" + cus.getIDNo() + "#" + cus.getDuration()
                        + "#" + cus.getNoOfPeople() + "#";
                Payment p = r.getPay();
                if (p.getExtra() != null)
                    str += "0\n";
                else
                    str += "8\n";
                writer.write(str);
            }
            writer.close();
        } catch (Exception e) {

        }
    }

    public static ArrayList<Reservation> getReservation() {
        ArrayList<Reservation> lis = new ArrayList<Reservation>();
        try {
            File file = new File(".//TxtFiles//reservation.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(str, "#");
                int roomNo = Integer.parseInt(token.nextToken());
                String st = token.nextToken();
                Room r;
                if (st.equals("Suit"))
                    r = new Suit(roomNo);
                else if (st.equals("Normal"))
                    r = new Normal(roomNo);
                else
                    r = new HoneyMoon(roomNo);
                String nameSurName = token.nextToken();
                int phoneNo = Integer.parseInt(token.nextToken());
                int iDNo = Integer.parseInt(token.nextToken());
                int duration = Integer.parseInt(token.nextToken());
                int noOfPeople = Integer.parseInt(token.nextToken());
                Customer cust = new Customer(nameSurName, phoneNo, iDNo, duration, noOfPeople);
                int extra = Integer.parseInt(token.nextToken());
                Payment pay;
                if (extra == 0)
                    pay = new Payment(r, cust, new Extra());
                else
                    pay = new Payment(r, cust, null);
                Reservation res = new Reservation(cust, r, pay);
                lis.add(res);
            }
            reader.close();
        } catch (Exception e) {
        }
        return lis;
    }
}
