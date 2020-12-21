package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ReservationController;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class ReservationView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Font buttonFont;
    private Font labelFont;
    private ReservationController controller;
    private JTextField nameT;
    private JTextField phoneT;
    private JTextField idT;
    private JTextField durationT;
    private JTextField noT;
    private JTextField roomNoT;
    private JCheckBox mas;
    private JButton add;
    private JButton main;
    private JButton clear;

    public ReservationView() {
        this.controller = new ReservationController(this);
        buttonFont = new Font("Arial", Font.BOLD, 16);
        labelFont = new Font("Arial", Font.BOLD, 36);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 274);
        setTitle("Hotel System");
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        add = new JButton("ADD");
        add.setBounds(100, 205, 117, 25);
        contentPane.add(add);

        main = new JButton("Main Menu");
        main.setBounds(229, 205, 117, 25);
        contentPane.add(main);

        JLabel res = new JLabel("Reservation");
        res.setFont(labelFont);
        res.setForeground(Color.WHITE);
        res.setBounds(190, 5, 236, 30);
        contentPane.add(res);

        JLabel name = new JLabel("Name");
        name.setBounds(20, 47, 70, 15);
        contentPane.add(name);

        nameT = new JTextField();
        nameT.setBounds(100, 40, 150, 25);
        contentPane.add(nameT);
        nameT.setColumns(10);

        JLabel phoneNo = new JLabel("Phone No.");
        phoneNo.setBounds(10, 87, 100, 15);
        contentPane.add(phoneNo);

        phoneT = new JTextField();
        phoneT.setColumns(10);
        phoneT.setBounds(100, 80, 150, 25);
        contentPane.add(phoneT);

        idT = new JTextField();
        idT.setColumns(10);
        idT.setBounds(100, 120, 150, 25);
        contentPane.add(idT);

        JLabel idNo = new JLabel("ID No");
        idNo.setBounds(20, 127, 70, 15);
        contentPane.add(idNo);

        durationT = new JTextField();
        durationT.setColumns(10);
        durationT.setBounds(373, 80, 150, 25);
        contentPane.add(durationT);

        JLabel duration = new JLabel("Duration");
        duration.setBounds(293, 87, 70, 15);
        contentPane.add(duration);

        noT = new JTextField();
        noT.setColumns(10);
        noT.setBounds(373, 117, 150, 25);
        contentPane.add(noT);

        JLabel noOf = new JLabel("Peoples");
        noOf.setBounds(293, 124, 84, 15);
        contentPane.add(noOf);

        clear = new JButton("clear");
        clear.setBounds(358, 205, 117, 25);
        contentPane.add(clear);

        JLabel roomNo = new JLabel("Room No");
        roomNo.setBounds(290, 47, 80, 15);
        contentPane.add(roomNo);

        roomNoT = new JTextField();
        roomNoT.setColumns(10);
        roomNoT.setBounds(373, 40, 150, 25);
        contentPane.add(roomNoT);

        mas = new JCheckBox("Massage and Room service");
        mas.setBounds(20, 160, 250, 23);
        contentPane.add(mas);

        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("Back.jpg"));
        background.setBounds(0, 0, 605, 354);
        contentPane.add(background);

        name.setForeground(Color.WHITE);
        phoneNo.setForeground(Color.WHITE);
        roomNo.setForeground(Color.WHITE);
        duration.setForeground(Color.WHITE);
        idNo.setForeground(Color.WHITE);
        noOf.setForeground(Color.WHITE);
        mas.setForeground(Color.WHITE);

        name.setFont(buttonFont);
        phoneNo.setFont(buttonFont);
        roomNo.setFont(buttonFont);
        duration.setFont(buttonFont);
        idNo.setFont(buttonFont);
        noOf.setFont(buttonFont);
        mas.setFont(buttonFont);

        mas.setOpaque(false);

        main.addActionListener(controller);
        clear.addActionListener(controller);
        add.addActionListener(controller);
    }

    public Font getLabelFont() {
        return labelFont;
    }

    public String getName() {
        return nameT.getText();
    }

    public int getPhoneT() {
        try {
            return Integer.parseInt(phoneT.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public int getIdT() {
        try {
            return Integer.parseInt(idT.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public int getDurationT() {
        try {
            return Integer.parseInt(durationT.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public int getNoofPeople() {
        try {
            return Integer.parseInt(noT.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public int getRoomNoT() {
        try {
            return Integer.parseInt(roomNoT.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean getMas() {
        return mas.isSelected();
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getMain() {
        return main;
    }

    public JButton getClear() {
        return clear;
    }

    public void clear() {
        roomNoT.setText("");
        nameT.setText("");
        phoneT.setText("");
        idT.setText("");
        durationT.setText("");
        noT.setText("");
        mas.setSelected(false);
    }
    
    public boolean isEmpty() {
        return roomNoT.getText().equals("") ||
                nameT.getText().equals("") ||
                phoneT.getText().equals("")  ||
                idT.getText().equals("") ||
                durationT.getText().equals("") ||
                noT.getText().equals("") ||
                mas.getText().equals("") ;
    }
}