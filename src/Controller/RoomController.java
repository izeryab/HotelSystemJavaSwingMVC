package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.HotelSys;
import Model.Normal;
import Model.Room;
import view.MainPanel;
import view.RoomView;

public class RoomController implements ActionListener {
    private HotelSys hotel;
    private RoomView room;

    public RoomController(RoomView roomView) {
        this.room = roomView;
        hotel = new HotelSys();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var source = e.getSource();
        if (source instanceof JRadioButton) {
            room.getNormalR().setSelected(true);
            room.getSuitR().setSelected(true);
            room.getHoneyR().setSelected(true);
            if (source.equals(room.getHoneyR())) {
                room.getSuitR().setSelected(false);
                room.getNormalR().setSelected(false);
            } else if (source.equals(room.getSuitR())) {
                room.getHoneyR().setSelected(false);
                room.getNormalR().setSelected(false);
            } else if (source.equals(room.getNormalR())) {
                room.getSuitR().setSelected(false);
                room.getHoneyR().setSelected(false);
            }
        }
        if (source instanceof JButton) {
            if (source.equals(room.getAdd())) {
                addRoom();
            }else if(source.equals(room.getRemove())){
                removeRoom();
            }else if(source.equals(room.getMain())) {
                MainPanel panel=new MainPanel();
                panel.setVisible(true);
                room.dispose();
            }
        }
    }

    private void removeRoom() {
        hotel.deleteRoom(room.getRoomNo());
        hotel.save();
        setTable();
    }

    private void addRoom() {
        if(room.getNormalR().isSelected()){
            hotel.addRoom(new Normal(room.getRoomNo()));
        }
        else if(room.getSuitR().isSelected()){
            hotel.addRoom(new Normal(room.getRoomNo()));
        }
        else if(room.getHoneyR().isSelected()){
            hotel.addRoom(new Normal(room.getRoomNo()));
        }
        hotel.save();
        setTable();
    }

    public void setTable() {
        ArrayList<Room> list = HotelSys.getRooms();
        room.setTable();
        JTable table = room.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int i = 1;
        for (var x : list) {
            model.addRow(new Object[] { i++, x.getRoomNo(), x.status() });
        }
    }

}
