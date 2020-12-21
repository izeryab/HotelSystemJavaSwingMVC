package Model;


public class Extra {
	private int massage;
	private int spa;
	private int roomService;
	public Extra() {
		this.massage = 50;
		this.spa = 50;
		this.roomService = 50;
	}
	public void debt(int massage, int spa, int roomService) {
		this.massage = massage;
		this.spa = spa;
		this.roomService = roomService;
	}
	public int getMassage() {
		return massage;
	}
	public int getSpa() {
		return spa;
	}
	public int getRoomService() {
		return roomService;
	}
	public void setMassage(int massage) {
		this.massage = massage;
	}
	public void setSpa(int spa) {
		this.spa = spa;
	}
	public void setRoomService(int roomService) {
		this.roomService = roomService;
	}
	@Override
	public String toString() {
		return "Extra [massage=" + massage + ", spa=" + spa + ", roomService=" + roomService + "]";
	}
	
	
}
