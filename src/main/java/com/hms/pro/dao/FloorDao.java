package com.hms.pro.dao;

import java.util.List;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.domain.Floor;
import com.hms.pro.ui.RoomsUI;

public interface FloorDao extends AbstractDao<Floor, Integer>{

	List<Floor> getFloors(QueryResultBySateEnum bySateEnum);
	
	List<RoomsUI> getFloors(QueryResultBySateEnum bySateEnum, int roomType,
			int buildingId);
}
