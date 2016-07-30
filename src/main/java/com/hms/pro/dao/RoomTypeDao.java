package com.hms.pro.dao;

import java.util.List;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.domain.RoomType;
import com.hms.pro.ui.RoomTypeUI;
import com.hms.pro.ui.RoomsUI;

public interface RoomTypeDao extends AbstractDao<RoomType,Integer> {

	List<RoomType> getRoomTypes(QueryResultBySateEnum roomTypeEnum);

	List<RoomsUI> getRooms(QueryResultBySateEnum bySateEnum, int roomType,
			int buildingId, int floorId);

	List<RoomTypeUI> getRoomTypesOfBuilding(Integer buildingId);
}
