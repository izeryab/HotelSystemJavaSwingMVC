package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HotelSys {
    public ArrayList<Room> arr;

    public HotelSys() {
        arr = new ArrayList<Room>();
    }

    public void addRoom(Room room) {
        for (var x : arr) {
            if (x.equals(room))
                return;
        }
        arr.add(room);
    }

    public void deleteRoom(int roomNo) {
        for (var x : arr) {
            if (x.getRoomNo() == roomNo) {
                arr.remove(x);
                break;
            }
        }
    }

    public boolean searchRoom(Room room) {
        return arr.contains(room);
    }

    public void display() {
        for (var room : arr) {
            System.out.println(room);
        }
    }

    public static ArrayList<Room> getRooms() {
        ArrayList<Room> array = new ArrayList<Room>();
        try {
            File file = new File(".//TxtFiles//RoomDetails.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(str, "#");
                int num = Integer.parseInt(token.nextToken());
                String st = token.nextToken();
                if (st.equals("Normal")) {
                    array.add(new Normal(num));
                } else if (st.equals("Suit")) {
                    array.add(new Suit(num));
                } else if (st.equals("HoneyMoon")) {
                    array.add(new HoneyMoon(num));
                }
            }
            reader.close();
        } catch (Exception e) {
        }
        return array;
    }

    public void save() {
        try {
            File file = new File(".//TxtFiles//RoomDetails.txt");
            PrintWriter writer = new PrintWriter(file);
            for (var x : arr) {
                writer.write(x.getRoomNo() + "#" + x.status() + "\n");
            }
            writer.close();
        } catch (Exception e) {
        }
    }
}
