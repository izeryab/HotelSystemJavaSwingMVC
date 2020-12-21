package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.CustomerController;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class CustomerView extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Font mainLabel;
    private CustomerController controller;
    private JTable table;

    public CustomerView() {
        mainLabel = new Font("Arial", Font.BOLD, 34);
        controller = new CustomerController(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 590, 387);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel csDetails = new JLabel("Customer Details");
        csDetails.setFont(mainLabel);
        csDetails.setForeground(Color.WHITE);
        csDetails.setBounds(150, 5, 300, 30);
        contentPane.add(csDetails);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 40, 530, 263);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "ID No", "Name", "Phone No", "Duration", "No of Peoples" }));
        scrollPane.setViewportView(table);
        controller.setTabel();

        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(223, 315, 117, 25);
        contentPane.add(mainMenu);

        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("Back.jpg"));
        background.setBounds(0, 0, 605, 354);
        contentPane.add(background);

        mainMenu.addActionListener(controller);
    }

    public void setTable() {
        table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "ID No", "Name", "Phone No", "Duration", "No of Peoples" }));
    }

    public JTable getTable() {
        return table;
    }
}
