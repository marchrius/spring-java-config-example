package com.hms.pro.dao;

import java.util.List;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.domain.Room;
import com.hms.pro.ui.RoomSearchUI;

public interface RoomDao extends AbstractDao<Room, Integer> {
	
	List<RoomSearchUI> getRoomSearchResults(QueryResultBySateEnum bySateEnum, Integer roomType);
}
