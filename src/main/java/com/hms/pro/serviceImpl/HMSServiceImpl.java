package com.hms.pro.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.dao.BuildingDao;
import com.hms.pro.dao.CandidateDao;
import com.hms.pro.dao.FloorDao;
import com.hms.pro.dao.RoomDao;
import com.hms.pro.dao.RoomTypeDao;
import com.hms.pro.domain.Building;
import com.hms.pro.domain.Candidate;
import com.hms.pro.domain.Floor;
import com.hms.pro.domain.Room;
import com.hms.pro.domain.RoomType;
import com.hms.pro.service.HMSService;
import com.hms.pro.ui.CandidateUI;
import com.hms.pro.ui.RoomsUI;

@Service
public class HMSServiceImpl implements HMSService{

	@Autowired
	private RoomTypeDao roomTypeDao;
	
	@Autowired
	private BuildingDao buildingDao;
	
	@Autowired
	private FloorDao floorDao;
	
	@Autowired
	private CandidateDao candiateDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Transactional(readOnly=true)
	public List<RoomType> getRoomTypes(QueryResultBySateEnum roomTypeEnum) {
		List<RoomType> roomTypes=roomTypeDao.getRoomTypes(roomTypeEnum);
		return roomTypes;
	}

	@Transactional(readOnly=true)
	public List<Building> getBuildings(QueryResultBySateEnum bySateEnum) {
		return buildingDao.getBuildingsList(bySateEnum);
	}

	@Transactional(readOnly=true)
	public List<Floor> getFloors(QueryResultBySateEnum bySateEnum) {

		return floorDao.getFloors(bySateEnum);
	}

	@Transactional(readOnly=true)
	public List<RoomsUI> getFloors(QueryResultBySateEnum bySateEnum, int roomType,
			int buildingId) {
		return floorDao.getFloors(bySateEnum, roomType,buildingId);
	}

	@Transactional(readOnly=false)
	public List<RoomsUI> getRooms(QueryResultBySateEnum bySateEnum, int roomType,
			int buildingId, int floorId) {
		return roomTypeDao.getRooms(bySateEnum,roomType,buildingId,floorId);
	}

	@Transactional(readOnly=false)
	public void saveCandidate(Candidate candidate) {
		candiateDao.save(candidate);	
	}

	@Transactional(readOnly=true)
	public Room getRoom(int roomId) {
		// TODO Auto-generated method stub
		return roomDao.get(roomId);
	}

	@Transactional(readOnly=true)
	public List<Candidate> getCandidates(QueryResultBySateEnum bySateEnum) {
		return candiateDao.getCandidates(bySateEnum);
	}
	
	public Candidate getCandidateDetails (QueryResultBySateEnum bySateEnum, int candidateId) {
		return candiateDao.getCandidateDetails(bySateEnum, candidateId);
	}
	public int updateVacateData (QueryResultBySateEnum bySateEnum, int candidateId, Date vacateDate) {
		return candiateDao.updateVacateData(bySateEnum, candidateId, vacateDate);
	}

	public List<CandidateUI> getCandidates(QueryResultBySateEnum bySateEnum,
			int candidateId) {
		return candiateDao.getCandidates(bySateEnum, candidateId);
	}

}
