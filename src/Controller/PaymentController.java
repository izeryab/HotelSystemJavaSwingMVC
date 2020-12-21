package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Payment;
import Model.Reservation;
import Model.ReservationInfo;
import view.MainPanel;
import view.PaymentView;

public class PaymentController implements ActionListener {
    private PaymentView pay;

    public PaymentController(PaymentView paymentView) {
        this.pay=paymentView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel panel = new MainPanel();
        panel.setVisible(true);
        pay.dispose();
    }

    public void setTabel() {
        ArrayList<Reservation> lis = ReservationInfo.getReservation();
        pay.setTable();
        DefaultTableModel model = (DefaultTableModel) pay.getTable().getModel();
        for (Reservation x : lis) {
            Payment p = x.getPay();
            model.addRow(new Object[] { p.getCust().getIDNo(), p.getRoom().getRoomNo(),p.calculate()});
        }
    }
}
