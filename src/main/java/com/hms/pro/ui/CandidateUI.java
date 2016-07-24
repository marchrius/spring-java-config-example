package com.hms.pro.ui;

import java.sql.Date;


public class CandidateUI {
	
	private Integer candidateId;
	private String fullName;
	private String address;
	private String mobileNo;
	private String emergencyContactNo;
	private String occupation;
	private String workPlace;
	private String idType;
	private String idNo;
	private int roomType;
	private int building;
	private int floor;
	private int room;
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	private String paymentDate;
	private int candidateFee;
	private int paidAmount;
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	private String dueDate;
	private Date joinDate;
	private int vacationFlag;
	private String roomCategory;
	private Date vacationDate;
	
	
	
	
	public Date getVacationDate() {
		return vacationDate;
	}
	public void setVacationDate(Date vacationDate) {
		this.vacationDate = vacationDate;
	}
	public String getRoomCategory() {
		return roomCategory;
	}
	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}
	public int getVacationFlag() {
		return vacationFlag;
	}
	public void setVacationFlag(int vacationFlag) {
		this.vacationFlag = vacationFlag;
	}
	public Integer getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmergencyContactNo() {
		return emergencyContactNo;
	}
	public void setEmergencyContactNo(String emergencyContactNo) {
		this.emergencyContactNo = emergencyContactNo;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	public int getBuilding() {
		return building;
	}
	public void setBuilding(int building) {
		this.building = building;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public int getCandidateFee() {
		return candidateFee;
	}
	public void setCandidateFee(int candidateFee) {
		this.candidateFee = candidateFee;
	}
	public int getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
