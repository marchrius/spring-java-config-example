package com.hms.pro.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpEntity;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.domain.Building;
import com.hms.pro.domain.Candidate;
import com.hms.pro.domain.Floor;
import com.hms.pro.domain.Room;
import com.hms.pro.domain.RoomType;
import com.hms.pro.ui.CandidateUI;
import com.hms.pro.ui.RoomSearchUI;
import com.hms.pro.ui.RoomTypeUI;
import com.hms.pro.ui.RoomsUI;
import com.hms.pro.ui.SearchReqObj;

public interface HMSService {

	List<RoomType> getRoomTypes(QueryResultBySateEnum roomTypeEnum);
	
	List<Building> getBuildings(QueryResultBySateEnum bySateEnum);
	
	List<Floor> getFloors(QueryResultBySateEnum bySateEnum);

	List<RoomsUI> getFloors(QueryResultBySateEnum active, int roomType,
			int buildingId);

	List<RoomsUI> getRooms(QueryResultBySateEnum active, int roomType,
			int buildingId, int floorId);

	void saveCandidate(Candidate candidate);

	Room getRoom(int roomNo);

	List<Candidate> getCandidates(QueryResultBySateEnum active);
	
	Candidate getCandidateDetails (QueryResultBySateEnum bySateEnum, int candidateId);
	int updateVacateData (QueryResultBySateEnum bySateEnum, int candidateId, Date vacateDate);
	List<CandidateUI> getCandidates(QueryResultBySateEnum bySateEnum, int buildingId);

	List<RoomTypeUI> getRoomTypesOfBuilding(Integer buildingId);	
	
	List<RoomSearchUI> getRoomSearchResults(QueryResultBySateEnum bySateEnum, SearchReqObj searchReqObj);

	List<Candidate> getCandidatesOfRoom(QueryResultBySateEnum active,
			Integer roomNo);

	List<Candidate> getPaymentsOfCandidates(QueryResultBySateEnum active,
			Date date, boolean b);
}
