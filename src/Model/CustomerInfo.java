package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;


public class CustomerInfo {
    private ArrayList<Customer> arr;

    public CustomerInfo() {
        arr = CustomerInfo.getCustomers();
    }
    
    public boolean add(Customer cust) {
        for(var x:arr)
            if(x.equals(cust) || cust.getIDNo()==x.getIDNo()) {
                JOptionPane.showMessageDialog(null, "Customer Id available");
                return false;
            }
        arr.add(cust);
        return true;
    }
    
    public void add(String nameSurName, int phoneNo, int iDNo, int duration, int noOfPeople) {
        Customer cust=new Customer(nameSurName, phoneNo, iDNo, duration, noOfPeople);
        for(var x:arr)
            if(x.equals(cust) || cust.getIDNo()==x.getIDNo())
                return;
        arr.add(cust);
    }
    
    public void remove(int idNo) {
        for(var x:arr) {
            if(x.getIDNo()==idNo) {
                arr.remove(x);
                return;
            }
        }
    }
    
    public static ArrayList<Customer> getCustomers(){
        ArrayList<Customer> array = new ArrayList<>();
        try {
            File file = new File(".//TxtFiles//CustomerDetails.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(str, "#");
                String nameSurName=token.nextToken();
                int phoneNo=Integer.parseInt(token.nextToken());
                int iDNo=Integer.parseInt(token.nextToken());
                int duration=Integer.parseInt(token.nextToken());
                int noOfPeople=Integer.parseInt(token.nextToken());
                Customer cust=new Customer(nameSurName, phoneNo, iDNo, duration, noOfPeople);
                array.add(cust);
            }
            reader.close();
        } catch (Exception e) {
        }
        return array;
    }
    
    public void save() {
        try {
            File file = new File(".//TxtFiles//CustomerDetails.txt");
            PrintWriter writer = new PrintWriter(file);
            for (var x : arr) {
                writer.write(x.getNameSurName() + "#" +
                             x.getPhoneNo() +"#"+
                             x.getIDNo()+"#"+
                             x.getDuration()+"#"+
                             x.getNoOfPeople()+"\n");
            }
            writer.close();
        } catch (Exception e) {
        }
    }
}
