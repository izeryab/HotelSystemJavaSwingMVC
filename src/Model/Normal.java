package Model;


public class Normal extends Room{
	public Normal(int roomNo) {
		super(roomNo, "Normal");
	}

    @Override
    public void roomInfo() {
        System.out.println(getRoomNo()+": This room is for Normal peoples!");
    }
}
