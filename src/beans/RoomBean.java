package beans;

public class RoomBean {

	private String user_id;
	private String userLogin;
	private String building_id;
	private String room_name;
	private String count;

	public String getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

}
