package com.hms.pro.daoImpl;

import org.springframework.stereotype.Repository;

import com.hms.pro.dao.RoomDao;
import com.hms.pro.domain.Room;

@Repository
public class RoomDaoImpl extends AbstractDaoImpl<Room, Integer> implements RoomDao{

	public RoomDaoImpl() {
		super(Room.class);
		// TODO Auto-generated constructor stub
	}

}
