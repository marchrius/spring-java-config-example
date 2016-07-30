package com.hms.pro.ui;

public class SearchReqObj {

	private Integer buildingId;
	
	private Integer shareTypeId;
	
	private Boolean fully;
	
	private Boolean partially;
	
	private Boolean empty;
	
	private Boolean vacates;

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Integer getShareTypeId() {
		return shareTypeId;
	}

	public void setShareTypeId(Integer shareTypeId) {
		this.shareTypeId = shareTypeId;
	}

	public Boolean getFully() {
		return fully;
	}

	public void setFully(Boolean fully) {
		this.fully = fully;
	}

	public Boolean getPartially() {
		return partially;
	}

	public void setPartially(Boolean partially) {
		this.partially = partially;
	}

	public Boolean getEmpty() {
		return empty;
	}

	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}

	public Boolean getVacates() {
		return vacates;
	}

	public void setVacates(Boolean vacates) {
		this.vacates = vacates;
	}
	
	
	
}
