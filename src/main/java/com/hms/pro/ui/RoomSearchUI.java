package com.hms.pro.ui;

public class RoomSearchUI {

	private String roomCategory;
	
	private String floorName;
	
	private String roomName;
	
	private Integer capacity;
	
	private Integer occupaid;
	
	private Integer isVacate;

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getOccupaid() {
		return occupaid;
	}

	public void setOccupaid(Integer occupaid) {
		this.occupaid = occupaid;
	}

	public Integer getIsVacate() {
		return isVacate;
	}

	public void setIsVacate(Integer isVacate) {
		this.isVacate = isVacate;
	}

	@Override
	public String toString() {
		return "RoomSearchUI [roomCategory=" + roomCategory + ", floorName="
				+ floorName + ", roomName=" + roomName + ", capacity="
				+ capacity + ", occupaid=" + occupaid + ", isVacate="
				+ isVacate + "]";
	}
	
}
