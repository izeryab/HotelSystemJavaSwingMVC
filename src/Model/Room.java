package Model;


public abstract class Room implements Service {
	private String RoomType;
	private int RoomNo;
	
	public Room() {}
	
	public Room(int roomNo,String roomType) {
		this.RoomNo=roomNo;
		this.RoomType=roomType;
	}
	
	public String status() {
		return RoomType;
	}
	
	public abstract void roomInfo();
	
	@Override
	public void specialService() {
	}
	public int getRoomNo() {
		return RoomNo;
	}

}
