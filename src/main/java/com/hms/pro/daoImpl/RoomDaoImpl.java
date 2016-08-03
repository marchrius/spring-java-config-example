package com.hms.pro.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.dao.RoomDao;
import com.hms.pro.domain.Room;
import com.hms.pro.ui.RoomSearchUI;

@Repository
public class RoomDaoImpl extends AbstractDaoImpl<Room, Integer> implements RoomDao{

	public RoomDaoImpl() {
		super(Room.class);
	}

	public List<RoomSearchUI> getRoomSearchResults(
			QueryResultBySateEnum bySateEnum, Integer roomType) {
		
		Query query=null;
		
		if(roomType!=0){
			 query=getCurrentSession().createSQLQuery("SELECT r.room_id as roomId,rt.room_category as roomCategory, f.floor_name as floorName, " +
					"										r.room_name as roomName,  rt.cost as cost," +
															" rt.capacity as capacity, COUNT(c.room) as occupaid,"+
															"c.vacation_flag as isVacate FROM room r JOIN floor f ON f.floor_id = r.floor and r.isActive=:isActive"+
															" JOIN room_type rt ON rt.room_type_id = r.room_type LEFT OUTER JOIN candidate c ON " +
															"r.room_id = c.room where r.room_type=:roomType GROUP BY r.room_id ");
			 query.setParameter("roomType", roomType);
		}else{
			query=getCurrentSession().createSQLQuery("SELECT r.room_id as roomId,rt.room_category as roomCategory, f.floor_name as floorName, " +
					"										r.room_name as roomName,  rt.cost as cost," +
															" rt.capacity as capacity, COUNT(c.room) as occupaid,"+
															"c.vacation_flag as isVacate FROM room r JOIN floor f ON f.floor_id = r.floor and r.isActive=:isActive"+
															" JOIN room_type rt ON rt.room_type_id = r.room_type LEFT OUTER JOIN candidate c ON " +
															"r.room_id = c.room GROUP BY r.room_id ");
			
		}
		query.setParameter("isActive", bySateEnum.ordinal());
		
		return (List<RoomSearchUI>) excuteQuery(query, RoomSearchUI.class);
	}

}
