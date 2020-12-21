package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Customer;
import Model.CustomerInfo;
import view.CustomerView;
import view.MainPanel;

public class CustomerController implements ActionListener{
    private CustomerView custV;

    public CustomerController(CustomerView customerView) {
        custV = customerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel panel=new MainPanel();
        panel.setVisible(true);
        custV.dispose();
    }
    
    public void setTabel() {
        ArrayList<Customer> arr=CustomerInfo.getCustomers();
        custV.setTable();
        DefaultTableModel model=(DefaultTableModel) custV.getTable().getModel();
        for(var x:arr)
            model.addRow(new Object[]{x.getIDNo(),x.getNameSurName(),x.getPhoneNo(),x.getDuration(),x.getNoOfPeople()});
    }

}
