package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Customer;
import Model.CustomerInfo;
import Model.Extra;
import Model.HotelSys;
import Model.Payment;
import Model.Reservation;
import Model.ReservationInfo;
import Model.Room;
import view.MainPanel;
import view.ReservationView;

public class ReservationController implements ActionListener{
    private ReservationView res;
    private ArrayList<Room> lis;
    private ReservationInfo reserv;
    private CustomerInfo cust;
    public ReservationController(ReservationView reservationView) {
        this.res=reservationView;
        lis=HotelSys.getRooms();
        reserv=new ReservationInfo();
        cust=new CustomerInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var source=e.getSource();
        if(source.equals(res.getAdd()) && !res.isEmpty() ) {
            int r=res.getRoomNoT();
            Room ro=null;
            for(var x:lis) {
                if(x.getRoomNo()==r) {
                    ro=x;
                    break;
                }
            }
            if(ro==null) {
                JOptionPane.showMessageDialog(null, "Room Not Available");
                return;
            }
            Customer cu=new Customer(res.getName(),res.getPhoneT(), res.getIdT(), res.getDurationT(), res.getNoofPeople());
            if(!cust.add(cu))return;
            cust.save();
            Extra ex=null;
            if(res.getMas())ex=new Extra();
            Payment pay=new Payment(ro, cu, ex);
            Reservation res=new Reservation(cu, ro, pay);
            reserv.newReservation(res);
            reserv.save();
            JOptionPane.showMessageDialog(null, "Added");
            this.res.clear();
        }else if(source.equals(res.getClear())) {
            res.clear();
        }else if(source.equals(res.getMain())) {
            MainPanel frame=new MainPanel();
            frame.setVisible(true);
            res.dispose();
        }
    }

}
