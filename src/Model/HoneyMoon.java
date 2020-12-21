package Model;

public class HoneyMoon extends Room {
    public HoneyMoon(int roomNo) {
        super(roomNo, "HoneyMoon");
    }

    @Override
    public void roomInfo() {
        System.out.println(getRoomNo() + ": This room is for HoneyMoon!");
    }
}
