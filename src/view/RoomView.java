package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.RoomController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class RoomView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private JButton add;
    private JRadioButton suitR;
    private JRadioButton honeyR;
    private JRadioButton normalR;
    private Font mainLabel;
    private Font label;
    private RoomController controller;
    private JButton remove;
    private JButton main;
    private JLabel warning;

    /**
     * Create the frame.
     */
    public RoomView() {
        mainLabel = new Font("Arial", Font.BOLD, 34);
        label = new Font("Arial", Font.BOLD, 14);
        controller = new RoomController(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 590, 387);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(149, 44, 429, 279);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Sr No.", "Room No", "Status" }));
        scrollPane.setViewportView(table);
        controller.setTable();

        JLabel room = new JLabel("Room");
        room.setBounds(250, 5, 114, 43);
        contentPane.add(room);

        JLabel roomNo = new JLabel("Room No");
        roomNo.setBounds(0, 45, 70, 15);
        contentPane.add(roomNo);

        suitR = new JRadioButton("Suit");
        suitR.setBounds(10, 105, 149, 23);
        contentPane.add(suitR);

        honeyR = new JRadioButton("HoneyMoon");
        honeyR.setBounds(10, 130, 149, 23);
        contentPane.add(honeyR);

        normalR = new JRadioButton("Normal");
        normalR.setBounds(10, 155, 149, 23);
        contentPane.add(normalR);

        add = new JButton("Add Room");
        add.setBounds(20, 186, 117, 20);
        contentPane.add(add);

        remove = new JButton("remove");
        remove.setBounds(20, 220, 117, 20);
        contentPane.add(remove);

        main = new JButton("Main Menu");
        main.setBounds(20, 250, 117, 20);
        contentPane.add(main);

        warning = new JLabel("Wrong Room No");
        warning.setForeground(Color.YELLOW);
        warning.setBounds(10, 95, 150, 15);
        warning.setVisible(false);
        contentPane.add(warning);

        textField = new JTextField();
        textField.setBounds(5, 67, 135, 25);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("Back.jpg"));
        background.setBounds(0, 0, 605, 354);
        contentPane.add(background);

        suitR.setOpaque(false);
        normalR.setOpaque(false);
        honeyR.setOpaque(false);

        room.setFont(mainLabel);
        room.setForeground(Color.WHITE);
        roomNo.setFont(label);
        roomNo.setForeground(Color.WHITE);
        suitR.setFont(label);
        suitR.setForeground(Color.WHITE);
        honeyR.setFont(label);
        honeyR.setForeground(Color.WHITE);
        normalR.setFont(label);
        normalR.setForeground(Color.WHITE);

        add.addActionListener(controller);
        remove.addActionListener(controller);
        main.addActionListener(controller);

        honeyR.addActionListener(controller);
        suitR.addActionListener(controller);
        normalR.addActionListener(controller);

    }

    public JTable getTable() {
        return table;
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getRemove() {
        return remove;
    }

    public JButton getMain() {
        return main;
    }

    public JRadioButton getSuitR() {
        return suitR;
    }

    public JRadioButton getNormalR() {
        return normalR;
    }

    public JRadioButton getHoneyR() {
        return honeyR;
    }

    public int getRoomNo() {
        int i;
        try {
            i = Integer.parseInt(textField.getText());
            return i;
        } catch (Exception e) {
            warning.setVisible(true);
        }
        return -1;
    }

    public void setTable() {
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Sr No.", "Room No", "Status" }));
    }

}
