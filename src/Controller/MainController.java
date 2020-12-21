package Controller;
import java.awt.event.*;

import javax.swing.JButton;

import view.CustomerView;
import view.MainPanel;
import view.PaymentView;
import view.ReservationView;
import view.RoomView;
public class MainController implements ActionListener{
    private MainPanel pan;
    public MainController(MainPanel mainPanel) {
        this.pan=mainPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        var b=(JButton) e.getSource();
        if (b.equals(pan.getExit())){
            System.exit(0);
        }else if(b.equals(pan.getRoom())) {
            RoomView view=new RoomView();
            view.setVisible(true);
        }else if(b.equals(pan.getPayment())) {
            PaymentView view=new PaymentView();
            view.setVisible(true);
        }else if(b.equals(pan.getReservation())) {
            ReservationView view=new ReservationView();
            view.setVisible(true);
        }else if(b.equals(pan.getCustomer())) {
            CustomerView view=new CustomerView();
            view.setVisible(true);
        }
        pan.dispose();
    }

}
