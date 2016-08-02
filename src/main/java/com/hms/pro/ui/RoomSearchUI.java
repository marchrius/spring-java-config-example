package com.hms.pro.ui;

import java.math.BigInteger;

public class RoomSearchUI {

	private Integer roomId;
	
	private String roomCategory;
	
	private String floorName;
	
	private String roomName;
	
	private Integer capacity;
	
	private BigInteger occupaid;
	
	private Integer isVacate;
	
	private String cost;

	
	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

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

	public BigInteger getOccupaid() {
		return occupaid;
	}

	public void setOccupaid(BigInteger occupaid) {
		this.occupaid = occupaid;
	}

	public Integer getIsVacate() {
		return isVacate;
	}

	public void setIsVacate(Integer isVacate) {
		this.isVacate = isVacate;
	}

	
	
	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "RoomSearchUI [roomCategory=" + roomCategory + ", floorName="
				+ floorName + ", roomName=" + roomName + ", capacity="
				+ capacity + ", occupaid=" + occupaid + ", isVacate="
				+ isVacate + "]";
	}
	
}
