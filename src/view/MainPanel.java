package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.MainController;

import javax.swing.JLabel;
import javax.swing.JButton;

public class MainPanel extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Font buttonFont;
    private Font labelFont;
    private MainController controller;
    private JButton room;
    private JButton exit;
    private JButton customer;
    private JButton reservation;
    private JButton payment;

    /**
     * Create the frame.
     */
    public MainPanel() {
        this.controller = new MainController(this);
        buttonFont = new Font("Arial", Font.BOLD, 16);
        labelFont = new Font("Arial", Font.BOLD, 36);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 211);
        setTitle("Hotel System");
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        room = new JButton("Room");
        room.setFont(buttonFont);
        room.setBounds(53, 63, 130, 25);
        contentPane.add(room);

        payment = new JButton("Payment");
        payment.setFont(buttonFont);
        payment.setBounds(53, 100, 130, 25);
        contentPane.add(payment);

        exit = new JButton("Exit");
        exit.setFont(buttonFont);
        exit.setBounds(152, 137, 130, 25);
        contentPane.add(exit);

        customer = new JButton("Customer");
        customer.setFont(buttonFont);
        customer.setBounds(247, 100, 130, 25);
        contentPane.add(customer);

        reservation = new JButton("Reservation");
        reservation.setFont(buttonFont);
        reservation.setBounds(247, 63, 130, 25);
        contentPane.add(reservation);

        JLabel mainLabel = new JLabel("Hotel System");
        mainLabel.setFont(labelFont);
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setBounds(105, 15, 242, 37);
        contentPane.add(mainLabel);

        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("Back.jpg"));
        background.setBounds(0, -12, 450, 263);
        contentPane.add(background);

        room.addActionListener(controller);
        payment.addActionListener(controller);
        reservation.addActionListener(controller);
        customer.addActionListener(controller);
        exit.addActionListener(controller);
    }

    public JButton getCustomer() {
        return customer;
    }

    public JButton getExit() {
        return exit;
    }

    public JButton getReservation() {
        return reservation;
    }

    public JButton getRoom() {
        return room;
    }

    public JButton getPayment() {
        return payment;
    }
}
