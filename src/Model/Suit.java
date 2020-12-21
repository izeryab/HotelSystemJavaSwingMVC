package Model;

public class Suit extends Room {
    public Suit(int roomNo) {
        super(roomNo, "Suit");
    }

    @Override
    public void roomInfo() {
        System.out.println(getRoomNo()+": This room is for Suit!");
    }
}
