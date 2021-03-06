package com.hms.pro.domain;

// Generated Jun 19, 2016 12:53:53 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RoomType generated by hbm2java
 */
@Entity
@Table(name = "room_type", catalog = "hms")
public class RoomType implements java.io.Serializable {

	private int roomTypeId;
	private String roomCategory;
	private String cost;
	private Integer isActive;
	private Integer capacity;
	private Set<Room> rooms = new HashSet<Room>(0);

	public RoomType() {
	}

	public RoomType(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public RoomType(int roomTypeId, String roomCategory, String cost,
			Integer isActive, Set<Room> rooms) {
		this.roomTypeId = roomTypeId;
		this.roomCategory = roomCategory;
		this.cost = cost;
		this.isActive = isActive;
		this.rooms = rooms;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "room_type_id", unique = true, nullable = false)
	public int getRoomTypeId() {
		return this.roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	@Column(name = "room_category", length = 45)
	public String getRoomCategory() {
		return this.roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

	@Column(name = "cost", length = 45)
	public String getCost() {
		return this.cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Column(name = "isActive")
	public Integer getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	@Column(name = "capacity")
	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomType")
	public Set<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

}
